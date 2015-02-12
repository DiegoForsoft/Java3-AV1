package br.com.projeto.java.av1.enumeracoes;

public enum TipoMotocicleta {
	BOBBER(1),
	CAFE_RACER(2),
	CUSTOM(3),
	ESPORTIVA(4),
	FUN_BIKE(5);
	
	private int cod;
	
	TipoMotocicleta(int codRecebido) {
		this.cod = codRecebido;
	}
}
