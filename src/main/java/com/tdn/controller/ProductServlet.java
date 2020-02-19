package com.tdn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdn.model.Product;
import com.tdn.productDAO.ProductDAOImp;
@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProductDAOImp productdao = new  ProductDAOImp();
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getServletPath();
	        try {
	            switch (action) {
	                case   "/listUser":
	                	listUser(request, response);

	                   //showNewForm(request, response);
	                    break;
	                case "/inseart":
	                   // insertcustomer(request, response);
	                    break;
	                case "/delete":
	                  //  deleteUser(request, response);
	                    break;
	                case "/edit":
	                  //  showEditForm(request, response);
	                  break;
	                case "/update":
	                   // updateUser(request, response);
	                    break;
	                default	:
	                  break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		  List < Product > products =productdao.getallproduct();
		  
	        request.setAttribute("listUser", products);
	       // System.out.println(customers);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("list-product.jsp");
	        dispatcher.forward(request, response);
	}

}
