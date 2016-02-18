package com.tdt.aws.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Login")
public class User {

	@DynamoDBHashKey(attributeName= "Login_ID")
	protected Integer id;
	
	@DynamoDBAttribute
	protected String email;
	
	@DynamoDBAttribute
	protected String password;
	
	@DynamoDBAttribute
	protected Integer person_id;
	
	
	public User() {
	}
	public User(String id, String email, String password, String person_id) {
		super();
		this.id = Integer.parseInt(id);
		this.email = email;
		this.password = password;
		this.person_id = Integer.parseInt(person_id);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getperson_id() {
		return person_id;
	}
	public void setperson_id(Integer person_id) {
		this.id = person_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
