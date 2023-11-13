package com.ddstudio.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddstudio.member.model.BookUserDTO;
import com.ddstudio.member.repository.BookUserDAO;

@WebServlet("/member/history/reservation.do")
public class AttractionReservationHistory extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// AttractionReservationHistory.java

		// 1.
		String email = req.getSession().getAttribute("email").toString();

		// 2.
		BookUserDAO dao = new BookUserDAO();

		ArrayList<BookUserDTO> list = dao.get(email);
		
		ArrayList<BookUserDTO> plist = dao.pget(email);

		// 3.
		req.setAttribute("list", list);
		
		req.setAttribute("plist", plist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/history/reservation.jsp");
		dispatcher.forward(req, resp);
	}
}