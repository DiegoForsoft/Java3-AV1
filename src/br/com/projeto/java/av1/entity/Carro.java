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

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
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

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
