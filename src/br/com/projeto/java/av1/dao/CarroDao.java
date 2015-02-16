package br.com.projeto.java.av1.dao;

import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;
import br.com.projeto.java.av1.exception.ClasseNaoEncontrada;

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
			
			System.out.println("Deu Certo ou pelo menos quase");
		} catch(AcessoIlegalBanco e ) {
			this.connection.rollback();
			System.out.println(e.getMessage());
		}catch(ClasseNaoEncontrada s){
			this.connection.rollback();
			System.out.println(s.getMessage());
		}finally{
			prst.close();
			this.connection.close();
		}
	}
	
	public Carro PesquisarCarro(String chassi) throws SQLException{
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
			carro.setTipoInt(rs.getInt("tipo"));
			carro.setCorInt(rs.getInt("cor"));
			carro.setCambioInt(rs.getInt("cambio"));
			carro.setPreco(rs.getFloat("preco"));
			return carro;
		}catch(AcessoIlegalBanco a){
			System.out.println(a.getMessage());
			return null;
		}catch(ClasseNaoEncontrada c){
			System.out.println(c.getMessage());
			return null;
		}finally{
			rs.close();
			prst.close();
			this.connection.close();
		}
		
	}
	
}
