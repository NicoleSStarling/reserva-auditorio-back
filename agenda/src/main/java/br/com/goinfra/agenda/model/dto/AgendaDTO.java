package br.com.goinfra.agenda.model.dto;

import lombok.Data;

@Data
public class AgendaDTO {

    private Integer id;
    private String solicitante_cpf;
    private Integer ramal;
    private String local;
    private String dataInicial;
    private String dataFinal;
    private String horaInicial;
    private String horaFinal;
}
