package org.eclipse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.DAO.SalleDaoImp;
import org.eclipse.beans.Salle;

/**
 * Servlet implementation class SalleServlet
 */
@WebServlet("/SalleServlet")
public class SalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalleDaoImp salleDAO;
	
	public void init() {
		salleDAO = new SalleDaoImp();
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
			case "/newSalle":
				showNewForm(request, response);
				break;
			case "/insertSalle":
				insertsalle(request, response);
				break;
			case "/deleteSalle":
				deletesalle(request, response);
				break;
			case "/editSalle":
				showEditForm(request, response);
				break;
			case "/updateSalle":
				updatesalle(request, response);
				break;
			case "/listSalle":
				listsalle(request, response);
				break;
			case "/SalleServlet":
				listsalle(request, response);
				break;
				/*default:
				listsalle(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listsalle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listsalle = salleDAO.getAll();
		request.setAttribute("listsalle", listsalle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salleList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertSalle.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int salleId = Integer.parseInt(request.getParameter("salleId"));
		Salle existingsalle = salleDAO.findById(salleId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formSalleEdit.jsp");
		request.setAttribute("salle", existingsalle);
		dispatcher.forward(request, response);

	}

	private void insertsalle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String salleType = request.getParameter("salleType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Salle newsalle = new Salle(salleType,capacite,nbPersonne,tarifId);
		salleDAO.save(newsalle);
		response.sendRedirect("listSalle");
	}

	private void updatesalle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String salleType = request.getParameter("salleType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Salle book = new Salle( salleType,capacite,nbPersonne,tarifId);
		salleDAO.update(book);
		response.sendRedirect("listSalle");
	}

	private void deletesalle(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("salleId"));
		salleDAO.remove(id);
		response.sendRedirect("listSalle");

	}

}
