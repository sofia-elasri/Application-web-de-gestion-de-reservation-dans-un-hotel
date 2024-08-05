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

import org.eclipse.DAO.ClubDaoImp;
import org.eclipse.beans.Club;

/**
 * Servlet implementation class ClubServlet
 */
@WebServlet("/ClubServlet")
public class ClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClubDaoImp clubDAO;
	
	public void init() {
		clubDAO = new ClubDaoImp();
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
			case "/newClub":
				showNewForm(request, response);
				break;
			case "/insertClub":
				insertclub(request, response);
				break;
			case "/deleteClub":
				deleteclub(request, response);
				break;
			case "/editClub":
				showEditForm(request, response);
				break;
			case "/updateClub":
				updateclub(request, response);
				break;
			case "/ClubServlet":
				listclub(request, response);
				break;
			case "/listClub":
				listclub(request, response);
				break;
				/*default:
				listclub(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listclub(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listclub = clubDAO.getAll();
		request.setAttribute("listclub", listclub);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clubList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertClub.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int clubId = Integer.parseInt(request.getParameter("clubId"));
		Club existingclub = clubDAO.findById(clubId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formClubEdit.jsp");
		request.setAttribute("club", existingclub);
		dispatcher.forward(request, response);

	}

	private void insertclub(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String clubType = request.getParameter("clubType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Club newclub = new Club(clubType,capacite,nbPersonne,tarifId);
		clubDAO.save(newclub);
		response.sendRedirect("listClub");
	}

	private void updateclub(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String clubType = request.getParameter("clubType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Club book = new Club( clubType,capacite,nbPersonne,tarifId);
		clubDAO.update(book);
		response.sendRedirect("listClub");
	}

	private void deleteclub(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int clubId = Integer.parseInt(request.getParameter("clubId"));
		clubDAO.remove(clubId);
		response.sendRedirect("listClub");

	}
}
