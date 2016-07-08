package com.red.sqlBuilder;

public class SqlBuilder {
	
	private StringBuilder sb;

	public SqlBuilder() {
		this.sb = new StringBuilder();
	}
	
	public SqlBuilder Select(){
		this.sb.append("SELECT * ");
		return this;
	}
	
	public SqlBuilder Select(String[] fields){
		this.sb.append("SELECT ");
		for (int i = 0; i < fields.length; i++) {
			if(i == fields.length - 1)
				this.sb.append(String.format("%s ", fields[i]));
			else
				this.sb.append(String.format("%s, ", fields[i]));
		}
		return this;
	}
	
	public SqlBuilder From(String tableName){
		this.sb.append(String.format("FROM %s", tableName));
		return this;
	}
	
	public String Result(){
		return this.sb.toString();
	}
	
}
