package com.cg.slms.controller;

import com.cg.slms.domain.Client;
import com.cg.slms.domain.Client;
import com.cg.slms.service.IClientService;
import com.cg.slms.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/14 21:43
 */
@Controller
public class ClientController {

    @Autowired
    private IClientService clientService;
    /* 员工档案查询 */
    @RequestMapping("/clientAction")
    public ModelAndView findClient(Client client) {
        ModelAndView modelAndView;
        List<Client> clients = clientService.findClient(client);
        if(clients!=null){
            modelAndView=new ModelAndView("/client/client");
            modelAndView.addObject("clients", clients) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/addClientAction")
    public ModelAndView addClient(@Valid Client client, Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/client/addClient");
            return modelAndView;
        }
        boolean ret = clientService.addClient(client);
        if(ret){
            String finish_Url="/slms/moduls/client/client.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/findClientByIdAction")
    public ModelAndView findClientById(String id) {
        ModelAndView modelAndView;
        Client client= clientService.findClientById(id);
        if(client!=null){
            modelAndView=new ModelAndView("/client/updateClient");
            modelAndView.addObject("client",client) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/updateClientAction")
    public ModelAndView updateClient(@Valid Client client,Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/client/updateClient");
            return modelAndView;
        }
        boolean ret = clientService.updateClient(client);
        if(ret){
            String finish_Url="/slms/moduls/client/client.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/deleteClientByIdAction")
    public String deleteClientById(String id) {
        boolean ret= clientService.deleteClientById(id);
        if(ret){
            return "forward:/clientAction";
        }else{
            return "forward:/error.jsp";
        }
    }

}
