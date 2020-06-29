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
public class GenerateQuotePage {
    public static void openQuotePage()
    {
        JFrame f = new JFrame("QUOTE GENERATION");

        JLabel l1 = new JLabel("ROOM ID *");

        l1.setBounds(50,50,180,25);
        f.add(l1);
        JTextField f1 = new JTextField();
        f1.setBounds(180,50,180,25);
        f.add(f1);
        
        JButton submit = new JButton("Submit");
        submit.setBounds(180,100,80,25);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {

                // generate Quote and show in another frame. 
                // add 2 buttons one to send mail and one to close.

                f.dispose();
            }
        });

        f.add(submit);

        f.setSize(400,200);
        f.setLayout(null);
        f.setVisible(true);
    
    }

    public static void openAllQuotesPage()
    {
        // generate all quotes 
        
        // show the quotes data in tables

        // add 2 buttons to send mails and to just save the info.
    }
}