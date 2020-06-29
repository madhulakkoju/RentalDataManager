package RentalApp.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddPowerBillPage {
    public static void openAddPowerBillPage()
    {
        JFrame f = new JFrame("ADD POWER BILL");

        JLabel l1 = new JLabel("Meter Number *");
        JLabel l2 = new JLabel("Bill Date DDMMYYYY *");
        JLabel l3 = new JLabel("Bill Amount *");

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

                    String sql = "INSERT INTO POWERBILLS(BILLID,METERID,BILLDATE,BILLAMT,PAYMENTSTATUS) VALUES(?,?,?,?,?)";
                    PreparedStatement st = HomePage.dbConnector.prepareStatement(sql);
                    Statement s2 = HomePage.dbConnector.createStatement();
                    ResultSet r = s2.executeQuery("select max(BILLID) from POWERBILLS");
                    int c = r.getInt(1);
                    st.setInt(1, c+1);
                    st.setString(2, f1.getText());
                    st.setString(3, f2.getText());
                    st.setString(4,f3.getText());
                    st.setBoolean(5,false); // not paid

                    st.executeUpdate();

                    

                    // link the power bill to room and tenant to update balance amounts.
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