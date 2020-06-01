package com.employee.app.view;

import com.employee.app.domain.Email;
import com.employee.app.domain.Grade;
import com.employee.app.domain.Name;
import com.employee.app.domain.Phone;

public interface InputView {
	Name inputName();
	Phone inputPhoneNumber();
	Email inputEmail();
	Grade inputGrade();
	int inputMenuNumber();
	int inputEmployeeId();
}
