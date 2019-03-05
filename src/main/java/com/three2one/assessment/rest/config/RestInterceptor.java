package com.three2one.assessment.rest.config;

import com.three2one.assessment.model.RequestLog;
import com.three2one.assessment.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;


@Component
public class RestInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    RequestLogService requestLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if (RequestMethod.POST.name().equalsIgnoreCase(request.getMethod())) {
            // try to get request body
        }
        RequestLog requestLog = new RequestLog(request.getRequestURI(), request.getMethod(), null, LocalDateTime.now());
        requestLogService.save(requestLog);
        return true;
    }


}

