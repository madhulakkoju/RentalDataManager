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
import RentalApp.src.HomePage;

public class TenantsPage {
    public static void openTenantsPage() {
        JFrame f = new JFrame("SHOW TENANTS");
        JTable tnts = new JTable();
        try{
            System.out.println("jai");
            Statement st = HomePage.dbConnector.createStatement();
            
            System.out.println("jai");
            ResultSet rs = st.executeQuery("SELECT TNTID , ROOMID , STARTDATE  , NAME ,EMAIL , MOBILE1 ,MOBILE2,MOBILE3,ADVANCE , BALANCEAMT, STATUS FROM TENANTS");
            System.out.println("jai");
            tnts.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println("jai");
            JScrollPane scrollPane = new JScrollPane(tnts);
            System.out.println("jai");
            f.add(scrollPane);
            f.setSize(1000,500);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
        }
        catch(Exception e)
        {
            f.dispose();
            JOptionPane.showMessageDialog(null,"Some error occured");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}