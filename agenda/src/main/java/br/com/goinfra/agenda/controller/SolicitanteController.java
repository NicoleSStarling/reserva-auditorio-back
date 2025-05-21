package br.com.goinfra.agenda.controller;

import br.com.goinfra.agenda.model.Solicitante;
import br.com.goinfra.agenda.repository.SolicitanteRepository;
import br.com.goinfra.agenda.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SolicitanteController {


    private final Logger log = LoggerFactory.getLogger(SolicitanteController.class);

    @Autowired
    private SolicitanteService service;

    @Autowired
    SolicitanteRepository repository;


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/solicitante/{cpf}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable String cpf){
        Solicitante obj = service.findCPF(cpf);
        return ResponseEntity.ok().body(obj);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/solicitante", method= RequestMethod.GET)
    public ResponseEntity<List<Solicitante>> findAll(){
        List<Solicitante> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/solicitante", method= RequestMethod.POST)
    ResponseEntity<Solicitante> createSolicitante( @RequestBody Solicitante solicitante) throws URISyntaxException {
        log.info("Request to create solicitante: {}", solicitante);
        Solicitante result = repository.save(solicitante);
        return ResponseEntity.created(new URI("/api/group/" + result.getCpf()))
                .body(result);
    }

}
