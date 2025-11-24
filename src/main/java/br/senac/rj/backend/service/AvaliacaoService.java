package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.AvaliacaoDao;
import br.senac.rj.backend.entity.Avaliacao;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Avaliacao.
 */
public class AvaliacaoService {
    private final AvaliacaoDao dao = new AvaliacaoDao();

    public Response salvar(Avaliacao avaliacao) {
        Avaliacao avaliacaoSalvo = dao.salvar(avaliacao);
        if (avaliacaoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar a Avaliação.\"}")
            		.build();
        }
        return Response.ok(avaliacaoSalvo).build();
    }

    public Response buscar(Long id) {
        Avaliacao AvaliacaoObtido = dao.buscarPorId(id);
        if (AvaliacaoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Avaliacao não encontrado.\"}")
            		.build();
        }
        return Response.ok(AvaliacaoObtido).build();
    }
}
