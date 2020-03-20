///////Signup_page////////

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class admin_signup implements ActionListener
{   
    public static JFrame f2=new JFrame();
    public static  ImageIcon loginImg=new ImageIcon("G:\\my-java-projects\\images\\loginbtn.png"); 
    public static  ImageIcon submitImg=new ImageIcon("G:\\my-java-projects\\images\\submit.png"); 
    public static Container c1=f2.getContentPane();
    public static JTextField tname=new JTextField();
  //  public static JTextField temail=new JTextField();
   // public static JTextField tphone=new JTextField();
    public static JTextField tusername=new JTextField();
    public static JPasswordField tpassword=new JPasswordField();
    public static JButton submit=new JButton("Submit",submitImg);
    public static JButton btnlogin=new JButton(loginImg);
    
    
    admin_signup()//constructor
    {
       c1.setBackground(new Color(100,200,10,109)); 
       ImageIcon signupImg=new ImageIcon("G:\\my-java-projects\\images\\signup.png"); 
       JLabel signup=new JLabel(signupImg);
       Font fn1=new Font("Arial",Font.BOLD,25);
       Font fn2=new Font("Arial",Font.BOLD,13);
       
       f2.setIconImage(signupImg.getImage());
       JLabel name=new JLabel("Your Full Name ");
       JLabel create=new JLabel("Create Admin Account ");
      /// JLabel email=new JLabel("E-mail");
      // JLabel phone=new JLabel("Phone No");
       JLabel username=new JLabel("UserName");
       JLabel password=new JLabel("Password");
       JLabel log_in=new JLabel("Already Having Account:");
       
       
       f2.setBounds(360,140,530,400);
       f2.setLayout(null);
       f2.setTitle("Create Account");
       
       create.setBounds(150,40,300,30);
       f2.add(create);
       create.setFont(fn1);   
       
       signup.setBounds(50,4,100,100);
       f2.add(signup);
       
       name.setBounds(60,100,200,30);
       name.setFont(fn2);
       f2.add(name);
       
       tname.setBounds(160,100,290,35);
       f2.add(tname);
       
      /* email.setBounds(60,170,100,30);
       email.setFont(fn2);
       f2.add(email);
       
       temail.setBounds(60,195,290,35);
       f2.add(temail);
       
       phone.setBounds(60,240,100,30);
       phone.setFont(fn2);
       f2.add(phone);
               
       tphone.setBounds(60,265,290,35);
       f2.add(tphone);
       */
       username.setBounds(60,150,100,30);
       username.setFont(fn2);
       f2.add(username);
       
       tusername.setBounds(160,150,290,35);
       f2.add(tusername);
           
       password.setBounds(60,200,100,30);
       password.setFont(fn2);
       f2.add(password);
       
       tpassword.setBounds(160,200,290,35);
       f2.add(tpassword);
       
       submit.setBounds(160,250,118,30);
       submit.setBackground(Color.DARK_GRAY);
       submit.setForeground(Color.WHITE);
       submit.setFont(fn2);
       f2.add(submit);
       
       log_in.setBounds(160,300,300,30);
       f2.add(log_in);
       log_in.setForeground(Color.blue);
       
       btnlogin.setBounds(310,300,80,30);
       f2.add(btnlogin);
       btnlogin.setBackground(new Color(100,200,10,50));
     
       f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
       
       submit.addActionListener(this);
       
       btnlogin.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent eve)
           {
               //login button
             admin_login ad=new admin_login();
               f2.setVisible(false);
           }
       });
       f2.setVisible(true);
       f2.setResizable(false);
               
       f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
       
    }
    public static void main(String args[])
    {
        admin_signup sign=new admin_signup();
    }
    
    @Override
    //submit button
    public void actionPerformed(ActionEvent ev)
    {
        
        String name,username,phone,password,email;
        name=tname.getText();
        //phone=tphone.getText();
        username=tusername.getText();
        password=tpassword.getText();
       // email=temail.getText();
        
     if(name.isEmpty()||username.isEmpty()||password.isEmpty())
     {
           JOptionPane.showMessageDialog(f2,"Fill the Credentials..");
     }
     else
     {
        try
        {
        //creating connection
        Connection conn;
        conn=DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/library","root","sagarmatha0school");
        
        //creare statement
        // first check whether the username already exist or not
        PreparedStatement pcheck=conn.prepareStatement("select * from admindetail where username='"+username+"' ");
        ResultSet rs=pcheck.executeQuery();
          if(rs.next())
             {
              JOptionPane.showMessageDialog(f2,"Already exists");  //if exist
             }   
          else  //else insert into database.
             {
        
              PreparedStatement ps=conn.prepareStatement("insert into admindetail values(?,?,?)");
            //  ResultSet rs=ps.executeQuery();
        
              ps.setString(1, name);
              ps.setString(2, username);
              ps.setString(3,password);
       
             int i=ps.executeUpdate();
             conn.close();
             ps.close();
             JOptionPane.showMessageDialog(f2,"Account created");
             f2.setVisible(false);
             // admin_login lpp=new admin_login();   //calling the login page
             }
        }catch(Exception ep)
        {
            System.err.println(ep);
        }
       
     }
    }
        
}
