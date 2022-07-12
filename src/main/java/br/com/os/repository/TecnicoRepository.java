package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.os.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
