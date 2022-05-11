/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author neemi
 */
public abstract class Categoria {
    private int idCategoria;
    private String descricao;
    
    public Categoria(int idCategoria, String descricao){
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }
    public Categoria(String descricao){
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }
    
    public Categoria(){}
    
    public int getIdCategoria(){
        return this.idCategoria;
    }

    public void setIdCategoria(int id){
        this.idCategoria= id;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }

}
