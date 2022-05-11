/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOLancamento;
import Model.Lancamento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saimeen
 */
public class TabelaRelatorio extends AbstractTableModel{
    private ArrayList<Lancamento> dados;
    private String[] colunas = {"Descricão", "Valor", "Data", "Forma de Pagamento"};
            
    public TabelaRelatorio(){
        DAOLancamento dao = new DAOLancamento();
        this.dados = dao.buscaLancamentos(LoginController.getUsuario().getIdUsuario());
    }
    
    
    public TabelaRelatorio(ArrayList<Lancamento> dados){
        this.dados = dados;
    }
    
    public void filtrarTabela(int mes, int ano, String tipo, int idUsuario) {
        DAOLancamento dao = new DAOLancamento();     
        setLinhas(dao.filtraLancamentos(mes, ano, tipo, idUsuario));
    }
    
    public ArrayList<Lancamento> getLinhas(){
        return dados;
    }
    
    public void setLinhas(ArrayList<Lancamento> linhas){
        this.dados = linhas;
    }
    
    public String[] getColunas(){
        return this.colunas;
    }
    
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    
    
    public String getColumnName(int column){
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {        
        switch(columnIndex){
		case 0:
                        return this.dados.get(rowIndex).getDescricao();		
		case 1:
			 return this.dados.get(rowIndex).getValor();
		case 2:
			return this.dados.get(rowIndex).getData();
		case 3:
			return this.dados.get(rowIndex).getForma().getDescricao();
		default:
			System.err.println("Índice inválido para propriedade do bean Usuario.class");
			return null;
	}		
    }
    
}
