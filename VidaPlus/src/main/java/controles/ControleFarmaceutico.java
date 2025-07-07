/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import classes.Farmaceutico;
import dao.FarmaceuticoDAO;

/**
 *
 * @author Amanda
 */
public class ControleFarmaceutico {
    
    private FarmaceuticoDAO farmaceuticoDAO;

    public ControleFarmaceutico() {
        this.farmaceuticoDAO = new FarmaceuticoDAO();
    }
    
    public Farmaceutico buscaFarmaceutico(String crf){
        Farmaceutico farmaceutico = farmaceuticoDAO.buscaEnfermeiroPorCRF(crf);
        return farmaceutico;
    }
    
    public boolean cadastraFarmaceutico(Farmaceutico farmaceutico){
        boolean confirmacao = farmaceuticoDAO.cadastrarFarmaceutico(farmaceutico);
        return confirmacao;
    }
    
}
