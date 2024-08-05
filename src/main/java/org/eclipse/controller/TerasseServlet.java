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

import org.eclipse.DAO.TerasseDaoImp;
import org.eclipse.beans.Terasse;

/**
 * Servlet implementation class TerasseServlet
 */
@WebServlet("/TerasseServlet")
public class TerasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TerasseDaoImp terasseDAO;
	
	public void init() {
		terasseDAO = new TerasseDaoImp();
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
			case "/newTerasse":
				showNewForm(request, response);
				break;
			case "/insertTerasse":
				insertterasse(request, response);
				break;
			case "/deleteTerasse":
				deleteterasse(request, response);
				break;
			case "/editTerasse":
				showEditForm(request, response);
				break;
			case "/updateTerasse":
				updateterasse(request, response);
				break;
				case "/TerasseServlet":
				listterasse(request, response);
				break;
			case "/listTerasse":
				listterasse(request, response);
				break;
				/*default:
				listterasse(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listterasse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listterasse = terasseDAO.getAll();
		request.setAttribute("listterasse", listterasse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/terasseList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertTerasse.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int terasseId = Integer.parseInt(request.getParameter("terasseId"));
		Terasse existingterasse = terasseDAO.findById(terasseId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formTerasseEdit.jsp");
		request.setAttribute("terasse", existingterasse);
		dispatcher.forward(request, response);

	}

	private void insertterasse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String terasseType = request.getParameter("terasseType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Terasse newterasse = new Terasse(terasseType,capacite,nbPersonne,tarifId);
		terasseDAO.save(newterasse);
		response.sendRedirect("listTerasse");
	}

	private void updateterasse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String terasseType = request.getParameter("terasseType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Terasse book = new Terasse( terasseType,capacite,nbPersonne,tarifId);
		terasseDAO.update(book);
		response.sendRedirect("listTerasse");
	}

	private void deleteterasse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int terasseId = Integer.parseInt(request.getParameter("terasseId"));
		terasseDAO.remove(terasseId);
		response.sendRedirect("listTerasse");

	}

}
