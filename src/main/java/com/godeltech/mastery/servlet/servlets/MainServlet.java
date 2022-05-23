package com.godeltech.mastery.servlet.servlets;

import com.godeltech.mastery.servlet.util.MessageJson;
import com.godeltech.mastery.servlet.util.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/check")
public class MainServlet extends HttpServlet {

    WebUtils webUtils = new WebUtils();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map map = webUtils.getHeadersInfo(req);
        PrintWriter printWriter = resp.getWriter();

        if(map.containsValue("application/text")){
            resp.setContentType("application/text");
            printWriter.write("Success text message!!!");
            printWriter.close();
        }
        else if(map.containsValue("application/json")){
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            MessageJson messageJson = new MessageJson(1L, "Success JSON message!!!");
            String messageJsonString = this.gson.toJson(messageJson);
            printWriter.print(messageJsonString);
            printWriter.flush();
        }
        }
    }



