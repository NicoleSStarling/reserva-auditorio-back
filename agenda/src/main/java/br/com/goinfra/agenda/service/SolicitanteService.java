package br.com.goinfra.agenda.service;

import br.com.goinfra.agenda.model.Solicitante;
import br.com.goinfra.agenda.repository.SolicitanteRepository;
import br.com.goinfra.agenda.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolicitanteService {

    @Autowired
    private SolicitanteRepository repo;

    public Solicitante findCPF(String cpf) {
        Optional<Solicitante> obj = repo.findByCpf(cpf);
        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpf + " " +  Solicitante.class.getName()));
    }
}
