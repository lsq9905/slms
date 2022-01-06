package com.cg.slms.controller;

import com.cg.slms.domain.*;
import com.cg.slms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/15 23:05
 */
@Controller
public class StockorderController {

    @Resource(name="stockorderService")
    IStockorderService stockorderService;
    @Resource(name="employeeService")
    IEmployeeService employeeService;
    @Resource(name="merchandiseService")
    IMerchandiseService merchandiseService;
    @Resource(name="clientService")
    IClientService clientService;

    public IStockorderService getStockorderService() {
        return stockorderService;
    }

    public void setStockorderService(IStockorderService stockorderService) {
        this.stockorderService = stockorderService;
    }

    public IEmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public IMerchandiseService getMerchandiseService() {
        return merchandiseService;
    }

    public void setMerchandiseService(IMerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }

    public IClientService getClientService() {
        return clientService;
    }

    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }
    Map<String, String> employeesMap;
    Map<String, String> merchandisesMap;
    Map<String, String> clientsMap;

    @RequestMapping("/preStockorderAction")
    public ModelAndView preStockorderAction() {

        ModelAndView modelAndView;
        List<Employee> employees = employeeService.findEmployee(new Employee());
        List<Merchandise> merchandises = merchandiseService.findMerchandise(new Merchandise());
        List<Client> clients = clientService.findClient(new Client());
        if(employees!=null&&merchandises!=null&&clients!=null){
            modelAndView=new ModelAndView("/stockorder/stockorder");
            employeesMap = new HashMap<String, String>();
            employeesMap.put("", "");
            for (Employee employee : employees) {
                employeesMap.put(employee.getName(), employee.getName());
            }
            modelAndView.addObject("employees", employeesMap) ;
            merchandisesMap = new HashMap<String, String>();
            merchandisesMap.put("", "");
            for (Merchandise merchandise : merchandises) {
                merchandisesMap.put(merchandise.getName(), merchandise.getName());
            }
            modelAndView.addObject("merchandises", merchandisesMap) ;
            clientsMap = new HashMap<String, String>();
            clientsMap.put("", "");
            for (Client client : clients) {
                clientsMap.put(client.getName(), client.getName());
            }
            modelAndView.addObject("clients", clientsMap) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }
    @RequestMapping("/stockorderAction")
    public ModelAndView findStockorder(Stockorder stockorder) {
        ModelAndView modelAndView;
        List<Stockorder> stockorders = stockorderService.findStockorder(stockorder);
        if(stockorders!=null){
            modelAndView=new ModelAndView("/stockorder/stockorder");
            modelAndView.addObject("merchandises", merchandisesMap) ;
            modelAndView.addObject("clients", clientsMap) ;
            modelAndView.addObject("stockorders", stockorders) ;
            modelAndView.addObject("employees", employeesMap) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/findStockorderByIdAction")
    public ModelAndView findStockorderById(String id) {
        ModelAndView modelAndView;
        Stockorder stockorder= stockorderService.findStockorderById(id);
        if(stockorder!=null){
            modelAndView=new ModelAndView("/stockorder/updateStockorder");
            modelAndView.addObject("stockorder",stockorder) ;
            modelAndView.addObject("merchandises", merchandisesMap) ;
            modelAndView.addObject("clients", clientsMap) ;
            modelAndView.addObject("employees", employeesMap) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }



    @RequestMapping("/updateStockorderAction")
    public ModelAndView updateStockorder(@Valid Stockorder stockorder, Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/stockorder/updateStockorder");
            return modelAndView;
        }
        boolean ret = stockorderService.updateStockorder(stockorder);
        if(ret){
            String finish_Url="/slms/moduls/stockorder/stockorder.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/deleteStockorderByIdAction")
    public String deleteStockorderById(String id) {
        boolean ret= stockorderService.deleteStockorderById(id);
        if(ret){
            return "forward:/stockorderAction";
        }else{
            return "forward:/error.jsp";
        }
    }
    @RequestMapping("/addStockorderAction")
    public ModelAndView addStockorder(@Valid Stockorder stockorder, Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/stockorder/addStockorder");
            return modelAndView;
        }
        boolean ret = stockorderService.addStockorder(stockorder);
        if(ret){
            String finish_Url="/slms/moduls/stockorder/stockorder.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

}
