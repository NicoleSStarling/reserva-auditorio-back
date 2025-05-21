package br.com.goinfra.agenda.service;

import br.com.goinfra.agenda.model.Agenda;
import br.com.goinfra.agenda.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repo;

    public Agenda buscar(Integer id){
        Optional<Agenda> obj = repo.findById(id);
        return obj.orElse(null);
    }

    public void  update(Agenda obj){
        Agenda agenda =  buscar(obj.getId());
        agenda.setSolicitante(obj.getSolicitante());
        agenda.setDataFinal(obj.getDataFinal());
        agenda.setDataInicial(obj.getDataInicial());
        agenda.setDescricao(obj.getDescricao());
        agenda.setEquipamento(obj.getEquipamento());
        agenda.setHoraInicial(obj.getHoraInicial());
        agenda.setHoraFinal(obj.getHoraFinal());
        agenda.setRamal(obj.getRamal());
        agenda.setLocal(obj.getLocal());

        repo.save(agenda);
    }
}
