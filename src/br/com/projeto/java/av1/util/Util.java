package br.com.projeto.java.av1.util;

import br.com.projeto.java.av1.enumeracoes.Cambio;
import br.com.projeto.java.av1.enumeracoes.Cor;
import br.com.projeto.java.av1.enumeracoes.TipoCarro;
import br.com.projeto.java.av1.enumeracoes.TipoMotocicleta;

public class Util {
	
	public static TipoCarro TransfEnumTipoCarro(int cod)
	{
		TipoCarro tc = null;
		switch(cod)
		{
		case 1: return tc.HATCH_COMPACTO;
		case 2: return tc.HATCH_MEDIO_ESPORTIVO;
		case 3: return tc.PICAPE;
		case 4: return tc.SEDA_COMPACTO;
		case 5: return tc.SEDA_MEDIO;
		default: return null;
		}
	}
	
	public static TipoMotocicleta TransfEnumTipoMoto(int cod)
	{
		TipoMotocicleta tm = null;
		switch(cod)
		{
		case 1: return tm.BOBBER;
		case 2: return tm.CAFE_RACER;
		case 3: return tm.CUSTOM;
		case 4: return tm.ESPORTIVA;
		case 5: return tm.FUN_BIKE;
		default: return null;
		}
	}
	
	public static Cor TransfEnumCor(int cod)
	{
		Cor c = null;
		switch(cod)
		{
		case 1: return c.AZUL;
		case 2: return c.BRANCO;
		case 3: return c.PRETO;
		case 4: return c.ROSA;
		case 5: return c.VERDE;
		case 6: return c.VERMELHO;
		default: return null;
		}
	}
	
	public static Cambio TransfEnumCambio(int cod)
	{
		Cambio c = null;
		switch(cod)
		{
		case 1: return c.AUTOMATICO;
		case 2: return c.MANUAL;
		default: return null;
		}
	}

}
