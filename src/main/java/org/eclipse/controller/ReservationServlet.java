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

import org.eclipse.DAO.ReservationDaoImp;
import org.eclipse.beans.Reservation;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDaoImp reservationDAO;
	
	public void init() {
		reservationDAO = new ReservationDaoImp();
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
			case "/newReservation":
				showNewForm(request, response);
				break;
			case "/insertReservation":
				insertreservation(request, response);
				break;
			case "/deleteReservation":
				deletereservation(request, response);
				break;
			case "/editReservation":
				showEditForm(request, response);
				break;
			case "/updateReservation":
				updatereservation(request, response);
				break;
			case "/":
				listreservation(request, response);
				break;
			case "/listReservation":
				listreservation(request, response);
				break;
			/*default:
				listreservation(request, response);
				break;*/
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listreservation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Map<String,Object>> listreservation = reservationDAO.getAll();
		request.setAttribute("listreservation", listreservation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/reservationList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertReservation.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int resId = Integer.parseInt(request.getParameter("resId"));
		Reservation existingreservation = reservationDAO.findById(resId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formReservationEdit.jsp");
		request.setAttribute("reservation", existingreservation);
		dispatcher.forward(request, response);

	}

	private void insertreservation(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int chambreId = Integer.parseInt(request.getParameter("chambreId"));
		int salleId = Integer.parseInt(request.getParameter("salleId"));
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		int terasseId = Integer.parseInt(request.getParameter("terasseId"));
		int piscineId = Integer.parseInt(request.getParameter("piscineId"));
		int clubId = Integer.parseInt(request.getParameter("clubId"));
		Reservation newreservation = new Reservation(bookId,chambreId,salleId,tableId,terasseId,piscineId,clubId);
		reservationDAO.save(newreservation);
		response.sendRedirect("listReservation");
	}

	private void updatereservation(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int chambreId = Integer.parseInt(request.getParameter("chambreId"));
		int salleId = Integer.parseInt(request.getParameter("salleId"));
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		int terasseId = Integer.parseInt(request.getParameter("terasseId"));
		int piscineId = Integer.parseInt(request.getParameter("piscineId"));
		int clubId = Integer.parseInt(request.getParameter("clubId"));
		Reservation book = new Reservation( bookId,chambreId,salleId,tableId,terasseId,piscineId,clubId);
		reservationDAO.update(book);
		response.sendRedirect("listReservation");
	}

	private void deletereservation(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int resId = Integer.parseInt(request.getParameter("resId"));
		reservationDAO.remove(resId);
		response.sendRedirect("listReservation");

	}

}
