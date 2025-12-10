package br.ifpe.jaboatao.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente extends Pessoa {

    @Column(nullable = false)
    private Integer nivelAcesso;

    @Column(nullable = false, length = 100)
    private String departamento;

    @Column(nullable = false)
    private Float salario;

    @Column(nullable = false)
    private LocalDate dataInicioGestao;

    public Gerente() {}

    public Gerente(Integer idPessoa, String nome, String cpf, LocalDate dataNasc,
                   String telefone, String email, String senha,
                   Integer nivelAcesso, String departamento,
                   Float salario, LocalDate dataInicioGestao) {

        super(idPessoa, nome, cpf, dataNasc, telefone, email, senha);

        this.nivelAcesso = nivelAcesso;
        this.departamento = departamento;
        this.salario = salario;
        this.dataInicioGestao = dataInicioGestao;
    }


    public Integer getNivelAcesso() {
        return this.nivelAcesso;
    }

    public void setNivelAcesso(Integer nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Float getSalario() {
        return this.salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public LocalDate getDataInicioGestao() {
        return this.dataInicioGestao;
    }

    public void setDataInicioGestao(LocalDate dataInicioGestao) {
        this.dataInicioGestao = dataInicioGestao;
    }

}