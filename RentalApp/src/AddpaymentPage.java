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
public class AddpaymentPage {
    public static void openAddPaymentPage()
    {
        JFrame f = new JFrame("ADD PAYMENT ");

        JLabel l1 = new JLabel("ROOM ID*");
        JLabel l2 = new JLabel("Bill Date DDMMYYYY *");
        JLabel l3 = new JLabel("PAYMENT Amount *");

        l1.setBounds(50,50,180,25);
        l2.setBounds(50,100,180,25);
        l3.setBounds(50,150,180,25);
        f.add(l1);
        f.add(l2);
        f.add(l3);

        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();
        JTextField f3 = new JTextField();

        f1.setBounds(200,50,180,25);
        f2.setBounds(200,100,180,25);
        f3.setBounds(200,150,180,25);
        f.add(f1);
        f.add(f2);
        f.add(f3);

        JButton submit = new JButton("Submit");
        submit.setBounds(180,200,80,25);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try{
                String  sql = "insert into payments(roomid,paydate,payamt) values(?,?,?)";
                PreparedStatement st = HomePage.dbConnector.prepareStatement(sql);
                st.setString(1,f1.getText());
                st.setString(2,f2.getText());
                st.setInt(3,Integer.parseInt(f3.getText()));
                }
                catch(Exception q)
                {
                    q.printStackTrace();
                }

                f.dispose();
            }
        });




        f.add(submit);

        f.setSize(450,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}