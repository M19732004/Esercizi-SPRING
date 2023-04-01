package co.develhope.API_Interceptor_Middleware_02.controllers;

import co.develhope.API_Interceptor_Middleware_02.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Months")
public class MonthController {
    @GetMapping
    public Month get(HttpServletRequest request){
        Month month =(Month) request.getAttribute("month");
        return month;
    }

}
