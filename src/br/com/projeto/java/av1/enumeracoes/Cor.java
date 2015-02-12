package br.com.projeto.java.av1.enumeracoes;

public enum Cor {
	ROSA(1),
	VERMELHO(2),
	PRETO(3),
	AZUL(4),
	VERDE(5),
	BRANCO(6);
	
	private int cod;
	
	Cor(int codRecebido) {
		this.cod = codRecebido;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
}
