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
import techquiz.dbutil.DBConnection;
import techquiz.POJO.ExamPOJO;

public class ExamDAO 
{
    public static String getExamId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        String result=null;
        ResultSet rs = st.executeQuery("Select count(*) from Exam");
        if(rs.next())
        {
            String s = String.valueOf((rs.getInt(1))+1); System.out.println(s);
            result="EX-"+s;
        }
        return result;
  }
    
    public static boolean addExam(ExamPOJO newExam) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("insert into exam values(?,?,?)");
        pst.setString(1,newExam.getExamId());
        pst.setString(2,newExam.getLanguage());
        pst.setInt(3,newExam.getTotalQuestions());
        int response = pst.executeUpdate();
        return response==1;
    }
    public static ArrayList<String> getExamIdBySubject(String language) throws SQLException
    {
        String query = "select examid from exam where language=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, language);
        ResultSet rs = pst.executeQuery();
        ArrayList <String> examList = new ArrayList();
        while(rs.next())
        {
            examList.add(rs.getString(1));
        }
         return examList;
    }
    
    public static int getQuestionCountByExam(String examId) throws SQLException
    {
         String query = "select total_question from Exam where examid=?";
         Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(query);
         pst.setString(1,examId);
         ResultSet rs=pst.executeQuery();
	 rs.next();
         int rowCount=rs.getInt(1);
         return rowCount;

    }    
    
    public static boolean isPaperSet(String subject) throws SQLException 
    {
         String query="Select examid from Exam where language=? ";       
         Connection conn=DBConnection.getConnection();
         PreparedStatement pst=conn.prepareStatement(query);
         pst.setString(1,subject);
         ResultSet rs=pst.executeQuery();
         return rs.next();
    }
    
    public static ArrayList<String> getExamIdBySubject(String userid,String subject) throws SQLException
    {
         String query="Select examid from Exam where language=? minus Select examid from performance where userid=?"; 
         ArrayList<String> examList=new ArrayList<>();
         Connection conn=DBConnection.getConnection();
         PreparedStatement pst=conn.prepareStatement(query);
         pst.setString(1,subject);
         pst.setString(2,userid);
         ResultSet rs=pst.executeQuery();
         while(rs.next())
         {
            examList.add(rs.getString(1));
         }
         return examList;        

    }    
}
