package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLeagueView
 */
@WebServlet(
		urlPatterns = { "/add_league.view" }, 
		initParams = { 
				@WebInitParam(name = "season-list", value = "select,Summer,Winter,Autumn")
		})
public class AddLeagueView extends HttpServlet {
	
	
       
    private String seasonList;
	private String[] seasonArr;

	/**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		seasonList=config.getInitParameter("season-list");
		seasonArr=seasonList.split(",");
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		List<String> l=(List<String>)request.getAttribute("ERROR");
		if(l!=null) {
			out.println("<font color='red'>please correct the error</font>");
			for(String s:l)
			{
				out.println("<font color='red'>"+s+"</font><br/>");
			}
		}
		out.println("<html><body>");
		out.println("<form action='add_league.do' method='post'>");
		out.println("Year<input type='text' name='year'></br>");
		out.println("Season<select name='season'>");
		for(String s:seasonArr) {
			out.println("<option value='"+s+"'>"+s+"</option>");
		}
		
		out.println("</select><br/>");
		out.println("Title<input type='text' name='title'>");
		out.println("<input type='submit' name='add League'");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
