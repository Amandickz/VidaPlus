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
    
    private int id;
    private String queixa;
    private String diagnostico;
    private String prescricao;

    public Consulta(String queixa, String diagnostico, String prescricao) {
        this.queixa = queixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    public Consulta(int id, String queixa, String diagnostico, String prescricao) {
        this.id = id;
        this.queixa = queixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
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

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", queixa=" + queixa + ", diagnostico=" + diagnostico + ", prescricao=" + prescricao + '}';
    }
    
}
