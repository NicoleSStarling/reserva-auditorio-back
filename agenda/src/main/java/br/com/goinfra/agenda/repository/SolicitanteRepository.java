package br.com.goinfra.agenda.repository;


import br.com.goinfra.agenda.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {

    Optional<Solicitante> findByCpf(String cpf);
}
