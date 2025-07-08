/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Consulta {
    
    private int idAgenda;
    private int idProntuario;
    private String queixa;
    private String sintomas;
    private int pressao;
    private int frequenciaCardiaca;
    private int temperatura;
    private String diagnostico;
    private String prescricao;
    private String observacoes;

    public Consulta(int id, int idProntuario, String queixa, String sintomas, int pressao, int frequenciaCardiaca, int temperatura, String diagnostico, String prescricao) {
        this.idAgenda = id;
        this.idProntuario = idProntuario;
        this.queixa = queixa;
        this.sintomas = sintomas;
        this.pressao = pressao;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.temperatura = temperatura;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    public Consulta(int idProntuario, String queixa, String sintomas, int pressao, int frequenciaCardiaca, int temperatura, String diagnostico, String prescricao) {
        this.idProntuario = idProntuario;
        this.queixa = queixa;
        this.sintomas = sintomas;
        this.pressao = pressao;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.temperatura = temperatura;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + idAgenda + ", idProntuario=" + idProntuario + ", queixa=" + queixa + ", sintomas=" + sintomas + ", pressao=" + pressao + ", frequenciaCardiaca=" + frequenciaCardiaca + ", temperatura=" + temperatura + ", diagnostico=" + diagnostico + ", prescricao=" + prescricao + ", observacoes=" + observacoes + '}';
    }
    
}
