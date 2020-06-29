package RentalApp.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class AddRoomPage 
{
    public static  String x;

    public static void openAddRoomPage() {
        JFrame f = new JFrame("ADD NEW ROOM");
        JLabel l1 = new JLabel("ROOM ID *");
        l1.setBounds(50,50,180,25);
        f.add(l1);
        JTextField f1 = new JTextField();
        f1.setBounds(200,50,180,25);
        JLabel l2 = new JLabel("Floor");
        l2.setBounds(50,100,180,25);
        f.add(l2);
        JTextField f2 = new JTextField();
        f2.setBounds(200,100,180,25);
        JLabel l3 = new JLabel("ROOM Type *");
        l3.setBounds(50,150,180,25);
        f.add(l3);
        JTextField f3 = new JTextField();
        f3.setBounds(200,150,180,25);
        JLabel l4 = new JLabel("ROOM Rent *");
        l4.setBounds(50,200,180,25);
        f.add(l4);
        JTextField f4 = new JTextField();
        f4.setBounds(200,200,180,25);
        JLabel l5 = new JLabel("ROOM Maintenance *");
        l5.setBounds(50,250,180,25);
        f.add(l5);
        JTextField f5 = new JTextField();
        f5.setBounds(200,250,180,25);
        JLabel l6 = new JLabel("ROOM water bill *");
        l6.setBounds(50,300,180,25);
        f.add(l6);
        JTextField f6 = new JTextField();
        f6.setBounds(200,300,180,25);
        
        f.add(f1);
        f.add(f2);
        f.add(f3);
        f.add(f4);
        f.add(f5);
        f.add(f6);

        JButton submit=new JButton("SUBMIT");
        submit.setBounds(180,400,80,25);
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // save these to database after validation of response
                String query = " insert into rooms (ROOMID ,FLOOR ,ROOMTYPE, RENTAMT ,MAINTENANCE , WATERBILL,STATUS)"
        + " values (?, ?, ?, ?, ?,?,?)";
                try{
                    PreparedStatement st = HomePage.dbConnector.prepareStatement(query);
                    st.setString( 1,f1.getText());
                    st.setInt(2,Integer.parseInt(f2.getText()));
                    st.setString(3,f3.getText());
                    st.setInt(4,Integer.parseInt(f4.getText()));
                    st.setInt(5,Integer.parseInt(f5.getText()));
                    st.setInt(6,Integer.parseInt(f6.getText()));
                    st.setBoolean(7,false);

                    st.executeUpdate();
                }
                catch(Exception a)
                {
                    a.printStackTrace();
                }

               f.dispose();
            }
        });
        f.add(submit);
        
        f.setSize(450,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        f.setLocationRelativeTo(null);
    }

    public static void ModifyRoom()
    {
        JFrame f = new JFrame("Modify Room Details");
        JLabel l1 = new JLabel("ROOM ID *");
        l1.setBounds(50,50,180,25);
        f.add(l1);

        JTextField f1 = new JTextField();
        f1.setBounds(200,50,180,25);
        f.add(f1);

        JButton submit=new JButton("SUBMIT");
        submit.setBounds(180,100,80,25);
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // save these to database after validation of response
                x = f1.getText();
                f.dispose();
                System.out.println("jai");
                PreparedStatement st;
                try {
                    System.out.println("jai");

                    st = HomePage.dbConnector.prepareStatement("SELECT * FROM ROOMS WHERE ROOMID = ? ");
                    System.out.println("jai");
                    st.setString(1,x);
                    System.out.println("jai");
                    ResultSet rs = st.executeQuery();
                    if(rs.next())
                    {
                        ModifyRoomUpdate(x);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"The room Id Not found !\n Add the room in the window");
                        openAddRoomPage();
                    }
                    
                } catch (Exception e1) {

                    e1.printStackTrace();
                }
            
                
                
            }
        });
        f.add(submit);

        f.setSize(500,250);//600 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        f.setLocationRelativeTo(null);

    }


    public static void ModifyRoomUpdate(String room)
    {
        JFrame f = new JFrame("Modify Room Details");
        PreparedStatement st;

        try{
            st = HomePage.dbConnector.prepareStatement("SELECT * FROM ROOMS WHERE ROOMID =? ");
            st.setString(1,x);
            System.out.println("jai");
            ResultSet rs = st.executeQuery();
            JLabel l1 = new JLabel("ROOM ID *");
        l1.setBounds(50,50,180,25);
        f.add(l1);

        JLabel k1 = new JLabel( room );
        k1.setBounds(250,50,180,25);
        f.add(k1);

        JLabel l2 = new JLabel("Floor");
        l2.setBounds(50,100,180,25);
        f.add(l2);
        JLabel f2 = new JLabel(""+ rs.getInt(2));
        f2.setBounds(200,100,180,25);
        JLabel l3 = new JLabel("ROOM Type ");
        l3.setBounds(50,150,180,25);
        f.add(l3);
        JLabel f3 = new JLabel(rs.getString(3));
        f3.setBounds(200,150,180,25);
        JLabel l4 = new JLabel("ROOM Rent ");
        l4.setBounds(50,200,180,25);
        f.add(l4);

        JLabel k2 = new JLabel(""+rs.getFloat(4));
        k2.setBounds(150,200,180,25);
        f2.add(k2);

        JTextField f4 = new JTextField();
        f4.setBounds(250,200,180,25);
        f.add(f4);

        JLabel l5 = new JLabel("Maintenance");
        l5.setBounds(50,250,180,25);
        f.add(l5);

        JLabel k5 = new JLabel(""+rs.getFloat(5));
        k5.setBounds(150,250,180,25);
        f.add(k5);

        JTextField f5 = new JTextField();
        f5.setBounds(250,250,180,25);

        JLabel l6 = new JLabel("water bill");
        l6.setBounds(50,300,180,25);
        f.add(l6);
        
        JLabel k6 = new JLabel(""+rs.getFloat(6));
        k6.setBounds(150,300,180,25);
        f.add(k6);

        JTextField f6 = new JTextField();
        f6.setBounds(250,300,180,25);
        

        f.add(f2);
        f.add(f3);
        f.add(f4);
        f.add(f5);
        f.add(f6);

        JButton submit=new JButton("SUBMIT");
        submit.setBounds(180,400,80,25);
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // save these to database after validation of response
                
                String sql = "UPDATE ROOMS SET RENTAMT = ?, MAINTENANCE = ?,WATERBILL=? WHERE ROOMID = ?";
                try{
                    PreparedStatement st = HomePage.dbConnector.prepareStatement(sql);
                    st.setInt(1,Integer.parseInt(f4.getText()));
                    st.setInt(2,Integer.parseInt(f5.getText()));
                    st.setInt(3,Integer.parseInt(f6.getText()));
                    st.setString(4, room);
                    st.executeUpdate();
                }
                catch(Exception ea)
                {
                    ea.printStackTrace();
                }


               f.dispose();
            }
        });
        f.add(submit);
        
        f.setSize(600,500);//600 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        f.setLocationRelativeTo(null);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        
    }

   
}