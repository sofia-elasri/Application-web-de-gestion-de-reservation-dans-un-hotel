package org.eclipse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.DAO.ClientDaoImp;
import org.eclipse.beans.Client;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDaoImp clientDAO;
	
	public void init() {
		clientDAO = new ClientDaoImp();
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
				insertclient(request, response);
				break;
			case "/delete":
				deleteclient(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateclient(request, response);
				break;
			case "/list":
				listclient(request, response);
				break;
			case "/ClientServlet":
				listclient(request, response);
				break;
				/*default:
				listclient(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listclient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Client> listclient = clientDAO.getAll();
		request.setAttribute("listclient", listclient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clientList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formInsert.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client existingclient = clientDAO.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formEdit.jsp");
		request.setAttribute("client", existingclient);
		dispatcher.forward(request, response);

	}

	private void insertclient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		Client newclient = new Client(nom,prenom, email, passwd);
		clientDAO.save(newclient);
		response.sendRedirect("list");
	}

	private void updateclient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		Client book = new Client( nom,prenom, email, passwd);
		clientDAO.update(book);
		response.sendRedirect("list");
	}

	private void deleteclient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clientDAO.remove(id);
		response.sendRedirect("list");

	}

}
