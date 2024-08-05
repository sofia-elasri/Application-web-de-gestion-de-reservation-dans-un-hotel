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

import org.eclipse.DAO.ChambreDaoImp;
import org.eclipse.beans.Chambre;

/**
 * Servlet implementation class ChambreServlet
 */
@WebServlet("/ChambreServlet")
public class ChambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChambreDaoImp chambreDAO;
	
	public void init() {
		chambreDAO = new ChambreDaoImp();
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
			case "/newChambre":
				showNewForm(request, response);
				break;
			case "/insertChambre":
				insertchambre(request, response);
				break;
			case "/deleteChambre":
				deletechambre(request, response);
				break;
			case "/editChambre":
				showEditForm(request, response);
				break;
			case "/updateChambre":
				updatechambre(request, response);
				break;
			case "/ChambreServlet":
				listChambre(request, response);
				break;
			case "/listChambre":
				listChambre(request, response);
				break;
			/*default:
				listChambre(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listChambre(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listchambre = chambreDAO.getAll();
		request.setAttribute("listchambre", listchambre);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/chambreList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertChambre.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int chambreId = Integer.parseInt(request.getParameter("chambreId"));
		Chambre existingchambre = chambreDAO.findById(chambreId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formChambreEdit.jsp");
		request.setAttribute("chambre", existingchambre);
		dispatcher.forward(request, response);

	}

	private void insertchambre(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String chambreType = request.getParameter("chambreType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Chambre newchambre = new Chambre(chambreType,capacite,nbPersonne,tarifId);
		chambreDAO.save(newchambre);
		response.sendRedirect("listChambre");
	}

	private void updatechambre(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String chambreType = request.getParameter("chambreType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Chambre book = new Chambre( chambreType,capacite,nbPersonne,tarifId);
		chambreDAO.update(book);
		response.sendRedirect("listChambre");
	}

	private void deletechambre(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int chambreId = Integer.parseInt(request.getParameter("chambreId"));
		chambreDAO.remove(chambreId);
		response.sendRedirect("listChambre");

	}
}
