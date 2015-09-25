/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.bean;

import br.com.servicos.dao.ClientesDAO;
import br.com.servicos.entity.Clientes;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cardoso
 */

public class ClientesBean extends HttpServlet{
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    /**
     * Creates a new instance of ClientesBean
     */
    
    private Clientes cliente = new Clientes();
    private ClientesDAO clienteDAO = new ClientesDAO();
    private List<Clientes> listaCliente;
    
    public ClientesBean() {
    }
    
    public String adicionarCliente(){
        clienteDAO.addCliente(cliente);
        System.out.println("Passou addclienteDAO");
        return "sucesso!";
    }
    public String removerCliente(Clientes c){
        this.cliente = c;
        clienteDAO.removeCliente(this.cliente);
        return "sucesso!";
    }
    
    public List listarClientes(){
        listaCliente = clienteDAO.getList();
        if(!listaCliente.isEmpty()){
            System.out.println("Não esta vazia!");
        }else{
            System.out.println("Esta vazia");
        }
        return this.listaCliente;
    }
    
    public String carregarCLientes(Clientes c){
        cliente = c;
        return "editar";
    }
    
    public String alterarClientes(){
        clienteDAO.updateCliente(cliente);
        cliente = null;
        return "";
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
}
