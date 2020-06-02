package com.employee.app.view.controller;

import static com.employee.app.utils.constants.SelectOperation.*;

import com.employee.app.domain.payload.EmployeePayload;
import com.employee.app.service.EmployeeService;
import com.employee.app.service.EmployeeServiceImpl;
import com.employee.app.view.InputView;
import com.employee.app.view.OutputView;

public class EmployeeController {
	private final InputView inputView;
	private final OutputView outputView;
	private final EmployeeService service;

	public EmployeeController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.service = new EmployeeServiceImpl();
	}

	public void execute() {
		while(true) {
			int menuNumber = inputView.inputMenuNumber();
			if(menuNumber == INPUT_INFORMATION) {
				saveEmployee();
				continue;
			}
			if(menuNumber == FIND_LIST) {
				getEmployeeList();
				continue;
			}
			if(menuNumber == FIND_DETAIL_INFORMATION_LIST) {
				getEmployeeDetailList();
				continue;
			}
			if(menuNumber == UPDATE_INFORMATION) {
				updateEmployee();
				continue;
			}
			if(menuNumber == DELETE_INFORMATION) {
				deleteEmployee();
				continue;
			}
			if(menuNumber == EXIT_PROGRAM) {
				exit();
				break;
			}
		}
	}

	private void saveEmployee() {
		EmployeePayload payload = EmployeePayload.builder()
			.name(inputView.inputName())
			.email(inputView.inputEmail())
			.grade(inputView.inputGrade())
			.phone(inputView.inputPhoneNumber())
			.build();
		service.save(payload);
	}

	private void updateEmployee() {
		outputView.employeeDetailList(service.findAll());
		service.update(inputView.inputEmployeeId(),
			EmployeePayload.builder()
				.email(inputView.inputEmail())
				.grade(inputView.inputGrade())
				.phone(inputView.inputPhoneNumber())
				.build());
	}

	private void deleteEmployee() {
		service.delete(inputView.inputEmployeeId());
	}

	private void getEmployeeDetailList() {
		outputView.employeeDetailList(service.findAll());
	}

	private void getEmployeeList() {
		outputView.employeeList(service.findAll());
	}

	private void exit() {
		outputView.exitProgram();
	}
}
