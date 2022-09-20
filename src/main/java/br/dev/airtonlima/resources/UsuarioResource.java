package br.dev.airtonlima.resources;

import br.dev.airtonlima.models.Usuario;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {
    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Usuario usuario) {
        Usuario.inserir(usuario);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> list() {
        return Usuario.listAll();
    }
}
