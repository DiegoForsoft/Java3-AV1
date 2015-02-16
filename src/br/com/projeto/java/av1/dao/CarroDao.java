package br.com.projeto.java.av1.dao;

import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.enumeracoes.TipoCarro;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;
import br.com.projeto.java.av1.exception.ClasseNaoEncontrada;
import br.com.projeto.java.av1.util.Util;
import br.com.projeto.java.av1.enumeracoes.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {
	
	/**
	 * Método para adicionar o carro no banco de dados
	 * @throws AcessoIlegalBanco - dispara essa exceção caso de problemas no insert na base, 
	 * <br/> o roolback é feito.
	 * @param c 
	 */
	
	private Connection connection = null;
	
	public void adicionarCarro(Carro c) throws SQLException  {
		PreparedStatement prst = null;
		try{
			this.connection = ConnectionFactory.getConnection();
			this.connection.setAutoCommit(false);
			
			String sql = "INSERT INTO carro (chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco)" + 
						 "VALUES(?,?,?,?,?,?,?,?)";
			prst = this.connection.prepareStatement(sql);
			
			prst.setString(1, c.getChassi());
			prst.setString(2, c.getMontadora());
			prst.setString(3, c.getModelo());
			prst.setInt(4, c.getTipoCarro());
			prst.setInt(5, c.getCorInt());
			prst.setFloat(6, c.getMotorizacao());
			prst.setInt(7, c.getCambioInt());
			prst.setFloat(8, c.getPreco());
			prst.execute();
			this.connection.commit();
			prst.close();
			this.connection.close();
		}catch(AcessoIlegalBanco a){
			System.out.println(a.getMessage());
		}catch(ClasseNaoEncontrada cn){
			System.out.println(cn.getMessage());
		}catch(SQLException | NullPointerException s){
			System.out.println("Erro ao acessar o banco!");
		}
	}
	
	public Carro PesquisarCarro(String chassi) {
		Carro carro = new Carro();
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try{
			this.connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM carro WHERE chassi=?";
			prst = this.connection.prepareStatement(sql);
			prst.setString(1, chassi);
			rs = prst.executeQuery();
			rs.next();
			carro.setChassi(rs.getString("chassi"));
			carro.setMontadora(rs.getString("montadora"));
			carro.setModelo(rs.getString("modelo"));
			carro.setTipo(Util.TransfEnumTipoCarro(rs.getInt("tipo")));
			carro.setCor(Util.TransfEnumCor(rs.getInt("cor")));
			carro.setMotorizacao(rs.getFloat("motorizacao"));
			carro.setCambio(Util.TransfEnumCambio(rs.getInt("cambio")));
			carro.setPreco(rs.getFloat("preco"));
			rs.close();
			prst.close();
			this.connection.close();
			return carro;
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
	
	public List<Carro> ListarCarros() {
		List<Carro> carro = new ArrayList<Carro>();
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try{
			this.connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM carro";
			prst = this.connection.prepareStatement(sql);
			rs = prst.executeQuery();
			while(rs.next())
			{
				String Chassi = rs.getString("chassi");
				String Montadora = rs.getString("montadora");
				String Modelo = rs.getString("modelo");
				TipoCarro Tipo = Util.TransfEnumTipoCarro(rs.getInt("tipo"));
				Cor Cor = Util.TransfEnumCor(rs.getInt("cor"));
				float Motoricacao = rs.getFloat("motorizacao");
				Cambio Cambio = Util.TransfEnumCambio(rs.getInt("cambio"));
				float Preco = rs.getFloat("preco");
				carro.add(new Carro(Chassi, Montadora, Modelo, Tipo, Cor, Motoricacao, Cambio, Preco));
			}
			rs.close();
			prst.close();
			this.connection.close();
			return carro;
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
