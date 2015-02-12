package br.com.projeto.java.av1.enumeracoes;

public enum Cambio {
	AUTOMATICO(1), 
	MANUAL(2);
	
	private int cod;
	
	Cambio(int cod) {
		this.cod = cod;
	}
}
