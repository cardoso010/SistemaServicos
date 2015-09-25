/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.bean;

import br.com.servicos.dao.ServicosDAO;
import br.com.servicos.entity.Servicos;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author cardoso
 */

public class ServicosBean {

    /**
     * Creates a new instance of ServicosBean
    */
    private Servicos servico = new Servicos();
    private ServicosDAO servicosDAO = new ServicosDAO();
    private List<Servicos> listaServicos;
    
    
    public ServicosBean() {
    }
    
    public List listarServicos(){
        listaServicos = servicosDAO.getList();
        return this.listaServicos;
    }
    
    public String adicionaServico(){
        System.out.println("Entrou adc servicos");
        servicosDAO.addServicos(servico);
        return "sucesso!";
    }
    
    public String removerservico(){
        servicosDAO.removeServicos(servico);
        return "sucesso!";
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

}
