package br.com.servicos.controller;

import br.com.servicos.bean.ServicosContratadosBean;
import br.com.servicos.entity.Servicos;
import br.com.servicos.entity.ServicosContratados;
import br.com.servicos.funcoes.Funcoes;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cardoso
 */
@WebServlet("/ServicosContratados")
public class ServicosContratadosCTR extends HttpServlet{
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        control(request, response);
    }
    
    protected void control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        Funcoes objfuncoes = new Funcoes();        
        String acao = objfuncoes.Nulo(request.getParameter("acao"));
        List<ServicosContratados> servicoContr = new ServicosContratadosBean().listarServContra();
        if(!servicoContr.isEmpty()){
            System.out.println("Não esta vazio!");
            request.setAttribute("servicos", servicoContr);
        }else{
            System.out.println("esta vazio!");
        }
        
        if(acao.equals("cadastrarServicosContratados")){
            if(request.getParameter("nome") != null){
                System.out.println("Entrou inserir servico");
            
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/ServicosContratados/CadServicosContratados.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/ServicosContratados/CadServicosContratados.jsp");
                rd.forward(request, response);
            }
        }else if(acao.equals("alterarServicosContratados")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/ServicosContratados/CadServicosContratados.jsp");
                rd.forward(request, response);
        }else if(acao.equals("deletarServicosContratados")){
            if(request.getParameter("id") != null){
                ServicosContratadosBean servicosbean = new ServicosContratadosBean();
                ServicosContratados serv = new ServicosContratados();
                serv.setId(Integer.parseInt(request.getParameter("id")));
                servicosbean.removerservicoContr(serv);
            }
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/ServicosContratados/CadServicosContratados.jsp");
            rd.forward(request, response);
        }
            
    }
    
    
}
