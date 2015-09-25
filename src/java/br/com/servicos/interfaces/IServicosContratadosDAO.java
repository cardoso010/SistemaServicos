/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.interfaces;

import br.com.servicos.entity.ServicosContratados;

/**
 *
 * @author cardoso
 */
public interface IServicosContratadosDAO {
    
    public void addServicosContratados(ServicosContratados sc);
    public void removeServicosContratados(ServicosContratados sc);
    
}
