/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ganhos;
import Model.Lancamento;
import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author Saimeen
 */
public class DAOLancamento {
    
    public void salvaLancamento(Lancamento objeto) {
        try{
            Connection conn = Conexao.getConnection();            
            String sql = 
                    "INSERT INTO `lancamento` (`descricao`, `valor`,  `data`, `parcela`, `fk_formadepagamento`, `fk_usuario`)"             
            		+ " VALUES("
			+ "'" + objeto.getDescricao()+ "',"
                        + "'" + objeto.getValor() + "',"
                        + "'" + objeto.getData() + "',"
                        + "'" + objeto.getParcela() + "',"
                        + "'" + objeto.getIdforma_pagamento() + "',"
                        + "'" + objeto.getIdUsuario() + "'"
			+ ");";
					
            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            System.out.println("Salvou LANCAMENTO");
        }	
	catch(SQLException e){			
           e.printStackTrace();
	} 
    } 
    
    public int getUltimoIDLancamento() {
        Statement query;
	Connection conn           = null;
	int idLancamento          = 0;	
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();	  
	    String sql = "SELECT idLancamento FROM lancamento order by idLancamento desc limit 1;";
	    	     
	    ResultSet rs = query.executeQuery(sql);
            if(rs.next()){ 
                idLancamento = rs.getInt("lancamento.idLancamento");         
                conn.close();
            }
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
        return idLancamento;
    }
    
 
 
    public ArrayList<Lancamento> buscaLancamentos(int idUsuario){
        
        ArrayList dados = new ArrayList<Lancamento>();
        ArrayList todos = new ArrayList<Lancamento>();
        DAOGanhos ganhos = new DAOGanhos();
        DAOGastos gastos = new DAOGastos();
            
        dados.addAll(ganhos.buscaLancamentosGanhos(idUsuario));
        dados.addAll(gastos.buscaLancamentosGastos(idUsuario));
        for (Iterator it = dados.iterator(); it.hasNext();) {
            Lancamento e = (Lancamento) it.next();
            System.out.println(
                        "idLancamento: "+e.getIdLancamento()+
                        "\nDescricao: "+e.getDescricao()+
                        "\nValor: "+e.getValor()+
                        "\nData: "+e.getData()+
                        "\nParcela: "+e.getParcela()+
                        "\nForma de pagamento: "+e.getForma().getDescricao()
                );
            todos.add(e);
        }        
        return todos;
    }
  
    
    public double somaLancamentosMensais(int tipo, int mes, String dataLimite, int idRenda){
        Statement query;
	Connection conn = null;
        double valorTotal = 0;
              
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
	    	  
	    String sql = 
            "SELECT sum(Valor) FROM lancamento where tipo = "+tipo+" and data between '2019-"+mes+"-01' and '2019-"+mes+"-31' and idRenda = "+idRenda+";";	    	     
	    ResultSet rs = query.executeQuery(sql);  
		         
	    while(rs.next()){
	       	valorTotal = rs.getDouble("sum(Valor)");
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
        return valorTotal;
    }
    
    
    /*
     public ArrayList<Lancamento> filtraLancamentos(int mes, int ano, int tipo, int idRenda){
        ArrayList<Lancamento> dados = new ArrayList<Lancamento>();
        Statement query;
	Connection conn           = null;
        Lancamento lancamento     = null;
	int idLancamento          = 0;
        double valor              = 0;
        String categoria          = "";
        String descricao          = "";
        Date dataMySQL            = null;
        int parcela               = 0;
        String f_pagamento        = "";
        String data               = "";
	
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
	    ResultSet rs;	  
	    String sql = 
            "SELECT * FROM economize.lancamento where Data between '"+ano+"-"+mes+"-01' and '"+ano+"-"+mes+"-31' and idRenda ="+idRenda+" and tipo ="+tipo+";";
            String sql2 =
            "SELECT * FROM economize.lancamento where Data between '"+ano+"-"+mes+"-01' and '"+ano+"-"+mes+"-31' and idRenda ="+idRenda+";";
	    
            if(tipo == 2){	     
                rs = query.executeQuery(sql2);  
            }else{
                rs = query.executeQuery(sql); 
            }
	    while(rs.next()){
                idLancamento     = rs.getInt("lancamento.idLancamento");	        		
	       	descricao        = rs.getString("lancamento.Descricao"); 
	       	tipo             = rs.getInt("lancamento.Tipo");
	       	valor            = rs.getDouble("lancamento.Valor");
	       	categoria        = rs.getString("lancamento.Categoria");
	       	dataMySQL        = rs.getDate("lancamento.Data");
	       	parcela          = rs.getInt("lancamento.Parcela");
	       	f_pagamento      = rs.getString("lancamento.Forma_Pagamento");
                idRenda          = rs.getInt("lancamento.idRenda");
                
	       	data = convertDataMySQLparaString(dataMySQL);
                String tipoLancamento = defineTipoLancamento(tipo);
                lancamento = new Lancamento(idLancamento, descricao, tipoLancamento, valor, categoria, data, parcela, f_pagamento, idRenda);
                dados.add(lancamento);
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
    return dados;
    }
*/
/*
    public Lancamento atualizaLancamento(int id) {
        Statement query;
	Connection conn           = null;
        Lancamento lancamento     = new Lancamento();
	int idLancamento        = 0;
        double valor              = 0;
        String categoria          = "";
        String descricao          = "";
        int tipo                  = 0;
        Date dataMySQL            = null;
        int parcela               = 0;
        String f_pagamento        = "";
        String data               = "";
        int idRenda               = 0;
	
	try {
            conn = Conexao.getConnection();
	    query = (Statement) conn.createStatement();
	    	  
	    String sql = 
            "SELECT * FROM economize.lancamento where idLancamento = '"+id+"';";
	    	     
	    ResultSet rs = query.executeQuery(sql);  
		         
	    while(rs.next()){
                idLancamento     = rs.getInt("lancamento.idLancamento");
	       	descricao        = rs.getString("lancamento.Descricao"); 
	       	tipo             = rs.getInt("lancamento.Tipo");
	       	valor            = rs.getDouble("lancamento.Valor");
	       	categoria        = rs.getString("lancamento.Categoria");
	       	dataMySQL        = rs.getDate("lancamento.Data");
	       	parcela          = rs.getInt("lancamento.Parcela");
	       	f_pagamento      = rs.getString("lancamento.Forma_Pagamento");
                idRenda          = rs.getInt("lancamento.idRenda");	
                
                String tipoLancamento = defineTipoLancamento(tipo);
                String dataLancamento = convertDataMySQLparaString(dataMySQL);              
	       	lancamento            = new Lancamento(idLancamento, descricao, tipoLancamento, valor, categoria, dataLancamento, parcela, f_pagamento, idRenda);
	    }
	    conn.close();
	} 
        catch (SQLException e) {  
            e.printStackTrace();   
	}
    return lancamento;
    }
*/
    public String convertDataMySQLparaString(Date dataMySQL){
        String data;
        data = dataMySQL.toString();
        String dia = data.substring(8); 
        String mes = data.substring(5, 7); 
        String ano = data.substring(0, 4);
        String dataLancamento = dia+"/"+mes+"/"+ano;
        return dataLancamento;
    }

    public ArrayList<Lancamento> filtraLancamentos(int mes, int ano, String tipo, int idUsuario) {
        ArrayList<Lancamento> dados = new ArrayList<Lancamento>();
        return dados;
    }

    
}
