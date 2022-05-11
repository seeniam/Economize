
package DAO;

import java.sql.*;

/*
MUDE A PORTA DA VARIÁVEL "porta" conforme a porta do seu XAMPP. EX:
public static String porta = "3306"
*/
public class Conexao {
    public static String user = "root";
    public static String password = "";
    public static String ip = "localhost";
    public static String porta = "3306";
    public static String name = "economize-asi";
    
    private static Connection conn;
    
    
    public static Connection getConnection() throws SQLException {
        //Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://" +
                ip + ":" + porta + "/", user, password);
        
        conn.setCatalog(name);
        System.out.println("Conectado!");
        
        return conn;
    }
   
    /*
    public static Connection getConnection() throws SQLException {
    
        conn = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/economize.db");
        //conn.setCatalog("economize_sqlite.db");
        
        System.out.println("Conectado!");
        
        
        
        return conn;
    }
    */
    public static Statement criarStatement(){
	try{
            return Conexao.conn.createStatement();
	}catch(SQLException e){
            return null;
	}
    }
  /*  
    public static void criarBancodeDados() throws SQLException {
        System.err.println("ENTROU NO criaBancodeDados() -> CONEXAO");
                
               
        String sql = ""
                + "BEGIN TRANSACTION;\n" +
"CREATE TABLE IF NOT EXISTS \"usuario\" (\n" +
"	\"idUsuario\"	INTEGER NOT NULL,\n" +
"	\"nome\"	TEXT NOT NULL,\n" +
"	\"senha\"	TEXT NOT NULL,\n" +
"	\"email\"	TEXT NOT NULL,\n" +
"	\"valorTotal\"	TEXT NOT NULL,\n" +
"	PRIMARY KEY(\"idUsuario\" AUTOINCREMENT)\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"forma_de_pagamento\" (\n" +
"	\"idformadepagamento\"	INTEGER NOT NULL,\n" +
"	\"descricao\"	TEXT NOT NULL,\n" +
"	PRIMARY KEY(\"idformadepagamento\" AUTOINCREMENT)\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"categoria_ganho\" (\n" +
"	\"idcategoria_ganho\"	INTEGER NOT NULL,\n" +
"	\"descricao\"	TEXT NOT NULL,\n" +
"	PRIMARY KEY(\"idcategoria_ganho\" AUTOINCREMENT)\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"categoria_gasto\" (\n" +
"	\"idcategoria_gasto\"	INTEGER NOT NULL,\n" +
"	\"descricao\"	TEXT NOT NULL,\n" +
"	PRIMARY KEY(\"idcategoria_gasto\" AUTOINCREMENT)\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"meta\" (\n" +
"	\"idmeta\"	INTEGER NOT NULL,\n" +
"	\"nome\"	TEXT NOT NULL,\n" +
"	\"prazo\"	TEXT NOT NULL,\n" +
"	\"valormaximo\"	REAL NOT NULL,\n" +
"	\"fk_categoria_gasto\"	INTEGER NOT NULL,\n" +
"	\"fk_usuario\"	INTEGER NOT NULL,\n" +
"	CONSTRAINT \"fk_meta_usuario\" FOREIGN KEY(\"fk_usuario\") REFERENCES \"usuario\"(\"idUsuario\"),\n" +
"	CONSTRAINT \"fk_meta_categoria_gasto\" FOREIGN KEY(\"fk_categoria_gasto\") REFERENCES \"categoria_gasto\"(\"idcategoria_gasto\"),\n" +
"	PRIMARY KEY(\"idmeta\" AUTOINCREMENT)\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"lancamento\" (\n" +
"	\"idLancamento\"	INTEGER NOT NULL,\n" +
"	\"valor\"	REAL NOT NULL,\n" +
"	\"data\"	TEXT NOT NULL,\n" +
"	\"parcela\"	INTEGER NOT NULL,\n" +
"	\"descricao\"	TEXT NOT NULL,\n" +
"	\"fk_formadepagamento\"	INTEGER NOT NULL,\n" +
"	\"fk_usuario\"	INTEGER NOT NULL,\n" +
"	CONSTRAINT \"fk_Lancamento_formadepagamento\" FOREIGN KEY(\"fk_formadepagamento\") REFERENCES \"forma_de_pagamento\"(\"idformadepagamento\"),\n" +
"	CONSTRAINT \"fk_lancamento_usuario\" FOREIGN KEY(\"fk_usuario\") REFERENCES \"usuario\"(\"idUsuario\"),\n" +
"	PRIMARY KEY(\"idLancamento\" AUTOINCREMENT)\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"lancamentos_ganhos\" (\n" +
"	\"idlancamentos_ganhos\"	INTEGER NOT NULL,\n" +
"	\"fk_categoria_ganho\"	INTEGER NOT NULL,\n" +
"	CONSTRAINT \"fk_lancamentos_ganhos_categoria_ganho\" FOREIGN KEY(\"fk_categoria_ganho\") REFERENCES \"categoria_ganho\"(\"idcategoria_ganho\"),\n" +
"	CONSTRAINT \"fk_lancamentos_ganhos_lancamento\" FOREIGN KEY(\"idlancamentos_ganhos\") REFERENCES \"lancamento\"(\"idLancamento\"),\n" +
"	PRIMARY KEY(\"idlancamentos_ganhos\")\n" +
");\n" +
"CREATE TABLE IF NOT EXISTS \"lancamento_gastos\" (\n" +
"	\"idlancamentos_gastos\"	INTEGER NOT NULL,\n" +
"	\"fk_categoria_gasto\"	INTEGER NOT NULL,\n" +
"	CONSTRAINT \"fk_lancamentos_gastos_lancamento\" FOREIGN KEY(\"idlancamentos_gastos\") REFERENCES \"lancamento\"(\"idLancamento\"),\n" +
"	CONSTRAINT \"fk_lancamentos_gastos_categoria_gasto\" FOREIGN KEY(\"fk_categoria_gasto\") REFERENCES \"categoria_gasto\"(\"idcategoria_gasto\"),\n" +
"	PRIMARY KEY(\"idlancamentos_gastos\")\n" +
");\n" +
"COMMIT;"
                + "";
        conn = Conexao.getConnection();
	Statement state = conn.createStatement();	
	state.execute(sql);
        System.out.println("Banco de dados criado.");
        conn.close();
        
    }
    */
    public static void main(String[] args) {
        
        
        try {
            Connection conn = Conexao.getConnection();
            Statement query = conn.createStatement();
            String sql = "select * from usuario";
            ResultSet result = query.executeQuery(sql);
            
            if(result.next()) System.out.println(result.getString("usuario.Nome"));
            else System.out.println("usuario não encontrado.");
            
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro - Conexão com o banco de dados");
            e.printStackTrace();
        }
    }
    
}
