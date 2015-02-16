package br.com.projeto.java.av1.enumeracoes;

import java.util.Enumeration;

import com.sun.jmx.snmp.Enumerated;

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
	public int getCod() {
		return cod;
	}
	
	public TipoCarro setCod(int cod)
	{
		switch(cod)
		{
		case 1: return HATCH_COMPACTO;
		case 2: return HATCH_MEDIO_ESPORTIVO;
		case 3: return PICAPE;
		case 4: return SEDA_COMPACTO;
		case 5: return SEDA_MEDIO;
		default: return null;
		}
	}
	
}
