/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum ServicoConsulta {
    
    C("CONCLUIR CONSULTA"),
    I("ENCAMINHAR PARA INTERNAÇÃO"),
    R("RETORNO EM 15 DIAS");
    
    private String situacaoConsulta;

    ServicoConsulta(String situacaoConsulta) {
        this.situacaoConsulta = situacaoConsulta;
    }

    public String getSituacaoConsulta() {
        return situacaoConsulta;
    }
    
}
