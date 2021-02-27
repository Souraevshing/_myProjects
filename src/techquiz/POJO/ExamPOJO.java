/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiz.POJO;


public class ExamPOJO
{
    private String ExamId;

    public ExamPOJO(String ExamId, String language, int TotalQuestions) {
        this.ExamId = ExamId;
        this.language = language;
        this.TotalQuestions = TotalQuestions;
    }
    
    public ExamPOJO()
    {
        
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTotalQuestions(int TotalQuestions) {
        this.TotalQuestions = TotalQuestions;
    }

    public String getExamId() {
        return ExamId;
    }

    public String getLanguage() {
        return language;
    }

    public int getTotalQuestions() {
        return TotalQuestions;
    }
    private String language;
    private int TotalQuestions;
}
