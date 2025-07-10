/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum ServicoProntuario {
    
    UM("CRIAÇÃO/ATUALIZAÇÃO ANAMNESE"),
    DOIS("CONSULTA REALIZADA - ALTA"),
    TRES("CONSULTA REALIZADA - ENCAMINHADO INTERNAÇÃO"),
    QUATRO("INTERNAÇÃO"),
    CINCO("ALTA DA INTERNAÇÃO"),
    SEIS("REALIZAÇÃO DE PROCEDIMENTO"),
    SETE("APLICAÇÃO DE MEDICAMENTO");
    
    private String servico;

    ServicoProntuario(String servico) {
        this.servico = servico;
    }

    public String getServico() {
        return servico;
    }
    
}
