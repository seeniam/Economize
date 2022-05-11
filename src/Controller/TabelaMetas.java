/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOMeta;
import Model.Meta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author neemi
 */
public class TabelaMetas extends AbstractTableModel{
    private ArrayList<Meta> dados;
    private String[] colunas = {"Meta", "Valor Máximo", "Prazo de até"};    
    
    public TabelaMetas(){
        DAOMeta dao = new DAOMeta();
        this.dados = dao.buscaMetas(LoginController.getUsuario().getIdUsuario());
    }
    public ArrayList<Meta> getLinhas(){
        return dados;
    }
    
    public void setLinhas(ArrayList<Meta> linhas){
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
                        return this.dados.get(rowIndex).getCategoria();
		case 1:
			 return this.dados.get(rowIndex).getValor();
		case 2:
			return this.dados.get(rowIndex).getPrazo();
		default:
			System.err.println("Índice inválido para propriedade do bean Usuario.class");
			return null;
	}
    }
    
}
