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
public class FormaDePagamento {
    private int id_formadePagamento;
    private String descricao;
    
    public FormaDePagamento(int id, String descricao){
       this.id_formadePagamento = id;
       this.descricao = descricao;
    }

    public FormaDePagamento(String descricao) {
        this.descricao = descricao;    
    }
    
    public int getIdFormadePagamento(){
        return this.id_formadePagamento;
    }

    public void setIdFormadePagamento(int id){
        this.id_formadePagamento = id;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String desc){
        this.descricao = desc;
    }
}
