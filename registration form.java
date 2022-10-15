/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package idcardgenerator;

import dao.ConnectionProvider;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import java.util.regex.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static java.lang.String.format;
import java.lang.reflect.Method;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Win7
 */
public class RegistrationForm extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationForm
     */
    File f;
    BufferedImage img = null;
    Image img1;
    ImageIcon format;
    byte[] pimg = null;
    String name,branch,stdId,add,date,mobNo,email,bldGrp,yr,gender,pass,cnPass,filename;
    

    public RegistrationForm() {
        initComponents();
       
        
    }
    
    public boolean verify(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        malebtn.setActionCommand("Male");
        femalebtn.setActionCommand("Female");
        otherGbtn.setActionCommand("Other");
        name = RegistrationForm.nameIp.getText();
        stdId = RegistrationForm.idIp1.getText();
        add = RegistrationForm.addId.getText();
        mobNo = RegistrationForm.mbIp1.getText();
        branch = RegistrationForm.branchIp.getSelectedItem().toString();
        //date = ((JTextField)dateIp.getDateEditor().getUiComponent()).getText();
        date = sdf.format(dateIp.getDate());
        yr = RegistrationForm.yrIp.getSelectedItem().toString();
        gender = RegistrationForm.buttonGroup1.getSelection().getActionCommand();
        email = RegistrationForm.mbIp.getText();
        bldGrp = RegistrationForm.blood.getSelectedItem().toString();
        pass = RegistrationForm.pssFld.getText();
        cnPass = RegistrationForm.cnPssFld.getText();
        if(!pass.equals(cnPass)){
            JOptionPane.showMessageDialog(null,"Password does not match");
            cnPssFld.setText("");
            cnPssFld.grabFocus();
            return false;
        }
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is mandatory");
            nameIp.grabFocus();
            return false;
        }
        if(add.equals("")){
            JOptionPane.showMessageDialog(null,"Address Field is missing");
            addId.grabFocus();
            return false;
        }
        if(stdId.equals("")){
            JOptionPane.showMessageDialog(null,"Student ID is missing");
            return false;
        }
        if(mobNo.equals("")){
            JOptionPane.showMessageDialog(null,"Mobile no. is missing");
            mbIp1.grabFocus();
            return false;
        }
        if(date.equals("")){
            JOptionPane.showMessageDialog(null,"Date is missing");
            dateIp.grabFocus();
            return false;
        }
        if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Email is missing");
            mbIp.grabFocus();
            return false;
        }
        if(gender.equals("")){
            JOptionPane.showMessageDialog(null,"Select Gender");
            return false;
        }
        if(pass.equals("") || pass.length()<8){
            JOptionPane.showMessageDialog(null,"Password length too short");
            return false;
        }
        if(filename.equals("")){
            JOptionPane.showMessageDialog(null,"Select an Image");
            return false;
        }
       
        
        return true;
    }

    public void insertIntoDb(){
         try{
                
                InputStream is = new FileInputStream(f);
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                String sql = "insert into idcards values(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,stdId);
                pst.setString(2,name);
                pst.setString(3,gender);
                pst.setString(4,branch);
                pst.setString(5,bldGrp);
                pst.setString(6,email);
                pst.setString(7, add);
                pst.setString(8,date);
                pst.setString(9,yr);
                pst.setString(10,mobNo);
                pst.setBlob(11,is);
                pst.setString(12,pass);
                
                pst.executeUpdate();
                
                
                
               
                JOptionPane.showMessageDialog(null,"Registered Successfully");
            
                con.close();
            
            
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nameIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mbIp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        idIp1 = new javax.swing.JTextField();
        branchIp = new javax.swing.JComboBox<>();
        blood = new javax.swing.JComboBox<>();
        dateIp = new com.toedter.calendar.JDateChooser();
        pssFld = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addId = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        mbIp1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        otherGbtn = new javax.swing.JRadioButton();
        malebtn = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        femalebtn = new javax.swing.JRadioButton();
        mobErr = new javax.swing.JLabel();
        nameErr = new javax.swing.JLabel();
        emailErr = new javax.swing.JLabel();
        yrIp = new javax.swing.JComboBox<>();
        cnPssFld = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        imgPath = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        imgIp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMaximumSize(new java.awt.Dimension(1680, 1080));
        jPanel2.setMinimumSize(new java.awt.Dimension(1680, 1080));
        jPanel2.setPreferredSize(new java.awt.Dimension(1680, 1080));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        nameIp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        nameIp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        nameIp.setOpaque(true);
        nameIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameIpActionPerformed(evt);
            }
        });
        nameIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameIpKeyReleased(evt);
            }
        });
        jPanel2.add(nameIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 267, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Branch:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Mob no. :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        mbIp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        mbIp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mbIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbIpActionPerformed(evt);
            }
        });
        mbIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mbIpKeyReleased(evt);
            }
        });
        jPanel2.add(mbIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 267, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Std ID :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Blood Gp :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Address :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, -1, -1));

        submit.setBackground(new java.awt.Color(0, 153, 0));
        submit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel2.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, 130, 50));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Gender :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        idIp1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        idIp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        idIp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idIp1ActionPerformed(evt);
            }
        });
        jPanel2.add(idIp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 267, -1));

        branchIp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        branchIp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "IT", "EXTC", "MECH", "CIVIL" }));
        branchIp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        branchIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchIpActionPerformed(evt);
            }
        });
        jPanel2.add(branchIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 267, -1));

        blood.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        blood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "B+", "O+", "O-", "B-", "A-", "AB+" }));
        blood.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 267, -1));

        dateIp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        dateIp.setDateFormatString("d-MM-yyyy");
        dateIp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dateIp.setMaxSelectableDate(new java.util.Date(1127417473000L));
        dateIp.setMinSelectableDate(new java.util.Date(631135873000L));
        dateIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateIpKeyReleased(evt);
            }
        });
        jPanel2.add(dateIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 270, -1));

        pssFld.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        pssFld.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(pssFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 190, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("Password :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 190, 90, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("Date of Birth:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        addId.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(addId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 270, 80));

        cancel.setBackground(new java.awt.Color(204, 0, 0));
        cancel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 130, 50));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setText("Year of Addmission :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        mbIp1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        mbIp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mbIp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbIp1ActionPerformed(evt);
            }
        });
        mbIp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mbIp1KeyReleased(evt);
            }
        });
        jPanel2.add(mbIp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 267, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("Email :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        buttonGroup1.add(otherGbtn);
        otherGbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        otherGbtn.setText("Other");
        otherGbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherGbtnActionPerformed(evt);
            }
        });
        jPanel2.add(otherGbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        buttonGroup1.add(malebtn);
        malebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        malebtn.setText("Male");
        jPanel2.add(malebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setText("Confirm Password:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 260, 160, -1));

        buttonGroup1.add(femalebtn);
        femalebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        femalebtn.setText("Female");
        femalebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femalebtnActionPerformed(evt);
            }
        });
        jPanel2.add(femalebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, -1, -1));

        mobErr.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        mobErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(mobErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 190, 20));

        nameErr.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        nameErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(nameErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 190, 20));

        emailErr.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        emailErr.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(emailErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 150, 20));

        yrIp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022" }));
        yrIp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(yrIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 270, 30));

        cnPssFld.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cnPssFld.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(cnPssFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 290, 190, 30));

        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 100, 30));

        imgPath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(imgPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 250, 20));

        jDesktopPane1.add(imgIp);
        imgIp.setBounds(0, 0, 130, 130);

        jPanel2.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 130, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/idcardgenerator/images/Add a subheading (1).png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>                        
    
   
    
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void branchIpActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void idIp1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        //registerUSer();
        
        
        if(verify()){
           
            insertIntoDb();
            setVisible(false);
            new Home().setVisible(true);
            
        
        }else{
            JOptionPane.showMessageDialog(null, "There's an Error");
        }
        
        
        
         
        

    }                                      

    private void mbIpActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void nameIpActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:

    }                                      

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        JFrame frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame,"Are you sure you want to exit","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            setVisible(false);
            new Home().setVisible(true);
        }
        
        
    }                                      

    private void mbIp1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void otherGbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void femalebtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void nameIpKeyReleased(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
        String PATTERN = "^[a-zA-Z ,]{5,50}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(nameIp.getText());
        if(!match.matches()){
            nameErr.setText("Name is incorrect");
        }else{
            nameErr.setText(null);
        }
        
    }                                  

    private void mbIp1KeyReleased(java.awt.event.KeyEvent evt) {                                  
        // TODO add your  handling code here:
        String PATTERN = "^[0-9]{10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(mbIp1.getText());
        if(!match.matches()){
            mobErr.setText("Mobile no. is incorrect");
        }else{
            mobErr.setText(null);
        }
    }                                 

    private void dateIpKeyReleased(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
        
    }                                  

    private void mbIpKeyReleased(java.awt.event.KeyEvent evt) {                                 
        // TODO add your handling code here:
//        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
          String PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
          Pattern patt = Pattern.compile(PATTERN,Pattern.CASE_INSENSITIVE);
          Matcher match = patt.matcher(mbIp.getText());
         if(!match.matches()){
            emailErr.setText("email not valid");
         }else{
            emailErr.setText(null);
        }
        
    }                                

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpeg","jpg");
        chooser.addChoosableFileFilter(fnwf);
        int load = chooser.showOpenDialog(null);
        if(load==chooser.APPROVE_OPTION){
            //chooser.showOpenDialog(null);
            f = chooser.getSelectedFile();
            try{
               
            
                img =ImageIO.read(new File(f.getAbsolutePath()));
                img1 = img.getScaledInstance(imgIp.getWidth(), imgIp.getHeight(), Image.SCALE_SMOOTH);
                format = new ImageIcon(img1);
                imgIp.setIcon(format);
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        
        filename = f.getAbsolutePath();
        imgPath.setText(filename);
        
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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify                     
    public static javax.swing.JTextField addId;
    public static javax.swing.JComboBox<String> blood;
    public static javax.swing.JComboBox<String> branchIp;
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    public static javax.swing.JTextField cnPssFld;
    public static com.toedter.calendar.JDateChooser dateIp;
    private javax.swing.JLabel emailErr;
    public static javax.swing.JRadioButton femalebtn;
    public static javax.swing.JTextField idIp1;
    private javax.swing.JLabel imgIp;
    private javax.swing.JLabel imgPath;
    public static javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    public static javax.swing.JRadioButton malebtn;
    public static javax.swing.JTextField mbIp;
    public static javax.swing.JTextField mbIp1;
    private javax.swing.JLabel mobErr;
    private javax.swing.JLabel nameErr;
    public static javax.swing.JTextField nameIp;
    public static javax.swing.JRadioButton otherGbtn;
    public static javax.swing.JTextField pssFld;
    public static javax.swing.JButton submit;
    public static javax.swing.JComboBox<String> yrIp;
    // End of variables declaration                   
}
