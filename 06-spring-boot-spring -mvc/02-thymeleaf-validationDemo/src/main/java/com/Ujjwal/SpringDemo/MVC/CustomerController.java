package com.Ujjwal.SpringDemo.MVC;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public  String showForm(Model theModel){


        theModel.addAttribute("customer",new Customer());

        return "customerForm";
    }


    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer , BindingResult theBindingResult
    ){
        if(theBindingResult.hasErrors()){
            return "customerForm";
        }else{
            return "customer-confirmation";
        }
    }

}