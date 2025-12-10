package br.ifpe.jaboatao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.jaboatao.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
