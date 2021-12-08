package com.ss.runner;

import com.retrieval.data.UsingProperties;
import com.ss.relations.OnetoOne;

public class Run {

	public static void main(String[] args) {

		//UsingProperties usingProperties = new UsingProperties();
		//usingProperties.fetchEmployeeDetails();
		//String objectList = usingProperties.fetchEmployeeDetails().toString();
		//System.out.println(objectList);
		OnetoOne onetoOne = new OnetoOne();
		onetoOne.getPayRate("Barbara");

	}

}
