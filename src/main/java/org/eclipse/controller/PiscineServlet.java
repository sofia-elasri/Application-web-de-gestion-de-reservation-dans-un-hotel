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

import org.eclipse.DAO.PiscineDaoImp;
import org.eclipse.beans.Piscine;

/**
 * Servlet implementation class PiscineServlet
 */
@WebServlet("/PiscineServlet")
public class PiscineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PiscineDaoImp piscineDAO;
	
	public void init() {
		piscineDAO = new PiscineDaoImp();
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
			case "/newPiscine":
				showNewForm(request, response);
				break;
			case "/insertPiscine":
				insertpiscine(request, response);
				break;
			case "/deletePiscine":
				deletepiscine(request, response);
				break;
			case "/editPiscine":
				showEditForm(request, response);
				break;
			case "/updatePiscine":
				updatepiscine(request, response);
				break;
			case "/PiscineServlet":
				listpiscine(request, response);
				break;
			case "/listPiscine":
				listpiscine(request, response);
				break;
				/*default:
				listpiscine(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listpiscine(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listpiscine = piscineDAO.getAll();
		request.setAttribute("listpiscine", listpiscine);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/piscineList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertPiscine.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int piscineId = Integer.parseInt(request.getParameter("piscineId"));
		Piscine existingpiscine = piscineDAO.findById(piscineId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formPiscineEdit.jsp");
		request.setAttribute("piscine", existingpiscine);
		dispatcher.forward(request, response);

	}

	private void insertpiscine(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String piscineType = request.getParameter("piscineType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Piscine newpiscine = new Piscine(piscineType,capacite,nbPersonne,tarifId);
		piscineDAO.save(newpiscine);
		response.sendRedirect("listPiscine");
	}

	private void updatepiscine(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String piscineType = request.getParameter("piscineType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Piscine book = new Piscine( piscineType,capacite,nbPersonne,tarifId);
		piscineDAO.update(book);
		response.sendRedirect("listPiscine");
	}

	private void deletepiscine(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int piscineId = Integer.parseInt(request.getParameter("piscineId"));
		piscineDAO.remove(piscineId);
		response.sendRedirect("listPiscine");

	}

}
