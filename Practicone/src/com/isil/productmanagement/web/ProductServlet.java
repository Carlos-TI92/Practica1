package com.isil.productmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isil.productmanagement.model.Product;
import com.isil.productmanagement.service.ProductService;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Abel Huarca [Isil]
 */

@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
	public void init() {
		productService = new ProductService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertProduct(request, response);
				break;
			case "/delete":
				deleteProduct(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listUser = productService.selectAllProducts();
		request.setAttribute("listProduct", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product existingProduct = productService.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		request.setAttribute("product", existingProduct);
		dispatcher.forward(request, response);

	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nameproduct = request.getParameter("nameproduct");
		String nameprov = request.getParameter("nameprov");
		String producttype = request.getParameter("producttype");
		Product newUser = new Product(nameproduct,nameprov,producttype);
		productService.insertProduct(newUser);
		response.sendRedirect("list");
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nameproduct = request.getParameter("nameproduct");
		String nameprov = request.getParameter("nameprov");
		String producttype = request.getParameter("producttype");

		Product book = new Product(id, nameproduct,nameprov,producttype);
		productService.updateProduct(book);
		response.sendRedirect("list");
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(id);
		response.sendRedirect("list");

	}

}
