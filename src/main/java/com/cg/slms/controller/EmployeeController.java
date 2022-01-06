package com.cg.slms.controller;

import com.cg.slms.domain.Employee;
import com.cg.slms.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/9 22:04
 */
@Controller
public class EmployeeController{


    @Resource(name="employeeService")
    private IEmployeeService employeeService;
    /* 员工档案查询 */
    @RequestMapping("/employeeAction")
    public ModelAndView findEmployee(Employee employee) {
        ModelAndView modelAndView;
        List<Employee> employees = employeeService.findEmployee(employee);
        if(employees!=null){
            modelAndView=new ModelAndView("/archive/employee");
            modelAndView.addObject("employees", employees) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/addEmployeeAction")
    public ModelAndView addEmployee(@Valid Employee employee, Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/archive/addEmployee");
            return modelAndView;
        }
        boolean ret = employeeService.addEmployee(employee);
        if(ret){
            String finish_Url="/slms/moduls/archive/employee.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/findEmployeeByIdAction")
    public ModelAndView findEmployeeById(String id) {
        ModelAndView modelAndView;
        Employee employee= employeeService.findEmployeeById(id);
        if(employee!=null){
            modelAndView=new ModelAndView("/archive/updateEmployee");
            modelAndView.addObject("employee",employee) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/updateEmployeeAction")
    public ModelAndView updateEmployee(@Valid Employee employee,Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/archive/updateEmployee");
            return modelAndView;
        }
        boolean ret = employeeService.updateEmployee(employee);
        if(ret){
            String finish_Url="/slms/moduls/archive/employee.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/deleteEmployeeByIdAction")
    public String deleteEmployeeById(String id) {
        boolean ret= employeeService.deleteEmployeeById(id);
        if(ret){
            return "forward:/employeeAction";
        }else{
            return "forward:/error.jsp";
        }
    }


}

