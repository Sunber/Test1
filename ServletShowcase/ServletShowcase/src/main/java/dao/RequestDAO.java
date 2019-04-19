package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.requests;
import com.revature.servlets.JdbcConnection;


public class RequestDAO {
	
	public long submitReq(requests request){
		
		try(Connection conn = JdbcConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO PROJECT_1.REQUESTS(requestId, workerId, request) VALUES(?,?,?)");
			
			stmt.setInt(1,request.getRequestId());
			stmt.setInt(2, request.getWorkerId());
			stmt.setString(3, request.getReq());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
