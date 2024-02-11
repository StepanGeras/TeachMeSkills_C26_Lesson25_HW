package server.webservlet;

import server.model.Operation;
import server.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/calc")
public class Servlet extends HttpServlet {

    OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getQueryString();
        String[] parameters = query.split("&");
        Map<String, String> mapParameters = new HashMap<>();

        for (String s : parameters) {
            String parameter = s.substring(5, s.length());
            String key = s.substring(0, 4);
            mapParameters.put(key, parameter);
        }

        Operation operation = new Operation(Double.parseDouble(mapParameters.get("num1")), Double.parseDouble(mapParameters.get("num2")), mapParameters.get("type"));
        Operation calculate = operationService.calculate(operation);

        String result = "Result = " + calculate.getResult();
        resp.getWriter().print(result);
    }
}
