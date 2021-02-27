/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquiz.POJO.PerformancePOJO;
import techquiz.POJO.StudentScore;
import techquiz.dbutil.DBConnection;


public class PerformanceDAO 
{
    public static ArrayList<String> getAllExamId(String studentId)throws SQLException
    {
       String qry="select examid from performance where userid=?";
       ArrayList<String> examIdList=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1, studentId);
       ResultSet rs=ps.executeQuery();
       while(rs.next())
           {
               String id=rs.getString(1);
               examIdList.add(id);
           }
               
       return examIdList;                      
   }

    public static void addPerformance(PerformancePOJO performance)  throws SQLException
    {
        String query = "Insert into performance values(?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement(query);
        pst.setInt(3, performance.getRight());
        pst.setInt(4, performance.getWrong());
        pst.setInt(5, performance.getUnattempted());
        pst.setDouble(6, performance.getPer());
        pst.setString(1, performance.getUserId());
        pst.setString(2, performance.getExamId());
        pst.setString(7, performance.getLanguage());
        pst.executeUpdate();
    }
    
    public static ArrayList<PerformancePOJO> getAllData() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String query="Select * from Performance";
        ArrayList<PerformancePOJO> performanceList=new ArrayList<>();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
               String userId=rs.getString("userid");
               String examId=rs.getString("examid");
               String language=rs.getString("language");
               int right=rs.getInt("right");
               int wrong=rs.getInt("wrong");
               int unattempted=rs.getInt("unattempted");
               double per=rs.getDouble("per");
               PerformancePOJO p = new PerformancePOJO(examId,language,userId,right,wrong,unattempted,per);
               performanceList.add(p);
        }
        return performanceList;
    }
    
    public static ArrayList<String> getAllStudentId()throws SQLException
    {
        String query = "select distinct userid from performance";
        ArrayList <String> studentIdList = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next())
        {
            String id = rs.getString(1);
            studentIdList.add(id);
        }
        return studentIdList;
    }
    
    public static StudentScore getScore(String studentId, String ExamId) throws SQLException
    {
        String query = "Select language, per from Performance where userid=? and examid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(query);        
        ps.setString(1,studentId);
        ps.setString(2,ExamId);
        ResultSet rs=ps.executeQuery();
        rs.next(); 
        StudentScore score = new StudentScore();  
        score.setLanguage(rs.getString("language"));
        score.setPer(rs.getInt("per"));
        return score; 
    }
}
