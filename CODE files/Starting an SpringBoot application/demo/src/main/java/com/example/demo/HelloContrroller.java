package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContrroller {

    @GetMapping("hello")
public String Hello()
{
return "<h1>Hello Wansorld!</h1>";
}

    @GetMapping("bye")
    public String greetBye()
    {
        return "<h1>Greeting Bye!</h1>";
    }



}
