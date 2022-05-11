/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.FormaDePagamento;
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
public class DAOFormaDePagamento {
    public boolean salvaFormadePagamento(FormaDePagamento forma) {
        try{
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO `forma_de_pagamento` (`descricao`) "
                    + "VALUES ('"+forma.getDescricao()+"');";
            
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}               
    }
    
    public List<String> getFPagamento(){
        List<String> formasP = new ArrayList<String>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT `descricao` FROM `forma_de_pagamento`";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            
            while (res.next()) {                
                formasP.add(res.getString("forma_de_pagamento.descricao"));
            }
        } catch (Exception e) {
            System.out.println("Não há formas de pagamento cadastradas!");
            e.printStackTrace();
        }
        return formasP;
    }

    public int getIDFpagamento(FormaDePagamento forma) {
        int id = -1;
        Connection conn;
        String sql = "";        
        try {
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            sql = "SELECT idformadepagamento FROM forma_de_pagamento where descricao = '"+forma.getDescricao()+"';";        
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                id = resultado.getInt("forma_de_pagamento.idformadepagamento");        
                conn.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }        
        return id;
    }

}
