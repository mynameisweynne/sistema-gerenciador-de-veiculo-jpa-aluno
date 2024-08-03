package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entity.Veiculo;

public interface VeiculoDAO {

	void insert(Veiculo obj);

	void deleteById(int codigo);

	void update(Veiculo obj);

	Veiculo findById(int codigo);

	List<Veiculo> findAll();

}
