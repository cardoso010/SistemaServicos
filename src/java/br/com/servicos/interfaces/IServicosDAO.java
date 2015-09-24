package br.com.servicos.interfaces;

import br.com.servicos.entity.Servicos;

/**
 *
 * @author cardoso
 */
public interface IServicosDAO {
    
    public void addServicos(Servicos s);
    public void removeServicos(Servicos s);
    
}
