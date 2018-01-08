package com.zeus.calculator;

public class Calculator implements java.io.Serializable,CanCalculate{
	private double operandOne = 0.0;
	private double operandTwo = 0.0;
	private String operation;
	private double result;
	
	public Calculator() {
		
	}
	public Calculator performOperation(double opOne,String sig, double opTwo) {
		if(sig == "+") {
			result = opOne + opTwo;
		}else if(sig == "-") {
			result = opOne - opTwo;
		}else {
			System.out.println("Invalid input");
		}
		return this;
	}
	public double getResult() {
		System.out.println("Result "+ result);
		
		return result;
		
	}
	
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double num1) {
		this.operandOne = num1;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double num2) {
		this.operandTwo = num2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String op) {
		this.operation = op;
	}


}
