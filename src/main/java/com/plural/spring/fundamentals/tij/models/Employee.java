package com.plural.spring.fundamentals.tij.models;

import com.plural.spring.fundamentals.tij.annotations.Constraints;
import com.plural.spring.fundamentals.tij.annotations.DBTable;
import com.plural.spring.fundamentals.tij.annotations.SQLString;

@DBTable(name = "EMPLOYEE")
public class Employee {

    @SQLString(value = 55, name = "EMPLOYEE_ID", constraints = @Constraints(isNull = false, isPrimary = true, isUnique = true))
    private String employeeId;

    @SQLString(value = 101, name = "FIRST_NAME", constraints = @Constraints(isNull = false))
    private String firstName;

    @SQLString(value = 101, name = "LAST_NAME", constraints = @Constraints(isNull = false))
    private String lastName;

    @SQLString(1001)
    private String address;
}
