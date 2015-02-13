package br.com.projeto.java.av1.dao;

import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDao {
	
	/**
	 * Método para adicionar o carro no banco de dados
	 * @throws AcessoIlegalBanco - dispara essa exceção caso de problemas no insert na base, 
	 * <br/> o roolback é feito.
	 * @param c 
	 */
	
	private Connection connection = null;
	
	public void adicionarCarro(Carro c) throws SQLException, AcessoIlegalBanco  
	{
		try
		{
			this.connection = ConnectionFactory.getConnection();
			this.connection.setAutoCommit(false);
			
			String sql = "INSERT INTO carro (chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco)" + 
						 "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement prst = this.connection.prepareStatement(sql);
			
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
		} catch(SQLException | ClassNotFoundException s) {
			this.connection.rollback();
			throw new RuntimeException(s);
		}
	}
	
}
