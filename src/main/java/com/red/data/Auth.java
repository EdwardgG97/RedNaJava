package com.red.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.RowMapper;

import com.red.entities.ClientEntity;
import com.red.sqlBuilder.SqlBuilder;

public class Auth {
	private String email, password;
	private long count;
	private List<ClientEntity> clients;
	
	public Auth(String email, String password) {
		this.email = email;
		this.password = password;
		this.count = 0;
		this.clients = Data.jdbcTemplate().query(new SqlBuilder().Select().From(AppSchemas.CLIENTS).Result(), new RowMapper<ClientEntity>(){

			@Override
			public ClientEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClientEntity clientEntity = new ClientEntity();
				clientEntity.setEmail(rs.getString(ClientEntity.EMAIL));
				clientEntity.setPass(rs.getString(ClientEntity.PASSWORD));
				clientEntity.setId(rs.getInt(ClientEntity.ID));
				clientEntity.setCompleteName(rs.getString(ClientEntity.COMPLETE_NAME));
				return clientEntity;
			}
			
		});
	}
	
	public boolean authenticate(){
		this.count = this.clients.stream().filter(f -> f.getEmail().equals(email) && f.getPass().equals(password)).count();
		if(this.count > 0 && this.count < 2)
			return true;
		return false;
	}
	
	public ClientEntity getClient(){
		return this.clients.stream().filter(f -> f.getEmail().equals(email) && f.getPass().equals(password)).collect(Collectors.toList()).get(0);
	}
}
