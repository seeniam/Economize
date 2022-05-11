/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Model.Categoria_de_Gastos;
import Model.FormaDePagamento;
import Model.Gastos;
import Model.Lancamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author neemi
 */
public class DAOGastos extends DAOLancamento{
    public void salvaLancamento(Lancamento lancamento) {
        
        super.salvaLancamento(lancamento);
        int idLancamento = super.getUltimoIDLancamento();
        System.out.println("chegou\nid: "+idLancamento);
        Gastos objeto = (Gastos) lancamento;
        try{
            Connection conn = Conexao.getConnection(); 
            String sql = 
                    "INSERT INTO `lancamentos_gastos` (`idlancamentos_gastos`, `fk_categoria_gasto`)"             
            		+ " VALUES("
                        + "'" + idLancamento  + "',"   
			+ "'" + objeto.getTipoDeCategoria()  + "'"                    
			+ ");";
					
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            System.out.println("chegou\n"+idLancamento);
        }	
	catch(SQLException e){			
           e.printStackTrace();
	} 
    }
    
    public ArrayList<Gastos> buscaLancamentosGastos(int idUsuario){
        ArrayList<Gastos> dados = new ArrayList();
        Statement query;
	Connection conn           = null;
        Gastos lancamento         = null;
	int idLancamento          = 0;
        String descCategoria      = "";
        double valor              = 0;
        String categoria          = "";
        String descricao          = "";
        int tipo                  = 0;
        Date dataMySQL            = null;
        int parcela               = 0;
        String f_pagamento        = "";
        String data               = "";
        String nomeTipo           = "";
	
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
	    	  
	    String sql = "SELECT distinct idlancamentos_ganhos as Lancamento, catg.descricao as categoria, valor, data, parcela, f.descricao as formadepagamento, l.descricao \n" +
"FROM lancamentos_gastos as lg inner join lancamento as l inner join forma_de_pagamento as f inner join categoria_gasto as catg \n" +
"on( catg.idcategoria_gasto = lg.fk_categoria_gasto and l.fk_formadepagamento = f.idformadepagamento and l.idLancamento = lg.idlancamentos_gastos and lg.fk_usuario ='"+idUsuario+"');";     
	    String sql2 = "SELECT distinct idlancamentos_gastos as Lancamento, catg.descricao as categoria, \n" +
"valor, data, parcela, f.descricao as formadepagamento, l.descricao \n" +
"FROM lancamentos_gastos as lg inner join lancamento as l inner join forma_de_pagamento as f inner join categoria_gasto as catg\n" +
"on( catg.idcategoria_gasto = lg.fk_categoria_gasto and l.fk_formadepagamento = f.idformadepagamento \n" +
"                    and l.idLancamento = lg.idlancamentos_gastos and l.fk_usuario = '"+idUsuario+"');";
            
            ResultSet rs = query.executeQuery(sql2);  
		         
	    while(rs.next()){
                                
                descCategoria    = rs.getString("categoria");
                //idLancamento     = rs.getInt("lancamento.idLancamento");	        		
	       	descricao        = rs.getString("descricao");
	       	valor            = rs.getDouble("valor");
	       	dataMySQL        = rs.getDate("data");
	       	parcela          = rs.getInt("parcela");
	       	f_pagamento      = rs.getString("formadepagamento");
               // idUsuario        = rs.getInt("lancamento.idUsuario");
                //nomeTipo         = rs.getString("lancamentos_gastos.tipo");
                data = convertDataMySQLparaString(dataMySQL);
                
                Categoria cat = new Categoria_de_Gastos(descCategoria);
                FormaDePagamento forma = new FormaDePagamento(f_pagamento);
                
                lancamento = new Gastos((Categoria_de_Gastos) cat, idLancamento, descricao, valor, data, parcela, idUsuario, forma);
                dados.add(lancamento);
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
    return dados;
    }
    
    public double buscaGastosTotais(int idUsuario){
      
        Statement query;
	Connection conn           = null;
        double valor              = 0;
	
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();    	  
	    String sql = "SELECT sum(valor) as valor FROM `economize-asi`.lancamento where fk_usuario ="+idUsuario+" and valor < 0;";
            
            ResultSet rs = query.executeQuery(sql);  
		         
	    while(rs.next()){                                
	       	valor = rs.getDouble("valor");             
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
        return valor;
    }
}
