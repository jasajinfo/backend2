package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Pagamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PagamentoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Pagamento salvar(Pagamento pagamento) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Pagamento PagamentoSalvo = em.merge(pagamento); // obter objeto completo salvo
			em.getTransaction().commit();
			return PagamentoSalvo;
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

	public Pagamento buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Pagamento.class, id);
		} finally {
			em.close();
		}
	}
}
