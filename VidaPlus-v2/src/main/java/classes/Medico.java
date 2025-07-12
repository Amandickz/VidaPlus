/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Medico extends ProfissionalSaude{
    
    private String crm;
    private String uf;
    private String dataInscricao;
    private int especialidade;

    public Medico(String crm, String uf, String dataInscricao, int especialidade, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        super(cpf, nome, telefone, email, dataNascimento, dataContratacao);
        this.crm = crm;
        this.uf = uf;
        this.dataInscricao = dataInscricao;
        this.especialidade = especialidade;
    }

    public Medico(String crm, String uf, String dataInscricao, int especialidade, int id, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        super(id, cpf, nome, telefone, email, dataNascimento, dataContratacao);
        this.crm = crm;
        this.uf = uf;
        this.dataInscricao = dataInscricao;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", uf=" + uf + ", dataInscricao=" + dataInscricao + ", especialidade=" + especialidade + '}';
    }
    
}
