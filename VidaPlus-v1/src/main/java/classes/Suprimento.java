/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Suprimento {
    
    private int id;
    private int idAdministracao;
    private int tipo;
    private String nome;
    private double valorUnitario;
    private int quantidadeEstoque;

    public Suprimento(int idAdministracao, int tipo, String nome, double valorUnitario, int quantidadeEstoque) {
        this.idAdministracao = idAdministracao;
        this.tipo = tipo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Suprimento(int id, int idAdministracao, int tipo, String nome, double valorUnitario, int quantidadeEstoque) {
        this.id = id;
        this.idAdministracao = idAdministracao;
        this.tipo = tipo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAdministracao() {
        return idAdministracao;
    }

    public void setIdAdministracao(int idAdministracao) {
        this.idAdministracao = idAdministracao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Suprimento{" + "id=" + id + ", idAdministracao=" + idAdministracao + ", tipo=" + tipo + ", nome=" + nome + ", valorUnitario=" + valorUnitario + ", quantidadeEstoque=" + quantidadeEstoque + '}';
    }
    
}
