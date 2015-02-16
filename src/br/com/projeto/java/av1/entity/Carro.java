package br.com.projeto.java.av1.entity;

import br.com.projeto.java.av1.enumeracoes.Cambio;
import br.com.projeto.java.av1.enumeracoes.Cor;
import br.com.projeto.java.av1.enumeracoes.TipoCarro;

public class Carro {
	private int id;
	private String chassi;
	private String montadora;
	private String modelo;
	private TipoCarro tipo;
	private Cor cor;
	private float motorizacao;
	private Cambio cambio;
	private float preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoCarro getTipo() {
		return tipo;
	}
	public int getTipoCarro() {
		return this.tipo.getCod();
	}

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}
	
	public void setTipoInt(int tipo) {//DAR UM LOCAL MELHOR PARA ESSE MÉTODO
		TipoCarro tc = null;
		switch(tipo)
		{
		case 1: this.tipo = tc.HATCH_COMPACTO;
		break;
		case 2: this.tipo = tc.HATCH_MEDIO_ESPORTIVO;
		break;
		case 3: this.tipo = tc.PICAPE;
		break;
		case 4: this.tipo = tc.SEDA_COMPACTO;
		break;
		case 5: this.tipo = tc.SEDA_MEDIO;
		break;
		}
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getCorInt() {
		return this.cor.getCod();
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public void setCorInt(int cor) {//DAR UM LOCAL MELHOR PARA ESSE MÉTODO
		Cor c = null;
		switch(cor)
		{
		case 1: this.cor = c.AZUL;
		break;
		case 2: this.cor = c.BRANCO;
		break;
		case 3: this.cor = c.PRETO;
		break;
		case 4: this.cor = c.ROSA;
		break;
		case 5: this.cor = c.VERDE;
		break;
		case 6: this.cor = c.VERMELHO;
		break;
		}
	}

	public float getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}

	public Cambio getCambio() {
		return cambio;
	}
	
	public int getCambioInt() {
		return this.cambio.getCod();
	}

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	
	public void setCambioInt(int cambio) {//DAR UM LOCAL MELHOR PARA ESSE MÉTODO
		Cambio c = null;
		switch(cambio)
		{
		case 1: this.cambio = c.AUTOMATICO;
		break;
		case 2: this.cambio = c.MANUAL;
		break;
		}
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
