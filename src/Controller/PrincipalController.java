/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Conexao;
import Model.Categoria;
import Model.Categoria_de_Ganhos;
import Model.Categoria_de_Gastos;
import Model.Enum.TipoLancamento;
import static Model.Enum.TipoLancamento.GANHO;
import static Model.Enum.TipoLancamento.GASTO;
import Model.Lancamento;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Saimeen
 */
public class PrincipalController {
    private UsuarioController usuarioController;
    private LancamentoController lancamentoController;
    private MetaController metaController;
    private TabelaRelatorio tabelaRelatorio;
    
    private CategoriaController categoriaController;
    private FormaDePagamentoController formadepagamentoController;
    
    public PrincipalController(){
        this.usuarioController          = new UsuarioController();
        this.lancamentoController       = new LancamentoController();
        this.metaController             = new MetaController();
        this.categoriaController        = new CategoriaController();
        this.formadepagamentoController = new FormaDePagamentoController();
    }
   /* 
    public void criarBancodeDados(){
        try {
            Conexao.criarBancodeDados();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    public boolean encaminhaCadastrodeFormadePagamento(String f_pagamento){
        if(this.formadepagamentoController.insereFormaDePagamento(f_pagamento))
            return true;
        return false;
    }
    
    public boolean encaminhaInsercaoUsuario(String nome, String senha, String email) {       
        if(this.usuarioController.insereUsuario(nome, senha, email)){
            int codCliente = this.usuarioController.getID_Usuario(nome, senha);
            return true;
        }
        else
            return false;
    }
    
    public boolean novaMovimentacao(String descricao, String tipoLancamento, double valor, String nomecategoria, String data, int parcela, String f_pagamento){
                //PAINEL     
        if(tipoLancamento.equals(GASTO.getTipo()))
            valor = -valor;            
       
        int idusuario = LoginController.getUsuario().getIdUsuario();        
        int idF_pagamento = this.formadepagamentoController.obterIDf_pagamento(f_pagamento);
       
        this.lancamentoController.enviaLancamento(tipoLancamento, descricao, valor, nomecategoria, data, parcela, idF_pagamento, idusuario);
        
        return true;
    }
    
    public boolean encaminhaCadastroCategoria(String tipo, String descricao){
        TipoLancamento tipoLancamento = getTipoLancamento(tipo);
        Categoria categoria = tipoLancamento == TipoLancamento.GANHO 
                        ? new Categoria_de_Ganhos(descricao) 
                        : new Categoria_de_Gastos(descricao);
        return categoriaController.insereCategoria(tipo, categoria);
    }
    
    public List<String> buscaFormasDePagamento(){
        return formadepagamentoController.buscaFormasDePagamento();
    }
    
    public List<String> buscaCategorias(String tipoLanc){
        return categoriaController.getDescricaoCategorias(getTipoLancamento(tipoLanc));
    }
    
    private TipoLancamento getTipoLancamento(String tipoLancamento){
        return (tipoLancamento.equals("ganho"))
                ? TipoLancamento.GANHO 
                : TipoLancamento.GASTO;
    }
    public boolean encaminhaMeta(String categoria, double valor, int limite) {
        if(this.metaController.insereMeta(categoria, valor, limite, LoginController.getUsuario().getIdUsuario()))
            return true;
        return false;
    }
    
    public double saldoTotalHome(){
        //return this.lancamentoController.getSaldoFinal(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.getSaldoFinal(LoginController.getUsuario().getIdUsuario());
    }
    
    public double gastosTotalHome(){
        //return this.lancamentoController.totalGastos(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.gastosTotais(LoginController.getUsuario().getIdUsuario());
    }
    public double ganhosTotalHome(){
        //return this.lancamentoController.totalGanhos(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.ganhosTotais(LoginController.getUsuario().getIdUsuario());

    }
    
    /*
    public double getSaldoIncial(){
        int codRenda = this.rendaController.getID_Renda(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.getSaldoInicialHome(codRenda);
    }
    
    public double getSaldoFinalHome(){
        int codRenda = this.rendaController.getID_Renda(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.getSaldoFinalHome(codRenda);
    }
    public double getGanhosHome(){
        int codRenda = this.rendaController.getID_Renda(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.getGanhosHome(codRenda);
    }
    public double getGastosHome(){
        int codRenda = this.rendaController.getID_Renda(LoginController.getUsuario().getIdUsuario());
        return this.lancamentoController.getGastosHome(codRenda);
    }
    */
   
/*
    public TabelaRelatorio iniciaTabela() {
        int idRenda = this.rendaController.getID_Renda(LoginController.getUsuario().getIdUsuario());
        this.tabelaRelatorio = new TabelaRelatorio(idRenda);
        return this.tabelaRelatorio;
    }

    public TabelaRelatorio filtrarTabela(int mes, int ano, int tipo){      
        int idRenda = this.rendaController.getID_Renda(LoginController.getUsuario().getIdUsuario());
        this.tabelaRelatorio = new TabelaRelatorio();
        this.tabelaRelatorio.filtrarTabela(mes, ano, tipo, idRenda);
        return this.tabelaRelatorio;
    }
  */  
}
