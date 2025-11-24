package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.PagamentoDao;
import br.senac.rj.backend.entity.Pagamento;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Pagamento.
 */
public class ProdutoService {
    private final PagamentoDao dao = new PagamentoDao();

    public Response salvar(Pagamento pagamento) {
        Pagamento pagamentoSalvo = dao.salvar(pagamento);
        if (pagamentoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o pagamento.\"}")
            		.build();
        }
        return Response.ok(pagamentoSalvo).build();
    }

    public Response buscar(Long id) {
        Pagamento PagamentoObtido = dao.buscarPorId(id);
        if (PagamentoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Pagamento não encontrado.\"}")
            		.build();
        }
        return Response.ok(PagamentoObtido).build();
    }
}
