package com.cg.slms.service;

import com.cg.slms.dao.IEmployeeDao;
import com.cg.slms.domain.Employee;

import java.util.List;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 22:05
 */
//业务处理层接口
public interface IEmployeeService{

    List<Employee> findEmployee(Employee employee);
    boolean addEmployee(Employee employee);
    Employee findEmployeeById(String id);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployeeById(String id);
}


