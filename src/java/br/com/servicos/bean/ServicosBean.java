/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.bean;

import br.com.servicos.dao.ServicosDAO;
import br.com.servicos.entity.Servicos;
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
    
    
    public ServicosBean() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.servico);
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
        final ServicosBean other = (ServicosBean) obj;
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
