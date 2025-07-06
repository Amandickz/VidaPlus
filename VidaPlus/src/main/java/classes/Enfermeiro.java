/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Enfermeiro extends ProfissionalSaude{
    
    private String coren;
    private String uf;
    private String dataEmissao;
    private int tipo;

    public Enfermeiro(String coren, String uf, String dataEmissao, int tipo, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        super(cpf, nome, telefone, email, dataNascimento, dataContratacao);
        this.coren = coren;
        this.uf = uf;
        this.dataEmissao = dataEmissao;
        this.tipo = tipo;
    }

    public Enfermeiro(String coren, String uf, String dataEmissao, int tipo, int id, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        super(id, cpf, nome, telefone, email, dataNascimento, dataContratacao);
        this.coren = coren;
        this.uf = uf;
        this.dataEmissao = dataEmissao;
        this.tipo = tipo;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" + "coren=" + coren + ", uf=" + uf + ", dataEmissao=" + dataEmissao + ", tipo=" + tipo + '}';
    }
    
}
