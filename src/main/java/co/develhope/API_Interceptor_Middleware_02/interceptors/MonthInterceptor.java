package co.develhope.API_Interceptor_Middleware_02.interceptors;

import co.develhope.API_Interceptor_Middleware_02.entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    List<Month> monthList=new ArrayList<>(Arrays.asList(
            new Month(1,"January","Gennaio","Januar"),
            new Month(2,"February","Febbraio","Februar"),
            new Month(3,"March","Marzo","Marsch"),
            new Month(4,"April","Aprile","April"),
            new Month(5,"May","Maggio","Durfen"),
            new Month(6,"June","Giugno","Juni")));
    ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberRequestString=request.getHeader("monthNumber");
        if(monthNumberRequestString==null){response.setStatus(400);return true;}
        long monthNumberRequest=Long.parseLong(monthNumberRequestString);
        Optional<Month> monthOptional=monthList.stream().filter(month -> month.getMonthNumber()==monthNumberRequest).findFirst();
        if(monthOptional.isPresent())
        {request.setAttribute("month",monthOptional.get());}
        else{request.setAttribute("month",new Month(null,"nope","nope","nope"));}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
