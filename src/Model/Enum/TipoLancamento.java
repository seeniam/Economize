/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Enum;

/**
 *
 * @author neemi
 */
public enum TipoLancamento {
    GANHO("ganho"),
    GASTO("gasto");

    private final String tipo;

    private TipoLancamento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
