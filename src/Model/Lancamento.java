
package Model;

import java.util.Calendar;


public class Lancamento {
    private int idLancamento;
    private String descricao;
    private double valor;
    private String data;
    private int parcela;
    private int idforma_pagamento;
    private int idUsuario;
    
    private FormaDePagamento forma;

    public Lancamento(int idLancamento, String descricao, double valor, String data, int parcela, int idUsuario, FormaDePagamento forma) {
        this.idLancamento = idLancamento;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.parcela = parcela;
        this.idUsuario = idUsuario;
        this.forma = forma;
    }    
    
    public Lancamento(int idLancamento, String descricao, double valor, String data, int parcela, int idforma_pagamento, int idUsuario) {
        this.idLancamento = idLancamento;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.parcela = parcela;
        this.idforma_pagamento = idforma_pagamento;
        this.idUsuario = idUsuario;
    }
    

    public Lancamento(String descricao, double valor, String data, int parcela, int idforma_pagamento, int idUsuario) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.parcela = parcela;
        this.idforma_pagamento = idforma_pagamento;
        this.idUsuario = idUsuario;
    }
    
    
    public int getIdLancamento() {
        return idLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public int getParcela() {
        return parcela;
    }

    public int getIdforma_pagamento() {
        return idforma_pagamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public void setIdforma_pagamento(int idforma_pagamento) {
        this.idforma_pagamento = idforma_pagamento;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }  

    public FormaDePagamento getForma() {
        return forma;
    }

    public void setForma(FormaDePagamento forma) {
        this.forma = forma;
    }
    
    
}
