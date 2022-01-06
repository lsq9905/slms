package com.cg.slms.controller;

import com.cg.slms.domain.Merchandise;
import com.cg.slms.service.IMerchandiseService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author lsq_9905@163.com
 * @date 2021/12/14 22:55
 */
@Controller
public class MerchandiseController {
    @Resource(name="merchandiseService")
    private IMerchandiseService merchandiseService;
    /* 员工档案查询 */
    @RequestMapping("/merchandiseAction")
    public ModelAndView findMerchandise(Merchandise merchandise) {
        ModelAndView modelAndView;
        List<Merchandise> merchandises = merchandiseService.findMerchandise(merchandise);
        if(merchandises!=null){
            modelAndView=new ModelAndView("/merchandise/merchandise");
            modelAndView.addObject("merchandises", merchandises) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/addMerchandiseAction")
    public ModelAndView addMerchandise(@Valid Merchandise merchandise, Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/merchandise/addMerchandise");
            return modelAndView;
        }
        boolean ret = merchandiseService.addMerchandise(merchandise);
        if(ret){
            String finish_Url="/slms/moduls/merchandise/merchandise.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/findMerchandiseByIdAction")
    public ModelAndView findMerchandiseById(String id) {
        ModelAndView modelAndView;
        Merchandise merchandise= merchandiseService.findMerchandiseById(id);
        if(merchandise!=null){
            modelAndView=new ModelAndView("/merchandise/updateMerchandise");
            modelAndView.addObject("merchandise",merchandise) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/updateMerchandiseAction")
    public ModelAndView updateMerchandise(@Valid Merchandise merchandise,Errors errors) {
        ModelAndView modelAndView;
        if (errors.getErrorCount()>0){
            modelAndView=new ModelAndView("/merchandise/updateMerchandise");
            return modelAndView;
        }
        boolean ret = merchandiseService.updateMerchandise(merchandise);
        if(ret){
            String finish_Url="/slms/moduls/merchandise/merchandise.jsp";
            modelAndView=new ModelAndView("forward:/finish.jsp");
            modelAndView.addObject("finish_Url", finish_Url) ;
        }else{
            modelAndView=new ModelAndView("forward:/error.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/deleteMerchandiseByIdAction")
    public String deleteMerchandiseById(String id) {
        boolean ret= merchandiseService.deleteMerchandiseById(id);
        if(ret){
            return "forward:/merchandiseAction";
        }else{
            return "forward:/error.jsp";
        }
    }

}
