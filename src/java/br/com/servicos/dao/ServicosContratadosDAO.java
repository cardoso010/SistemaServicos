package br.com.servicos.dao;
import br.com.servicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.servicos.entity.ServicosContratados;

/**
 *
 * @author cardoso
 */
public class ServicosContratadosDAO {
    
    private Session sessao;
    private Transaction trans;
    private List<ServicosContratados> list;

    public List<ServicosContratados> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(ServicosContratados.class);
        this.list = cri.list();
        return list;
    }
    
    public void addServicosContratados(ServicosContratados sc){
        try {    
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            ServicosContratados servcont = new ServicosContratados();
            servcont.setServicos(sc.getServicos());
            servcont.setCliente(sc.getCliente());
            servcont.setPreco(sc.getPreco());
            servcont.setData_inicio(sc.getData_inicio());
            servcont.setData_fim(sc.getData_fim());

            sessao.save(servcont);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(sessao != null){
                sessao.close();
            }
        }
    }
    
    public void removeServicosContratados(ServicosContratados sc){
        try {
        
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
             
            sessao.delete(sc);
            trans.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    
}
