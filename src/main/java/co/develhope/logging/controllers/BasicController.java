package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @Autowired
    BasicService basicService;
    @Autowired
    private Environment environment;
    Logger logger= LoggerFactory.getLogger(BasicController.class);
    @GetMapping("/")
    public String getWelcome(){
        logger.info("Welcome");
        return "Welcome";
    }
    @GetMapping("/exp")
    public  Integer[] exp(){
        int n1=Integer.parseInt(environment.getProperty("customEnvs.n1"));
        int n2=Integer.parseInt(environment.getProperty("customEnvs.n2"));
        logger.info("This is the EXP starting");
        Integer[] n1pow_n2pow_array= basicService.n1_n2_power(n1,n2);
        logger.info("This is the EXP finishing");
        return n1pow_n2pow_array;
    }

    @GetMapping("/get-errors")
    public void error(){
        Error error= new Error("This is the error");
        logger.error("This is the error logging",error);

    }
}