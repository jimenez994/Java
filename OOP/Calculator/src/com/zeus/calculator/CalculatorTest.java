package com.zeus.calculator;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator bla = new Calculator();
		bla.performOperation(2, "+", 1).performOperation(bla.getResult(), "+", bla.getResult()).performOperation(bla.getResult(), "+", 2345).performOperation(1323, "+", bla.getResult());
		bla.getResult();
	}

}
