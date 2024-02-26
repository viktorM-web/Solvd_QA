package com.solvd.QA.homework_06_02.API;

import com.solvd.QA.homework_06_02.models.Employee;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import org.testng.annotations.Test;

import java.util.Objects;

public class EmployeeTest {

    @Test
    public void verifyGetEmployeeByEmployeeIdTest() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Tiger Nixon");
        employee.setSalary(320800);
        employee.setAge(61);

        GetEmployeeMethods getEmployeeMethods = new GetEmployeeMethods(employee.getId());
        getEmployeeMethods.addProperty("employee", employee);

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Integer>withPredicate("idPredicate", id -> Objects.equals(id, employee.getId()))
                .<Integer>withPredicate("salaryPredicate", salary -> Objects.equals(salary, employee.getSalary()))
                .<Integer>withPredicate("agePredicate", age -> Objects.equals(age, employee.getAge()));

        getEmployeeMethods.callAPIExpectSuccess();

        getEmployeeMethods.validateResponse(comparatorContext);
    }

    @Test
    public void verifyDeleteEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(1);

        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod(employee.getId());
        deleteEmployeeMethod.addProperty("employee", employee);
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }

    @Test
    public void verifyPostEmployeeTest() {
        Employee employee = new Employee();
        employee.setName("test");
        employee.setSalary(123);
        employee.setAge(23);

        PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
        postEmployeeMethod.addProperty("employee", employee);
        postEmployeeMethod.callAPIExpectSuccess();
        postEmployeeMethod.validateResponse();
    }

    @Test
    public void verifyPutEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("test");
        employee.setSalary(124);
        employee.setAge(24);

        PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod(employee.getId());
        putEmployeeMethod.addProperty("employee", employee);
        putEmployeeMethod.callAPIExpectSuccess();
        putEmployeeMethod.validateResponse();
    }
}
