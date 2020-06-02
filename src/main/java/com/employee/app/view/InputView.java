package com.employee.app.view;

import com.employee.app.domain.vo.Email;
import com.employee.app.domain.vo.Grade;
import com.employee.app.domain.vo.Name;
import com.employee.app.domain.vo.Phone;

public interface InputView {
	Name inputName();
	Phone inputPhoneNumber();
	Email inputEmail();
	Grade inputGrade();
	int inputMenuNumber();
	int inputEmployeeId();
}
