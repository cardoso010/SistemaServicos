/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.bean;

import br.com.servicos.dao.ClientesDAO;
import br.com.servicos.entity.Clientes;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author cardoso
 */

public class ClientesBean {

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
    public String removerCliente(){
        clienteDAO.removeCliente(cliente);
        return "sucesso!";
    }
    
    public List listarClientes(){
        listaCliente = clienteDAO.getList();
        return this.listaCliente;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientesBean other = (ClientesBean) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }
    
    
    
}
