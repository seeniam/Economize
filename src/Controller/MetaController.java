/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOMeta;
import java.util.Calendar;

/**
 *
 * @author Saimeen
 */
public class MetaController {
    private DAOMeta daoMeta;
    private Calendar data;

    public MetaController() {
        this.daoMeta = new DAOMeta();
        this.data = Calendar.getInstance();
    }
    
    public boolean insereMeta(String categoria, double valor, int limite, int codCliente) {
        String dataLimite = calculaData(limite);
        CategoriaController c = new CategoriaController();
        int fk_categoriaGasto=c.buscaIdCategoriaPorNome(categoria);
        
        if(this.daoMeta.salvaMeta(categoria, valor, dataLimite, codCliente, fk_categoriaGasto))
            return true;
        return false;
    }
    
    private String calculaData(int limite){
        int mesAtual = (data.get(Calendar.MONTH)+1);
        int resultado;
        if((mesAtual+limite) > 12){
             resultado = 12 - mesAtual;
             mesAtual= limite - resultado;
        }else
            mesAtual += limite;
        
        return ""+data.get(Calendar.YEAR)+"-"+mesAtual+"-"+data.get(Calendar.DATE);
    }
}
