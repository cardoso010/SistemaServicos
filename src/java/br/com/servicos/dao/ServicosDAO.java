package br.com.servicos.dao;

import br.com.servicos.entity.Servicos;
import br.com.servicos.interfaces.IServicosDAO;
import br.com.servicos.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cardoso
 */
public class ServicosDAO implements IServicosDAO{
    
    private Session sessao;
    private Transaction trans;
    
    public void addServicos(Servicos s){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Servicos servicos = new Servicos();
            servicos.setNome(s.getNome());
            servicos.setPreco(s.getPreco());

            sessao.save(servicos);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sessao != null){
                sessao.close();
            }
        }
    }
    
    public void removeServicos(Servicos s){
        try {
             sessao = HibernateUtil.getSessionFactory().openSession();
             trans = sessao.beginTransaction();
             
             sessao.delete(s);
             trans.commit();
                 
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
}
