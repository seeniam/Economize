
package Model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;
    private String email;
    private double valorTotal;
    
    
    public Usuario(int id, String nome, String senha, String email, double total) {
        this.idUsuario = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.valorTotal = total;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    public double getValorTotal() {
        return valorTotal;
    }

    public boolean adcionaValor(double valor) {
        if(valor <= 0){
            return false;
        }else{
            this.valorTotal = this.valorTotal + valor;
            return true;
        }
    }
    public boolean subrtrairValor(double valor) {
        if(valor < 0)
            return false;
        if(valor > this.getValorTotal()){
            return false;
        }else{
            this.valorTotal = this.valorTotal + valor;
            return true;
        }
    }
    
}
