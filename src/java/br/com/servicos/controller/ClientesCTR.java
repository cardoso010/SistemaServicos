package br.com.servicos.controller;

import br.com.servicos.bean.ClientesBean;
import br.com.servicos.entity.Clientes;
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
@WebServlet("/Clientes")
public class ClientesCTR extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        control(request, response);
    }
    
    protected void control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        Funcoes objfuncoes = new Funcoes();
        String acao = objfuncoes.Nulo(request.getParameter("acao"));
        List<Clientes> cliente = new ClientesBean().listarClientes();
        if(!cliente.isEmpty()){
            request.setAttribute("cliente", cliente);
            System.out.println("Não esta vazia!");
        }else{
            System.out.println("Esta vazia");
        }      
        if(acao.equals("cadastrarClientes")){
            if(request.getParameter("nome") != null){
                Clientes clientes = new Clientes();
                clientes.setNome(request.getParameter("nome"));
                clientes.setEndereco(request.getParameter("endereco"));
                clientes.setCep(request.getParameter("cep"));
                clientes.setCidade(request.getParameter("cidade"));
                clientes.setTelefone(request.getParameter("telefone"));
                clientes.setPais(request.getParameter("pais"));
                clientes.setEmail(request.getParameter("email"));
                ClientesBean clientesBean = new ClientesBean();
                clientesBean.setCliente(clientes);
                clientesBean.adicionarCliente(); 
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Clientes/CadClientes.jsp");
                rd.forward(request, response);
            }else{
                System.out.println("entrou else");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Clientes/CadClientes.jsp");
                rd.forward(request, response);
            }
        }else if(acao.equals("alterarCliente")){
            if(request.getParameter("id") != null){
                
            }
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Clientes/LisClientes.jsp");
            rd.forward(request, response);
        }else if(acao.equals("deletarCliente")){
            if(request.getParameter("id") != null){
                Clientes clientes = new Clientes();
                clientes.setId(Integer.parseInt(request.getParameter("id")));
                ClientesBean clientesbean = new ClientesBean();
                clientesbean.removerCliente(clientes);
            }
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Clientes/CadClientes.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Clientes/CadClientes.jsp");
            rd.forward(request, response);
        }
    } 
}
