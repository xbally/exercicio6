/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author leand
 */
public class ClientesFacade {

    public static void inserir(Cliente c) throws SQLException, ClassNotFoundException {
        ClienteDAO dao = new ClienteDAO();
        dao.insereCliente(c);
    }
public static void alterar(Cliente c) throws SQLException, ClassNotFoundException {
        
        ClienteDAO dao = new ClienteDAO();
        dao.alteraCliente(c);
    }
public static Cliente buscar(int id) throws SQLException, ClassNotFoundException {
        ClienteDAO dao = new ClienteDAO();
        return dao.selectClienteById(id);
    }
public static List<Cliente> buscarTodos() throws SQLException, ClassNotFoundException {
        ClienteDAO dao = new ClienteDAO();
        return dao.listaCliente();
    }
    public static void excluir(int id) throws SQLException, ClassNotFoundException {
        ClienteDAO dao = new ClienteDAO();
        dao.removerClienteById(id);
    }
}

