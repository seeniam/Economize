/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOUsuario;
import Model.Usuario;

/**
 *
 * @author Saimeen
 */
public class UsuarioController {
    
    private DAOUsuario daoUsuario;

    public UsuarioController(){
        this.daoUsuario = new DAOUsuario();
    }
    
    public boolean insereUsuario(String nome, String senha, String email) {
        return this.daoUsuario.salvaUsuario(nome, senha, email);
    }
    
    public int getID_Usuario(String nome, String senha){
        return this.daoUsuario.getID_Usuario(nome, senha);
    }
    
    public void atualizaRenda(double novaRenda, int idRenda) {
        Usuario user = LoginController.getUsuario();
        user.adcionaValor(novaRenda);            
        this.daoUsuario.updateValorTotal(user);
        
    }



    
}
