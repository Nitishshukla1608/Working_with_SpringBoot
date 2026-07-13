package com.taskflow.filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

 @Component
 @Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String requestId =  UUID.randomUUID().toString();

        System.out.println("Incoming request: "
                + httpRequest.getRequestURI() +
                " "+ httpRequest.getMethod());

  httpResponse.setHeader("X-Request-ID", requestId);

      try{
          filterChain.doFilter(servletRequest, servletResponse);
      }finally {
          long duration = System.currentTimeMillis() - startTime;

          System.out.println("Response status: " + httpResponse.getStatus());
          System.out.println("Response time: " + duration);
      }


    }
}
