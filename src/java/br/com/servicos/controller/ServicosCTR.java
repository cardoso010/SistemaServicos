/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos.controller;

import br.com.servicos.bean.ServicosBean;
import br.com.servicos.entity.Servicos;
import br.com.servicos.funcoes.Funcoes;
import java.io.IOException;
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
@WebServlet("/Servicos")
public class ServicosCTR extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        control(request, response);
    }
    
    protected void control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        Funcoes objfuncoes = new Funcoes();        
        String acao = objfuncoes.Nulo(request.getParameter("acao"));
        
        if(acao.equals("cadastrarServicos")){
            if(request.getParameter("nome") != null){
                Servicos servicos = new Servicos();
                System.out.println("Nome = "+ request.getParameter("nome"));
                servicos.setNome(request.getParameter("nome"));
                System.out.println("preco = "+ request.getParameter("preco"));
                servicos.setPreco(Float.parseFloat(request.getParameter("preco")));
                ServicosBean servicosBean = new ServicosBean();
                servicosBean.setServico(servicos);
                servicosBean.adicionaServico();
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Servicos/CadServicos.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Servicos/CadServicos.jsp");
                rd.forward(request, response);
            }
        }else if(acao.equals("listarServicos")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Servicos/LisServicos.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Servicos/CadServicos.jsp");
            rd.forward(request, response);
        }
            
    }
    
}
