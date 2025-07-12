/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Consulta;
import dao.ConsultaDAO;

/**
 *
 * @author Amanda
 */
public class ControleConsulta {
    
    private ConsultaDAO consultaDAO;

    public ControleConsulta() {
        this.consultaDAO = new ConsultaDAO();
    }
    
    public boolean salvarConsulta(Consulta consulta){
        boolean confirmacao = consultaDAO.salvarConsulta(consulta);
        return confirmacao;
    }
    
}
