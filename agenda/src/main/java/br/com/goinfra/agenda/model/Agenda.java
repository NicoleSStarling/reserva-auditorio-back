package br.com.goinfra.agenda.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Solicitante solicitante;

    private Integer ramal;
    private String local;
    private String dataInicial;
    private String dataFinal;
    private String horaInicial;
    private String horaFinal;

    private String descricao;
    private String equipamento;

    private Agenda(){
    }

    public Agenda(Integer id, Solicitante solicitante, Integer ramal, String local, String dataInicial, String dataFinal, String horaInicial, String horaFinal,String descricao, String equipamento) {
        this.id = id;
        this.solicitante = solicitante;
        this.ramal = ramal;
        this.local = local;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.descricao = descricao;
        this.equipamento = equipamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
