package br.com.fuctura.dao.factory;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.dao.impl.VeiculoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAOFactory {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static VeiculoDAO createVeiculoDAO() {
		return new VeiculoDAOImpl(emf.createEntityManager());
	}
}