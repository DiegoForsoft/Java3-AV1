package br.com.projeto.java.av1.enumeracoes;

public enum TipoCarro {
	HATCH_COMPACTO(1),
	HATCH_MEDIO_ESPORTIVO(2),
	SEDA_COMPACTO(3),
	SEDA_MEDIO(4),
	PICAPE(5);
	
	private int cod;
	
	TipoCarro(int codRecebido) { 
		this.cod = codRecebido;
	}
}
