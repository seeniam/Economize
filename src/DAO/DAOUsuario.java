
package DAO;

import Model.Usuario;
import java.sql.*;

public class DAOUsuario {
    
    public DAOUsuario() {
        
    }
    
    public int getID_Usuario(String login, String senhaCliente){
        int idCliente = -1;
        Connection conn;
        String sql = "";        
        try {
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            sql = "select idUsuario from usuario where (nome = '"+login+"' and senha = '"+senhaCliente+"');";            
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                idCliente = resultado.getInt("usuario.idUsuario");        
                conn.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }        
        return idCliente;
    }
    
    public Usuario buscaUsuario(String login, String senhaCliente) {
        int idUsuario;
        String nome;
        String senha;
        String email = "";
        double valorTotal=0;
        
        Connection conn;
        String sql = "";
        Usuario usuario = null;
        
        try {
            conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            sql = "select * " +
                    "from Usuario where nome = '" + login +
                    "' and senha = '" + senhaCliente + "'";
            
            ResultSet resultado = query.executeQuery(sql);
            
            if(resultado.next()) {
                idUsuario = resultado.getInt("usuario.idUsuario");
                nome = resultado.getString("usuario.nome");
                senha = resultado.getString("usuario.senha");
                email = resultado.getString("usuario.email");
                valorTotal = resultado.getDouble("usuario.valorTotal");
                
                usuario = new Usuario(idUsuario, nome, senha, email, valorTotal);
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Erro ao buscar Usuario: " + sql);
            e.printStackTrace();
        }
        
        return usuario;
    }

    public boolean salvaUsuario(String nome, String senhaCliente, String email) {
        double valorTotal = 0.0;
        try{
            Connection conn = Conexao.getConnection();
            String sql =  "INSERT INTO `usuario` (`nome`, `senha`, `email`, `valorTotal`)"
            		+ " VALUES("
			+ "'" + nome  + "',"
			+ "'" + senhaCliente + "',"
			+ "'" + email + "'," 
                        + "'" + valorTotal + "'"
			+ ");";
            
            String sql2 =  "INSERT INTO usuario (nome, senha, email, valorTotal) VALUES('"+nome+"','"+senhaCliente+"','"+email+"','"+valorTotal+"')";
					
            PreparedStatement Statement = conn.prepareStatement(sql2); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}        
    }

    public boolean updateValorTotal(Usuario user) {
        try{
            Connection conn = Conexao.getConnection();
            String sql = 
            "UPDATE `usuario` SET `ValorTotal` = '"+user.getValorTotal()+"' WHERE (`idUsuario` = '"+user.getIdUsuario()+"');";

            PreparedStatement Statement = conn.prepareStatement(sql); 
            Statement.executeUpdate();
            return true;
        }	
	catch(SQLException e){			
            e.printStackTrace();
            return false;
	}
    }
    
   
}
