/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.ErroBean;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.facade.ClientesFacade;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leand
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            LoginBean log = new LoginBean();
            log = (LoginBean) request.getSession().getAttribute("login");
            if (log == null) {
                ErroBean erro = new ErroBean();
                erro.setMsg("Usuário deve se atutenticar para acessar o sistema");
                erro.setPage("index.jsp");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                request.setAttribute("erro", erro);
                rd.forward(request, response);
            }
            int id;
            Cliente cliente;
            List<Cliente> lista;
            RequestDispatcher rd;
            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "list":
                        lista = ClientesFacade.buscarTodos();
                        request.setAttribute("clientes", lista);
                        rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");
                        rd.forward(request, response);
                        break;
                    case "show":
                        id = Integer.parseInt(request.getParameter("id"));
                        cliente = ClientesFacade.buscar(id);
                        request.setAttribute("visualizar", cliente);
                        rd = getServletContext().getRequestDispatcher("/clientesVisualizar.jsp");
                        rd.forward(request, response);
                        break;
                    case "formUpdate":
                        id = Integer.parseInt(request.getParameter("id"));
                        cliente = ClientesFacade.buscar(id);
                        request.setAttribute("alterar", cliente);
                        rd = getServletContext().getRequestDispatcher("/clientesAlterar.jsp");
                        rd.forward(request, response);
                        break;
                    case "remove":
                        id = Integer.parseInt(request.getParameter("id"));
                        ClientesFacade.excluir(id);
                        response.sendRedirect(request.getContextPath() + "/ClientesServlet");
                        break;
                    case "update":
                        cliente = new Cliente();
                        id = Integer.parseInt(request.getParameter("id"));
                        cliente.setId(id);
                        cliente.setCpf(request.getParameter("cpf"));
                        cliente.setNome(request.getParameter("nome"));
                        cliente.setEmail(request.getParameter("email"));
                        String dataString = request.getParameter("date");
                        DateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
                        Date data = new Date(frmt.parse(dataString).getTime());
                        cliente.setDate(data);
                        cliente.setCep(request.getParameter("cep"));
                        cliente.setRua(request.getParameter("rua"));
                        cliente.setNr(request.getParameter("nr"));
                        cliente.setCidade(request.getParameter("cidade"));
                        cliente.setUf(request.getParameter("uf"));
                        ClientesFacade.alterar(cliente);
                        response.sendRedirect(request.getContextPath() + "/ClientesServlet");
                        break;
                    case "formNew":
                        response.sendRedirect(request.getContextPath() + "/clientesNovo.jsp");
                        break;
                    case "new":
                        cliente = new Cliente();
                        cliente.setNome(request.getParameter("nome"));
                        cliente.setCpf(request.getParameter("cpf"));
                        cliente.setEmail(request.getParameter("email"));
                        String dataS = request.getParameter("date");
                        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date(fmt.parse(dataS).getTime());
                        cliente.setDate(date);
                        cliente.setCep(request.getParameter("cep"));
                        cliente.setRua(request.getParameter("rua"));
                        cliente.setNr(request.getParameter("numero"));                       
                        cliente.setCidade(request.getParameter("cidade"));
                        cliente.setUf(request.getParameter("uf"));
                        ClientesFacade.inserir(cliente);
                        response.sendRedirect(request.getContextPath() + "/ClientesServlet");
                        break;
                    default:;
                }

            } else {

                lista = ClientesFacade.buscarTodos();
                request.setAttribute("clientes", lista);
                rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");
                rd.forward(request, response);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
