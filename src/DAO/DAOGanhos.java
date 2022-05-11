/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Model.Categoria_de_Ganhos;
import Model.FormaDePagamento;
import Model.Ganhos;
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
public class DAOGanhos extends DAOLancamento{
    @Override
    public void salvaLancamento(Lancamento lancamento) {
        System.out.println("2");
        super.salvaLancamento(lancamento);
        int idLancamento = super.getUltimoIDLancamento();
        System.out.println("lancamentos_ganhos\nidLancamento: "+idLancamento);
        Ganhos objeto = (Ganhos) lancamento;
        try{
     
            Connection conn = Conexao.getConnection(); 
            System.out.println("idLancamento: "+idLancamento+"\ntipodecategoria: "+objeto.getTipoDeCategoria());
            String sql = 
                    "INSERT INTO `lancamentos_ganhos` (`idlancamentos_ganhos`,`fk_categoria_ganho`)"             
            		+ " VALUES("
                        + "'" + idLancamento  + "',"  
			+ "'" + objeto.getTipoDeCategoria()  + "'"                      
			+ ");";
					
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
        }	
	catch(SQLException e){			
           e.printStackTrace();
	} 
    }
    
    public ArrayList<Ganhos> buscaLancamentosGanhos(int idUsuario){
        ArrayList<Ganhos> dados = new ArrayList();
        Statement query;
	Connection conn           = null;
        Ganhos lancamento         = null;
	int idLancamento          = 0;
        double valor              = 0;
        String categoria          = "";
        String descricao          = "";
        int tipo                  = 0;
        Date dataMySQL            = null;
        int parcela               = 0;
        String f_pagamento        = "";
        String data               = "";
        String nomeTipo           = "";
        String descCategoria      = "";
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
	    	  
	    String sql = "SELECT distinct idlancamentos_ganhos as Lancamento, catg.descricao as categoria, valor, data, parcela, f.descricao as formadepagamento, l.descricao FROM lancamentos_ganhos as lg inner join lancamento as l inner join forma_de_pagamento as f inner join categoria_ganho as catg\n" +
"on( catg.idcategoria_ganho = lg.fk_categoria_ganho and l.fk_formadepagamento "
                    + "= f.idformadepagamento and l.idLancamento = lg.idlancamentos_ganhos and l.fk_usuario ='"+idUsuario+"');";     
	    
            String sql2 = "SELECT distinct idlancamentos_ganhos as Lancamento, catg.descricao as categoria, \n" +
"valor, data, parcela, f.descricao as formadepagamento, l.descricao \n" +
"FROM lancamentos_ganhos as lg inner join lancamento as l inner join forma_de_pagamento as f inner join categoria_ganho as catg\n" +
"on( catg.idcategoria_ganho = lg.fk_categoria_ganho and l.fk_formadepagamento = f.idformadepagamento \n" +
"                    and l.idLancamento = lg.idlancamentos_ganhos and l.fk_usuario = '"+idUsuario+"');";
            
            ResultSet rs = query.executeQuery(sql2);  
		         
	    while(rs.next()){
                                
                descCategoria    = rs.getString("categoria");
                //idLancamento     = rs.getInt("lancamento.idLancamento");	        		
	       	descricao        = rs.getString("descricao");
	       	valor            = rs.getDouble("valor");
	       	dataMySQL        = rs.getDate("data");
	       	parcela          = rs.getInt("parcela");
	       	f_pagamento      = rs.getString("formadepagamento");
                //idUsuario        = rs.getInt("lancamento.idUsuario");
                //nomeTipo         = rs.getString("lancamentos_ganhos.tipo");
                data = convertDataMySQLparaString(dataMySQL);
                
                Categoria cat = new Categoria_de_Ganhos(descCategoria);
                FormaDePagamento forma = new FormaDePagamento(f_pagamento);
                
                lancamento = new Ganhos((Categoria_de_Ganhos) cat, idLancamento, descricao, valor, data, parcela, idUsuario, forma);
                dados.add(lancamento);
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
        return dados;
    }
    
    public double buscaGanhosTotais(int idUsuario){
      
        Statement query;
	Connection conn           = null;
        double valor              = 0;
	
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
	    	  
	    String sql = "SELECT sum(valor) as valor FROM `economize-asi`.lancamento where fk_usuario ="+idUsuario+" and valor > 0;";
            
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