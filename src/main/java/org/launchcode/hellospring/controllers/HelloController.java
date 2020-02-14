package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name){
       return "Hello, " + name + "!";
    }

    @GetMapping("helloAgain/{name}")
    public String helloAgain(@PathVariable String name){
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "helloForm";

    }

    @RequestMapping(value = "createMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, @RequestParam String language, Model model){
        String message = name + "!";
        if(language.equals("English")){
            message = "Hello, " + message;
        }else if(language.equals("French")){
            message = "Bonjour, " + message;
        }
        else if(language.equals("Spanish")){
            message =  "Hola, " +  message;
        }

        else if(language.equals("Italian")){
            message = "Ciao, " + message;
        }
        else if(language.equals("Portuguese")){
            message = "Ola, " + message;
        }
        model.addAttribute("message",message);
        return "greeting";
        //return "<p style ='color:red;text-align:center;'>" +message+"</p>";
    }
    @RequestMapping(value = "greetForm", method = {RequestMethod.GET, RequestMethod.POST})
    public String greetForm(){

        return "form";
    }
}
