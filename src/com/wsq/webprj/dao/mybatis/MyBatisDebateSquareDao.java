package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.vo.DebateSquare;

public class MyBatisDebateSquareDao implements DebateSquareDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<DebateSquare> getDebateSquares() throws SQLException {
		return getDebateSquares(1, "master_id", "");
	}

	@Override
	public List<DebateSquare> getDebateSquares(int page) throws SQLException {
		
		return getDebateSquares(page, "master_id", "");
	}

	@Override
	public List<DebateSquare> getDebateSquares(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		List<DebateSquare>list = dao.getDebateSquares(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(DebateSquare ds) throws SQLException {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		int count = dao.update(ds);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}
	
	@Override
	public int insert(DebateSquare ds) throws SQLException  {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		int count = dao.insert(ds);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public DebateSquare getDebate(String code) {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class); // mapper按眉 积己
		DebateSquare notice = dao.getDebate(code);

		//sqlSession.close(); // 技记 辆丰.

		return notice;
	}

	@Override
	public DebateSquare getDebateFirst() {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class); // mapper按眉 积己
		DebateSquare notice = dao.getDebateFirst();

		//sqlSession.close(); // 技记 辆丰.

		return notice;
	}

}
