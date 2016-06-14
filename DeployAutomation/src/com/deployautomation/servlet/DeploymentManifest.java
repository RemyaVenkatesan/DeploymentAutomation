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
import com.deployautomation.model.Deployment_Manifest_Header;
import com.deployautomation.model.Deployment_Manifest_Items;



/**
 * Servlet implementation class DeploymentManifest
 */
public class DeploymentManifest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeploymentManifest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
Deployment_Manifest_Header header=new Deployment_Manifest_Header();
		
		List<Deployment_Manifest_Items> items=new ArrayList<Deployment_Manifest_Items>();

		
		Deployment_Manifest_HeaderDAOImpl daoImpl=null;

		List<Deployment_Manifest_Header> headerArray=new ArrayList<Deployment_Manifest_Header>();
		
		try {
			daoImpl=new Deployment_Manifest_HeaderDAOImpl();
			
			
			headerArray=daoImpl.viewHeader();
			
		
			
			request.getSession().setAttribute("headerArray",headerArray);
			request.getSession().setAttribute("deploymentHeader",header);
			request.getSession().setAttribute("itemsArray", items);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			//System.out.println("test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
