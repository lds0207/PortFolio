package com.PortFoli.dong.springboot.web;

import com.PortFoli.dong.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   @GetMapping("/hello")
    public String hello(){
       return "hello";
   }
}
