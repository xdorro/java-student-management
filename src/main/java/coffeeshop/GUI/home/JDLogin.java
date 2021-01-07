/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.GUI.home;

import coffeeshop.DAO.impl.UserDao;
import coffeeshop.DTO.User;
import coffeeshop.Util.Common;
import coffeeshop.Util.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh
 */
public class JDLogin extends javax.swing.JDialog {

    CallbackLogin callback;

    Frame parent;

    UserDao userDao;

    DbUtil dbUtil;

    interface CallbackLogin {

        public void actionLogin(User user);
    }

    /**
     * Creates new form JDLogin
     *
     * @param parent
     * @param modal
     * @param dbUtil
     * @param callback
     */
    public JDLogin(java.awt.Frame parent, boolean modal, DbUtil dbUtil, CallbackLogin callback) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        this.dbUtil = dbUtil;
        this.callback = callback;
        this.userDao = new UserDao(dbUtil);

        parent.setVisible(false);
        txtEmail.setText("admin@gmail.com");
        txtPassword.setText("123456");

        // Custom code
        lblBackground.setBounds(0, 0, 960, 610);
        lblBackground.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/background.png")).getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), 1)));

        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);

        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                txtEmail.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                txtPassword.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackround = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        boxLogin = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        lblQuestionRegister = new javax.swing.JLabel();
        lblForgotPassword = new javax.swing.JLabel();
        lblHeaderPrimary = new javax.swing.JLabel();
        lblHeaderSecondary = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐĂNG NHẬP TÀI KHOẢN");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelBackround.setMaximumSize(new java.awt.Dimension(960, 610));
        panelBackround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("QUẢN LÝ CỬA HÀNG CAFE");
        panelBackround.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 960, -1));

        panelLogin.setBackground(new java.awt.Color(54, 57, 63));
        panelLogin.setMaximumSize(new java.awt.Dimension(480, 406));
        panelLogin.setMinimumSize(new java.awt.Dimension(480, 406));

        boxLogin.setBackground(new java.awt.Color(54, 57, 63));
        boxLogin.setMinimumSize(new java.awt.Dimension(416, 342));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(142, 146, 151));
        lblEmail.setText("EMAIL");

        txtEmail.setBackground(new java.awt.Color(48, 51, 57));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(220, 221, 222));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 36, 40)));
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(48, 51, 57));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(220, 221, 222));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 36, 40)));
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(114, 137, 218));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setFocusable(false);
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(114, 137, 218));
        lblRegister.setText("Đăng ký");
        lblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        lblQuestionRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQuestionRegister.setForeground(new java.awt.Color(114, 118, 125));
        lblQuestionRegister.setText("Cần một tài khoản?");

        lblForgotPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblForgotPassword.setForeground(new java.awt.Color(114, 137, 218));
        lblForgotPassword.setText("Quên mật khẩu?");
        lblForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseClicked(evt);
            }
        });

        lblHeaderPrimary.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeaderPrimary.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderPrimary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeaderPrimary.setText("Chào mừng trở lại");

        lblHeaderSecondary.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeaderSecondary.setForeground(new java.awt.Color(185, 187, 190));
        lblHeaderSecondary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeaderSecondary.setText("Rất vui mừng khi được gặp lại bạn!");

        lblEmailError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(240, 71, 71));
        lblEmailError.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEmailError.setText("Email không được để trống");
        lblEmailError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(142, 146, 151));
        lblPassword.setText("MẬT KHẨU");

        lblPasswordError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(240, 71, 71));
        lblPasswordError.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPasswordError.setText("Mật khẩu không được để trống");
        lblPasswordError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout boxLoginLayout = new javax.swing.GroupLayout(boxLogin);
        boxLogin.setLayout(boxLoginLayout);
        boxLoginLayout.setHorizontalGroup(
            boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeaderSecondary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeaderPrimary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtEmail)
            .addComponent(txtPassword)
            .addGroup(boxLoginLayout.createSequentialGroup()
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(boxLoginLayout.createSequentialGroup()
                        .addComponent(lblQuestionRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(boxLoginLayout.createSequentialGroup()
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(boxLoginLayout.createSequentialGroup()
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        boxLoginLayout.setVerticalGroup(
            boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLoginLayout.createSequentialGroup()
                .addComponent(lblHeaderPrimary)
                .addGap(10, 10, 10)
                .addComponent(lblHeaderSecondary)
                .addGap(18, 18, 18)
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblEmailError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(lblPasswordError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblForgotPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestionRegister)
                    .addComponent(lblRegister)))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(boxLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(boxLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panelBackround.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBackground.setMaximumSize(new java.awt.Dimension(960, 610));
        lblBackground.setMinimumSize(new java.awt.Dimension(960, 610));
        lblBackground.setPreferredSize(new java.awt.Dimension(960, 610));
        panelBackround.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();
        boolean validate = true;

        // Reset to default
        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 36, 40)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 36, 40)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        lblEmail.setForeground(new Color(220, 221, 222));
        lblPassword.setForeground(new Color(220, 221, 222));

        if (email.equals("")) {
            txtEmail.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblEmail.setForeground(new Color(240, 71, 71));
            lblEmailError.setText("Email không được để trống");
            lblEmailError.setVisible(true);
            validate = false;
        } else {
            String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            if (!email.matches(email_regex)) {
                txtEmail.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(240, 71, 71)),
                        BorderFactory.createEmptyBorder(5, 8, 5, 8)));
                lblEmail.setForeground(new Color(240, 71, 71));
                lblEmailError.setText("Email không đúng định dạng");
                lblEmailError.setVisible(true);
                validate = false;
            }
        }

        if (password.equals("")) {
            txtPassword.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblPassword.setForeground(new Color(240, 71, 71));
            lblPasswordError.setText("Mật khẩu không được để trống");
            lblPasswordError.setVisible(true);
            validate = false;
        }

        if (validate == true) {
            User obj = userDao.auth(email, password);
            System.out.println(obj);

            if (!Common.isNullOrEmpty(obj)) {
                callback.actionLogin(obj);
                this.setVisible(false);
                parent.setVisible(true);
                txtPassword.setText("");
                txtEmail.setText("");
            } else {
                txtPassword.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(240, 71, 71)),
                        BorderFactory.createEmptyBorder(5, 8, 5, 8)));
                txtPassword.setText("");
                lblPassword.setForeground(new Color(240, 71, 71));
                lblPasswordError.setText("Email hoặc mật khẩu đăng nhập không chính xác.");
                lblPasswordError.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        JOptionPane.showMessageDialog(this, "Vui lòng liên hệ admin để đăng ký tài khoản.");        // TODO add your handling code here:
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void lblForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseClicked
        JOptionPane.showMessageDialog(this, "Vui lòng liên hệ admin để lấy lại mật khẩu.");
    }//GEN-LAST:event_lblForgotPasswordMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            dbUtil.getInstance().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boxLogin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblHeaderPrimary;
    private javax.swing.JLabel lblHeaderSecondary;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblQuestionRegister;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBackround;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
