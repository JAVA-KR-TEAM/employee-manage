package com.employee.app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryEmployeeRepository implements EmployeeRepository {
	private final Map<Integer, Employee> data = new ConcurrentHashMap<>();
	private Integer incrementId = 1;

	@Override
	public Optional<Employee> findById(Integer employeeId) {
		return data.values()
			.stream()
			.filter(it -> Objects.equals(employeeId, it.getId()))
			.findFirst();
	}

	@Override
	public List<Employee> findAll() {
		return new ArrayList<>(data.values());
	}

	@Override
	public Employee save(Employee entity) {
		if (entity.getId() == null) {
			entity.setId(incrementId);
			incrementId++;
		}
		data.putIfAbsent(Objects.requireNonNull(entity.getId()), entity);
		return entity;
	}

	@Override
	public void deleteById(Integer employeeId) {
		data.remove(employeeId);
	}
}
