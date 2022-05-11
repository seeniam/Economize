/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Model.Categoria_de_Ganhos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neemi
 */
public class DAOCategoria_Ganhos extends DAOCategoria{    

    private Categoria_de_Ganhos categoria;
    
    public DAOCategoria_Ganhos() {
    }

    public DAOCategoria_Ganhos(Categoria_de_Ganhos categoria) {
        this.categoria = categoria;
    }
    
       
    @Override
    public boolean salvaCategoria(Categoria ganho) {  
        try{
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO `categoria_ganho` (`descricao`) "
                    + "VALUES ('"+ganho.getDescricao()+"');";
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}               
    }

    @Override
    public int buscaID(Categoria categoria) {
        int id = -1;
        Connection conn;
        try {
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            String sql = "SELECT idcategoria_ganho FROM categoria_ganho where descricao = '"+categoria.getDescricao()+"';";        
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                id = resultado.getInt("categoria_ganho.idcategoria_ganho");        
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }        
        return id;
    }

    @Override
    public Categoria buscaCategoriaPorDescricao(Categoria categoria) {
        int id = -1;
        
        Connection conn;
        try {
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            String sql = "SELECT idcategoria_ganho FROM categoria_ganho where descricao = '"+categoria.getDescricao()+"';";        
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                id = resultado.getInt("categoria_ganho.idcategoria_ganho");        
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        categoria.setIdCategoria(id);
        return categoria;
    }

    @Override
    public List<String> buscaDescricaoCategorias(){
        List<String> categorias = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT `descricao` FROM `categoria_ganho`;";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            
            while (res.next()) {                
                categorias.add(res.getString("categoria_ganho.descricao"));
            }
        } catch (Exception e) {
            System.out.println("Não há categorias de ganho cadastradas!");
            e.printStackTrace();
        }
        
        return categorias;
    }
}