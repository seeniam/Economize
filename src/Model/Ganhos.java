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
public class Ganhos extends Lancamento{
    private int tipo_de_categoria;
    private String tipo;
    
    private Categoria_de_Ganhos categoria;
    
    public Ganhos(String descricao, double valor, String data, int parcela, int f_pagamento, int idUsuario, int cat){
        super(descricao, valor, data, parcela, f_pagamento, idUsuario);
        this.tipo_de_categoria = cat;
    }
    
    public Ganhos(String descricao, double valor, String data, int parcela, int f_pagamento, int idUsuario){
        super(descricao, valor, data, parcela, f_pagamento, idUsuario);
    }

    public Ganhos(Categoria_de_Ganhos categoria, int idLancamento, String descricao, double valor, String data, int parcela, int idUsuario, FormaDePagamento forma) {
        super(idLancamento, descricao, valor, data, parcela, idUsuario, forma);
        this.categoria = categoria;
    }   

    public Ganhos(int idLancamento, String descricao, double valor, String data, int parcela, 
            int idforma_pagamento, int idUsuario, int tipo_de_categoria, String nomeTipo) {
        
        super(idLancamento, descricao, valor, data, parcela, idforma_pagamento, idUsuario);
        this.tipo_de_categoria = tipo_de_categoria;
        this.tipo = nomeTipo;
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

    public Categoria_de_Ganhos getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_de_Ganhos categoria) {
        this.categoria = categoria;
    }
    
    
    
}
