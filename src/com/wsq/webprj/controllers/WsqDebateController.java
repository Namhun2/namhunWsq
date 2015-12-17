package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.mybatis.MyBatisDebateSquareDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.DebateSquare;
import com.wsq.webprj.vo.Member;


//POJO Å¬·¡½º
@Controller
@RequestMapping("/wsqdebate/")
public class WsqDebateController {
	
	@Autowired
	private DebateSquareDao dao;
	
	@RequestMapping("debate")
	public String debate(String c, Model model)
	{
		System.out.printf("\nc:%s", c);
		
		if(c==null){
			DebateSquare debate = dao.getDebateFirst();
			model.addAttribute("debate", debate);
		}
		else{
			DebateSquare debate = dao.getDebate(c);
			model.addAttribute("debate", debate);
		}		
		
		return "wsqdebate/debate";		
	}
	
	
	@RequestMapping("debateList")
	public String list(Model model) throws SQLException{
		List<DebateSquare> list = dao.getDebateSquares(1);
		model.addAttribute("list", list);
		
		return "wsqdebate/debateList";
	}
}
