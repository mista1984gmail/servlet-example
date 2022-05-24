package com.godeltech.mastery.servlet.filter;

import com.godeltech.mastery.servlet.util.GenerateUUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/check")
public class ResponseHeaderFilter implements Filter {

    GenerateUUID generateUUID = new GenerateUUID();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Mastery-Example-Filter-Header", generateUUID.generateRandomUUID());
        chain.doFilter(request, response);
    }

}
