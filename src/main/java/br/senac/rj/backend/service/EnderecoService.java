package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.EnderecoDao;
import br.senac.rj.backend.entity.Enderecoentity;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Endereço.
 */
public class EnderecoService {
    private final EnderecoDao dao = new EnderecoDao();

    public Response salvar(Enderecoentity endereco) {
    	Enderecoentity enderecoSalvo = dao.salvar(endereco);
        if (enderecoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o endereco.\"}")
            		.build();
        }
        return Response.ok(enderecoSalvo).build();
    }

    public Response buscar(Long id) {
    	Enderecoentity EnderecoObtido = dao.buscarPorId(id);
        if (EnderecoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Endereç não encontrado.\"}")
            		.build();
        }
        return Response.ok(EnderecoObtido).build();
    }
}
