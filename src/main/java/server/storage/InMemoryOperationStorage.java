package server.storage;



import server.model.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon Pirko on 25.01.24
 */
public class InMemoryOperationStorage {

	private final List<Operation> operations = new ArrayList<>();

	public void save(Operation operation) {
		operations.add(operation);
	}

	public List<Operation> findAll() {
		return new ArrayList<>(operations);
	}
}
