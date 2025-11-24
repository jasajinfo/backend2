package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EnderecoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Endereco salvar(Endereco endereco) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Endereco EnderecoSalvo = em.merge(endereco); // obter objeto completo salvo
			em.getTransaction().commit();
			return EnderecoSalvo;
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

	public Endereco buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Endereco.class, id);
		} finally {
			em.close();
		}
	}
}
