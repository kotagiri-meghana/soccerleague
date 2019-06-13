package comm.example.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import comm.example.model.League;




public class LeagueListener implements ServletContextListener {
	
	String str=null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext context=sce.getServletContext();
		List<League> l=new ArrayList<League>();
		str=(String)context.getInitParameter("leagues-list");
		System.out.println(str);
		String[] arr=str.split(",");
		League newLeague=new League(Integer.parseInt(arr[0]),arr[1],arr[2]);
		l.add(newLeague);
		context.setAttribute("leaguelist", l);
	}


	
	
	
	public void contextDestroyed(ServletContextEvent sce) {
		str=null;
		System.out.println("context destroyed");
	}
}
