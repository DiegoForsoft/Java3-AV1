package br.com.projeto.java.av1.dao;

import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.entity.Motocicleta;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;
import br.com.projeto.java.av1.exception.ClasseNaoEncontrada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotocicletaDao {
	
private Connection connection = null;
	
	public void adicionarMotocicleta(Motocicleta m) throws SQLException  
	{
		try
		{
			this.connection = ConnectionFactory.getConnection();
			this.connection.setAutoCommit(false);
			
			String sql = "INSERT INTO motocicleta (chassi, montadora, modelo, tipo, cor, cilindrada, capacidade_tanque, preco)" + 
						 "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement prst = this.connection.prepareStatement(sql);
			
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
			System.out.println("Deu Certo ou pelo menos quase");
		} catch(AcessoIlegalBanco e ) {
			this.connection.rollback();
			System.out.println(e.getMessage());
		}
		catch(ClasseNaoEncontrada s)
		{
			this.connection.rollback();
			throw new RuntimeException(s);
		}
	}
}
