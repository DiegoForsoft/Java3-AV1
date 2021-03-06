package br.com.projeto.java.av1.entity;

import br.com.projeto.java.av1.enumeracoes.Cambio;
import br.com.projeto.java.av1.enumeracoes.Cor;
import br.com.projeto.java.av1.enumeracoes.TipoCarro;
import br.com.projeto.java.av1.enumeracoes.TipoMotocicleta;

public class Motocicleta {
	private int id;
	private String chassi;
	private String montadora;
	private String modelo;
	private TipoMotocicleta tipo;
	private Cor cor;
	private int cilindrada;
	private int capacidadeTanque;
	private float preco;
	
	public Motocicleta(){
		
	}
	
	public Motocicleta(String chassi, String montadora,
			String modelo, TipoMotocicleta tipo, Cor cor, int cilindrada,
			int capacidadeTanque, float preco) {
		this.chassi = chassi;
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cor = cor;
		this.cilindrada = cilindrada;
		this.capacidadeTanque = capacidadeTanque;
		this.preco = preco;
	}
	
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

	public TipoMotocicleta getTipo() {
		return tipo;
	}
	
	public int getTipoInt() {
		return this.tipo.getCod();
	}

	public void setTipo(TipoMotocicleta tipo) {
		this.tipo = tipo;
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

	public float getPreco() {
		return preco;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
