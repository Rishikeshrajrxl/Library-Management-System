///////Signup_page////////

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class signup_page implements ActionListener
{   
    public static JFrame f2=new JFrame();
    public static  ImageIcon loginImg=new ImageIcon("G:\\my-java-projects\\images\\loginbtn.png"); 
    public static  ImageIcon submitImg=new ImageIcon("G:\\my-java-projects\\images\\submit.png"); 
    public static Container c1=f2.getContentPane();
    public static JTextField tname=new JTextField();
    public static JTextField temail=new JTextField();
    public static JTextField tphone=new JTextField();
    public static JTextField tusername=new JTextField();
    public static JTextField tpassword=new JTextField();
    public static JButton submit=new JButton("Submit",submitImg);
    public static JButton btnlogin=new JButton(loginImg);
    
    
    signup_page()//constructor
    {
       c1.setBackground(new Color(0,22,123,123)); 
       ImageIcon signupImg=new ImageIcon("G:\\my-java-projects\\images\\signup.png"); 
       JLabel signup=new JLabel(signupImg);
       Font fn1=new Font("Arial",Font.BOLD,25);
       Font fn2=new Font("Arial",Font.BOLD,13);
       
       f2.setIconImage(signupImg.getImage());
       JLabel name=new JLabel("Your Full Name ");
       JLabel create=new JLabel("Create Account ");
       JLabel email=new JLabel("E-mail");
       JLabel phone=new JLabel("Phone No");
       JLabel username=new JLabel("UserName");
       JLabel password=new JLabel("Password");
       JLabel log_in=new JLabel("Already Having Account:");
       
       
       f2.setBounds(400,50,430,600);
       f2.setLayout(null);
       f2.setTitle("Create Account");
       
       create.setBounds(150,50,300,30);
       f2.add(create);
       create.setFont(fn1);   
       
       signup.setBounds(50,4,100,100);
       f2.add(signup);
       
       name.setBounds(60,100,200,30);
       name.setFont(fn2);
       f2.add(name);
       
       tname.setBounds(60,125,290,35);
       f2.add(tname);
       
       email.setBounds(60,170,100,30);
       email.setFont(fn2);
       f2.add(email);
       
       temail.setBounds(60,195,290,35);
       f2.add(temail);
       
       phone.setBounds(60,240,100,30);
       phone.setFont(fn2);
       f2.add(phone);
               
       tphone.setBounds(60,265,290,35);
       f2.add(tphone);
       
       username.setBounds(60,310,100,30);
       username.setFont(fn2);
       f2.add(username);
       
       tusername.setBounds(60,335,290,35);
       f2.add(tusername);
           
       password.setBounds(60,380,100,30);
       password.setFont(fn2);
       f2.add(password);
       
       tpassword.setBounds(60,405,290,35);
       f2.add(tpassword);
       
       submit.setBounds(232,450,118,30);
       submit.setBackground(Color.DARK_GRAY);
       submit.setForeground(Color.WHITE);
       submit.setFont(fn2);
       f2.add(submit);
       
       log_in.setBounds(90,500,300,30);
       f2.add(log_in);
       log_in.setForeground(Color.yellow);
       
       btnlogin.setBounds(250,500,80,30);
       f2.add(btnlogin);
       btnlogin.setBackground(new Color(255,255,255,155));
     
       f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
       
       submit.addActionListener(this);
       
       btnlogin.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent eve)
           {
               //login button
               login_page lp=new login_page ();
               f2.setVisible(false);
           }
       });
       f2.setVisible(true);
       f2.setResizable(false);
               
       f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
       
    }
    public static void main(String args[])
    {
        signup_page sign=new signup_page();
    }
    
    @Override
    //submit button
    public void actionPerformed(ActionEvent ev)
    {
        
        String name,username,phone,password,email;
        name=tname.getText();
        phone=tphone.getText();
        username=tusername.getText();
        password=tpassword.getText();
        email=temail.getText();
        
     if(name.isEmpty())
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
        "jdbc:mysql://localhost:3306/student","root","sagarmatha0school");
        
        //creare statement
        // first check whether the username already exist or not
        PreparedStatement pcheck=conn.prepareStatement("select * from userdetail where username='"+username+"' ");
        ResultSet rs=pcheck.executeQuery();
          if(rs.next())
             {
              JOptionPane.showMessageDialog(f2,"Already exists");  //if exist
             }   
          else  //else insert into database.
             {
        
              PreparedStatement ps=conn.prepareStatement("insert into userdetail values(?,?,?,?,?)");
            //  ResultSet rs=ps.executeQuery();
        
              ps.setString(1, name);
              ps.setString(2,email);
              ps.setString(3,phone);
              ps.setString(4, username);
              ps.setString(5,password);
       
             int i=ps.executeUpdate();
             conn.close();
             ps.close();
             JOptionPane.showMessageDialog(f2,"Account created");
             f2.setVisible(false);
             login_page lp=new login_page ();   //calling the login page
             }
        }catch(Exception ep)
        {
            System.err.println(ep);
        }
       
     }
    }
        
}
