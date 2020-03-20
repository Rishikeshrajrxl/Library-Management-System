///Login_page

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class admin_login implements ActionListener
{
    public static JFrame f1=new JFrame();
    public static Container c=f1.getContentPane();
    public static JTextField txt1=new JTextField();
    public static JPasswordField txt2=new JPasswordField();
    public static JButton btncreate=new JButton("SignUp");
    public static String s1;
    public static String s2;
    
    admin_login()
    {
        reset();    //clear the pre-entered data from the TextBox.
        f1.setBounds(440,150,370,400);
        c.setBackground(new Color(100,200,10,109));
        ImageIcon loginImg=new ImageIcon("G:\\my-java-projects\\images\\loginbtn.png");
        f1.setIconImage(loginImg.getImage());
        JLabel l3=new JLabel("<html>Admin<br>Login...</html>");
        Font fnt=new Font("Arial",Font.BOLD,30);
        Font fn=new Font("Arial",Font.BOLD,15);
        JLabel l1=new JLabel("UserName");
        JLabel l2=new JLabel("Password");
        JLabel create=new JLabel("Create Account:");
        ImageIcon userImg=new ImageIcon("G:\\my-java-projects\\images\\user.png");
        JLabel user=new JLabel(userImg);
        
        
        ImageIcon keyImg=new ImageIcon("G:\\my-java-projects\\images\\key.png");
        ImageIcon lockImg=new ImageIcon("G:\\my-java-projects\\images\\lock.png");
        JLabel key=new JLabel(keyImg);
        JLabel lock=new JLabel(lockImg);
        
        
        create.setForeground(Color.black);
        f1.setTitle("Login");
      
        
        JButton btn=new JButton(loginImg);
        l3.setBounds(95,05,200,100);
        f1.add(l3);
        l3.setFont(fnt);
        
        user.setBounds(30,25,50,50);
        f1.add(user);
        l1.setBounds(100,120,100,30);
        f1.add(l1);
        l1.setFont(fn);
        
        txt1.setBounds(100,145,200,30);
        f1.add(txt1);
        lock.setBounds(40,140,30,30);
        f1.add(lock);
        
        l2.setBounds(100,180,100,30);
        l2.setFont(fn);
        f1.add(l2);
        
        txt2.setBounds(100,205,200,30);
        f1.add(txt2);
        key.setBounds(40,205,30,30);
        f1.add(key);
        
        
        btn.setBounds(229,250,70,30);
        f1.add(btn);
        btn.setBackground(new Color(100,200,10,10));
       // btn.setForeground(Color.DARK_GRAY);
        btn.setFont(fn);
        
        create.setBounds(100,320,300,30);
        f1.add(create);
        
        btncreate.setBounds(200,326,100,20);
        btncreate.setBackground(Color.DARK_GRAY);
        btncreate.setForeground(Color.WHITE);
        f1.add(btncreate);
        
        btn.addActionListener(this);
        btncreate.addActionListener(new ActionListener()
        {
            @Override
            //signup button
            public void actionPerformed(ActionEvent ev)
            {
               admin_signup sign=new  admin_signup();
                f1.setVisible(false);
            }
        });
         
       
        
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);
        
    }
    public void reset()
    {
        txt1.setText(null);
        txt2.setText(null);
    }
    
    public static void main(String args[])
    {
        admin_login login=new admin_login();
       
    }

    //login button
    @Override
    public void actionPerformed(ActionEvent e)
    {
       
       s1=txt1.getText();
       s2=txt2.getText();
       
    if(s1.isEmpty())
    {
        JOptionPane.showMessageDialog(f1,"Invalid Login");
    }
    else
    {
       
       try 
       {
           //creating connection
           Connection conn;
           conn=DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/library","root","sagarmatha0school");
           
           //creating statements
           //checking username and password
           PreparedStatement ps=conn.prepareStatement("select * from admindetail where username='"+s1+"' AND password='"+s2+"' ");
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
             //  JOptionPane.showMessageDialog(f1,"Login Successful");
               f1.setVisible(false);         
             //  Home h =new Home();  //calling Home page.
                 adminpage ad=new adminpage(s1);
               
           }else
           {
               JOptionPane.showMessageDialog(f1,"Invalid Login");
               txt1.setText(" ");
               txt2.setText(" ");      
           }
             
           conn.close();
           ps.close();
           rs.close();
           
           
       }catch(Exception ex)
       {
           System.err.println(e);
       }
      
       
    }
    }
    
    
}