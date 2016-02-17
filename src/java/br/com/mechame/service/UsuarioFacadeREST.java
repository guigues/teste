/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mechame.service;

import br.com.mechame.Usuario;
import br.com.mechame.facade.UsuarioFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Pablo
 */
@Stateless
@Path("usuario")
public class UsuarioFacadeREST extends UsuarioFacade {
    @PersistenceContext(unitName = "ApiMeChamePU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Path("inserir")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Path("editar")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void edit(Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("excluir/{telefone}")
    public void remove(@PathParam("telefone") Long telefone) {
        super.remove(super.find(telefone));
    }

    @GET
    @Path("unico/{telefone}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Usuario find(@PathParam("telefone") Long telefone) {
        return super.findByTelefone(telefone);
    }
    
    @GET
    @Override
    @Path("todos")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Usuario> findAll() {
        return super.findAll();
    }
    
    @POST
    @Override
    @Path("login")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Usuario login(Usuario entity) {
        return super.login(entity);
    }
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
