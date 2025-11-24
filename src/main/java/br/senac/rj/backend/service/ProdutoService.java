package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.ProdutoDao;
import br.senac.rj.backend.entity.Produtoentity;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Produto.
 */
public class ProdutoService {
    private final ProdutoDao dao = new ProdutoDao();

    public Response salvar(Produtoentity produto) {
    	Produtoentity produtoSalvo = dao.salvar(produto);
        if (produtoSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o produto.\"}")
            		.build();
        }
        return Response.ok(produtoSalvo).build();
    }

    public Response buscar(Long id) {
    	Produtoentity ProdutoObtido = dao.buscarPorId(id);
        if (ProdutoObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Produto não encontrado.\"}")
            		.build();
        }
        return Response.ok(ProdutoObtido).build();
    }
}
