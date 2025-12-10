package br.ifpe.jaboatao.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingresso")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingresso")
    private Integer id;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @Column(nullable = false, length = 10)
    private String horarioSessao;

    @Column(nullable = false, length = 10)
    private String assento;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false, length = 30)
    private String formaPagamento;

    @Column(nullable = false, unique = true, length = 50)
    private String codigoConfirmacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_filme")
    private Filme filme;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Ingresso() {
        // GERA AUTOMÁTICO
        this.codigoConfirmacao = gerarCodigoConfirmacao();
        this.dataCompra = LocalDate.now();
    }


public  Ingresso(Integer id, LocalDate dataCompra, String horarioSessao, String assento,
                    float valor, String formaPagamento,
                    Filme filme, Cliente cliente) {

        this.id = id;
        this.dataCompra = dataCompra;
        this.horarioSessao = horarioSessao;
        this.assento = assento;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.filme = filme;
        this.cliente = cliente;

        // GERA AUTOMÁTICO TAMBÉM NO CONSTRUTOR
        this.codigoConfirmacao = gerarCodigoConfirmacao();
    }

    //  MÉTODO QUE GERA O CÓDIGO ALEATÓRIO 
    public static String gerarCodigoConfirmacao() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 12)
                .toUpperCase();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getHorarioSessao() {
        return this.horarioSessao;
    }

    public void setHorarioSessao(String horarioSessao) {
        this.horarioSessao = horarioSessao;
    }

    public String getAssento() {
        return this.assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getCodigoConfirmacao() {
        return this.codigoConfirmacao;
    }

    public void setCodigoConfirmacao(String codigoConfirmacao) {
        this.codigoConfirmacao = codigoConfirmacao;
    }

    public Filme getFilme() {
        return this.filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
