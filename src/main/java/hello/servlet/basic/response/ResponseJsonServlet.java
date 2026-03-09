package hello.servlet.basic.response;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Content-type: application/json
//        response.setContentType("application/json");
        response.setHeader("content-type","application/json");
        response.setCharacterEncoding("UTF-8");

        HelloData data = new HelloData();
        data.setUsername("테스트");
        data.setAge(35);

        String result = mapper.writeValueAsString(data);
        response.getWriter().write(result);

    }
}
