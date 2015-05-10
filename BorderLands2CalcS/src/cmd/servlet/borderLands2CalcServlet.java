package cmd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.addressing.EndpointReference;

import cmd.borderLands2Calc.Calculator;
import net.dolusnomenhic.*;
import net.dolusnomenhic.BorderLands2CalcServiceStub.TrueDpsRequest;
import net.dolusnomenhic.BorderLands2CalcServiceStub.TrueDpsResponse;

/**
 * Servlet implementation class borderLands2CalcServlet
 */
//@WebServlet("/borderLands2CalcServlet")
public class borderLands2CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public borderLands2CalcServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Init BorderLands 2 Calculator Servlet.");
		
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("BorderLands2Calc doGet called.");
		
		String input = request.getParameter("inputValues");
		
		System.out.println("Input values = " + input);
		
		String[] strings = input.split(" ");
		
		float damage = Float.parseFloat(strings[0]);
		float fireRate = Float.parseFloat(strings[1]);
		float reloadTime = Float.parseFloat(strings[2]);
		float clipSize = Float.parseFloat(strings[3]);
		float ammoPerShot = Float.parseFloat(strings[4]);
		
		
		
		BorderLands2CalcServiceStub stub = new BorderLands2CalcServiceStub("http://localhost:8080/axis2/services/BorderLands2CalcService");
		TrueDpsRequest trueDpsRequest = new TrueDpsRequest();
		trueDpsRequest.setDamage(damage);
		trueDpsRequest.setFireRate(fireRate);
		trueDpsRequest.setReloadTime(reloadTime);
		trueDpsRequest.setClipSize(clipSize);
		trueDpsRequest.setAmmoPerShot(ammoPerShot);
		
		TrueDpsResponse trueDpsResponse = stub.calcTrueDps(trueDpsRequest);
		
		float trueDps = trueDpsResponse.getTrueDps();
		
		
	    response.setContentType("text/html");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<head>");
	    out.println("<title>BorderLands 2 Calculator</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Result:</h1>");
	    out.println("True DPS = " + trueDps + "<br/><br/>");
	    out.println("<a href='./index.html'>Go back</a>");
	    out.println("</body>");
	    out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("BorderLands2Calc doPost called.");
		
		doGet(request, response);
		
	}

}
