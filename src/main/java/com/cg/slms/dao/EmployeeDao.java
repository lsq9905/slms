package com.cg.slms.dao;

import com.cg.slms.domain.Employee;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    private SqlSessionTemplate sqlSession;

    public List<Employee> findEmployee(Employee employee) {
        List<Employee> employees = new ArrayList<Employee>();
        employees = sqlSession.selectList("findEmployee", employee);
        return employees;
    }

    public boolean addEmployee(Employee employee) {
        int ret = sqlSession.insert("addEmployee", employee);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Employee findEmployeeById(String id) {
        Employee employee = sqlSession.selectOne("findEmployeeById", id);
        return employee;
    }

    public boolean updateEmployee(Employee employee) {
        int ret = sqlSession.update("updateEmployee", employee);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEmployeeById(String id) {
        int ret = sqlSession.delete("deleteEmployeeById", id);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }


}
