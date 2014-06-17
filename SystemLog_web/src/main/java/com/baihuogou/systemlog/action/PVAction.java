package com.baihuogou.systemlog.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baihuogou.systemlog.service.PVService;

public class PVAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   
		String SearchTime=req.getParameter("search_time");
		   Calendar cal= Calendar.getInstance();
		   //06/18/2014
		   DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date daystart = df.parse(SearchTime);
			cal.setTime(daystart);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		  PrintWriter out = resp.getWriter();
		   try {
			out.println(PVService.pVStr(cal));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		   out.flush();   // 必须有这行，不然页面不会显示
		}
	}
	
	public static void main(String[] args){
		
	}
	
}
