package com.pizza.inventory.mgmt.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerClass {

	public static void main(String[] args) {
		Result factoryPatternResult = JUnitCore.runClasses(PizzaStoreTest.class);

		for (Failure failure : factoryPatternResult.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(factoryPatternResult.wasSuccessful());
		

		Result result = JUnitCore.runClasses(PizzaStoreTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
}