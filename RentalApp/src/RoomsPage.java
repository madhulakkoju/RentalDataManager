package RentalApp.src;

import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class RoomsPage {
    
    public static void openRoomsPage() {
        JFrame f = new JFrame(" ALL ROOMS Details");
        JTable rooms = new JTable();
        try{ 
            Statement st = HomePage.dbConnector.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ROOMS");
            rooms.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane scrollPane = new JScrollPane(rooms);
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