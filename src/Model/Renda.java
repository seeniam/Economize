
package Model;

public class Renda {
    private int idRenda;
    private double valorTotal;
    private int idCliente;
    
    public Renda() {
        
    }
    
    public Renda(int id, double valor, int idCliente) {
        this.idRenda = id;
        this.valorTotal = valor;
        this.idCliente = idCliente;
    }

    public int getIdRenda() {
        return idRenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }  
}
