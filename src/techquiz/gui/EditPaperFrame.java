/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquiz.gui;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import techquiz.DAO.ExamDAO;
import techquiz.POJO.ExamPOJO;
import techquiz.POJO.UserProfilePOJO;

/**
 *
 * @author Lenovo
 */
public class EditPaperFrame extends javax.swing.JFrame
{

    Color oldColor = new Color(255,51,51);
    String subjectName;
    JFrame fr;      //For showing polymorphism.
    
    public EditPaperFrame() {
        initComponents();
        setTitle("EDIT QUESTIONS");
        setLocationRelativeTo(null);
        setResizable(false);
        lblEditUser.setText("Hello "+UserProfilePOJO.getUsername());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogOut = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcChooseSubject = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcNumberOfQuestions = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        btnSetQuestions = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEditLogOut = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcEditChooseSubject = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcEditExamId = new javax.swing.JComboBox<>();
        btnEditBack = new javax.swing.JButton();
        btnEditQuestion = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblEditUser = new javax.swing.JLabel();

        lblLogOut.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lblLogOut.setForeground(new java.awt.Color(255, 51, 0));
        lblLogOut.setText("Log Out");
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

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("PAPER SETTING PANEL");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Set Paper Details");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("Choose The Subject");

        jcChooseSubject.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jcChooseSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAVA", "C", "C++" }));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("Set Number of Questions");

        jcNumberOfQuestions.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jcNumberOfQuestions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 51, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSetQuestions.setBackground(new java.awt.Color(0, 0, 0));
        btnSetQuestions.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSetQuestions.setForeground(new java.awt.Color(255, 51, 0));
        btnSetQuestions.setText("Set The Questions");
        btnSetQuestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetQuestionsActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techquiz/img/examicon.png"))); // NOI18N

        lblUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 51, 0));
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUserMouseExited(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblEditLogOut.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lblEditLogOut.setForeground(new java.awt.Color(255, 51, 0));
        lblEditLogOut.setText("Log Out");
        lblEditLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditLogOutMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("PAPER SETTING PANEL");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Set Paper Details");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Choose The Subject");

        jcEditChooseSubject.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jcEditChooseSubject.setForeground(new java.awt.Color(255, 51, 51));
        jcEditChooseSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "JAVA", "C", "C++" }));
        jcEditChooseSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEditChooseSubjectActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("Choose the Exam ID");

        jcEditExamId.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jcEditExamId.setForeground(new java.awt.Color(255, 51, 51));

        btnEditBack.setBackground(new java.awt.Color(0, 0, 0));
        btnEditBack.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnEditBack.setForeground(new java.awt.Color(255, 51, 0));
        btnEditBack.setText("Back");
        btnEditBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBackActionPerformed(evt);
            }
        });

        btnEditQuestion.setBackground(new java.awt.Color(0, 0, 0));
        btnEditQuestion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnEditQuestion.setForeground(new java.awt.Color(255, 51, 0));
        btnEditQuestion.setText("Edit The Questions");
        btnEditQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuestionActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techquiz/img/examicon.png"))); // NOI18N

        lblEditUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblEditUser.setForeground(new java.awt.Color(255, 51, 0));
        lblEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditUserMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEditLogOut))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(93, 161, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEditQuestion)
                                .addGap(41, 41, 41)
                                .addComponent(btnEditBack, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcEditExamId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcEditChooseSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEditLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcEditChooseSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcEditExamId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean validateInput()
    {
    int selectedIndex=jcEditChooseSubject.getSelectedIndex();
    if(selectedIndex==-1||selectedIndex==0)
        return false;
    subjectName=jcEditChooseSubject.getSelectedItem().toString();
    return true;
    }

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseEntered
        lblEditLogOut.setForeground(Color.white);
    }//GEN-LAST:event_lblLogOutMouseEntered

    private void lblLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseExited
        lblEditLogOut.setForeground(oldColor);
    }//GEN-LAST:event_lblLogOutMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminOptionsFrame admin = new AdminOptionsFrame();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSetQuestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetQuestionsActionPerformed
        SetQuestionPaper questionPaper = new SetQuestionPaper();
        questionPaper.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSetQuestionsActionPerformed

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseClicked

    private void lblUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseEntered

    private void lblUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseExited

    private void lblEditLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditLogOutMouseClicked
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblEditLogOutMouseClicked

    private void lblEditLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditLogOutMouseEntered
        lblEditLogOut.setForeground(Color.white);
    }//GEN-LAST:event_lblEditLogOutMouseEntered

    private void lblEditLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditLogOutMouseExited
        lblEditLogOut.setForeground(oldColor);
    }//GEN-LAST:event_lblEditLogOutMouseExited

    private void btnEditBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBackActionPerformed
        AdminOptionsFrame admin = new AdminOptionsFrame();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditBackActionPerformed

    private void btnEditQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuestionActionPerformed
        int count=jcEditChooseSubject.getSelectedIndex();
        if(count==-1||count==0)
        {
            JOptionPane.showMessageDialog(null, "Please choose a subject","Edit Paper Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String subject = jcEditChooseSubject.getSelectedItem().toString();
        String examId = jcEditExamId.getSelectedItem().toString();
        int response;
        response = JOptionPane.showConfirmDialog(null, "You have chosen \""+subject+"\" and \""+examId+"\" paper!\nIs this OK ?","Conformation!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION)
        {
            try
            {
                 int totalQuest=ExamDAO.getQuestionCountByExam(examId.trim());
                 //Creating ExamPOJO obj and adding to exam table.
                 ExamPOJO editExam = new ExamPOJO(examId,subject,totalQuest);
                 fr = new EditQuestionsFrame(editExam);
                 fr.setVisible(true);
                 this.dispose();
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Edit Paper !",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditQuestionActionPerformed

    private void lblEditUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEditUserMouseClicked

    private void lblEditUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEditUserMouseEntered

    private void lblEditUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEditUserMouseExited

    private void jcEditChooseSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEditChooseSubjectActionPerformed
        boolean result = validateInput();
        if(result==false)
        {
            JOptionPane.showMessageDialog(null, "Please choose a subject","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            ArrayList <String> examList = ExamDAO.getExamIdBySubject(subjectName); 
            System.out.print("error caught1");
            if(examList.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Sorry! No exam set for "+subjectName,"Subject Not Found!",JOptionPane.ERROR_MESSAGE);
                return;

            }
            jcEditExamId.removeAllItems();System.out.print("error caught2");
            for(String examId : examList)
            {
                jcEditExamId.addItem(examId);
            }
            System.out.print("error caught1");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Edit Paper Error!",JOptionPane.ERROR_MESSAGE); 
            ex.printStackTrace();System.out.print("error caught1");

        }
    }//GEN-LAST:event_jcEditChooseSubjectActionPerformed

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
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPaperFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPaperFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditBack;
    private javax.swing.JButton btnEditQuestion;
    private javax.swing.JButton btnSetQuestions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcChooseSubject;
    private javax.swing.JComboBox<String> jcEditChooseSubject;
    private javax.swing.JComboBox<String> jcEditExamId;
    private javax.swing.JComboBox<String> jcNumberOfQuestions;
    private javax.swing.JLabel lblEditLogOut;
    private javax.swing.JLabel lblEditUser;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
