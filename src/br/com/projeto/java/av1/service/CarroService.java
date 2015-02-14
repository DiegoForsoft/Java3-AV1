package br.com.projeto.java.av1.service;

import java.sql.SQLException;

import com.google.gson.Gson;

import br.com.projeto.java.av1.dao.CarroDao;
import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;

public class CarroService {
	
	private CarroDao dao = new CarroDao();
	
	public void adicionarCarroNoBanco(Carro c) throws SQLException, AcessoIlegalBanco {
		
		dao.adicionarCarro(c);
	}
}
