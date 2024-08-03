package br.com.fuctura.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@Column(length = 7)
	private String placa;
	private String modelo;
	@Column(length = 4)
	private int ano;
	private double valor;
	@OneToOne(cascade = CascadeType.ALL)
	private Tipo tipo;

	public Veiculo() {
	}

	public Veiculo(int codigo, String placa, String modelo, int ano, double valor, Tipo tipo) {
		this.codigo = codigo;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "\nVeiculo: " + "\nCódigo = " + codigo + "\nPlaca = " + placa + "\nModelo = " + modelo + "\nAno = " + ano
				+ "\nValor = " + valor + "\nDescrição = " + tipo.getDescricao() + "\n";
	}

}
