package com.ss.runner;

import com.retrieval.data.UsingProperties;
import com.ss.relations.ManyToMany;
import com.ss.relations.ManyToOne;
import com.ss.relations.OnetoOne;

public class Run {

	public static void main(String[] args) {

		// UsingProperties usingProperties = new UsingProperties();
		// usingProperties.fetchEmployeeDetails();
		// String objectList = usingProperties.fetchEmployeeDetails().toString();
		// System.out.println(objectList);
		
		// OnetoOne onetoOne = new OnetoOne();
		// onetoOne.getPayRate("Barbara");
		
		// ManyToOne manyToOne = new ManyToOne();
		// manyToOne.getOrderDetails("Jamison Books");
		
		ManyToMany manyToMany = new ManyToMany();

		System.out.println(manyToMany.getDetails("EN1-33"));

	}

}
