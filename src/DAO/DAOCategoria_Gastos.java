/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Model.Categoria_de_Gastos;
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
public class DAOCategoria_Gastos extends DAOCategoria{
    
    private Categoria_de_Gastos categoria = new Categoria_de_Gastos();

    public DAOCategoria_Gastos(Categoria_de_Gastos categoria) {
        this.categoria = categoria;
    }

    public DAOCategoria_Gastos() {
    }
      
    @Override
    public boolean salvaCategoria(Categoria gasto) {  
        try{
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO `categoria_gasto` (`descricao`) "
                    + "VALUES ('"+gasto.getDescricao()+"');";
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
            String sql = "SELECT idcategoria_gasto FROM categoria_gasto where descricao = '"+categoria.getDescricao()+"';";        
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                id = resultado.getInt("categoria_gasto.idcategoria_gasto");        
                conn.close();
            }
        } catch(SQLException e) {
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
            String sql = "SELECT idcategoria_gasto FROM categoria_gasto where descricao = '"+categoria.getDescricao()+"';";        
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                id = resultado.getInt("categoria_gasto.idcategoria_gasto");        
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
            String sql = "SELECT `descricao` FROM `categoria_gasto`;";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            
            while (res.next()) {                
                categorias.add(res.getString("categoria_gasto.descricao"));
            }
        } catch (Exception e) {
            System.out.println("Não há categorias de gasto cadastradas!");
            e.printStackTrace();
        }
        
        return categorias;
    }

    
}
