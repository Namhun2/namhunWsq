package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.CommentDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.mybatis.MyBatisDebateSquareDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.Comment;
import com.wsq.webprj.vo.DebateSquare;
import com.wsq.webprj.vo.Member;


//POJO Å¬·¡½º
@Controller
@RequestMapping("/wsqdebate/")
public class WsqDebateController {
	
	@Autowired
	private DebateSquareDao dao;
	
	@Autowired
	private CommentDao commentDao;
	
	
	@RequestMapping(value="debate", method=RequestMethod.GET)
	public String debate(String c, Model model)
	{		
		if(c==null){
			System.out.printf("\ncode:%s / ", c);
			
			DebateSquare debate = dao.getDebateFirst();
			
			System.out.printf("getCode : " + String.valueOf(debate.getCode()) +"\n" );
			
			List<Comment> comments = commentDao.getComments(String.valueOf(debate.getCode()));
			
			model.addAttribute("debate", debate);
			model.addAttribute("comments", comments);
			
		}
		else{
			System.out.printf("\ncode:%s / ", c);
			
			DebateSquare debate = dao.getDebate(c);
			
			System.out.printf("getCode : " + String.valueOf(debate.getCode()) +"\n" );
			
			List<Comment> comments = commentDao.getComments(c);			
			
			model.addAttribute("debate", debate);			
			model.addAttribute("comments", comments);	
		}		
		
		return "wsqdebate/debate";		
	}
	
	@RequestMapping(value="debate", method=RequestMethod.POST)
	public String debate(String c, Comment comment, HttpServletRequest request, Model model, boolean opinion) throws SQLException
	{
		DebateSquare debate = dao.getDebate(c);		
		List<Comment> comments = commentDao.getComments(c);
		
		
		model.addAttribute("debate", debate);
		model.addAttribute("comments", comments);
		
		
		//´ñ±Û »ðÀÔ
		//String opinion = request.getParameter("opinion");
		comment.setOpinion(opinion);
		comment.setDebateCode(Integer.parseInt(c));
		commentDao.insert(comment);		
		
		return "redirect:debate?c="+c;		
	}
	
	@RequestMapping(value="debateDelete", method=RequestMethod.GET)
	public String debateDelete(String c, String code) throws SQLException{
		
		System.out.println("delete success : " + commentDao.delete(code) + "\n");		
		
		return "redirect:debate?c="+c;
	}
	
	
	@RequestMapping(value="comment", method=RequestMethod.GET)
	public String comment(String c, Model model){
		
		if(c==null){
			DebateSquare debate = dao.getDebateFirst();	
			
			List<Comment> comments = commentDao.getComments(String.valueOf(debate.getCode()));	
						
			model.addAttribute("comments", comments);
		}
		
		else{
			List<Comment> comments = commentDao.getComments(c);
			model.addAttribute("comments", comments);
		}
		
		return "wsqdebate/comment";
	}
	
	
	
	@RequestMapping("debateList")
	public String list(Model model) throws SQLException{
		List<DebateSquare> list = dao.getDebateSquares(1);
		model.addAttribute("list", list);
		
		return "wsqdebate/debateList";
	}
}
