package edu.ycp.cs320.gamingwebsite.client;

import java.sql.SQLException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.gamingwebsite.shared.Login;

@RemoteServiceRelativePath("login")
public interface ScoreService extends RemoteService{
	
	public Login setscore(final double score) throws SQLException;
}
