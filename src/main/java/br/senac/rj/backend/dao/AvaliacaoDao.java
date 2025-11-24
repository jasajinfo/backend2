package br.senac.rj.backend.dao;

import br.senac.rj.backend.Entity.Avaliacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AvaliacaoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Avaliacao salvar(Avaliacao avaliacao) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Avaliacao AvaliacaoSalvo = em.merge(avaliacao); // obter objeto completo salvo
			em.getTransaction().commit();
			return AvaliacaoSalvo;
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

	public Avaliacao buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Avaliacao.class, id);
		} finally {
			em.close();
		}
	}
}
