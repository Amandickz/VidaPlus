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
    private String data;
    private String procedimentoRealizado;
    private int quantidade;
    private String anotacoes;

    public HistoricoInternacao(String data, String procedimentoRealizado, int quantidade, String anotacoes) {
        this.data = data;
        this.procedimentoRealizado = procedimentoRealizado;
        this.quantidade = quantidade;
        this.anotacoes = anotacoes;
    }

    public HistoricoInternacao(int id, String data, String procedimentoRealizado, int quantidade, String anotacoes) {
        this.id = id;
        this.data = data;
        this.procedimentoRealizado = procedimentoRealizado;
        this.quantidade = quantidade;
        this.anotacoes = anotacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProcedimentoRealizado() {
        return procedimentoRealizado;
    }

    public void setProcedimentoRealizado(String procedimentoRealizado) {
        this.procedimentoRealizado = procedimentoRealizado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return "HistoricoInternacao{" + "id=" + id + ", data=" + data + ", procedimentoRealizado=" + procedimentoRealizado + ", quantidade=" + quantidade + ", anotacoes=" + anotacoes + '}';
    }
    
}
