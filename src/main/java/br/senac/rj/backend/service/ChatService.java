package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.PagamentoDao;
import br.senac.rj.backend.entity.Pagamento;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Chat.
 */
public class ChatService {
    private final ChatDao dao = new ChatDao();

    public Response salvar(Chatpagamento) {
    	Chat pagamentoSalvo = dao.salvar(pagamento);
        if (pagamentoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o pagamento.\"}")
            		.build();
        }
        return Response.ok(chatSalvo).build();
    }

    public Response buscar(Long id) {
        Chat ChatObtido = dao.buscarPorId(id);
        if (ChatObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Chat não encontrado.\"}")
            		.build();
        }
        return Response.ok(ChatObtido).build();
    }
}
