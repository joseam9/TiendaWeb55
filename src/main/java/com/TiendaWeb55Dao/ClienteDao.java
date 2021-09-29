package com.TiendaWeb55Dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.TiendaWeb55Dto.ClienteVO;
public class ClienteDao {

	
	public ArrayList<ClienteVO> listarPersona(){
		
		ArrayList<ClienteVO> listaClientes =new ArrayList<>();
		Conexion conex=new Conexion();
		
		try {
			String query="Select idClientes,Nombre,Apellidos from clientes;";
			PreparedStatement consulta =conex.getConnection().prepareStatement(query);
			ResultSet res=consulta.executeQuery();
			
			
			while(res.next()) {
				ClienteVO cliente=new ClienteVO();
				cliente.setIdCliente(res.getInt("idClientes"));
				cliente.setNombreCliente(res.getString("Nombre"));
				cliente.setApellidoCliente(res.getString("Apellidos"));
				listaClientes.add(cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			
			System.out.println("Error listarPersona..."+e);
		}
		return listaClientes;
	}
	
	public ArrayList<ClienteVO> consultarPersona(int id){
		ArrayList<ClienteVO> listaClientes =new ArrayList<>();
		Conexion conex=new Conexion();
		try {
			String query="Select idClientes,Nombre,Apellidos from clientes where idClientes=?";
			PreparedStatement consulta =conex.getConnection().prepareStatement(query);
			consulta.setInt(1, id);
			ResultSet res= consulta.executeQuery();
			if(res.next()) {
				ClienteVO cliente=new ClienteVO();
				cliente.setIdCliente(res.getInt("idClientes"));
				cliente.setNombreCliente(res.getString("Nombre"));
				cliente.setApellidoCliente(res.getString("Apellidos"));
				listaClientes.add(cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("Error consultarPersona..."+e);
		}
		return listaClientes;
	}
	
	public void registarPersona(ClienteVO persona) {
		Conexion conex = new Conexion();
		try {
			Statement est=conex.getConnection().createStatement();
			String query = "insert into clientes (idClientes,Nombre,Apellidos) "
					+ "values ("+persona.getIdCliente()+",'"+persona.getNombreCliente()+"','"+persona.getApellidoCliente()+"');";
			est.executeUpdate(query);
			System.out.println("Registro Correcto");
			est.close();
			conex.desconectar();
		} catch (Exception e) {
			System.out.println("Error registro");
		}
	}
	
}
