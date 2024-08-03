package br.com.fuctura.dao.impl;

import java.util.List;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entity.Veiculo;
import jakarta.persistence.EntityManager;

public class VeiculoDAOImpl implements VeiculoDAO {

	private final EntityManager em;

	public VeiculoDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Veiculo obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(int codigo) {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		if (veiculo != null) {
			em.getTransaction().begin();
			em.remove(veiculo);
			em.getTransaction().commit();
		}
	}

	@Override
	public void update(Veiculo obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	@Override
	public Veiculo findById(int codigo) {
		return em.find(Veiculo.class, codigo);
	}

	@Override
	public List<Veiculo> findAll() {
		return em.createQuery("FROM Veiculo", Veiculo.class).getResultList();
	}
}
