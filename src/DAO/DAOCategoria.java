/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author neemi
 */
public abstract class DAOCategoria {
    
    public abstract boolean salvaCategoria(Categoria categoria);
    
    public abstract int buscaID(Categoria categoria);
    
    public abstract Categoria buscaCategoriaPorDescricao(Categoria categoria);
    
    public abstract List<String> buscaDescricaoCategorias();
}
