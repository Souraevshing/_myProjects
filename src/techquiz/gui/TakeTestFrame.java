/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiz.gui;




import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import techquiz.DAO.PerformanceDAO;
import techquiz.DAO.QuestionDAO;
import techquiz.POJO.Answer;
import techquiz.POJO.AnswerStore;
import techquiz.POJO.ExamPOJO;
import techquiz.POJO.PerformancePOJO;
import techquiz.POJO.Question;
import techquiz.POJO.QuestionStore;
import techquiz.POJO.UserProfilePOJO;
import techquiz.dbutil.DBConnection;

public class TakeTestFrame extends javax.swing.JFrame
{
    private Answer newanswer;
    private Answer answer;
    private ExamPOJO exam;
    private QuestionStore qstore;
    private AnswerStore astore;
    private int qno,pos=0;
    Color oldColor = new Color(255,51,51);
    JFrame fr;          //Showing Polymorphism .
    
    public TakeTestFrame() 
    {
        initComponents();
        setTitle("TAKE TEST PANEL");
        setLocationRelativeTo(null);
        setResizable(false);
        lblUser.setText("Hello "+UserProfilePOJO.getUsername());
        qstore = new QuestionStore();
        astore = new AnswerStore();
        qno = 1;
        lblTimer.setEnabled(false);
        TakeTestFrame.SplashScreen sp = new TakeTestFrame.SplashScreen();
        sp.start();
    }

    public TakeTestFrame(ExamPOJO exam)
    {
        this();
        this.exam=exam;
        lblTitle.setText(exam.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();

    }
    public void loadQuestions()
    {
        try
        {
                ArrayList<Question> questionList=QuestionDAO.getQuestionsByExamId(exam.getExamId());
                for(Question obj:questionList)
                {
                    qstore.addQuestion(obj);
                }
        }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Take Test!",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
    }

    public void showQuestion()
    {
        Question question=qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQuestion.setText(question.getQuestion()); 
        jrbOption1.setText(question.getAnswer1());
        jrbOption2.setText(question.getAnswer2());
        jrbOption3.setText(question.getAnswer3());
        jrbOption4.setText(question.getAnswer4());
        String opt1,opt2,opt3,opt4;
        opt1=jrbOption1.getText();
        txtOpt1.setText(opt1);
        opt2=jrbOption2.getText();
        txtOpt2.setText(opt2);
        opt3=jrbOption3.getText();
        txtOpt3.setText(opt3);
        opt4=jrbOption4.getText();
        txtOpt4.setText(opt4);
        Answer answer=astore.getAnswerByQno(qno);
        if(answer==null)
            return;
        String chosenAnswer=answer.getChosenAnswer();
        //Activating the radio selected button
        switch(chosenAnswer)                    //There is no default case as there can't be any case that no options will be the correct answer .
        {
            case "Answer1":
                jrbOption1.setSelected(true);
                break;
            case "Answer2":
                jrbOption2.setSelected(true);
                break;
            case "Answer3":
                jrbOption3.setSelected(true);
                break;
            case "Answer4":
                jrbOption4.setSelected(true);
                break;
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        takeTestPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        txtOpt1 = new javax.swing.JLabel();
        txtOpt2 = new javax.swing.JLabel();
        txtOpt4 = new javax.swing.JLabel();
        txtOpt3 = new javax.swing.JLabel();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        btnTakeTestNext = new javax.swing.JButton();
        btnTakeTestPrevious = new javax.swing.JButton();
        btnTakeTestCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        takeTestPanel.setBackground(new java.awt.Color(0, 0, 0));
        takeTestPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techquiz/img/good luck.jpg"))); // NOI18N

        lblUser.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 51, 51));

        lblLogOut.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblLogOut.setForeground(new java.awt.Color(255, 51, 51));
        lblLogOut.setText("Log Out ");
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogOutMouseExited(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 51, 0));
        lblTitle.setText("EXAM PAPER");

