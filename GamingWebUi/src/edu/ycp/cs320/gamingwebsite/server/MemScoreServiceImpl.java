package edu.ycp.cs320.gamingwebsite.server;

import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.gamingwebsite.client.ScoreService;
import edu.ycp.cs320.gamingwebsite.shared.Login;

@SuppressWarnings("serial")
public class MemScoreServiceImpl extends RemoteServiceServlet implements
		ScoreService {

//	@Override
//	public Login setscore(double score) {
//		try {
//			return DBUtil.instance().setscore(score);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}
