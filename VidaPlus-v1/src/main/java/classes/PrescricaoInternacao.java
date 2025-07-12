/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class PrescricaoInternacao {
    
    private int id;
    private int idInternacao;
    private String data;
    private String prescricao;
    private String orientacoes;
    private String observacoes;
    private boolean realizado;

    public PrescricaoInternacao(int idInternacao, String data, String prescricao) {
        this.idInternacao = idInternacao;
        this.data = data;
        this.prescricao = prescricao;
    }

    public PrescricaoInternacao(int id, int idInternacao, String data, String prescricao) {
        this.id = id;
        this.idInternacao = idInternacao;
        this.data = data;
        this.prescricao = prescricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInternacao() {
        return idInternacao;
    }

    public void setIdInternacao(int idInternacao) {
        this.idInternacao = idInternacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getOrientacoes() {
        return orientacoes;
    }

    public void setOrientacoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    @Override
    public String toString() {
        return "PrescricaoInternacao{" + "id=" + id + ", idInternacao=" + idInternacao + ", data=" + data + ", prescricao=" + prescricao + ", orientacoes=" + orientacoes + ", observacoes=" + observacoes + ", realizado=" + realizado + '}';
    }
    
}
