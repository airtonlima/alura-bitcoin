package br.dev.airtonlima.service;

import br.dev.airtonlima.models.Ordem;
import br.dev.airtonlima.models.Usuario;
import br.dev.airtonlima.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void insert(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O usuário logado é diferente do userID");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("SENT");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> list() {
        return ordemRepository.listAll();
    }
}
