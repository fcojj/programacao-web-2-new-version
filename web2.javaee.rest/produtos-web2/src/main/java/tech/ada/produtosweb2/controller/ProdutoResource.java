package tech.ada.produtosweb2.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import tech.ada.produtosweb2.model.Produto;
import tech.ada.produtosweb2.service.ProdutoService;

@Path("/produtos")
public class ProdutoResource {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProdutos(@QueryParam("nome") String nome) {
        var product = produtoService.getProdutos(nome);

        if (product != null) {
            return Response.ok(product).build();
        }
        return Response.noContent().build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduto(Produto produto) {
        var produtoCreated = produtoService.addProduto(produto);

        return Response.ok(produtoCreated)
                       .status(Response.Status.CREATED)
                       .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduto(@PathParam("id") int id) {
        produtoService.deleteProduto(id);

        return Response.noContent().build();
    }


}