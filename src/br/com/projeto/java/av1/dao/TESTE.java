package br.com.projeto.java.av1.dao;
import java.sql.SQLException;

import br.com.projeto.java.av1.entity.*;
import br.com.projeto.java.av1.enumeracoes.*;

public class TESTE 
{
	public static void main(String[] args) throws SQLException 
	{
		Carro carro = new Carro();
		carro.setChassi("12345");
		carro.setMontadora("Fiat");
		carro.setModelo("Novo");
		carro.setTipo(TipoCarro.SEDA_COMPACTO);
		carro.setCor(Cor.AZUL);
		carro.setMotorizacao(35000);
		carro.setCambio(Cambio.AUTOMATICO);
		carro.setPreco(700000);
		
		CarroDao cd = new CarroDao();
		cd.adicionarCarro(carro);
		
	}

}
