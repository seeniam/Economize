/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Saimeen
 */
public class TeclasPermitidasData extends PlainDocument{
    private int quantidadeMax;
    
    public TeclasPermitidasData(int maxLen){
        super();
        if(maxLen<=0)
            throw new IllegalArgumentException("Especifique a quantidade!");
        this.quantidadeMax=maxLen;
    }
    
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        if(str==null||getLength() ==this.quantidadeMax)
            return;
        int totalQuantidade = (getLength()+str.length());
        if(totalQuantidade<=this.quantidadeMax){
            super.insertString(offset, str.replaceAll("[^0-9|^/]", ""), attr);
            return;
        }
        String nova = str.substring(0, getLength()-this.quantidadeMax);
        super.insertString(offset, nova, attr);
    }
    
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^0-9|^,|^/]", ""), attr);
    }
 
}
