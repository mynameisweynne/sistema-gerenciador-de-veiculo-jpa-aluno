package br.com.fuctura.application;

import br.com.fuctura.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager manager = factory.createEntityManager();

		Usuario usuario = new Usuario();
		usuario.setNome("Weynne Guimarães");
		usuario.setCpf("091.043.034-90");
		usuario.setIdade(32);

		manager.getTransaction().begin();
		manager.persist(usuario); //inserir
		manager.remove(usuario); //excluir
		manager.find(Usuario.class, pk); //find by id
		manager.getTransaction().commit();
	}

}
