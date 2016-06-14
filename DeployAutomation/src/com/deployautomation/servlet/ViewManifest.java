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
 * Servlet implementation class ViewManifest
 */
public class ViewManifest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewManifest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String deploymentId=request.getParameter("id");
		
		Deployment_Manifest_Header header=new Deployment_Manifest_Header();
		Deployment_Manifest_Items items=new Deployment_Manifest_Items();

		Deployment_Manifest_ItemsDAOImpl itemsDAOImpl=null;
		Deployment_Manifest_HeaderDAOImpl daoImpl = null;
		ProjectDAOImpl impl=null;
		List<Project> list=new ArrayList<Project>();
		
		List<Deployment_Manifest_Items> items2=new ArrayList<Deployment_Manifest_Items>();
		
		
		header.setDeployment_Id(Integer.parseInt(deploymentId));
		try
		{
		daoImpl = new Deployment_Manifest_HeaderDAOImpl();
		itemsDAOImpl=new Deployment_Manifest_ItemsDAOImpl();
		impl=new ProjectDAOImpl();
		
		
	
		list=impl.projectNames();
		header=daoImpl.viewHeaderbyDeploymentId(header.getDeployment_Id());
		
	
		
		
		
		
		items2=itemsDAOImpl.viewItems(header.getDeployment_Id());
		
		header.setItems(items2);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		request.getSession().setAttribute("deploymentHeader",header);
		request.getSession().setAttribute("itemsArray", items2);
		request.getSession().setAttribute("ProjectName",list);
	
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
