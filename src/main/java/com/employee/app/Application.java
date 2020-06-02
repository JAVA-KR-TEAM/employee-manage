package com.employee.app;

import com.employee.app.Member.domain.Employees;

import static com.employee.app.view.OutputView.printConsole;


public class Application {

    public static void main(String[] args) {
        printConsole(new Employees());
    }
}
