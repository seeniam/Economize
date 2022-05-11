/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAORenda;
import Model.Renda;

/**
 *
 * @author Saimeen
 */
class RendaController {
    
    private DAORenda daoRenda;

    public RendaController() {
        this.daoRenda = new DAORenda();
    }

    void insereRenda(int codCliente) {
        double rendaInicial = 0;
        this.daoRenda.salvaRenda(rendaInicial, codCliente);
    }

    int getID_Renda(int codUsuario) {
        return this.daoRenda.buscaIdRendaPeloCliente(codUsuario);        
    }

    void atualizaRenda(double novaRenda, int idRenda) {
        Renda r = new Renda();
        r = this.daoRenda.buscaRenda(idRenda);
        novaRenda += r.getValorTotal();                          
        this.daoRenda.updateRenda(novaRenda, idRenda);
    }


}
