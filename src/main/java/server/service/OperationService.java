package server.service;


import server.model.Operation;

public class OperationService {

	public Operation calculate(Operation operation) {

		double result;

		switch (operation.getOperation()) {
			case "+":
				result = operation.getNum1() + operation.getNum2();
				operation.setResult(result);
				return operation;
			case "-":
				result = operation.getNum1() - operation.getNum2();
				operation.setResult(result);
				return operation;
			case "*":
				result = operation.getNum1() * operation.getNum2();
				operation.setResult(result);
				return operation;
			case "/":
				result = operation.getNum1() / operation.getNum2();
				operation.setResult(result);
				return operation;
			default:
				throw new IllegalArgumentException();
		}

	}
}
