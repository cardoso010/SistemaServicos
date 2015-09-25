package br.com.servicos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.servicos.entity.Clientes;
import br.com.servicos.interfaces.IClientesDAO;
import br.com.servicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author cardoso
 */
public class ClientesDAO implements IClientesDAO {
    
    private Session sessao;
    private Transaction trans;
    private List<Clientes> list;

    public List<Clientes> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Clientes.class);
        this.list = cri.list();
        return list;
    }
    
    public void addCliente(Clientes c){
        try {    
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Clientes clientes = new Clientes();
            clientes.setNome(c.getNome());
            clientes.setEndereco(c.getEndereco());
            clientes.setCep(c.getCep());
            clientes.setCidade(c.getCidade());
            clientes.setTelefone(c.getTelefone());
            clientes.setPais(c.getPais());
            clientes.setEmail(c.getEmail());

            sessao.save(clientes);
            trans.commit();
            System.out.println("Passou commit");
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sessao != null){
                sessao.close();
            }
        }
    }
    
    public void selectClienteAll(){
        try {    
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            
           
            System.out.println("Passou commit");
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sessao != null){
                sessao.close();
            }
        }
    }
    
    public void updateCliente(Clientes c){
        try {
        
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
             
            sessao.update(c);
            trans.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    
    public void removeCliente(Clientes c){
        try {
        
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
             
            sessao.delete(c);
            trans.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    
}
