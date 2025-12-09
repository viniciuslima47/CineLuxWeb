package br.ifpe.jaboatao.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(nullable = false)
    private Float salario;

    @Column(length = 20)
    private String turno;

    @Column(nullable = false)
    private LocalDate dataContratacao;

    public Funcionario() {}

    public Funcionario(Integer idPessoa, String nome, String cpf, LocalDate dataNasc,
                       String telefone, String email, String senha,
                       String cargo, Float salario, String turno, LocalDate dataContratacao) {

        super(idPessoa, nome, cpf, dataNasc, telefone, email, senha);

        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
        this.dataContratacao = dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
