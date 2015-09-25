/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.bean;

import br.com.servicos.dao.ServicosContratadosDAO;
import br.com.servicos.entity.ServicosContratados;
import java.io.StringWriter;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author cardoso
 */
public class ServicosContratadosBean {
    
    ServicosContratados servcontr = new ServicosContratados();
    ServicosContratadosDAO servcontrDAO = new ServicosContratadosDAO();
    List<ServicosContratados> listaServicosContratados;
    
    public String adicionarServicosContratados(){
        servcontrDAO.addServicosContratados(servcontr);
        System.out.println("Passou addclienteDAO");
        return "sucesso!";
    }
    public String removerservicoContr(ServicosContratados sc){
        this.servcontr = sc;
        servcontrDAO.removeServicosContratados(this.servcontr);
        return "sucesso!";
    }

    
    public List listarServContra(){
        listaServicosContratados = servcontrDAO.getList();
        if(!listaServicosContratados.isEmpty()){
            System.out.println("Não esta vazia!");
        }else{
            System.out.println("Esta vazia");
        }
        return this.listaServicosContratados;
    }
    
    public void Json(){
        listaServicosContratados = servcontrDAO.getList();
        JSONObject json = new JSONObject();
        StringWriter ou = new StringWriter();
        
    }

    public ServicosContratados getServcontr() {
        return servcontr;
    }

    public void setServcontr(ServicosContratados servcontr) {
        this.servcontr = servcontr;
    }
    
    
    
}
