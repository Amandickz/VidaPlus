/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class ProntuarioMedico {
    
    private int id;
    private int idPaciente;
    private int idAnamnese;
    private String dataAtualizacao;
    private String servico;

    public ProntuarioMedico(int idPaciente, int idAnamnese) {
        this.idPaciente = idPaciente;
        this.idAnamnese = idAnamnese;
    }

    public ProntuarioMedico(int id, int idPaciente, int idAnamnese) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idAnamnese = idAnamnese;
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

    public int getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "ProntuarioMedico{" + "id=" + id + ", idPaciente=" + idPaciente + ", idAnamnese=" + idAnamnese + ", dataAtualizacao=" + dataAtualizacao + ", servico=" + servico + '}';
    }
    
}
