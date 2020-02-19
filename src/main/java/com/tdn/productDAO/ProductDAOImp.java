package com.tdn.productDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tdn.dbutility.DatabaseUtility;
import com.tdn.model.Product;

public class ProductDAOImp implements ProductI{
	DatabaseUtility  dbutility=null;
	Connection con=null;


	public List<Product> getallproduct() {
		
		dbutility = new DatabaseUtility();
		con=dbutility.getconnection();
		ArrayList<Product> productlist=null;
		if (con!=null) {
			try {
			productlist = new  ArrayList<Product>();
			PreparedStatement ps = con.prepareStatement("select * from producttbl");
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				Product products = new Product(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
				
				productlist.add(products);
				//System.out.println(customerlist);
							}
			
		
			 	con.close();
		} catch (SQLException e) {
			// TODO: handle exception
				}
		
			}
			return productlist;
		
		
	
		}

	}
