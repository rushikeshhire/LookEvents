package com.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet1
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //Print writer is uded to display in frontend 
        String eventname=request.getParameter("EventName");  
        String eventon=request.getParameter("EventON");  
        String eventhcn=request.getParameter("EventHCN");  
        String emailorg=request.getParameter("EmailOrg");
		String eventcode=request.getParameter("Eventcode");
		String numberofseats=request.getParameter("NumberOfSeats");
		String eventcps=request.getParameter("EventCPS");
		String eventaddress=request.getParameter("EventAddress");
		String eventdate=request.getParameter("EventDate");
          
        AddEvent r=new AddEvent();  
        r.setEventName(eventname);;  
        r.setEventON(eventon);
        r.setEventHCN(eventhcn);
        r.setEmailOrg(emailorg);
		r.setEventcode(eventcode);
		r.setNumberOfSeats(numberofseats);
		r.setEventCPS(eventcps);
		r.setEventAddress(eventaddress);
		r.setEventDate(eventdate);
          
        int status=AddEventDao.save(r);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("adde.html").include(request, response);; 
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  

	}

