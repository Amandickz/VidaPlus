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
    private String suprimentos;
    private boolean solicitacaoAtendida;

    public HistoricoInternacao(int idPrescricao, int idEnfermeiro, String data, String hora, String suprimentos) {
        this.idPrescricao = idPrescricao;
        this.idEnfermeiro = idEnfermeiro;
        this.data = data;
        this.hora = hora;
        this.suprimentos = suprimentos;
    }

    public HistoricoInternacao(int id, int idPrescricao, int idEnfermeiro, String data, String hora, String suprimentos, boolean solicitacaoAtendida) {
        this.id = id;
        this.idPrescricao = idPrescricao;
        this.idEnfermeiro = idEnfermeiro;
        this.data = data;
        this.hora = hora;
        this.suprimentos = suprimentos;
        this.solicitacaoAtendida = solicitacaoAtendida;
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

    public String getSuprimentos() {
        return suprimentos;
    }

    public void setSuprimentos(String suprimentos) {
        this.suprimentos = suprimentos;
    }

    public boolean isSolicitacaoAtendida() {
        return solicitacaoAtendida;
    }

    public void setSolicitacaoAtendida(boolean solicitacaoAtendida) {
        this.solicitacaoAtendida = solicitacaoAtendida;
    }

    @Override
    public String toString() {
        return "HistoricoInternacao{" + "id=" + id + ", idPrescricao=" + idPrescricao + ", idEnfermeiro=" + idEnfermeiro + ", data=" + data + ", hora=" + hora + ", suprimentos=" + suprimentos + ", solicitacaoAtendida=" + solicitacaoAtendida + '}';
    }
    
}
