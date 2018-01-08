package com.zeus.calculator;

public interface CanCalculate {
	Calculator performOperation(double opOne,String sig, double opTwo);
	double getResult();
	

}
