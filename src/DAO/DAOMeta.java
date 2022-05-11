/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Meta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Saimeen
 */
public class DAOMeta {
    
    public boolean salvaMeta(String categoria, double valor, String limite, int idUsuario,int idcategoria) {
        try{
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO `economize-asi`.`meta` (`nome`, `prazo`, `valormaximo`, `fk_categoria_gasto`, `fk_usuario`) "
                    + "VALUES ('"+categoria+"', '"+limite+"', '"+valor+"', '"+idcategoria+"', '"+idUsuario+"');"
            ;
					
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}               
    }

    public ArrayList<Meta> buscaMetas(int idUsuario) {
        ArrayList<Meta> dados = new ArrayList();
        Meta meta = null;
        double valor;
        String categoria;
        Statement query;
	Connection conn           = null;
        Date dataMySQL            = null;
        try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
            String sql = "SELECT nome, valormaximo, prazo from meta where fk_usuario ='"+idUsuario+"';";     

            ResultSet rs = query.executeQuery(sql);  
		         
	    while(rs.next()){
                                
                categoria    = rs.getString("nome");
	       	valor        = rs.getDouble("valormaximo");
	       	dataMySQL    = rs.getDate("prazo");	                      
                String prazo = convertDataMySQLparaString(dataMySQL);
                             
                meta = new Meta(categoria, valor, prazo);
                dados.add(meta);
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
        return dados;
    }
    
    public String obterMes(int i){
        
        String[] meses = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro",
                "Outubro","Novembro","Dezembro" };          
        
        return meses[i-1];
    }

    public String convertDataMySQLparaString(Date dataMySQL){
        String mesAtual;
        String data;
        
        data = dataMySQL.toString();
        String nomeMes = data.substring(5, 7); 
        
        int mes = Integer.parseInt(nomeMes);
        mesAtual = obterMes(mes);
        
        return mesAtual;
    }
    
}
