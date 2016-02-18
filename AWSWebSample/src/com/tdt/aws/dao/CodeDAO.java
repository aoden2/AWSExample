package com.tdt.aws.dao;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tdt.aws.model.Code;

public class CodeDAO extends AbstractDAO<Code, Integer, Serializable> implements DynamodbDAO<Code, Integer, Serializable> {

	@Override
	public Class<Code> getClazz() {
		return Code.class;
	}

	public List<Code> getByCategory(String category) {

		return getDynamoDB().scan(getClazz(), new DynamoDBScanExpression()
				.withFilterExpression("Code_category= :category")
				.addExpressionAttributeValuesEntry(":category", new AttributeValue(category)));
	}
}
