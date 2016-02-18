package com.tdt.aws.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Code_category_value")
public class CodeCategoryValueConst {

	@DynamoDBHashKey(attributeName = "Code_category")
	protected String category;
	
	@DynamoDBRangeKey(attributeName = "Code_value")
	protected String value;
	
	@DynamoDBAttribute(attributeName = "Code_Id")
	protected Integer codeId;

	public Integer getCodeId() {
		return codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
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

	public CodeCategoryValueConst(String category, String value, Integer id) {
		this.category = category;
		this.value = value;
		this.codeId = id;
	}

	public CodeCategoryValueConst() {
	}
	
	
}
