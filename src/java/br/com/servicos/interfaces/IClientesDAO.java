package br.com.servicos.interfaces;

import br.com.servicos.entity.Clientes;

/**
 *
 * @author cardoso
 */
public interface IClientesDAO {
    
    public void addCliente(Clientes c);
    public void removeCliente(Clientes c);
    
}
