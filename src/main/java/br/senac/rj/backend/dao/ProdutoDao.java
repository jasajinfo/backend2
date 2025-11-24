package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Produto salvar(Produto produto) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Produto ProdutotoSalvo = em.merge(produto); // obter objeto completo salvo
			em.getTransaction().commit();
			return ProdutoSalvo;
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

	public Produto buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Produto.class, id);
		} finally {
			em.close();
		}
	}
}
