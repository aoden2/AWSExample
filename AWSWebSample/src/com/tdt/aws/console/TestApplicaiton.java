package com.tdt.aws.console;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amazonaws.util.json.JSONArray;
import com.tdt.aws.dao.CodeDAO;
import com.tdt.aws.model.Code;

public class TestApplicaiton {

	public static void main(String[] args) throws Exception {

		CodeDAO dao = new CodeDAO();

		// first get all codes from table
		List<Code> items = dao.getAll();
		
		// We need to prepare a map to convert to JSON object you looking for
		Map<String, Map<String, String>> results = new HashMap();
		
		// Set is a Java collection that not allows duplicates items inside, 
		Set<String> categories = new HashSet();
        for (Code c: items) {
        	
            categories.add(c.getCategory());
        }
        // with each unique category we scan the table and find all items associated with then put to a map
        for (String cate: categories) {

            Map<String, String> valueMap = new HashMap();
            for(Code c: dao.getByCategory(cate)) {
            	// construct a Map that represent a JSON object with key is code value and value is code value
                valueMap.put(c.getValue(), c.getDescription());
            }
            if (!valueMap.isEmpty()) {
                results.put(cate, valueMap);
            }
        }
		System.out.println("data in db: ");
		// print JSON array
		System.out.println(new JSONArray(new Object[]{results}));
        System.out.println("Done");
	}
}
