package br.com.goinfra.agenda.controller;

import br.com.goinfra.agenda.model.Agenda;
import br.com.goinfra.agenda.model.Solicitante;
import br.com.goinfra.agenda.repository.AgendaRepository;
import br.com.goinfra.agenda.repository.SolicitanteRepository;
import br.com.goinfra.agenda.service.AgendaService;
import br.com.goinfra.agenda.service.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class AgendaController {

    private final Logger log = LoggerFactory.getLogger(AgendaController.class);
    @Autowired
    private AgendaService service;

    @Autowired
    private AgendaRepository repository;

    @Autowired
    private SolicitanteService solicitanteService;

    @Autowired
    private SolicitanteRepository solicitanteRepository;



    @CrossOrigin(origins = "*")
    @RequestMapping(value="/agenda/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Agenda obj = service.buscar(id);

        return ResponseEntity.ok().body(obj);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/agenda", method= RequestMethod.GET, produces = "application/json")
    public Map<String, List<Agenda>> findAll() {
        HashMap<String, List<Agenda>> map = new HashMap<String, List<Agenda>>();
        List<Agenda> list = repository.findAll();
        map.put("agendas", list);
        return map;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/agenda", method= RequestMethod.POST)
    ResponseEntity<Agenda> createSolicitante(@RequestBody Agenda agenda) throws URISyntaxException {

        Solicitante solicitante = solicitanteService.findCPF(agenda.getSolicitante().getCpf());

        agenda.setSolicitante(solicitante);

        log.info("Request to create agenda: {}", agenda);

            if (agenda.getEquipamento() == "true") {
                agenda.setEquipamento("Sim");
            } else {
                agenda.setEquipamento("Não");
            }
        Agenda result = repository.save(agenda);
        return ResponseEntity.created(new URI("/agenda/" + result.getId()))
                .body(result);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value ="agenda/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Agenda> update(@RequestBody Agenda agenda,@PathVariable Integer id ) throws URISyntaxException {

        if (agenda.getEquipamento() == "true") {
            agenda.setEquipamento("Sim");
        } else {
            agenda.setEquipamento("Não");
        }

        service.update(agenda);
        
        Agenda novaAgenda = service.buscar(id);
        return ResponseEntity.created(new URI("/agenda/" + novaAgenda.getId()))
                .body(novaAgenda);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
    @RequestMapping(value="agenda/{id}", method= RequestMethod.DELETE)
    public String delete(@PathVariable Integer id){
        repository.deleteById(id);
        return "Agenda "+ id +" excluída com sucesso!";
    }

}
