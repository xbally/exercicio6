package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leand
 */
public class ClienteDAO {

    private Connection con;
    int i;

    public ClienteDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();
    }

    public ArrayList<Cliente> listaCliente() throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM tb_cliente ";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id_cliente"));
            cliente.setCpf(rs.getString("cpf_cliente"));
            cliente.setNome(rs.getString("nome_cliente"));
            cliente.setEmail(rs.getString("email_cliente"));
            cliente.setDate(rs.getDate("data_cliente"));
            cliente.setRua(rs.getString("rua_cliente"));
            cliente.setNr(rs.getString("nr_cliente"));
            cliente.setCep(rs.getString("cep_cliente"));
            cliente.setCidade(rs.getString("cidade_cliente"));
            lista.add(cliente);
        }
        return lista;

    }

    public void insereCliente(Cliente novo) throws SQLException {
        String sql = "INSERT INTO tb_cliente(cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente)"
                + " VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?));";
        PreparedStatement st = con.prepareStatement(sql);
        
        i=1;
        st.setString(i, novo.getCpf());
        i++;
        st.setString(i, novo.getNome());
        i++;
        st.setString(i, novo.getEmail());
        i++;
        st.setDate(i, new java.sql.Date(novo.getDate().getTime()));
        i++;
        st.setString(i, novo.getRua());
        i++;
        st.setString(i, novo.getNr());
        i++;
        st.setString(i, novo.getCep());
        i++;
        st.setString(i, novo.getCidade());
        i++;
        st.setString(i,novo.getUf());

        st.executeUpdate();
    }

    public Cliente selectClienteById(int id) throws SQLException {

        String sql = "SELECT * FROM tb_cliente WHERE id_cliente = (?);";
        PreparedStatement st;
        st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        Cliente cliente = new Cliente();
        while (rs.next()) {
            i=1;
            cliente.setId(rs.getInt(i));
            i++;
            cliente.setCpf(rs.getString(i));
            i++;
            cliente.setNome(rs.getString(i));
            i++;
            cliente.setEmail(rs.getString(i));
            i++;
            cliente.setDate(rs.getDate(i));
            i++;
            cliente.setRua(rs.getString(i));
            i++;
            cliente.setNr(rs.getString(i));
            i++;
            cliente.setCep(rs.getString(i));
            i++;
            cliente.setCidade(rs.getString(i));
            i++;
            cliente.setUf(rs.getString(i));
        }
        return cliente;
    }

    public void removerClienteById(int id) throws SQLException{
        
        String sql = "DELETE FROM tb_cliente WHERE id_cliente = (?);";
        PreparedStatement st;
        st = con.prepareStatement(sql);
        st.setInt(1,id);
        st.executeUpdate();
    }
    
    public void alteraCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE  tb_cliente SET "
                + "cpf_cliente = (?), nome_cliente = (?), email_cliente = (?), data_cliente = (?), rua_cliente = (?), nr_cliente = (?), cep_cliente = (?), "
                + "cidade_cliente = (?), uf_cliente = (?) WHERE id_cliente = (?);";
        PreparedStatement st = con.prepareStatement(sql);
       
        i=1;
        st.setString(i, cliente.getCpf());
        i++;
        st.setString(i, cliente.getNome());
        i++;
        st.setString(i, cliente.getEmail());
        i++;
        st.setDate(i, new java.sql.Date(cliente.getDate().getTime()));
        i++;
        st.setString(i, cliente.getRua());
        i++;
        st.setString(i, cliente.getNr());
        i++;
        st.setString(i, cliente.getCep());
        i++;
        st.setString(i, cliente.getCidade());
        i++;
        st.setString(i, cliente.getUf());
        i++;
        st.setInt(i, cliente.getId());
        
        
        st.executeUpdate();
    }

}
