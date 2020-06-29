package RentalApp.src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.*;


import net.proteanit.sql.DbUtils;

class HomePage {
    public static Connection dbConnector;

    public static void createDBLayout() {
        try {
            
            Statement stmt = dbConnector.createStatement();
            
            String sql1 = "CREATE TABLE ROOMS(ROOMID VARCHAR(5) NOT NULL PRIMARY KEY,FLOOR INT, ROOMTYPE VARCHAR(5),METERID VARCHAR(15) NOT NULL UNIQUE ,RENTAMT INT NOT NULL,MAINTENANCE INT NOT NULL, WATERBILL INT NOT NULL , STATUS BOOLEAN)";
            stmt.executeUpdate(sql1);
            System.out.println("Created successfully");
            sql1 = "CREATE TABLE TENANTS(TNTID INTEGER PRIMARY KEY  , ROOMID VARCHAR(5),STARTDATE DATE NOT NULL , NAME VARCHAR(30) NOT NULL,EMAIL VARCHAR(30), MOBILE1 VARCHAR(11),MOBILE2 VARCHAR(11),MOBILE3 VARCHAR(11),ADVANCE INT NOT NULL, BALANCEAMT INT NOT NULL, STATUS BOOLEAN)";
            stmt.executeUpdate(sql1);
            System.out.println("Created successfully");
            sql1 = "CREATE TABLE POWERCONNECTION(ROOMID VARCHAR(5) NOT NULL, METERID VARCHAR(10) NOT NULL )";
            stmt.executeUpdate(sql1);
            System.out.println("Created successfully");
            sql1 = "CREATE TABLE POWERBILLS(BILLID INTEGER PRIMARY KEY  , METERID VARCHAR(5) NOT NULL ,BILLDATE DATE, BILLAMT INT NOT NULL, PAYMENTSTATUS BOOLEAN)";
            stmt.executeUpdate(sql1);

            System.out.println("Created successfully");
            
             sql1 = "CREATE TABLE PAYMENTS(ROOMID VARCHAR(5) NOT NULL ,PAYDATE DATE, PAYAMT INT NOT NULL)";
            stmt.executeUpdate(sql1);
            
            sql1 = "CREATE TABLE ISSUES(ROOMID VARCHAR(5) NOT NULL ,ISSUEDATE DATE, ISSUE_DESCRIPTION TEXT,BUDGET INT ,STATUS BOOLEAN)";
            stmt.executeUpdate(sql1);

            System.out.println("Created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
            System.out.println(e.getStackTrace());
        }

    }

    public static void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnector = DriverManager.getConnection("jdbc:sqlite:rentalApptest2db.db");
            System.out.println("Database created");
            dbConnector.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + "           no");
        } finally {
            System.out.println("return");
        }
        //createDBLayout();
    }

    public static void openHomePage()
    {
        JFrame f = new JFrame("Home Page");

        JButton addRoom =new JButton("ADD ROOM");
        addRoom.setBounds(90,50,180,25);
        addRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //f.setVisible(false);
                AddRoomPage.openAddRoomPage();
                //f.setVisible(true);
                return;
            }
        });
        f.add(addRoom);

        JButton addTenant =new JButton("ADD TENANT");
        addTenant.setBounds(90,100,180,25);
        addTenant.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                AddTenantPage.openAddTenantPage();
            }
        });
        f.add(addTenant);

        JButton addPowerBill =new JButton("ADD POWER BILL");
        addPowerBill.setBounds(90,150,180,25);
        addPowerBill.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                AddPowerBillPage.openAddPowerBillPage();
            }
        });
        f.add(addPowerBill);

        JButton showRooms =new JButton("SHOW ROOMS");
        showRooms.setBounds(90,200,180,25);
        showRooms.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                RoomsPage.openRoomsPage();
            }
        });
        f.add(showRooms);

        JButton showTenants =new JButton("SHOW Tenants");
        showTenants.setBounds(90,250,180,25);
        showTenants.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                TenantsPage.openTenantsPage();
            }
        });
        f.add(showTenants);

        JButton showPayments =new JButton("SHOW Payments");
        showPayments.setBounds(90,300,180,25);
        showPayments.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                PaymentsPage.openPaymentsPage();
            }
        });
        f.add(showPayments);

        JButton AddPayments =new JButton("Add Payment");
        AddPayments.setBounds(300,50,180,25);
        AddPayments.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                AddpaymentPage.openAddPaymentPage();
            }
        });
        f.add(AddPayments);

        JButton generateQuote =new JButton("Generate Quote");
        generateQuote.setBounds(300,100,180,25);
        generateQuote.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                GenerateQuotePage.openQuotePage();
            }
        });
        f.add(generateQuote);

        JButton generateAllQuote =new JButton("Generate All Quotes");
        generateAllQuote.setBounds(300,150,180,25);
        generateAllQuote.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                GenerateQuotePage.openAllQuotesPage();
            }
        });
        f.add(generateAllQuote);
        
        JButton issues =new JButton("See Issues");
        issues.setBounds(300,200,180,25);
        issues.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                IssuesPage.openAllIssuesPage();
            }
        });
        f.add(issues);

        JButton closeissues =new JButton("close Issue");
        closeissues.setBounds(300,250,180,25);
        closeissues.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                IssuesPage.openCloseIssuePage();
            }
        });
        f.add(closeissues);

        JButton closedissues =new JButton("Closed Issues");
        closedissues.setBounds(300,300,180,25);
        closedissues.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                IssuesPage.openAllClosedIssues();
            }
        });
        f.add(closedissues);

        JButton Addissues =new JButton("Add Issues");
        Addissues.setBounds(300,350,180,25);
        Addissues.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                IssuesPage.AddIssues();
            }
        });
        f.add(Addissues);


        JButton modify =new JButton("Modify rent");
        modify.setBounds(90,350,180,25);
        modify.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                AddRoomPage.ModifyRoom();
            }
        });
        f.add(modify);



        f.setSize(600,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        f.setLocationRelativeTo(null);
    }
    
    public static void login()
    {
        JFrame f=new JFrame("Login");//creating instance of JFrame  
        JLabel l1,l2;  
        l1=new JLabel("Username");  //Create label Username
        l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
        l2=new JLabel("Password");  //Create label Password
        l2.setBounds(30,50, 100,30);    
     
        JTextField F_user = new JTextField(); //Create text field for username
        F_user.setBounds(110, 15, 200, 30);
         
        JPasswordField F_pass=new JPasswordField(); //Create text field for password
        F_pass.setBounds(110, 50, 200, 30);
       
        JButton login_but=new JButton("Login");//creating instance of JButton for Login Button
        login_but.setBounds(130,90,80,25);//Dimensions for button
        login_but.addActionListener(new ActionListener() {  //Perform action
         
        public void actionPerformed(ActionEvent e){ 
 
        String username = F_user.getText(); //Store username entered by the user in the variable "username"
        String password = F_pass.getText(); //Store password entered by the user in the variable "password"
         
        if(username.equals("")) //If username is null
        {
            JOptionPane.showMessageDialog(null,"Please enter username"); //Display dialog box with the message
        } 
        else if(password.equals("")) //If password is null
        {
            JOptionPane.showMessageDialog(null,"Please enter password"); //Display dialog box with the message
        }
        else if( username.equals("admin") && password.equals("admin") )
        {
            f.dispose();
            JOptionPane.showMessageDialog(null,"Logged in");
            System.out.println("Login succesful disposed");
            openHomePage();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Wrong credentials");
        }
    }               
    });
 
     
    f.add(F_pass); //add password
    f.add(login_but);//adding button in JFrame  
    f.add(F_user);  //add user
    f.add(l1);  // add label1 i.e. for username
    f.add(l2); // add label2 i.e. for password
     
    f.setSize(400,180);//400 width and 500 height  
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible 
    f.setLocationRelativeTo(null);
     
    }
    public static void main(String args[]) {
        System.out.println("main");
        createConnection();
        login();

    }
}