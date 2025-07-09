/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Amanda
 */
public enum Servico {
    
    C("CONCLUIR CONSULTA"),
    I("ENCAMINHAR PARA INTERNAÇÃO"),
    E("EM TRATAMENTO"),
    R("RETORNO EM 15 DIAS"),
    A("ALTA DA INTERNAÇÃO");
    
    private String situacaoConsulta;

    Servico(String situacaoConsulta) {
        this.situacaoConsulta = situacaoConsulta;
    }

    public String getSituacaoConsulta() {
        return situacaoConsulta;
    }
    
}
