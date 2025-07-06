/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Farmaceutico extends ProfissionalSaude{
    
    private String crf;
    private String uf;
    private int categoriaProfissional;
    private String dataConclusao;
    private String dataExpedicao;

    public Farmaceutico(String crf, String uf, int categoriaProfissional, String dataConclusao, String dataExpedicao, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        super(cpf, nome, telefone, email, dataNascimento, dataContratacao);
        this.crf = crf;
        this.uf = uf;
        this.categoriaProfissional = categoriaProfissional;
        this.dataConclusao = dataConclusao;
        this.dataExpedicao = dataExpedicao;
    }

    public Farmaceutico(String crf, String uf, int categoriaProfissional, String dataConclusao, String dataExpedicao, int id, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        super(id, cpf, nome, telefone, email, dataNascimento, dataContratacao);
        this.crf = crf;
        this.uf = uf;
        this.categoriaProfissional = categoriaProfissional;
        this.dataConclusao = dataConclusao;
        this.dataExpedicao = dataExpedicao;
    }

    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCategoriaProfissional() {
        return categoriaProfissional;
    }

    public void setCategoriaProfissional(int categoriaProfissional) {
        this.categoriaProfissional = categoriaProfissional;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    @Override
    public String toString() {
        return "Farmaceutico{" + "crf=" + crf + ", uf=" + uf + ", categoriaProfissional=" + categoriaProfissional + ", dataConclusao=" + dataConclusao + ", dataExpedicao=" + dataExpedicao + '}';
    }
    
}
