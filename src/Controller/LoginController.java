package Controller;
import DAO.DAOUsuario;
import Model.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    private static Usuario usuario;
    private static boolean logado;
    
    public LoginController() {
        this.usuario = null;
        this.logado = false;
    }
    
    
    public static boolean autenticaCliente(String login, String senha){
        DAOUsuario daoCliente = new DAOUsuario();
        usuario = daoCliente.buscaUsuario(login, senha);
        
        if(usuario != null) {
            setUsuario(usuario);
            LoginController.logado = true;
        }
        
        return isLogado();
    }
    
    public static boolean isLogado() {
        return logado;
    }
    
    public static void setUsuario(Usuario usuario) {
	LoginController.usuario = usuario;
    }
    
    public static Usuario getUsuario() {
	return usuario;
    }
}
