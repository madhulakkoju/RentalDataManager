package RentalApp.src;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class PaymentsPage {
    public static void openPaymentsPage() {
        JFrame f = new JFrame("SHOW PAYMENT TRANSACTIONS");
        JTable payments = new JTable();
        try{ 
            Statement st = HomePage.dbConnector.createStatement();
            ResultSet rs = st.executeQuery("SELECT PAYMENTS.ROOMID AS ROOM, TENANTS.NAME AS TENANT_NAME, PAYMENTS.PAYDATE AS DATE, PAYMENTS.PAYAMT AS AMOUNT FROM PAYMENTS INNER JOIN TENANTS ON PAYMENTS.ROOMID = TENANTS.ROOMID ORDER BY PAYMENTS.PAYDATE DESC");
            payments.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane scrollPane = new JScrollPane(payments);
            f.add(scrollPane);
            f.setSize(1000,500);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
        }
        catch(Exception e)
        {
            f.dispose();
            JOptionPane.showMessageDialog(null,"Some error occured");
            e.printStackTrace();
        }
    }
}