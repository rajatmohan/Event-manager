package eventscheduler;

import javax.swing.*;

public class LoginScreen extends javax.swing.JFrame {
    
    private String username, password;
    private String hostName, portNum;
    
    public LoginScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginInfoPnl = new javax.swing.JPanel();
        usernameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        usernameLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        hostNameTxt = new javax.swing.JTextField();
        portNumTxt = new javax.swing.JTextField();
        hostNameLbl = new javax.swing.JLabel();
        portNumLbl = new javax.swing.JLabel();
        connectToLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginInfoPnl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        loginBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        loginBtn.setText("log in");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        usernameLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        usernameLbl.setText("Username");
        usernameLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        passwordLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        passwordLbl.setText("Password");
        passwordLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginInfoPnlLayout = new javax.swing.GroupLayout(loginInfoPnl);
        loginInfoPnl.setLayout(loginInfoPnlLayout);
        loginInfoPnlLayout.setHorizontalGroup(
            loginInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginInfoPnlLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(loginInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(usernameTxt))
                .addGap(114, 114, 114))
        );

        loginInfoPnlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passwordTxt, usernameTxt});

        loginInfoPnlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passwordLbl, usernameLbl});

        loginInfoPnlLayout.setVerticalGroup(
            loginInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginInfoPnlLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(loginInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl))
                .addGap(18, 18, 18)
                .addComponent(loginBtn)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        loginInfoPnlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {passwordLbl, passwordTxt, usernameLbl, usernameTxt});

        hostNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostNameTxtActionPerformed(evt);
            }
        });

        portNumTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portNumTxtActionPerformed(evt);
            }
        });

        hostNameLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        hostNameLbl.setText("Host name");

        portNumLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        portNumLbl.setText("Port number");

        connectToLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        connectToLbl.setText("Connect to Server");

        jLabel1.setFont(new java.awt.Font("TeXGyreTermes", 0, 24)); // NOI18N
        jLabel1.setText(" EVENT SCHEDULER ");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hostNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(portNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hostNameTxt)
                    .addComponent(portNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
            .addComponent(loginInfoPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(connectToLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectToLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hostNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portNumLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hostNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginInfoPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {connectToLbl, hostNameLbl, hostNameTxt, portNumLbl, portNumTxt});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("UseSpecificCatch")
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        username = usernameTxt.getText();
        username.trim();
        password = new String(passwordTxt.getPassword());
        password.trim();
        hostName = hostNameTxt.getText();
        portNum = portNumTxt.getText();    
        if("".equals(username) || "".equals(password) || "".equals(hostName) || "".equals(portNum)){
            JOptionPane.showMessageDialog(this, "One or more input is missing.", 
                    "input warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            try{
                Client newClient = new Admin(username, password, hostName, Integer.parseInt(portNum));
                newClient.connectToServer();
                if(!newClient.login()){                    
                    JOptionPane.showMessageDialog(this, "Login Unsuccessful.", 
                            "conn error", JOptionPane.ERROR_MESSAGE);
                    
                }
                else{
                    ClientScreen mainScreen = new ClientScreen(newClient);
                    mainScreen.setVisible(true);
                    this.dispose();
                }
            }
            catch (Exception e){
                System.out.println("Login Screen: " + e);
                JOptionPane.showMessageDialog(this, "Error in connection", 
                       "conn error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void hostNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostNameTxtActionPerformed
        
    }//GEN-LAST:event_hostNameTxtActionPerformed

    private void portNumTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portNumTxtActionPerformed
        
    }//GEN-LAST:event_portNumTxtActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectToLbl;
    private javax.swing.JLabel hostNameLbl;
    private javax.swing.JTextField hostNameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginInfoPnl;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel portNumLbl;
    private javax.swing.JTextField portNumTxt;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables

}
