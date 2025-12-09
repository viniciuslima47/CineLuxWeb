package br.ifpe.jaboatao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; // Adicionar este import
import org.springframework.data.repository.query.Param;

import br.ifpe.jaboatao.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

    @Query(value="select * from cineluxweb.pessoa where cpf = :cpf and senha = :senha", nativeQuery = true)
    public Pessoa login(@Param("cpf") String cpf, @Param("senha") String senha);

}