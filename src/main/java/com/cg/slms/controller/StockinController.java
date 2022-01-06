package com.cg.slms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.slms.domain.Client;
import com.cg.slms.domain.Employee;
import com.cg.slms.domain.Merchandise;
import com.cg.slms.domain.Stockin;
import com.cg.slms.service.IClientService;
import com.cg.slms.service.IEmployeeService;
import com.cg.slms.service.IMerchandiseService;
import com.cg.slms.service.IStockinService;
@Controller
public class StockinController {
	@Resource(name="stockinService")
	IStockinService stockinService;
	@Resource(name="employeeService")
	IEmployeeService employeeService;
	@Resource(name="merchandiseService")
	IMerchandiseService merchandiseService;
	@Resource(name="clientService")
	IClientService clientService;

	public IStockinService getStockinService() {
		return stockinService;
	}

	public void setStockinService(IStockinService stockinService) {
		this.stockinService = stockinService;
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
	@RequestMapping("/preStockinAction")
	public ModelAndView preStockinAction() {

		ModelAndView modelAndView;
		List<Employee> employees = employeeService.findEmployee(new Employee());
		List<Merchandise> merchandises = merchandiseService.findMerchandise(new Merchandise());
		List<Client> clients = clientService.findClient(new Client());
		if(employees!=null&&merchandises!=null&&clients!=null){
			modelAndView=new ModelAndView("/stock/stockin");
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
	@RequestMapping("/stockinAction")
	public ModelAndView findStockin(Stockin stockin) {
		ModelAndView modelAndView;
		List<Stockin> stockins = stockinService.findStockin(stockin);
		if(stockins!=null){
			modelAndView=new ModelAndView("/stock/stockin");
			modelAndView.addObject("merchandises", merchandisesMap) ;
			modelAndView.addObject("clients", clientsMap) ;
			modelAndView.addObject("stockins", stockins) ;
			modelAndView.addObject("employees", employeesMap) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/findStockinByIdAction")
	public ModelAndView findStockinById(String id) {
		ModelAndView modelAndView;
		Stockin stockin= stockinService.findStockinById(id);
		if(stockin!=null){
			modelAndView=new ModelAndView("/stock/updateStockin");
			modelAndView.addObject("stockin",stockin) ;
			modelAndView.addObject("merchandises", merchandisesMap) ;
			modelAndView.addObject("clients", clientsMap) ;
			modelAndView.addObject("employees", employeesMap) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}



	@RequestMapping("/updateStockinAction")
	public ModelAndView updateStockin(@Valid Stockin stockin, Errors errors) {
		ModelAndView modelAndView;
		if (errors.getErrorCount()>0){
			modelAndView=new ModelAndView("/stock/updateStockin");
			return modelAndView;
		}
		boolean ret = stockinService.updateStockin(stockin);
		if(ret){
			String finish_Url="/slms/moduls/stock/stockin.jsp";
			modelAndView=new ModelAndView("forward:/finish.jsp");
			modelAndView.addObject("finish_Url", finish_Url) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/deleteStockinByIdAction")
	public String deleteStockinById(String id) {
		boolean ret= stockinService.deleteStockinById(id);
		if(ret){
			return "forward:/stockinAction";
		}else{
			return "forward:/error.jsp";
		}
	}
	@RequestMapping("/addStockinAction")
	public ModelAndView addStockin(@Valid Stockin stockin, Errors errors) {
		ModelAndView modelAndView;
		if (errors.getErrorCount()>0){
			modelAndView=new ModelAndView("/stock/addStockin");
			return modelAndView;
		}
		boolean ret = stockinService.addStockin(stockin);
		if(ret){
			String finish_Url="/slms/moduls/stock/stockin.jsp";
			modelAndView=new ModelAndView("forward:/finish.jsp");
			modelAndView.addObject("finish_Url", finish_Url) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}


}
