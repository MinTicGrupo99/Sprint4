package com.ciclo3.Sprint3.Controllers;

import com.ciclo3.Sprint3.Models.UsersApplication;
import com.ciclo3.Sprint3.Service.ServiceInterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @Autowired
    private ServiceInterfaceUser UserBDX;



    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/loginUser")
    public String getLogin(Model model){
        model.addAttribute("formUsersLogin",new UsersApplication());
        return "loginUser";
    }


    @GetMapping("/forgotPassword")
    public String getforgotPassword(Model model){
        return "forgotPassword";
    }

    @GetMapping("/WelcomeUser")
    public String getWelcomeUser(Model model){
        return "WelcomeUser";
    }


    @GetMapping("/WelcomeEnterprise")
    public String getWelcomeEnterprise(Model model){
        return "WelcomeEnterprise";
    }

    @GetMapping("/errorLogin")
    public String getErrorLogin(Model model){
        return "ErrorLogin";
    }

}
