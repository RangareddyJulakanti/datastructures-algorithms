package com.developer.tree;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer id;
    private String empName;
    private Double salary;
    private String designation;
    private Integer reportingId;
    private List<Employee> reportedEmployees=new ArrayList<>();
    public Employee(Integer id, String empName,  String designation,Double salary,Integer reportingId) {
        this.id = id;
        this.empName = empName;
        this.salary = salary;
        this.designation = designation;
        this.reportingId = reportingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getReportingId() {
        return reportingId;
    }

    public void setReportingId(Integer reportingId) {
        this.reportingId = reportingId;
    }

    public List<Employee> getReportedEmployees() {
        return reportedEmployees;
    }

    public void setReportedEmployees(List<Employee> reportedEmployees) {
        this.reportedEmployees = reportedEmployees;
    }
    public void addChild(Employee child){
        reportedEmployees.add(child);
    }
}
