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
public class Categoria_de_Gastos extends Categoria{
    
    public Categoria_de_Gastos(int id, String desc){
        super (id, desc);
    }    
    public Categoria_de_Gastos(String desc){
        super (desc);
    } 
    public Categoria_de_Gastos(){}    
}
