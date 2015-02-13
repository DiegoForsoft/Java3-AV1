package br.com.projeto.java.av1.dao;

import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDao {
	
	/**blz
	 * Método para adicionar o carro no banco de dados
	 * @throws AcessoIlegalBanco - dispara essa exceção caso de problemas no insert na base, 
	 * <br/> o roolback é feito. VI A MERDA. CALMA AI VOU RESOLVER. blz
	 * @param c :D :D  :D
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
			prst.setObject(4, c.getTipo());
			prst.setObject(5, c.getCor());
			prst.setFloat(6, c.getMotorizacao());
			prst.setObject(7, c.getCambio());
			prst.setFloat(8, c.getPreco());
			prst.execute();
		} catch(SQLException | ClassNotFoundException s) {
			this.connection.rollback();
			throw new RuntimeException(s);
		}
	}
	
}
