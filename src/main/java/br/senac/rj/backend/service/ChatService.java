package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.ChatDao;
import br.senac.rj.backend.entity.Chatentity;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Chatentity.
 */
public class ChatService {
    private final ChatDao dao = new ChatDao();

    public Response salvar(Chatentity chat) {
    	Chatentity chatSalvo = dao.salvar(chat);
        if (chatSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o CHAT.\"}")
            		.build();
        }
        return Response.ok(chatSalvo).build();
    }

    public Response buscar(Long id) {
        Chatentity ChatentityObtido = dao.buscarPorId(id);
        if (ChatentityObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Chatentity não encontrado.\"}")
            		.build();
        }
        return Response.ok(ChatentityObtido).build();
    }
}
