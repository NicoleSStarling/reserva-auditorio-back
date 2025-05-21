package br.com.goinfra.agenda;

import br.com.goinfra.agenda.model.Agenda;
import br.com.goinfra.agenda.model.Solicitante;
import br.com.goinfra.agenda.repository.AgendaRepository;
import br.com.goinfra.agenda.repository.SolicitanteRepository;
import br.com.goinfra.agenda.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AgendaApplication  implements CommandLineRunner {

	@Autowired
	private SolicitanteRepository solicitanteRepository;

	@Autowired
	private AgendaRepository agendaRepository;

	public static void main(String[] args)  {
		SpringApplication.run(AgendaApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception{
		Solicitante sol1 = new Solicitante(null,"12345678910","Pedro Henrique","Tecnologia da Informação");
		Solicitante sol2 = new Solicitante(null,"10987654321","João da Silva","Vendas");
		Solicitante sol3 = new Solicitante(null, "22222222222", "Marcelo da Silveira", "Recursos Humanos");
		solicitanteRepository.saveAll(Arrays.asList(sol1,sol2,sol3));


		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Agenda ag1 = new Agenda(null, sol1, 208,  "Auditório", "16/02/2023","16/02/2023", "14:00", "14:30","Deixar datashow ligado", "Sim");
		Agenda ag2 = new Agenda(null, sol2, 209,  "Sala de Treinamentos", "16/02/2023","16/02/2023", "14:00", "14:30","Equipamento de som","Não");

		agendaRepository.saveAll(Arrays.asList(ag1,ag2));
	}




}
