/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiz.DAO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquiz.POJO.Question;
import techquiz.POJO.QuestionStore;
import techquiz.dbutil.DBConnection;

public class QuestionDAO 
{
    public static void addQuestions(QuestionStore qstore) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList <Question> questionsList = qstore.getAllQuestions();
        for(Question q : questionsList)
        {
            pst.setString(1,q.getExamId());
            pst.setString(2,q.getLanguage());
            pst.setString(4,q.getQuestion());
            pst.setString(5,q.getAnswer1());
            pst.setString(6,q.getAnswer2());
            pst.setString(7,q.getAnswer3());
            pst.setString(8,q.getAnswer4());
            pst.setString(9,q.getCorrectAnswer());
            pst.setInt(3,q.getQno());
            pst.executeUpdate();
        }
    }
    
    public static ArrayList <Question> getQuestionsByExamId(String examId)throws SQLException
    {
        String query = "select * from questions where examid=? order by qno";
        ArrayList <Question> questionList = new ArrayList();
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1,examId);
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
            int qno=rs.getInt(3);
               String question=rs.getString(4);
               String option1=rs.getString(5);
               String option2=rs.getString(6);
               String option3=rs.getString(7);
               String option4=rs.getString(8);
               String correctAnswer=rs.getString(9);
               String language=rs.getString(2);
               Question que = new Question(examId,language,option1,option2,option3,option4,correctAnswer,question,qno);
               questionList.add(que);

        }
        return questionList;
    }
    
    public static void updateQuestions(QuestionStore qstore) throws SQLException
    {
       String query="Update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=?,language=? where examid=? and qno=?";
       ArrayList <Question> questionList=qstore.getAllQuestions();
       Connection conn=DBConnection.getConnection();
       PreparedStatement pst=conn.prepareStatement(query);
       for(Question q : questionList)
       {
           pst.setInt(3,q.getQno());
           pst.setString(5, q.getAnswer1());
           pst.setString(6, q.getAnswer2());
           pst.setString(7, q.getAnswer3());
           pst.setString(8, q.getAnswer4());
           pst.setString(9, q.getCorrectAnswer());
           pst.setString(4, q.getQuestion());
           pst.setString(2, q.getLanguage());
           pst.setString(1, q.getExamId());          
           
           pst.executeUpdate();         //Returns the value i.e. 0,1,2,3,4
       }
    }
}
