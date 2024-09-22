package com.systex.controller.lottery;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import com.systex.service.LotteryService;

/**
 * Servlet implementation class LotteryController
 */
public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		HttpSession session = request.getSession();
		if(!session.isNew()) {
			dispatcher.forward(request, response);
			return;
		}
		Integer set =Integer.parseInt(request.getParameter("set"));
		String excludeNumbersString = (String)request.getParameter("excludeNumbers");
		LinkedList<Integer> excludeList=null;
		if(excludeNumbersString!=null) {
			String[] excludeNumbers = excludeNumbersString.trim().split(" ");
			excludeList = new LinkedList<>();
			for(String str :excludeNumbers) {
				if(!str.matches("\\d+")) {
					continue;
				}
				Integer number = Integer.parseInt(str);
				if(number>0 && number<50) {
					excludeList.add(number);
				}
			}
		}
		LotteryService lotteryService = new LotteryService();
		ArrayList<Integer>[]resultList = lotteryService.getNumbers(set, excludeList);
		session.setAttribute("resultList", resultList);
		dispatcher.forward(request, response);
	}

}
