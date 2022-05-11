/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Renda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Saimeen
 */
public class DAORenda {
    
    public Renda buscaRenda(int idRenda){
	Connection conn   = null;
	Renda renda       = null;
	double valorTotal = 0;
        int idCliente     = 0;
	try{
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            String sql = "SELECT * FROM economize.renda where idRenda = '"+idRenda+"'";
            ResultSet resultado = query.executeQuery(sql);
			
            if( resultado.next()){
              	idRenda    = resultado.getInt("renda.idRenda");
                valorTotal = resultado.getDouble("renda.ValorTotal");
		idCliente  = resultado.getInt("renda.Cliente_idCliente");
		renda = new Renda(idRenda, valorTotal, idCliente);
            }
            conn.close();
	}
	catch(SQLException e) {
            e.printStackTrace();	
	}
	return renda;
    }
    
    public boolean updateRenda(double valorTotal ,int codCliente) {
        try{
            Connection conn = Conexao.getConnection();
            String sql = 
            "UPDATE `economize`.`renda` SET `ValorTotal` = '"+valorTotal+"' WHERE (`idRenda` = '"+codCliente+"');";

            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}  
    }
    public boolean salvaRenda(double valor ,int codCliente) {
        try{
            Connection conn = Conexao.getConnection();
            String sql =  "INSERT INTO `renda` ( `valorTotal`, `Cliente_idCliente`)"
            		+ " VALUES("
			+ "'" + valor  + "',"		
			+ "'" + codCliente +"'"
			+ ");";
					
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}               
    }

    public int buscaIdRendaPeloCliente(int codCliente) {
        int idRenda = -1;
        Connection conn;
        String sql = "";        
        try {
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            sql = "select idRenda from renda where Cliente_idCliente = '"+codCliente+"';";            
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                idRenda = resultado.getInt("renda.idRenda");        
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Erro ao encontrar o id da renda: " + sql);
            e.printStackTrace();
        }        
        return idRenda;
    }
    
}
