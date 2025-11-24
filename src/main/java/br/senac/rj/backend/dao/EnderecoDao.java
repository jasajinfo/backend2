package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Enderecoentity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EnderecoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Enderecoentity salvar(Enderecoentity endereco) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Enderecoentity EnderecoentitySalvo = em.merge(endereco); // obter objeto completo salvo
			em.getTransaction().commit();
			return EnderecoentitySalvo;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // desfazer transações pendentes
			}
			e.printStackTrace(); // Para depuração
			return null;
		} finally {
			em.close();
		}
	}

	public Enderecoentity buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Enderecoentity.class, id);
		} finally {
			em.close();
		}
	}
}
