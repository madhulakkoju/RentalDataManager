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

public class AddTenantPage 
{
    public static void openAddTenantPage() {
        JFrame f = new JFrame("ADD NEW TENANT");
        
        JLabel l1 = new JLabel("ROOM ID *");
        l1.setBounds(50,50,180,25);
        f.add(l1);

        JTextField f1 = new JTextField();
        f1.setBounds(200,50,180,25);

        JLabel l2 = new JLabel("DATE-DDMMYYYY *");
        l2.setBounds(50,100,180,25);
        f.add(l2);

        JTextField f2 = new JTextField();
        f2.setBounds(200,100,180,25);

        JLabel l3 = new JLabel("NAME *");
        l3.setBounds(50,150,180,25);
        f.add(l3);

        JTextField f3 = new JTextField();
        f3.setBounds(200,150,180,25);

        JLabel l4 = new JLabel("EMAIL *");
        l4.setBounds(50,200,180,25);
        f.add(l4);

        JTextField f4 = new JTextField();
        f4.setBounds(200,200,180,25);

        JLabel l5 = new JLabel("MOBILE 1 *");
        l5.setBounds(50,250,180,25);
        f.add(l5);

        JTextField f5 = new JTextField();
        f5.setBounds(200,250,180,25);

        JLabel l6 = new JLabel("MOBILE 2");
        l6.setBounds(50,300,180,25);
        f.add(l6);

        JTextField f6 = new JTextField();
        f6.setBounds(200,300,180,25);

        JLabel l7 = new JLabel("MOBILE 3");
        l7.setBounds(50,350,180,25);
        f.add(l7);

        JTextField f7 = new JTextField();
        f7.setBounds(200,350,180,25);

        JLabel l8 = new JLabel("ADVANCE AMT *");
        l8.setBounds(50,400,180,25);
        f.add(l8);

        JTextField f8 = new JTextField();
        f8.setBounds(200,400,180,25);

        f.add(f1); //room id
        f.add(f2); // date
        f.add(f3); //name
        f.add(f4);//email
        f.add(f5);//mobile
        f.add(f6);
        f.add(f7);
        f.add(f8);//advance


        JButton submit=new JButton("SUBMIT");
        submit.setBounds(180,450,80,25);
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // save these to database after validation of response
                try{
                    String sql = "INSERT INTO TENANTS(TNTID,ROOMID,STARTDATE,NAME,EMAIL,MOBILE1,MOBILE2,MOBILE3,ADVANCE,BALANCEAMT,STATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement st = HomePage.dbConnector.prepareStatement(sql);
                    Statement s2 = HomePage.dbConnector.createStatement();
                    ResultSet rs = s2.executeQuery("select MAX(TNTID) from tenants");
                    int a = rs.getInt(1);
                    st.setInt(1,a+1);
                    st.setString(2,f1.getText());
                    Date date1=new SimpleDateFormat("ddMMyyyy").parse(f2.getText());  
                    st.setString(3,date1.toString());
                    st.setString(4,f3.getText());
                    st.setString(5,f4.getText());
                    st.setString(6,f5.getText());
                    st.setString(7,f6.getText());
                    st.setString(8,f7.getText());
                    st.setInt(9,Integer.parseInt(f8.getText()));
                    st.setInt(10,0);
                    st.setBoolean(11,true);

                    st.executeUpdate();


                    sql = "UPDATE ROOMS SET STATUS = ? WHERE ROOMID = ?";
                    st = HomePage.dbConnector.prepareStatement(sql);
                    st.setBoolean(1,true);
                    st.setString(2,f1.getText());
                    st.executeUpdate();


                }catch(Exception q)
                {
                    q.printStackTrace();
                }
                

               f.dispose();
            }
        });
        f.add(submit);
        


        f.setSize(450,600);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        f.setLocationRelativeTo(null);
    }


}