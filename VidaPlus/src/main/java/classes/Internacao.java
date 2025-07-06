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
    private boolean status;
    private String observacao;

    public Internacao(boolean status, String observacao) {
        this.status = status;
        this.observacao = observacao;
    }

    public Internacao(int id, boolean status, String observacao) {
        this.id = id;
        this.status = status;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Internacao{" + "id=" + id + ", status=" + status + ", observacao=" + observacao + '}';
    }
    
}
