package com.tdt.aws.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Codes")
public class Code {

	@DynamoDBHashKey(attributeName = "Code_Id")
	protected Integer id;
	@DynamoDBAttribute(attributeName = "Code_category")
	protected String category;
	@DynamoDBAttribute(attributeName = "Code_value")
	protected String value;
	@DynamoDBAttribute(attributeName = "Code_description")
	protected String description;
	@DynamoDBAttribute(attributeName = "Status")
	protected String status;
	
	public Code() {
	}
	public Code(Integer id, String category, String value, String description,
			String status) {
		this.id = id;
		this.category = category;
		this.value = value;
		this.description = description;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
