package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Produtoentity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Produtoentity salvar(Produtoentity produto) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Produtoentity ProdutoentitytoSalvo = em.merge(produto); // obter objeto completo salvo
			em.getTransaction().commit();
			return ProdutoentitytoSalvo;
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

	public Produtoentity buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Produtoentity.class, id);
		} finally {
			em.close();
		}
	}
}
