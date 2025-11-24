package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Chat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ChatDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Chat salvar(Chat chat) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Chat ChatSalvo = em.merge(chat); // obter objeto completo salvo
			em.getTransaction().commit();
			return ChatoSalvo;
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

	public Chat buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Chat.class, id);
		} finally {
			em.close();
		}
	}
}
