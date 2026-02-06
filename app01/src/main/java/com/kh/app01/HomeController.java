package com.kh.app01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String m01(){
        return "redirect:/zzz";
   }//method

}//class
