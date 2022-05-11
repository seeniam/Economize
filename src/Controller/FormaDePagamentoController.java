/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFormaDePagamento;
import Model.FormaDePagamento;
import java.util.List;

/**
 *
 * @author neemi
 */
public class FormaDePagamentoController {
    private DAOFormaDePagamento formadepagamento;

    public FormaDePagamentoController() {
        this.formadepagamento = new DAOFormaDePagamento();
    }
    
    public boolean insereFormaDePagamento(String descricao) {
        FormaDePagamento forma = new FormaDePagamento(descricao);
        if(this.formadepagamento.salvaFormadePagamento(forma))
            return true;
        return false;
    }
    
    public int obterIDf_pagamento(String descricao) {
        FormaDePagamento forma = new FormaDePagamento(descricao);
        return this.formadepagamento.getIDFpagamento(forma);
    }
    
    public List<String> buscaFormasDePagamento(){
        return formadepagamento.getFPagamento();
    }
}
