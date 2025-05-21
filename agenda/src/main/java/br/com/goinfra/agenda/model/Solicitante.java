package br.com.goinfra.agenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "solicitante")

public class Solicitante implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    private String departamento;

    @OneToMany(mappedBy ="solicitante", cascade = CascadeType.ALL)
    private List<Agenda> agendamentos = new ArrayList<>();

    public Solicitante(List<Agenda> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @JsonIgnore
    public List<Agenda> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamento(List<Agenda> agendamentos) {
        this.agendamentos = agendamentos;
    }

    private Solicitante(){
    }

    public Solicitante(Integer id, String cpf, String nome, String departamento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
