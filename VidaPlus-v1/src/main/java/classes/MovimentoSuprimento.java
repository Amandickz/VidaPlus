/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class MovimentoSuprimento {
    
   private int id;
   private int idFarmaceutico;
   private int idSuprimento;
   private int idHistoricoInternacao;
   private int quantidade;
   private String data;
   private String hora;
   private boolean entregue;

    public MovimentoSuprimento(int idFarmaceutico, int idSuprimento, int idHistoricoInternacao, int quantidade, String data, String hora) {
        this.idFarmaceutico = idFarmaceutico;
        this.idSuprimento = idSuprimento;
        this.idHistoricoInternacao = idHistoricoInternacao;
        this.quantidade = quantidade;
        this.data = data;
        this.hora = hora;
    }

    public MovimentoSuprimento(int id, int idFarmaceutico, int idSuprimento, int idHistoricoInternacao, int quantidade, String data, String hora, boolean entregue) {
        this.id = id;
        this.idFarmaceutico = idFarmaceutico;
        this.idSuprimento = idSuprimento;
        this.idHistoricoInternacao = idHistoricoInternacao;
        this.quantidade = quantidade;
        this.data = data;
        this.hora = hora;
        this.entregue = entregue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFarmaceutico() {
        return idFarmaceutico;
    }

    public void setIdFarmaceutico(int idFarmaceutico) {
        this.idFarmaceutico = idFarmaceutico;
    }

    public int getIdSuprimento() {
        return idSuprimento;
    }

    public void setIdSuprimento(int idSuprimento) {
        this.idSuprimento = idSuprimento;
    }

    public int getIdHistoricoInternacao() {
        return idHistoricoInternacao;
    }

    public void setIdHistoricoInternacao(int idHistoricoInternacao) {
        this.idHistoricoInternacao = idHistoricoInternacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    @Override
    public String toString() {
        return "MovimentoSuprimento{" + "id=" + id + ", idFarmaceutico=" + idFarmaceutico + ", idSuprimento=" + idSuprimento + ", idHistoricoInternacao=" + idHistoricoInternacao + ", quantidade=" + quantidade + ", data=" + data + ", hora=" + hora + ", entregue=" + entregue + '}';
    }
    
}
