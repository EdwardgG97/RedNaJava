package com.red.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Data {
	private static DriverManagerDataSource dataSource;
	
	public static JdbcTemplate jdbcTemplate(){
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/rednajava");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return new JdbcTemplate(dataSource);
	}
	
	//private JdbcTemplate jdbcTemplate;
		/*public Data() {
			this.dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
			dataSource.setUrl("jdbc:mysql://localhost/rednajava");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		public List<Map<String, Object>> consultarTodo(String tableName){
			String sql = String.format("SELECT * FROM %s", tableName);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			return rows;
		}
		
		public List<Map<String, Object>> consultarEspecificos(String tableName, String fields){
			String sql = String.format("SELECT %s FROM %s", fields, tableName);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			return rows;
		}
		
		public List<ClientEntity> getClients(){
			List<ClientEntity> clients = jdbcTemplate.query("SELECT * FROM client", new RowMapper<ClientEntity>(){
				@Override
				public ClientEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
					ClientEntity clientEntity = new ClientEntity();
					clientEntity.setId(rs.getInt("ID_CLIENT"));
					clientEntity.setCompleteName(rs.getString("COMPLETE_NAME"));
					clientEntity.setEmail(rs.getString("EMAIL"));
					clientEntity.setRole(rs.getString("ROLE"));
					clientEntity.setTelephone(rs.getInt("TELEPHONE"));
					return clientEntity;
				}
			});
			
			return clients;
		}*/
}
