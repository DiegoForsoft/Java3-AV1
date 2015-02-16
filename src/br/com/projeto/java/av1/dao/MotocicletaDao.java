package br.com.projeto.java.av1.dao;

import br.com.projeto.java.av1.entity.Motocicleta;
import br.com.projeto.java.av1.entity.Motocicleta;
import br.com.projeto.java.av1.entity.Motocicleta;
import br.com.projeto.java.av1.enumeracoes.Cambio;
import br.com.projeto.java.av1.enumeracoes.Cor;
import br.com.projeto.java.av1.enumeracoes.TipoCarro;
import br.com.projeto.java.av1.enumeracoes.TipoMotocicleta;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;
import br.com.projeto.java.av1.exception.BancoVazio;
import br.com.projeto.java.av1.exception.ClasseNaoEncontrada;
import br.com.projeto.java.av1.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotocicletaDao {
	
private Connection connection = null;
	
	public void adicionarMotocicleta(Motocicleta m) {
		PreparedStatement prst = null;
		try{
			this.connection = ConnectionFactory.getConnection();
			this.connection.setAutoCommit(false);
			
			String sql = "INSERT INTO motocicleta (chassi, montadora, modelo, tipo, cor, cilindrada, capacidade_tanque, preco)" + 
						 "VALUES(?,?,?,?,?,?,?,?)";
			prst = this.connection.prepareStatement(sql);
			
			prst.setString(1, m.getChassi());
			prst.setString(2, m.getMontadora());
			prst.setString(3, m.getModelo());
			prst.setInt(4, m.getTipoInt());
			prst.setInt(5, m.getCorInt());
			prst.setFloat(6, m.getCilindrada());
			prst.setInt(7, m.getCapacidadeTanque());
			prst.setFloat(8, m.getPreco());
			prst.execute();
			this.connection.commit();
		}catch(AcessoIlegalBanco a){
			System.out.println(a.getMessage());
		}catch(ClasseNaoEncontrada cn){
			System.out.println(cn.getMessage());
		}catch(SQLException | NullPointerException s){
			System.out.println("Erro ao acessar o banco!");
		}
	}
	
	public Motocicleta PesquisarMotocicleta(String chassi){
		Motocicleta moto = new Motocicleta();
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try{
			this.connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM motocicleta WHERE chassi=?";
			prst = this.connection.prepareStatement(sql);
			prst.setString(1, chassi);
			rs = prst.executeQuery();
			rs.next();
			moto.setChassi(rs.getString("chassi"));
			moto.setMontadora(rs.getString("montadora"));
			moto.setModelo(rs.getString("modelo"));
			moto.setTipo(Util.TransfEnumTipoMoto(rs.getInt("tipo")));
			moto.setCor(Util.TransfEnumCor(rs.getInt("cor")));
			moto.setCilindrada(rs.getInt("cilindrada"));
			moto.setCapacidadeTanque(rs.getInt("capacidade_tanque"));
			moto.setPreco(rs.getFloat("preco"));
			rs.close();
			prst.close();
			this.connection.close();
			return moto;
		}catch(AcessoIlegalBanco a){
			System.out.println(a.getMessage());
			return null;
		}catch(ClasseNaoEncontrada c){
			System.out.println(c.getMessage());
			return null;
		}catch(SQLException | NullPointerException s){
			System.out.println("Erro ao acessar o banco!");
			return null;
		}
	}
	
	public List<Motocicleta> ListarMotos() {
		List<Motocicleta> moto = new ArrayList<Motocicleta>();
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try{
			this.connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM motocicleta";
			prst = this.connection.prepareStatement(sql);
			rs = prst.executeQuery();
			while(rs.next())
			{
				String Chassi = rs.getString("chassi");
				String Montadora = rs.getString("montadora");
				String Modelo = rs.getString("modelo");
				TipoMotocicleta Tipo = Util.TransfEnumTipoMoto(rs.getInt("tipo"));
				Cor Cor = Util.TransfEnumCor(rs.getInt("cor"));
				int Cilindrada = rs.getInt("cilindrada");
				int CapacidadeTanque = rs.getInt("capacidade_tanque");
				float Preco = rs.getFloat("preco");
				moto.add(new Motocicleta(Chassi, Montadora, Modelo, Tipo, Cor, Cilindrada, CapacidadeTanque, Preco));
			}
			rs.close();
			prst.close();
			this.connection.close();
			return moto;
		}catch(AcessoIlegalBanco a){
			System.out.println(a.getMessage());
			return null;
		}catch(ClasseNaoEncontrada c){
			System.out.println(c.getMessage());
			return null;
		}catch(SQLException | NullPointerException s){
			System.out.println("Erro ao acessar o banco!");
			return null;
		}
	}
}
