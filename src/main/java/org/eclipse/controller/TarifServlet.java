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

import org.eclipse.DAO.TarifDaoImp;
import org.eclipse.beans.Tarif;

/**
 * Servlet implementation class TarifServlet
 */
@WebServlet("/TarifServlet")
public class TarifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarifDaoImp tarifDAO;
	
	public void init() {
		tarifDAO = new TarifDaoImp();
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
			case "/editTarif":
				showEditForm(request, response);
				break;
			case "/updateTarif":
				updatetarif(request, response);
				break;
			case "/listTarif":
				listtarif(request, response);
				break;
			case "/TarifServlet":
				listtarif(request, response);
				break;
				/*default:
				listtarif(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	private void listtarif(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tarif> listtarif = tarifDAO.getAll();
		request.setAttribute("listtarif", listtarif);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tarifList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Tarif existingtarif = tarifDAO.findById(tarifId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formTarifEdit.jsp");
		request.setAttribute("tarif", existingtarif);
		dispatcher.forward(request, response);

	}
	
	private void updatetarif(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		float prix = Float.parseFloat(request.getParameter("prix"));
		float nvPrix = Float.parseFloat(request.getParameter("nvPrix"));
		Tarif book = new Tarif(prix,nvPrix);
		tarifDAO.update(book);
		response.sendRedirect("listTarif");
	}

}
