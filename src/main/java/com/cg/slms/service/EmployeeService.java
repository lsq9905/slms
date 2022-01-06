package com.cg.slms.service;

import com.cg.slms.dao.IEmployeeDao;
import com.cg.slms.domain.Employee;

import java.util.List;

//实现类
public class EmployeeService implements IEmployeeService {
    private IEmployeeDao employeeDao;

    public List<Employee> findEmployee(Employee employee) {
        return employeeDao.findEmployee(employee);
    }

    public IEmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public Employee findEmployeeById(String id) {
        return employeeDao.findEmployeeById(id);
    }

    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    public boolean deleteEmployeeById(String id) {
        return employeeDao.deleteEmployeeById(id);
    }

}
