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
public class Gastos extends Lancamento{
    private int tipo_de_categoria;
    private String tipo;
    
    private Categoria_de_Gastos categoria;
    
    public Gastos(String descricao, double valor, String data, int parcela, int f_pagamento, int idUsuario, int cat){
        
        super(descricao, valor, data, parcela, f_pagamento, idUsuario);
        this.tipo_de_categoria = cat;
    }
    
    public Gastos(String descricao, double valor, String data, int parcela, int f_pagamento, int idUsuario){
        super(descricao, valor, data, parcela, f_pagamento, idUsuario);
    }

    public Gastos(int idLancamento, String descricao, double valor, String data, int parcela, int idforma_pagamento, 
            int idUsuario, int tipo_de_categoria, String tipo) {
        
        super(idLancamento, descricao, valor, data, parcela, idforma_pagamento, idUsuario);
        this.tipo_de_categoria = tipo_de_categoria;
        this.tipo = tipo;
    }    

    public Gastos(Categoria_de_Gastos categoria, int idLancamento, String descricao, double valor, String data, int parcela, int idUsuario, FormaDePagamento forma) {
        super(idLancamento, descricao, valor, data, parcela, idUsuario, forma);
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public Categoria_de_Gastos getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria_de_Gastos categoria) {
        this.categoria = categoria;
    }    
    public int getTipoDeCategoria(){
        return this.tipo_de_categoria;
    }
    public void setTipo_de_categoria(int tipo_de_categoria) {
        this.tipo_de_categoria = tipo_de_categoria;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
