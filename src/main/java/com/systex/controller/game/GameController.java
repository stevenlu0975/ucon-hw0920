package com.systex.controller.game;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

import com.systex.service.GuessGame;

/**
 * Servlet implementation class GameController
 */
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("GuessGame", new GuessGame(10, 3));
		RequestDispatcher dispatcher = request.getRequestDispatcher("guess.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		GuessGame guessgame = (GuessGame)session.getAttribute("GuessGame");
		if(guessgame==null) {
			doGet(request,response);
			return;
		}
		LinkedList<String> list = new LinkedList<>();
		RequestDispatcher dispatcher=null; 
		String numberString = request.getParameter("number");
		if(numberString==null ||numberString.isEmpty()) {
			list.add("請填入1~10的數字");
			request.setAttribute("errors", list);
			dispatcher=request.getRequestDispatcher("guess.jsp");
			dispatcher.forward(request, response);
			return;
		}
		Integer number =Integer.parseInt(numberString);
		boolean result = guessgame.Guess(number);
		if(guessgame.getRemains()<=0) {
			request.setAttribute("answer", guessgame.getLuckyNumber());
			dispatcher=request.getRequestDispatcher("youLose.jsp");
		}else if(result==true) {
			request.setAttribute("answer", guessgame.getLuckyNumber());
			dispatcher=request.getRequestDispatcher("youWin.jsp");
		}else {
			dispatcher=request.getRequestDispatcher("guess.jsp");
		}
		dispatcher.forward(request, response);
		
	}

}
