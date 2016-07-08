package com.red.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.red.data.Auth;
import com.red.data.Data;
import com.red.entities.ClientEntity;
import com.red.entities.LoginEntity;
import com.red.models.LoginModel; 

@Controller
public class ApiController {
	
	@RequestMapping(value = "api/auth", method = RequestMethod.POST)
	public @ResponseBody LoginEntity login(@RequestBody LoginModel loginModel){
		
		LoginEntity loginEntity = new LoginEntity();
		Auth auth = new Auth(loginModel.getEmail(), loginModel.getPass());
		if(auth.authenticate()){
			loginEntity.setResponse("ok");
			loginEntity.setStatus(200);
			loginEntity.setUserEmail(auth.getClient().getEmail());
			loginEntity.setUserId(auth.getClient().getId());
		}else{
			loginEntity.setResponse("unauthorized");
			loginEntity.setStatus(401);
		}
		
		return loginEntity;
	}
	
	@RequestMapping(value = "api/auth", method = RequestMethod.GET)
	public @ResponseBody LoginEntity login(){
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setResponse("forbidden");
		loginEntity.setStatus(403);
		return loginEntity;
	}
	
	@RequestMapping(value = "api/clients", method = RequestMethod.GET)
	public @ResponseBody List<ClientEntity> getClients(){
		List<ClientEntity> clientes = Data.jdbcTemplate().query("SELECT * from client", new RowMapper<ClientEntity>(){

			@Override
			public ClientEntity mapRow(ResultSet rs, int numRow) throws SQLException {
				ClientEntity cE = new ClientEntity();
				cE.setId(rs.getInt(ClientEntity.ID));
				cE.setEmail(rs.getString(ClientEntity.EMAIL));
				cE.setCompleteName(rs.getString(ClientEntity.COMPLETE_NAME));
				cE.setPass(rs.getString(ClientEntity.PASSWORD));
				cE.setRole(rs.getString(ClientEntity.ROLE));
				cE.setTelephone(rs.getInt(ClientEntity.TELEPHONE));
				return cE;
			}
		});
		
		return clientes;
	}
}
