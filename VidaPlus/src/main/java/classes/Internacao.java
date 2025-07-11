/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Internacao {
    
    private int id;
    private int idConsulta;
    private int idMedico;
    private int idLeito;
    private int idProntuario;
    private boolean aguardandoAprovacao;
    private boolean statusAlta;
    private String observacoes;

    public Internacao(int idConsulta, int idMedico, int idProntuario, boolean aguardandoAprovacao, boolean statusAlta, String observacoes) {
        this.idConsulta = idConsulta;
        this.idMedico = idMedico;
        this.idProntuario = idProntuario;
        this.aguardandoAprovacao = aguardandoAprovacao;
        this.statusAlta = statusAlta;
        this.observacoes = observacoes;
    }

    public Internacao(int id, int idConsulta, int idMedico, int idLeito, int idProntuario, boolean aguardandoAprovacao, boolean statusAlta, String observacoes) {
        this.id = id;
        this.idConsulta = idConsulta;
        this.idMedico = idMedico;
        this.idLeito = idLeito;
        this.idProntuario = idProntuario;
        this.aguardandoAprovacao = aguardandoAprovacao;
        this.statusAlta = statusAlta;
        this.observacoes = observacoes;
    }

    public Internacao(int id, int idConsulta, int idMedico, int idProntuario, boolean aguardandoAprovacao, boolean statusAlta, String observacoes) {
        this.id = id;
        this.idConsulta = idConsulta;
        this.idMedico = idMedico;
        this.idProntuario = idProntuario;
        this.aguardandoAprovacao = aguardandoAprovacao;
        this.statusAlta = statusAlta;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdLeito() {
        return idLeito;
    }

    public void setIdLeito(int idLeito) {
        this.idLeito = idLeito;
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public boolean isAguardandoAprovacao() {
        return aguardandoAprovacao;
    }

    public void setAguardandoAprovacao(boolean aguardandoAprovacao) {
        this.aguardandoAprovacao = aguardandoAprovacao;
    }

    public boolean isStatusAlta() {
        return statusAlta;
    }

    public void setStatusAlta(boolean statusAlta) {
        this.statusAlta = statusAlta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Internacao{" + "id=" + id + ", idConsulta=" + idConsulta + ", idMedico=" + idMedico + ", idLeito=" + idLeito + ", idProntuario=" + idProntuario + ", aguardandoAprovacao=" + aguardandoAprovacao + ", statusAlta=" + statusAlta + ", observacoes=" + observacoes + '}';
    }
    
    
    
}
