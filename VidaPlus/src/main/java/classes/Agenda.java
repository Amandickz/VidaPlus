/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Agenda {
    
    private int id;
    private String data;
    private String hora;
    private int status;
    private int idPaciente;
    private int idMedico;

    public Agenda(String data, String hora, int status) {
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public Agenda(int id, String data, String hora, int status) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", data=" + data + ", hora=" + hora + ", status=" + status + ", idPaciente=" + idPaciente + ", idMedico=" + idMedico + '}';
    }
    
}
