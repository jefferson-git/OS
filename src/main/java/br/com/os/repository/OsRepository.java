package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.os.model.Os;

public interface OsRepository extends JpaRepository<Os, Integer>{

}
