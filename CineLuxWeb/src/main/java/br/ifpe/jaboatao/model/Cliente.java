package br.ifpe.jaboatao.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @Column(nullable = false)
    private boolean cartaoFidelidade;

    @Column
    private Integer pontosFidelidade;

    @Column(length = 50)
    private String genero;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    public Cliente() {}

    public Cliente(Integer idPessoa, String nome, String cpf, LocalDate dataNasc,
                   String telefone, String email, String senha,
                   boolean cartaoFidelidade, Integer pontosFidelidade,
                   String genero, LocalDate dataCadastro) {

        super(idPessoa, nome, cpf, dataNasc, telefone, email, senha);

        this.cartaoFidelidade = cartaoFidelidade;
        this.pontosFidelidade = pontosFidelidade;
        this.genero = genero;
        this.dataCadastro = dataCadastro;
    }

    public boolean isCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(boolean cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }

    public Integer getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(Integer pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
