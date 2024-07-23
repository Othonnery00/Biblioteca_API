package br.com.Biblioteca.escritor.repository;

import br.com.Biblioteca.escritor.domain.Escritor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscritorRepository extends JpaRepository<Escritor, Integer>{
}
