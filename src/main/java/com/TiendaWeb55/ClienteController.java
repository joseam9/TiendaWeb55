package com.TiendaWeb55;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TiendaWeb55Dao.ClienteDao;
import com.TiendaWeb55Dto.ClienteVO;

@RestController
public class ClienteController {

	@RequestMapping("/listarClientes")
	public ArrayList<ClienteVO> listar(){
		//ArrayList<ClienteVO> listacliente = new ArrayList<ClienteVO>();		
		ClienteDao dao=new ClienteDao();
		//listacliente=dao.listarPersona();		
		return dao.listarPersona();
		//return listacliente;
	}
	
	@RequestMapping("/consultarCliente")
	public ArrayList<ClienteVO> consultar(int id){
		ClienteDao dao=new ClienteDao();
		return dao.consultarPersona(id);
	}
	
	@RequestMapping("/registarCliente")
	public void registrarCliente(ClienteVO cliente) {
		ClienteDao dao = new ClienteDao();
		dao.registarPersona(cliente);
	}
}
