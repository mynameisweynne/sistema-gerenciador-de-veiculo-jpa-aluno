package br.com.fuctura.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vendas")
public class Venda implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private double valor;

	public Venda() {
	}

	public Venda(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Venda [valor=" + valor + "]";
	}

}
