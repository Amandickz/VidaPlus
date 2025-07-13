/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class HistoricoInternacao {
    
    private int id;
    private int idPrescricao;
    private int idEnfermeiro;
    private String data;
    private String hora;
    private String prescricao;
    private String anotacoes;

    public HistoricoInternacao(int idPrescricao, int idEnfermeiro, String data, String hora, String prescricao) {
        this.idPrescricao = idPrescricao;
        this.idEnfermeiro = idEnfermeiro;
        this.data = data;
        this.hora = hora;
        this.prescricao = prescricao;
    }

    
    
    public HistoricoInternacao(int id, int idPrescricao, int idEnfermeiro, String data, String hora, String prescricao) {
        this.id = id;
        this.idPrescricao = idPrescricao;
        this.idEnfermeiro = idEnfermeiro;
        this.data = data;
        this.hora = hora;
        this.prescricao = prescricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrescricao() {
        return idPrescricao;
    }

    public void setIdPrescricao(int idPrescricao) {
        this.idPrescricao = idPrescricao;
    }

    public int getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(int idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return "HistoricoInternacao{" + "id=" + id + ", idPrescricao=" + idPrescricao + ", idEnfermeiro=" + idEnfermeiro + ", data=" + data + ", hora=" + hora + ", prescricao=" + prescricao + ", anotacoes=" + anotacoes + '}';
    }
    
}
