package br.dev.airtonlima.resources;

import br.dev.airtonlima.models.Ordem;
import br.dev.airtonlima.repository.OrdemRepository;
import br.dev.airtonlima.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@Path("/ordens")
public class OrdemResource {
    @Inject
    OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(@Context SecurityContext securityContext, Ordem ordem) {
        ordemService.insert(securityContext, ordem);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> list() {
        return ordemService.list();
    }
}
