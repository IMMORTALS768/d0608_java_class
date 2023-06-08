package test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public static String SelectByInput(String key){
        String sql = "select * from replyselect where input = ?";
        String reply = "";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                reply = rs.getString("reply");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reply;
    }
}
