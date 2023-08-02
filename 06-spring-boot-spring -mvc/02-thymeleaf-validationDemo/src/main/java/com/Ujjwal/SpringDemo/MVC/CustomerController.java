package com.Ujjwal.SpringDemo.MVC;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

//    Add an initbinder .... to convert trim inout settings,
//    remove leading and tailing whitespaces.
//    resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class , stringTrimmerEditor);
    }



    @GetMapping("/")
    public  String showForm(Model theModel){


        theModel.addAttribute("customer",new Customer());

        return "customerForm";
    }



    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer , BindingResult theBindingResult
    ){
        System.out.println(theBindingResult);
        System.out.println(theCustomer);
        if(theBindingResult.hasErrors()){
            return "customerForm";
        }else{
            return "customer-confirmation";
        }
    }

}
