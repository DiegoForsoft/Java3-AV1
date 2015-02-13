package br.com.projeto.java.av1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projeto.java.av1.exception.*;

public class ConnectionFactory 
{
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	//Padr�o de projeto singleton.
	private ConnectionFactory() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, AcessoIlegalBanco {
	     try {
	    	 Class.forName(DRIVER); // Depois trata essa exception, mesmo esquema da debaixo.
	         return DriverManager.getConnection(
	 "jdbc:mysql://localhost:3306/loja", "root", "javaav1");
	     } catch(SQLException e) {  
	    	 
	     }
	         throw new AcessoIlegalBanco("Deu merda");   //Tem que criar uma exception especifica., Se quiser eu crio importou ela? n�o, mas vai atuomatico
	 }
	 
	
	/*public void conectar()
	{
		String servidor = "jdbc:mysql://localhost:3306/loja";
		String usuario = "root";
		String senha = "javaav1";
		String driver = "com.mysql.jdbc.Driver";
		
		try
		{
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			//this.prstatement = this.connection.prepareStatement(sql);
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		catch(ClassNotFoundException c)
		{
			throw new RuntimeException(c);
		}
	}
	
	public void desconectar()
	{
		try
		{
			this.connection.close();
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean estaConectado()
	{
		if(this.connection != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}*/
}
