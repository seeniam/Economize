/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOCategoria;
import DAO.DAOGanhos;
import DAO.DAOGastos;
import DAO.DAOLancamento;
import Model.Categoria;
import Model.Categoria_de_Ganhos;
import Model.Categoria_de_Gastos;
import Model.Enum.TipoLancamento;
import static Model.Enum.TipoLancamento.GANHO;
import static Model.Enum.TipoLancamento.GASTO;
import Model.Ganhos;
import Model.Gastos;
import Model.Lancamento;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Saimeen
 */
public class LancamentoController {
    
    private DAOLancamento daoLancamento;
    private Calendar data;
    
    public LancamentoController(){
        this.data = GregorianCalendar.getInstance();
        this.daoLancamento = new DAOLancamento();
    }
    
    public String convertFormatoDataParaMySQL(String data){
        String dia = data.substring(0,2); 
        String mes = data.substring(3, 5); 
        String ano = data.substring(6);
        String dataMySQL = ano+"-"+mes+"-"+dia;
        return dataMySQL;
    }
    
    public boolean enviaLancamento(String tipoLancamento, String descricao, double valor, 
            String nomecategoria, String data, int parcela, int IDf_pagamento, int idusuario){      
        
        String dataMySQL = convertFormatoDataParaMySQL(data);
        
        Categoria categoria;
        CategoriaController categoriacontroller = new CategoriaController();
        Lancamento lancamento = null;
        int idcategoria=0;
        
        if(tipoLancamento.equals(GASTO.getTipo())){
            categoria = categoriacontroller.buscaCategoriaPorNome(nomecategoria, new Categoria_de_Gastos());
            idcategoria = categoriacontroller.getIDCategoria(categoria);
            lancamento = new Gastos(descricao, valor, dataMySQL, parcela, IDf_pagamento, idusuario, idcategoria);
            this.daoLancamento = new DAOGastos();
        }
        if(tipoLancamento.equals(GANHO.getTipo())){
            categoria = categoriacontroller.buscaCategoriaPorNome(nomecategoria, new Categoria_de_Ganhos());
            idcategoria = categoriacontroller.getIDCategoria(categoria);
            lancamento = new Ganhos(descricao, valor, dataMySQL, parcela, IDf_pagamento, idusuario, idcategoria);
            
            this.daoLancamento = new DAOGanhos();
        }        

        this.daoLancamento.salvaLancamento(lancamento);
        return true;
        
    }    
    
    
/*
    public double getGastosHome(int idRenda){
        String dataLimite = ""+data.get(Calendar.YEAR)+"-"+(data.get(Calendar.MONTH)+1)+"-"+data.get(Calendar.DATE);
        double gastos = this.daoLancamento.somaLancamentosMensais(0, (data.get(Calendar.MONTH)+1), dataLimite, idRenda);
        return gastos;
    }
    public double getGanhosHome(int idRenda){
        String dataLimite = data.get(Calendar.YEAR)+"-"+(data.get(Calendar.MONTH)+1)+"-"+data.get(Calendar.DATE);
        double ganhos = this.daoLancamento.somaLancamentosMensais(1, (data.get(Calendar.MONTH)+1), dataLimite, idRenda);
        return ganhos;
    }
    public double getSaldoFinalHome(int idRenda){
        double sobrou = getGanhosHome(idRenda) + getGastosHome(idRenda);
        return sobrou;
    }
    
    public double getSaldoInicialHome(int idRenda){
        double saldoInicial = 0;
        double saldoFinal = getSaldoFinalHome(idRenda);
        if(saldoFinal < 0){
            saldoFinal = (saldoFinal * -1);
            double gastos  = getGastosHome(idRenda);
            saldoInicial = gastos + saldoFinal;
        }
        double ganhos  = getGanhosHome(idRenda) * -1;
        saldoInicial   = saldoInicial - ganhos;
        return saldoInicial;
    }
    
    public double CalculoDosLancamentosHome(int idRenda){        
        double sobrou = 0;
        Calendar hoje = Calendar.getInstance();
        String dataLimite = hoje.get(Calendar.YEAR)+"-"+(hoje.get(Calendar.MONTH)+1)+"-"+hoje.get(Calendar.DATE);
        double gastos = this.daoLancamento.somaLancamentosMensais(0, (hoje.get(Calendar.MONTH)+1), dataLimite, idRenda);
        double ganhos = this.daoLancamento.somaLancamentosMensais(1, (hoje.get(Calendar.MONTH)+1), dataLimite, idRenda);
        return sobrou = ganhos + gastos;
    }
*/   
   /*
    public void buscaLancamentos(){
        int idRenda = 1;
        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        Lancamento mov = new Lancamento();
        
        lancamentos = this.daoLancamento.buscaLancamentos(idRenda);
        
        String teste = "";
	Iterator<Lancamento> it = lancamentos.iterator();
	while(it.hasNext()){
            mov = (Lancamento) it.next();
            teste = ""
	    +  "\nDescricao: "+mov.getDescricao()
            +  "\nTipo: "+mov.getTipo()
            +  "\nValor: "+mov.getValor()
            +  "\nCategoria: "+ mov.getCategoria()
            +  "\nData: "+mov.getData()
            +  "\nForma de pagamento: "+mov.getForma_pagamento()
            +"";
            JOptionPane.showMessageDialog(null, ""+teste);
                 
	}
    }
    */
    
    public double gastosTotais(int idUsuario){
        DAOGastos gastos = new DAOGastos();
        return gastos.buscaGastosTotais(idUsuario);
    }
    public double ganhosTotais(int idUsuario){
        DAOGanhos ganhos = new DAOGanhos();
        return ganhos.buscaGanhosTotais(idUsuario);
    }
    
    public double getSaldoFinal(int idUsuario) {
        System.out.println(""+ganhosTotais(idUsuario)+" - "+gastosTotais(idUsuario)+": ");
        return (ganhosTotais(idUsuario)+gastosTotais(idUsuario));
    }
}