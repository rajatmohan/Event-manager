package eventscheduler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class ClientScreen extends javax.swing.JFrame {
    
    private boolean isAdmin;
    Client client;
    Admin admin;
    private DefaultTableModel mod; 
    private String date;
    
    public ClientScreen(Client newClient) {
        this.client = newClient;
        this.isAdmin = (newClient.groupId == 1);
        initComponents();
        checkAdmin();     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Header = new javax.swing.JLabel();
        schedulerTabPane = new javax.swing.JTabbedPane();
        addEventPnl = new javax.swing.JPanel();
        venueLbl = new javax.swing.JLabel();
        venueCBox = new javax.swing.JComboBox();
        descriptionLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxtArea = new javax.swing.JTextArea();
        addEventBtn = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        dateLbl = new javax.swing.JLabel();
        eventNameTxt = new javax.swing.JTextField();
        startingtimeLbl1 = new javax.swing.JLabel();
        SlotLbl = new javax.swing.JLabel();
        slotCBox = new javax.swing.JComboBox();
        endTimeTxt = new javax.swing.JTextField();
        startTimeTxt = new javax.swing.JTextField();
        SlotLbl1 = new javax.swing.JLabel();
        deleteeventpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        myEventsTbl = new javax.swing.JTable();
        deleteEvtBtn = new javax.swing.JButton();
        viewEventPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewEventTbl = new javax.swing.JTable();
        addnewuserpanel = new javax.swing.JPanel();
        userNameLbl = new javax.swing.JLabel();
        passwdLbl = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        passwdTxt = new javax.swing.JPasswordField();
        groupNameLbl = new javax.swing.JLabel();
        groupTxt = new javax.swing.JTextField();
        emailIdLbl = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        addUserBtn = new javax.swing.JButton();
        addvenuepanel = new javax.swing.JPanel();
        venueApplyBtn = new javax.swing.JButton();
        venueNameLbl = new javax.swing.JLabel();
        venueTxt = new javax.swing.JTextField();
        blockGrpLbl = new javax.swing.JLabel();
        blockedGrpTxt = new javax.swing.JTextField();
        addVenueRadBtn = new javax.swing.JRadioButton();
        rmvVenueRadBtn = new javax.swing.JRadioButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Header.setFont(new java.awt.Font("TeXGyreTermes", 0, 24)); // NOI18N
        Header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Header.setText("EVENT SCHEDULER");
        Header.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        schedulerTabPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(240, 240, 240), null, null));
        schedulerTabPane.setToolTipText("");
        schedulerTabPane.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        schedulerTabPane.addChangeListener(changeListener);

        addEventPnl.setToolTipText("");

        venueLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        venueLbl.setText(" Venue");

        venueCBox.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        venueCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venueCBoxActionPerformed(evt);
            }
        });

        descriptionLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        descriptionLbl.setText(" Description");

        descriptionTxtArea.setColumns(20);
        descriptionTxtArea.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        descriptionTxtArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTxtArea);

        addEventBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        addEventBtn.setText("Add Event");
        addEventBtn.setToolTipText("click to add the event");
        addEventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventBtnActionPerformed(evt);
            }
        });

        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dateChooserInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        dateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserPropertyChange(evt);
            }
        });

        dateLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        dateLbl.setText(" Date");

        eventNameTxt.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        startingtimeLbl1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        startingtimeLbl1.setText(" Event Name");

        SlotLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        SlotLbl.setText(" Time Slots");

        slotCBox.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        slotCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slotCBoxActionPerformed(evt);
            }
        });

        endTimeTxt.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        endTimeTxt.setToolTipText("End TIme");
        endTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTimeTxtActionPerformed(evt);
            }
        });

        startTimeTxt.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        startTimeTxt.setToolTipText("Start Time");
        startTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeTxtActionPerformed(evt);
            }
        });

        SlotLbl1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        SlotLbl1.setText(" Time (hh:mm:ss)");

        javax.swing.GroupLayout addEventPnlLayout = new javax.swing.GroupLayout(addEventPnl);
        addEventPnl.setLayout(addEventPnlLayout);
        addEventPnlLayout.setHorizontalGroup(
            addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEventPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startingtimeLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addEventPnlLayout.createSequentialGroup()
                        .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addEventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(venueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SlotLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SlotLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEventPnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEventPnlLayout.createSequentialGroup()
                                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(venueCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eventNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slotCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEventPnlLayout.createSequentialGroup()
                                .addComponent(startTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(endTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addEventPnlLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        addEventPnlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addEventBtn, dateChooser, slotCBox, venueCBox});

        addEventPnlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SlotLbl, venueLbl});

        addEventPnlLayout.setVerticalGroup(
            addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEventPnlLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startingtimeLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venueCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slotCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SlotLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(addEventPnlLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addEventPnlLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SlotLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(44, 44, 44)
                .addGroup(addEventPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEventPnlLayout.createSequentialGroup()
                        .addComponent(descriptionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(addEventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        addEventPnlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SlotLbl, dateChooser, dateLbl, descriptionLbl, eventNameTxt, slotCBox, venueCBox, venueLbl});

        addEventPnlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {endTimeTxt, startTimeTxt});

        dateChooser.setMinSelectableDate(new Date());

        schedulerTabPane.addTab("  ADD EVENT ", addEventPnl);

        deleteeventpanel.setToolTipText("click here to delete an existing event");

        myEventsTbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        myEventsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "eventId", "Name", "Venue", "Start Time", "End Time", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myEventsTbl.setColumnSelectionAllowed(true);
        myEventsTbl.getTableHeader().setReorderingAllowed(false);
        myEventsTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myEventsTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(myEventsTbl);
        myEventsTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (myEventsTbl.getColumnModel().getColumnCount() > 0) {
            myEventsTbl.getColumnModel().getColumn(0).setResizable(false);
            myEventsTbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            myEventsTbl.getColumnModel().getColumn(1).setResizable(false);
            myEventsTbl.getColumnModel().getColumn(2).setResizable(false);
            myEventsTbl.getColumnModel().getColumn(3).setResizable(false);
            myEventsTbl.getColumnModel().getColumn(4).setResizable(false);
            myEventsTbl.getColumnModel().getColumn(5).setResizable(false);
        }
        myEventsTbl.removeColumn(myEventsTbl.getColumnModel().getColumn(1));

        deleteEvtBtn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        deleteEvtBtn.setText("Delete");
        deleteEvtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEvtBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteeventpanelLayout = new javax.swing.GroupLayout(deleteeventpanel);
        deleteeventpanel.setLayout(deleteeventpanelLayout);
        deleteeventpanelLayout.setHorizontalGroup(
            deleteeventpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteeventpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteEvtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(394, 394, 394))
        );
        deleteeventpanelLayout.setVerticalGroup(
            deleteeventpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteeventpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(deleteEvtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        schedulerTabPane.addTab("  MY EVENTS ", deleteeventpanel);

        viewEventTbl.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        viewEventTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Name", " Organizer  Name", " Venue", " Start Time", " End Time", " Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewEventTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(viewEventTbl);

        javax.swing.GroupLayout viewEventPanelLayout = new javax.swing.GroupLayout(viewEventPanel);
        viewEventPanel.setLayout(viewEventPanelLayout);
        viewEventPanelLayout.setHorizontalGroup(
            viewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        viewEventPanelLayout.setVerticalGroup(
            viewEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewEventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
        );

        schedulerTabPane.addTab(" VIEW EVENTS", viewEventPanel);

        addnewuserpanel.setToolTipText("");

        userNameLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        userNameLbl.setText(" User Name");

        passwdLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passwdLbl.setText(" Password");

        usernameTxt.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        passwdTxt.setText("jPasswordField1");

        groupNameLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        groupNameLbl.setText(" Group Name");

        groupTxt.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        emailIdLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        emailIdLbl.setText(" E-Mail ID");

        emailTxt.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        addUserBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        addUserBtn.setText("Add User");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addnewuserpanelLayout = new javax.swing.GroupLayout(addnewuserpanel);
        addnewuserpanel.setLayout(addnewuserpanelLayout);
        addnewuserpanelLayout.setHorizontalGroup(
            addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addnewuserpanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addnewuserpanelLayout.createSequentialGroup()
                        .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(groupNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(emailIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(passwdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        addnewuserpanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {emailTxt, groupTxt, passwdTxt, usernameTxt});

        addnewuserpanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {emailIdLbl, groupNameLbl, userNameLbl});

        addnewuserpanelLayout.setVerticalGroup(
            addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addnewuserpanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(groupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addnewuserpanelLayout.createSequentialGroup()
                        .addComponent(groupNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(20, 20, 20)
                .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addnewuserpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(passwdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );

        addnewuserpanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {userNameLbl, usernameTxt});

        addnewuserpanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {emailIdLbl, emailTxt, groupNameLbl, groupTxt});

        schedulerTabPane.addTab(" ADD USER", addnewuserpanel);

        addvenuepanel.setToolTipText("");

        venueApplyBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        venueApplyBtn.setText("Apply");
        venueApplyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venueApplyBtnActionPerformed(evt);
            }
        });

        venueNameLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        venueNameLbl.setText(" Venue Name");

        venueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venueTxtActionPerformed(evt);
            }
        });

        blockGrpLbl.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        blockGrpLbl.setText(" Block Selected Groups (.., .., ...)");

        buttonGroup1.add(addVenueRadBtn);
        addVenueRadBtn.setFont(new java.awt.Font("Cabin", 1, 18)); // NOI18N
        addVenueRadBtn.setText("Add");
        addVenueRadBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addVenueRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVenueRadBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(rmvVenueRadBtn);
        rmvVenueRadBtn.setFont(new java.awt.Font("Cabin", 1, 18)); // NOI18N
        rmvVenueRadBtn.setText("Remove");
        rmvVenueRadBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rmvVenueRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvVenueRadBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addvenuepanelLayout = new javax.swing.GroupLayout(addvenuepanel);
        addvenuepanel.setLayout(addvenuepanelLayout);
        addvenuepanelLayout.setHorizontalGroup(
            addvenuepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addvenuepanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(addvenuepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addvenuepanelLayout.createSequentialGroup()
                        .addComponent(venueNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(venueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addvenuepanelLayout.createSequentialGroup()
                        .addComponent(blockGrpLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(blockedGrpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addvenuepanelLayout.createSequentialGroup()
                        .addComponent(addVenueRadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rmvVenueRadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(venueApplyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        addvenuepanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {blockGrpLbl, venueNameLbl, venueTxt});

        addvenuepanelLayout.setVerticalGroup(
            addvenuepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addvenuepanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(addvenuepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venueNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addvenuepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blockGrpLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blockedGrpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addvenuepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addVenueRadBtn)
                    .addComponent(rmvVenueRadBtn))
                .addGap(20, 20, 20)
                .addComponent(venueApplyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        addvenuepanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {venueNameLbl, venueTxt});

        addvenuepanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addVenueRadBtn, blockGrpLbl});

        schedulerTabPane.addTab(" EDIT VENUES", addvenuepanel);

        logoutBtn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        logoutBtn.setText("Logout!");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schedulerTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(schedulerTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Action listener which adds user on clicking add user button on add user panel*/
    
    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        String username, passwd, group, email;
        username = usernameTxt.getText().trim();
        passwd = new String(passwdTxt.getPassword()).trim();
        group = groupTxt.getText().trim();
        email = emailTxt.getText().trim();
        /*Display Messages*/
        if("".equals(username) || "".equals(passwd) || "".equals(group) || "".equals(email)){
            JOptionPane.showMessageDialog(this, "One or more input is missing.",
                "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(admin.addClient(username, passwd, group, email)){
            JOptionPane.showMessageDialog(this, "User added successfully");
            resetAllInAddUser();
        }
        else{
            JOptionPane.showMessageDialog(this, "User couldn't be added.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addUserBtnActionPerformed

    /*action listeners of radio buttons on edit venues panel*/
    
    private boolean venueActionChoice;
    
    private void rmvVenueRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvVenueRadBtnActionPerformed
        venueActionChoice = false;
    }//GEN-LAST:event_rmvVenueRadBtnActionPerformed

    private void addVenueRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVenueRadBtnActionPerformed
        venueActionChoice = true;
    }//GEN-LAST:event_addVenueRadBtnActionPerformed

    private void venueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venueTxtActionPerformed

    }//GEN-LAST:event_venueTxtActionPerformed

    /*function to add or remove venue on edit venues panel*/
    
    private void venueApplyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venueApplyBtnActionPerformed
        String venueName = venueTxt.getText().trim();
        String blockedGrp = blockedGrpTxt.getText().trim();
        String display = "venue ";
        boolean result;
        if(venueName.length() < 3){
            JOptionPane.showMessageDialog(this, "One or more input is missing.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            resetAllInEditVenue();
            return;
        }
        if(venueActionChoice){
            display += "added ";
            result = admin.addVenue(venueName, blockedGrp);
        }
        else{
            display += "removed ";
            result = admin.removeVenue(venueName);
        }
        if(result){
            JOptionPane.showMessageDialog(this, display);
            resetAllInEditVenue();
        }
        else{
            JOptionPane.showMessageDialog(this, display,
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_venueApplyBtnActionPerformed

    /*function to add events on clicking addevent button on add event panel*/
    private void addEventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventBtnActionPerformed
        String startT, endT, venue, description;
        String slotT, slotStartT, slotEndT;
        String eventName = eventNameTxt.getText().trim();
        venue = (String) venueCBox.getSelectedItem();
        startT = startTimeTxt.getText().trim();
        endT = endTimeTxt.getText().trim();
        slotT = slotCBox.getSelectedItem().toString().trim();
        slotStartT = slotT.substring(0, 8);
        slotEndT = slotT.substring(slotT.indexOf('-') + 2);
        description = descriptionTxtArea.getText().trim();
        boolean checkTimeSlot = (startT.compareTo(endT) < 0);   //check input time slot is valid i.e., start time is < end time
        checkTimeSlot &= (startT.compareTo(slotStartT) >= 0);   //check input time slot is available i.e.,
        checkTimeSlot &= (endT.compareTo(slotEndT) <= 0);       //start and end time lie in selected time slot
        if(!checkTimeSlot){
            JOptionPane.showMessageDialog(this, "Time slot is not available.", 
                "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            Event newEvent;
            try {
                newEvent = new Event(client.clientSocket);
                if(newEvent.createEvent(eventName, startT, endT, date, venue, client.id, description)){
                    JOptionPane.showMessageDialog(this, "Event added successfully.");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Event not added.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                System.out.println("ClientScreen: " + e);
            }
        }
    }//GEN-LAST:event_addEventBtnActionPerformed

    private void slotCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slotCBoxActionPerformed

    }//GEN-LAST:event_slotCBoxActionPerformed

    private void venueCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venueCBoxActionPerformed
        try {
            int i = slotCBox.getItemCount() - 1;    //empty the time slot combobox
            while(i >= 0){
                slotCBox.removeItemAt(i);
                --i;
            }
            date = dateChooser.getDate().toString();
            date = date.substring(24) + '-' + changeDateFormat(date.substring(4, 10));
            if(venueCBox.getSelectedItem() == null)
                return;
            String venue = venueCBox.getSelectedItem().toString();
            Slot s = new Slot(client);
            String venArr[] = s.getSlots(date, venue);
            for(i = 0; !"%%".equals(venArr[i]); ++i){         
                slotCBox.addItem(venArr[i]);
            }
        } catch (Exception e) {
            System.out.println("Client Screen: " + e);
        }
    }//GEN-LAST:event_venueCBoxActionPerformed

    private void dateChooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateChooserInputMethodTextChanged
        
    }//GEN-LAST:event_dateChooserInputMethodTextChanged

    private void dateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserPropertyChange
        try {                                   
            int i = slotCBox.getItemCount() - 1;        //empty the time slot combobox
            while(i >= 0){
                slotCBox.removeItemAt(i);
                --i;
            }
            if(dateChooser.getDate() == null)
                return;
            date = dateChooser.getDate().toString();
            date = date.substring(24) + '-' + changeDateFormat(date.substring(4, 10));
            String venue = venueCBox.getSelectedItem().toString();
            Slot s = new Slot(client);
            String venArr[] = s.getSlots(date, venue);
            for(i = 0; !"%%".equals(venArr[i]); ++i){         
                slotCBox.addItem(venArr[i]);
            }
        } catch (Exception e) {
            System.out.println("Client Screen: " + e);
        }
    }//GEN-LAST:event_dateChooserPropertyChange

    private void endTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTimeTxtActionPerformed

    }//GEN-LAST:event_endTimeTxtActionPerformed

    private void startTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeTxtActionPerformed

    }//GEN-LAST:event_startTimeTxtActionPerformed

    private void myEventsTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myEventsTblMouseClicked
        
    }//GEN-LAST:event_myEventsTblMouseClicked

    /*function which deletes selected event from view event table in myevents panel*/
    
    private void deleteEvtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEvtBtnActionPerformed
        if(myEventsTbl.getSelectedRow() == -1)
            return;
        String eventid = (String) myEventsTbl.getModel().getValueAt(myEventsTbl.getSelectedRow(), 0);
        ((DefaultTableModel) myEventsTbl.getModel()).removeRow(myEventsTbl.getSelectedRow());
        Event ev = null;
        try {
            ev = new Event(client.clientSocket);
        } catch (IOException e) {
            System.out.println("ClientScreen: " + e);
        }
        try {
            ev.removeEvent(eventid);
        } catch (IOException e) {
            System.out.println("ClientScreen: " + e);
        }
    }//GEN-LAST:event_deleteEvtBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        client.disconnectFromServer();
        this.dispose();
        LoginScreen loginscreen = new LoginScreen();
        loginscreen.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed
    
    /*clears everything in add user panel */
    private void resetAllInAddUser(){               
        usernameTxt.setText("");
        passwdTxt.setText("");
        groupTxt.setText("");
        emailTxt.setText("");
    }
    
    /*clears everything in edit venue panel */
    private void resetAllInEditVenue(){
        venueTxt.setText("");
        blockedGrpTxt.setText("");
        venueActionChoice = true;
        addVenueRadBtn.setSelected(true);
        rmvVenueRadBtn.setSelected(false);
    }
    /*function to change layout of clientscreen if client is admin*/
    private void checkAdmin(){       
        if(!isAdmin){          
            schedulerTabPane.remove(4);
            schedulerTabPane.remove(3);
        }
        else{
            schedulerTabPane.addTab("EDIT VENUES", addvenuepanel);
            schedulerTabPane.addTab("ADD USER", addnewuserpanel);
            admin = (Admin) client;
        }
    }
    
    /*miscellaneous function to change date().tostring to time stamp*/
    private String changeDateFormat(String date){
        String newDate = "";
        String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 1; i <= 12; ++i){
            if(mon[i - 1].equals(date.substring(0, 3))){
                if(i <= 9)
                    newDate += '0';
                newDate += i;
                break;
            }
        }
        newDate += '-' + date.substring(4);
        return newDate;
    }
    
    /*custom listener added to nav bars*/
    ChangeListener changeListener = new ChangeListener(){
        @Override
        public void stateChanged(ChangeEvent changeEvent){
            JTabbedPane source = (JTabbedPane) changeEvent.getSource();
            int index = source.getSelectedIndex();
            Event ev = null;
            if(index == 0){                             //if add event pane is selected
                try {
                    dateChooser.setDate(new Date());
                    Venue v = new Venue(client);
                    venueCBox.removeAllItems();
                    String[] venArr = v.viewVenues(client.groupId);
                    for(int i = 0; !"%%".equals(venArr[i]); ++i){
                        venueCBox.addItem(venArr[i]);
                    }
                } catch (IOException e) {
                    System.out.println("ClientScreen: " + e);
                }
            }
            else if(index == 1){    //if my events pane is selected
                try {
                    ev = new Event(client.clientSocket);      
                } catch (IOException e) {
                    System.out.println(e);
                }
                try{
                    mod = (DefaultTableModel) myEventsTbl.getModel();
                    mod.setRowCount(0);
                    ev.showMyEvents(mod, client);
                } catch (IOException | SQLException e) {
                    System.out.println("ClientScreen: " + e);
                }
            }
            else if(index == 2){                       //if view events pane is selected
                try {
                    ev = new Event(client.clientSocket);      
                } catch (IOException e) {
                    System.out.println(e);
                }
                try {
                    mod = (DefaultTableModel) viewEventTbl.getModel();
                    mod.setRowCount(0);
                    ev.viewEvents(mod);
                } catch (IOException | SQLException e) {
                    System.out.println("ClientScreen: " + e);
                }
            }
            else if(index == 3){                      //if edit venues is selected
                resetAllInEditVenue();
            }
        }
    };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Header;
    private javax.swing.JLabel SlotLbl;
    private javax.swing.JLabel SlotLbl1;
    private javax.swing.JButton addEventBtn;
    private javax.swing.JPanel addEventPnl;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JRadioButton addVenueRadBtn;
    private javax.swing.JPanel addnewuserpanel;
    private javax.swing.JPanel addvenuepanel;
    private javax.swing.JLabel blockGrpLbl;
    private javax.swing.JTextField blockedGrpTxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton deleteEvtBtn;
    private javax.swing.JPanel deleteeventpanel;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextArea descriptionTxtArea;
    private javax.swing.JLabel emailIdLbl;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField endTimeTxt;
    private javax.swing.JTextField eventNameTxt;
    private javax.swing.JLabel groupNameLbl;
    private javax.swing.JTextField groupTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTable myEventsTbl;
    private javax.swing.JLabel passwdLbl;
    private javax.swing.JPasswordField passwdTxt;
    private javax.swing.JRadioButton rmvVenueRadBtn;
    private javax.swing.JTabbedPane schedulerTabPane;
    private javax.swing.JComboBox slotCBox;
    private javax.swing.JTextField startTimeTxt;
    private javax.swing.JLabel startingtimeLbl1;
    private javax.swing.JLabel userNameLbl;
    private javax.swing.JTextField usernameTxt;
    private javax.swing.JButton venueApplyBtn;
    private javax.swing.JComboBox venueCBox;
    private javax.swing.JLabel venueLbl;
    private javax.swing.JLabel venueNameLbl;
    private javax.swing.JTextField venueTxt;
    private javax.swing.JPanel viewEventPanel;
    private javax.swing.JTable viewEventTbl;
    // End of variables declaration//GEN-END:variables

}
