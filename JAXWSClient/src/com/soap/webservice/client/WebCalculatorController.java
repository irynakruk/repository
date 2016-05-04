package com.soap.webservice.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soap.webservice.WebCalculator;
import com.soap.webservice.WebCalculatorImplService;

/**
 * Servlet implementation class WebCalculatorController
 */
@WebServlet("/WebCalculatorController")
public class WebCalculatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WebCalculatorImplService webCalculatorService = new WebCalculatorImplService();
	private WebCalculator webCalculator = webCalculatorService.getWebCalculatorImplPort();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double arg0 = Double.valueOf(request.getParameter("arg0"));
		Double arg1 = Double.valueOf(request.getParameter("arg1"));
		request.setAttribute("addition", webCalculator.add(arg0, arg1));
		request.setAttribute("subtraction", webCalculator.subtract(arg0, arg1));
		request.setAttribute("multiplication", webCalculator.multiply(arg0, arg1));
		request.setAttribute("division", webCalculator.divide(arg0, arg1));
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}	
}