        lblQno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 51, 51));
        lblQno.setText("Question No :");

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtQuestion.setForeground(new java.awt.Color(255, 51, 51));
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        txtOpt1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtOpt1.setForeground(new java.awt.Color(255, 51, 51));

        txtOpt2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtOpt2.setForeground(new java.awt.Color(255, 51, 51));

        txtOpt4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtOpt4.setForeground(new java.awt.Color(255, 51, 51));

        txtOpt3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtOpt3.setForeground(new java.awt.Color(255, 51, 51));

        buttonGroup1.add(jrbOption1);
        jrbOption1.setText("jRadioButton1");

        buttonGroup1.add(jrbOption2);
        jrbOption2.setText("jRadioButton2");
        jrbOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOption2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbOption3);
        jrbOption3.setText("jRadioButton3");

        buttonGroup1.add(jrbOption4);
        jrbOption4.setText("jRadioButton4");

        btnTakeTestNext.setBackground(new java.awt.Color(0, 0, 0));
        btnTakeTestNext.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnTakeTestNext.setForeground(new java.awt.Color(255, 51, 51));
        btnTakeTestNext.setText("Next");
        btnTakeTestNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeTestNextActionPerformed(evt);
            }
        });

        btnTakeTestPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnTakeTestPrevious.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnTakeTestPrevious.setForeground(new java.awt.Color(255, 51, 51));
        btnTakeTestPrevious.setText("Previous");
        btnTakeTestPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeTestPreviousActionPerformed(evt);
            }
        });

        btnTakeTestCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnTakeTestCancel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnTakeTestCancel.setForeground(new java.awt.Color(255, 51, 51));
        btnTakeTestCancel.setText("Cancel");
        btnTakeTestCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeTestCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 51, 51));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblTimer.setBackground(new java.awt.Color(0, 0, 0));
        lblTimer.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout takeTestPanelLayout = new javax.swing.GroupLayout(takeTestPanel);
        takeTestPanel.setLayout(takeTestPanelLayout);
        takeTestPanelLayout.setHorizontalGroup(
            takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(takeTestPanelLayout.createSequentialGroup()
                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(takeTestPanelLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrbOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(takeTestPanelLayout.createSequentialGroup()
                                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(takeTestPanelLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(btnTakeTestNext)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnTakeTestPrevious)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnTakeTestCancel))
                                    .addGroup(takeTestPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addComponent(btnDone)
                                .addGap(56, 56, 56))
                            .addGroup(takeTestPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOpt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, takeTestPanelLayout.createSequentialGroup()
                        .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(takeTestPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(247, 247, 247))
                            .addGroup(takeTestPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(lblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(takeTestPanelLayout.createSequentialGroup()
                            .addGap(211, 211, 211)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, takeTestPanelLayout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        takeTestPanelLayout.setVerticalGroup(
            takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(takeTestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(takeTestPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbOption1))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, takeTestPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbOption2)
                        .addGap(42, 42, 42)))
                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbOption4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jrbOption3)))
                .addGap(18, 18, 18)
                .addGroup(takeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTakeTestNext)
                    .addComponent(btnTakeTestPrevious)
                    .addComponent(btnTakeTestCancel)
                    .addComponent(btnDone))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(takeTestPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(takeTestPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseEntered
        lblLogOut.setForeground(Color.white);
    }//GEN-LAST:event_lblLogOutMouseEntered

    private void lblLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseExited
        lblLogOut.setForeground(oldColor);
    }//GEN-LAST:event_lblLogOutMouseExited

    private void jrbOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbOption2ActionPerformed

    private void btnTakeTestNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeTestNextActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null)
        {
        Question question=qstore.getQuestionByQno(qno);
        String correctAnswer=question.getCorrectAnswer();
        Answer newanswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
        
        Answer answer=astore.getAnswerByQno(qno);
        if(answer==null)
            astore.addAnswer(newanswer);
        else
        {
            if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
            {
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
        }
        pos++;
        if(pos>=qstore.getCount())
        {
            pos=0;
        }
        qno++;         
        if(qno>qstore.getCount())
                qno=1;
        lblQno.setText("Question no:"+qno);
        showQuestion();
    }   
    public String getUserAnswer()
    {
        
        if(jrbOption1.isSelected())
            return "Answer1";
        else if(jrbOption2.isSelected())
            return "Answer2";
        else if(jrbOption3.isSelected())
            return "Answer3";
        else if(jrbOption4.isSelected())
            return "Answer4";
        else
            return null;

    }//GEN-LAST:event_btnTakeTestNextActionPerformed

    private void btnTakeTestPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeTestPreviousActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null)
        {
            Question question=qstore.getQuestionByQno(qno);
            String correctAnswer=question.getCorrectAnswer();
            Answer newanswer = new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            Answer answer = astore.getAnswerByQno(qno);
            if(answer==null)
            {
                astore.addAnswer(newanswer);
            }
            else
            {
                if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
                {
                    int apos = astore.removeAnswer(answer);
                    astore.setAnswerAt(apos, newanswer);
                }
            }
        }
        --pos;
        if(pos<0)
        {
            pos=qstore.getCount()-1;
        }
        --qno;
        if(qno<=0)
        qno=qstore.getCount();
        lblQno.setText("Question no : "+qno);
        showQuestion();
    }//GEN-LAST:event_btnTakeTestPreviousActionPerformed

    private void btnTakeTestCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeTestCancelActionPerformed
        fr = new ChoosePaperFrame();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTakeTestCancelActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        
        String userAnswer = getUserAnswer(); 
        if(userAnswer!=null)
        {
            Question question=qstore.getQuestionByQno(qno); //getting question no from QuestionStore .
            String correctAnswer=question.getCorrectAnswer();   //Correct Answer .
            newanswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,userAnswer,correctAnswer);
            
            answer=astore.getAnswerByQno(qno);   //getting answer from AnswerStore .  
            if(answer==null)    //checking if answer is not entered by user .
            astore.addAnswer(newanswer);
        }
        else
        {
          if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
            {
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
        int right=0,wrong=0;
        for(Question question : qstore.getAllQuestions())
        {
            int qno=question.getQno();
            Answer answer=astore.getAnswerByQno(qno);
            if(answer==null)
                continue;
            else
            {
                String chosenAnswer1=answer.getChosenAnswer();
                String correctAnswer=answer.getCorrectAnswer();
                if(chosenAnswer1.equals(correctAnswer))
                    ++right;
                else
                    ++wrong;
                    
            }
        }
        String reportCard="Total Questions: "+qstore.getCount();
        reportCard+="\nRight Answers: "+right;
        reportCard+="\nWrong Answers: "+wrong;
        reportCard+="\nUnAttempted : "+(qstore.getCount()-(right+wrong));
        JOptionPane.showMessageDialog(null, reportCard,"Your Result!",JOptionPane.INFORMATION_MESSAGE);
        try
        {
            PerformancePOJO performance = new PerformancePOJO(exam.getExamId(),exam.getLanguage(),UserProfilePOJO.getUsername(),right,wrong,(qstore.getCount()-(right+wrong)),(double)right/qstore.getCount()*100);
            PerformanceDAO.addPerformance(performance);
            JOptionPane.showMessageDialog(null, "Your performance has been successfully added to the database"," Performance Added!",JOptionPane.INFORMATION_MESSAGE);
            fr = new ChoosePaperFrame();
            fr.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    class SplashScreen extends Thread
    {
        public void run()
        {
            int count=1;
            Random r=new Random();
            int timet= 1 * 60; // Convert to seconds
            long delay = timet * 1000;

        do
        {
            try
            {
                int minutes = timet / 60;
                int seconds = timet % 60;
                lblTimer.setText(minutes+"m :"+seconds+" s");
      
                Thread.sleep(1000);
                timet = timet - 1;
                delay = delay - 1000;
            }
            catch(InterruptedException ex)
            {
                JOptionPane.showMessageDialog(null, "Error in Take Test Frame", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }

        }
        while (delay != 0);
               JOptionPane.showMessageDialog(null, "Times Up!\n Thanks for giving the test","Test Complete",JOptionPane.INFORMATION_MESSAGE);
               btnDone.doClick();
        }
    }        
            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnTakeTestCancel;
    private javax.swing.JButton btnTakeTestNext;
    private javax.swing.JButton btnTakeTestPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel takeTestPanel;
    private javax.swing.JLabel txtOpt1;
    private javax.swing.JLabel txtOpt2;
    private javax.swing.JLabel txtOpt3;
    private javax.swing.JLabel txtOpt4;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
