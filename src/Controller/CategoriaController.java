/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOCategoria;
import DAO.DAOCategoria_Ganhos;
import DAO.DAOCategoria_Gastos;
import Model.Categoria;
import Model.Categoria_de_Ganhos;
import Model.Categoria_de_Gastos;
import Model.Enum.TipoLancamento;
import static Model.Enum.TipoLancamento.GANHO;
import static Model.Enum.TipoLancamento.GASTO;
import java.util.List;



/**
 *
 * @author neemi
 */
public class CategoriaController {
    
    private DAOCategoria daoCategoria;
    private Categoria categoria;
    
    public CategoriaController(Categoria categoria) {
        if (categoria instanceof Categoria_de_Ganhos)
            this.categoria = new Categoria_de_Ganhos();
        if (categoria instanceof Categoria_de_Gastos)
            this.categoria = new Categoria_de_Gastos();
        
    }

    public CategoriaController() {}
   
    
    public boolean insereCategoria(String nomecategoria, Categoria categoria) {
        if(categoria instanceof Categoria_de_Ganhos){
            this.daoCategoria = new DAOCategoria_Ganhos((Categoria_de_Ganhos) categoria);
        }
        else if(categoria instanceof Categoria_de_Gastos){
            this.daoCategoria = new DAOCategoria_Gastos((Categoria_de_Gastos) categoria);
        }
        return this.daoCategoria.salvaCategoria(categoria);
    }
    
    
    public int buscaIDCategoriaPorNome(String nomecategoria, Categoria categoria){
        if(categoria instanceof Categoria_de_Ganhos){
            this.daoCategoria = new DAOCategoria_Ganhos((Categoria_de_Ganhos) categoria);
        }
        else if(categoria instanceof Categoria_de_Gastos){
            this.daoCategoria = new DAOCategoria_Gastos((Categoria_de_Gastos) categoria);
        }
        return this.daoCategoria.buscaID(categoria);
    
    }
    
    public int buscaIdCategoriaPorNome(String nome){
        int id=0;
        Categoria_de_Gastos categoria = new Categoria_de_Gastos(nome);
        this.daoCategoria = new DAOCategoria_Gastos();
        id = this.daoCategoria.buscaID(categoria);
        return id;
    }
    
        public Categoria buscaCategoriaPorNome(String nomecategoria, Categoria categoria){
        if(categoria instanceof Categoria_de_Ganhos){
            categoria = new Categoria_de_Ganhos(nomecategoria); 
            this.daoCategoria = new DAOCategoria_Ganhos((Categoria_de_Ganhos) categoria);
        }
        if(categoria instanceof Categoria_de_Gastos){
            categoria = new Categoria_de_Gastos(nomecategoria);            
            this.daoCategoria = new DAOCategoria_Gastos((Categoria_de_Gastos) categoria);
        }
        return this.daoCategoria.buscaCategoriaPorDescricao(categoria);
    
    }
    
    public Categoria getCategoria(String nomecategoria, Categoria categoria){
        categoria.setDescricao(nomecategoria);
        this.daoCategoria.buscaCategoriaPorDescricao(categoria);        
        return categoria;
    }
    
    public int getIDCategoria(Categoria categoria){
        return categoria.getIdCategoria();
    }

    public int getIDCategoria(TipoLancamento tipoLancamento, String nomecategoria) {
        if(tipoLancamento == GANHO){
            this.categoria = new Categoria_de_Ganhos(nomecategoria);
            return this.daoCategoria.buscaID(categoria);
        }
        if(tipoLancamento == GASTO){
            this.categoria = new Categoria_de_Gastos(nomecategoria);
            return this.daoCategoria.buscaID(categoria);
        }
        return 0;
    }  

    public List<String> getDescricaoCategorias(TipoLancamento tipoLancamento){
        this.daoCategoria = (tipoLancamento == TipoLancamento.GANHO)
                ? new DAOCategoria_Ganhos()
                : new DAOCategoria_Gastos();
        return this.daoCategoria.buscaDescricaoCategorias();
    }
}
