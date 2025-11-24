package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.AvaliacaoDao;
import br.senac.rj.backend.entity.Avaliacaoentity;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Avaliacaoentity.
 */
public class AvaliacaoService {
    private final AvaliacaoDao dao = new AvaliacaoDao();

    public Response salvar(Avaliacaoentity avaliacao) {
        Avaliacaoentity avaliacaoSalvo = dao.salvar(avaliacao);
        if (avaliacaoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar a Avaliação.\"}")
            		.build();
        }
        return Response.ok(avaliacaoSalvo).build();
    }

    public Response buscar(Long id) {
        Avaliacaoentity AvaliacaoentityObtido = dao.buscarPorId(id);
        if (AvaliacaoentityObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Avaliacaoentity não encontrado.\"}")
            		.build();
        }
        return Response.ok(AvaliacaoentityObtido).build();
    }
}
