package com.tdt.aws.dao;

import java.io.Serializable;

import org.json.JSONObject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tdt.aws.model.User;

public class UserDao extends AbstractDAO<User, String, Serializable> implements
		DynamodbDAO<User, String, Serializable> {

	@Override
	public Class<User> getClazz() {
		return User.class;
	}
	
	public void resetPwd(User user, String newPwd) throws Exception {
		user.setPassword(newPwd);
		save(user);
	}

	/**
	 * get User by Email
	 * @param email email
	 * @return User object
	 */
	public User getByEmail(String email) {

		DynamoDBScanExpression expression = 
				new DynamoDBScanExpression()
				.withFilterExpression("email = :email")
				.addExpressionAttributeValuesEntry(":email", new AttributeValue().withS(email));
		// email should be unique so this list should only have maximum 1 item
		return getDynamoDB().scan(getClazz(), expression).get(0); 
	}
	
	public JSONObject getJSONByEmail(String email) {
		
		return new JSONObject(getByEmail(email));
	}
}
