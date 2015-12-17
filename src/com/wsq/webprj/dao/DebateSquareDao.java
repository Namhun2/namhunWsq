package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.DebateSquare;

public interface DebateSquareDao {
	
	public DebateSquare getDebate(String code);
	public DebateSquare getDebateFirst();
	
	public List<DebateSquare> getDebateSquares() throws SQLException;
	public List<DebateSquare> getDebateSquares(int page) throws SQLException;
	public List<DebateSquare> getDebateSquares(int page, String filed, String query) throws SQLException;
	
	public int update(DebateSquare ds) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(DebateSquare ds) throws SQLException;
	
		
	
	
}
