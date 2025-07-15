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
    private int idPaciente;
    private int idMedico;
    private String data;
    private String hora;
    private int status;

    public Agenda(String data, String hora, int status) {
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public Agenda(int idMedico, String data, String hora, int status) {
        this.idMedico = idMedico;
        this.data = data;
        this.hora = hora;
        this.status = status;
    }
    
    public Agenda(int id, int idMedico, String data, String hora, int status) {
        this.id = id;
        this.idMedico = idMedico;
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public Agenda(int id, int idPaciente, int idMedico, String data, String hora, int status) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
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

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", idPaciente=" + idPaciente + ", idMedico=" + idMedico + ", data=" + data + ", hora=" + hora + ", status=" + status + '}';
    }
    
}
