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

import org.eclipse.DAO.TableDaoImp;
import org.eclipse.beans.Table;

/**
 * Servlet implementation class TableServlet
 */
@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TableDaoImp tableDAO;
	
	public void init() {
		tableDAO = new TableDaoImp();
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
			case "/newTable":
				showNewForm(request, response);
				break;
			case "/insertTable":
				inserttable(request, response);
				break;
			case "/deleteTable":
				deletetable(request, response);
				break;
			case "/editTable":
				showEditForm(request, response);
				break;
			case "/updateTable":
				updatetable(request, response);
				break;
				case "/TableServlet":
				listtable(request, response);
				break;
			case "/listTable":
				listtable(request, response);
				break;
				/*default:
				listtable(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listtable(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listtable = tableDAO.getAll();
		request.setAttribute("listtable", listtable);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tableList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertTable.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		Table existingtable = tableDAO.findById(tableId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formTableEdit.jsp");
		request.setAttribute("table", existingtable);
		dispatcher.forward(request, response);

	}

	private void inserttable(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String tableType = request.getParameter("tableType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Table newtable = new Table(tableType,capacite,nbPersonne,tarifId);
		tableDAO.save(newtable);
		response.sendRedirect("listTable");
	}

	private void updatetable(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		String tableType = request.getParameter("tableType");
		int capacite = Integer.parseInt(request.getParameter("capacite"));
		int nbPersonne = Integer.parseInt(request.getParameter("nbPersonne"));
		int tarifId = Integer.parseInt(request.getParameter("tarifId"));
		Table book = new Table( tableType,capacite,nbPersonne,tarifId);
		tableDAO.update(book);
		response.sendRedirect("listtable");
	}

	private void deletetable(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		tableDAO.remove(tableId);
		response.sendRedirect("listTable");

	}
}
