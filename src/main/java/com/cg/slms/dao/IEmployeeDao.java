package com.cg.slms.dao;

import com.cg.slms.domain.Employee;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 22:08
 */
//数据访问层接口
public interface IEmployeeDao {
    List<Employee> findEmployee(Employee employee);
    boolean addEmployee(Employee employee);
    Employee findEmployeeById(String id);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployeeById(String id);
}
