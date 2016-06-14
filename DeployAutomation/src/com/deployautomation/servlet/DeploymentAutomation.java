package com.deployautomation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deployautomation.dao.impl.Deployment_Manifest_HeaderDAOImpl;
import com.deployautomation.dao.impl.Deployment_Manifest_ItemsDAOImpl;
import com.deployautomation.dao.impl.ProjectDAOImpl;
import com.deployautomation.model.Deployment_Manifest_Header;
import com.deployautomation.model.Deployment_Manifest_Items;
import com.deployautomation.model.Project;



/**
 * Servlet implementation class DeploymentAutomation
 */
public class DeploymentAutomation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeploymentAutomation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	Deployment_Manifest_Header header=new Deployment_Manifest_Header();
		
		Deployment_Manifest_ItemsDAOImpl itemsDAOImpl=null;
		Deployment_Manifest_HeaderDAOImpl daoImpl = null;
		ProjectDAOImpl impl=null;
		
		List<Deployment_Manifest_Items> items=new ArrayList<Deployment_Manifest_Items>();
		List<Project> list=new ArrayList<Project>();
					
	//	System.out.println(header.getRelease_Id());
		header.setDeployment_Name(request.getParameter("name"));
		header.setTag(request.getParameter("tag"));
		header.setArchive_Flag(0);

		String id=request.getParameter("id");
		if(id!="")
		{
		header.setDeployment_Id(Integer.parseInt(id));
		}
		
		
		try {
			daoImpl = new Deployment_Manifest_HeaderDAOImpl();
			itemsDAOImpl=new Deployment_Manifest_ItemsDAOImpl();
			impl=new ProjectDAOImpl();
			
			items=itemsDAOImpl.viewItems(header.getDeployment_Id());
			list=impl.projectNames();
			
			if(header.getDeployment_Id()==0)
			{
			daoImpl.insertHeader(header);
			}
			else
			{
				daoImpl.updateHeader(header);
			}
			
			System.out.println(header.getDeployment_Id());
			
			request.getSession().setAttribute("deploymentHeader",header);
			request.getSession().setAttribute("itemsArray", items);
			request.getSession().setAttribute("ProjectName",list);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
			System.out.println("sucess");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
