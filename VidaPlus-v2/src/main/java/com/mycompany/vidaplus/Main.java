/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vidaplus;

import classes.Administracao;
import com.google.gson.Gson;
import controles.ControleAdministracao;
import static spark.Spark.*;

/**
 *
 * @author Amanda
 */
public class Main {

    public static void main(String[] args) {
        
        port(4567);
        Gson gson = new Gson();
        ControleAdministracao controleAdministracao = new ControleAdministracao();
        
        post("/administrador", (req,res) -> {
            String json = req.body();
            Administracao administracao = gson.fromJson(json, Administracao.class);
            return controleAdministracao.cadastraAdministracao(administracao);
        });
        
        get("/administrador",(req,res) -> {
            return controleAdministracao.recuperaAdministracao();
        });
        
    }
}
