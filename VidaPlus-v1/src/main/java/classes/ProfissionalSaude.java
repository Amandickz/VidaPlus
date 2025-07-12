/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class ProfissionalSaude {
    
    private int id;
    private int idAdministracao;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String dataContratacao;

    public ProfissionalSaude(String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
    }

    public ProfissionalSaude(int id, String cpf, String nome, String telefone, String email, String dataNascimento, String dataContratacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public int getIdAdministracao() {
        return idAdministracao;
    }

    public void setIdAdministracao(int idAdministracao) {
        this.idAdministracao = idAdministracao;
    }
    
    @Override
    public String toString() {
        return "ProfissionalSaude{" + "id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + ", dataContratacao=" + dataContratacao + '}';
    }
    
}
