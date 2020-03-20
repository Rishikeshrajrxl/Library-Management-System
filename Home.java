
////Home_page///

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home
{ 
    public static ImageIcon stu=new ImageIcon("G:\\my-java-projects\\images\\student.png");
    public static ImageIcon login2Img=new ImageIcon("G:\\my-java-projects\\images\\login2.png");
    public static ImageIcon aboutImg=new ImageIcon("G:\\my-java-projects\\images\\about.png");
    public static ImageIcon addadminImg=new ImageIcon("G:\\my-java-projects\\images\\admin.png");
    public static ImageIcon adminloginImg=new ImageIcon("G:\\my-java-projects\\images\\adminlogin.png");
    public static JFrame f3=new JFrame();
    public static Container c=f3.getContentPane();
    public static JButton newstudent=new JButton(stu);
    public static JButton login2=new JButton(login2Img);
    public static JButton about=new JButton(aboutImg);
    public static JButton addadmin=new JButton(addadminImg);
    public static JButton adminlogin=new JButton(adminloginImg);
    
    Home()
    {
     // #################################################################################
     // STUDENTS CORNER
        
      ImageIcon i1=new ImageIcon("G:\\my-java-projects\\images\\libfavIcon.png");
      ImageIcon i2=new ImageIcon("G:\\my-java-projects\\images\\lib.png");
      ImageIcon i3=new ImageIcon("G:\\my-java-projects\\images\\library.png");
      ImageIcon lineImg=new ImageIcon("G:\\my-java-projects\\images\\line.png");
      
      JLabel operation=new JLabel("Students Corner");     
      JLabel aboutlevel=new JLabel("About");
      JLabel loginlevel=new JLabel("<html>Student Login</html>");
      JLabel newuser=new JLabel("New Student");
      JLabel lib=new JLabel(i2);
      JLabel line=new JLabel(lineImg);
      JLabel library=new JLabel(i3);
      JLabel l1=new JLabel("Welcome");
      JLabel l2=new JLabel("to");
      JLabel l3=new JLabel("Library Management System");
      f3.setTitle("Libray Management System");  
      Cursor cur=new Cursor(Cursor.HAND_CURSOR);
      Font fn1=new Font("Arial",Font.ITALIC,20);
      Font fn2=new Font("Arial",Font.BOLD,13);
 
      c.setBackground(new Color(100,200,10,100));
      
      lib.setBounds(60,5,60,60); //lobrary logo
      f3.add(lib);
      library.setBounds(10,55,170,50);//library logo
      f3.add(library);
      f3.setBounds(330,90,600,500);
      f3.setIconImage(i1.getImage());
      // c.setBackground(Color.GRAY);
      l1.setBounds(460,10,100,20);  //welcome Jlevel
      f3.add(l1);
      l1.setFont(fn2);
      l2.setFont(fn2);
      l3.setFont(fn2);
      l1.setForeground(Color.blue); 
      l2.setBounds(485,25,50,20);
      f3.add(l2);
      l2.setForeground(Color.blue); //to level
      l3.setBounds(400,40,300,20);  //library management sysytem JLevel
      f3.add(l3);
      l3.setForeground(Color.blue);
      
      line.setBounds(170,160,410,65);//line
      f3.add(line);
          
      operation.setBounds(5,150,200,20);
      f3.add(operation);
      operation.setFont(fn1);
     
      newstudent.setBounds(180,180,90,90);  //new user nutton image
      f3.add(newstudent);
      newstudent.setCursor(cur);
      
      newuser.setBounds(187,270,100,20);    //new user Jlevel
      f3.add(newuser);
      
      login2.setBounds(310,180,90,90);  //login button image
      f3.add(login2);
      login2.setCursor(cur);
      loginlevel.setBounds(315,270,100,20);  //login Jlevel 
      f3.add(loginlevel);
      
      about.setCursor(cur); 
      about.setBounds(440,180,90,90);    //about button 
      f3.add(about);
      aboutlevel.setBounds(475,270,100,20);    //about level
      f3.add(aboutlevel);
      
    // ######################################################################################
     // ###########################################################################################
     // ADMINS CORNER
     
      JLabel operation2=new JLabel("Admins Panel");
      JLabel line2=new JLabel(lineImg);
      JLabel addadminlevel=new JLabel("<html>Add Admin</html>");
      JLabel adminloginlevel=new JLabel("<html> Admin Login</html>");
      
      addadmin.setBounds(180,340,90,90);  //login button image
      f3.add(addadmin);
      addadmin.setCursor(cur);
      addadminlevel.setBounds(190,400,90,90);  //login Jlevel 
      f3.add(addadminlevel);
      
      adminlogin.setBounds(310,340,90,90);  //login button image
      f3.add(adminlogin);
      adminlogin.setCursor(cur);
      adminloginlevel.setBounds(315,400,90,90);  //login Jlevel 
      f3.add(adminloginlevel);
        
      operation2.setBounds(5,310,200,20);
      f3.add(operation2);
      operation2.setFont(fn1);
       
      line2.setBounds(170,320,410,65);//line
      f3.add(line2);
        
      f3.setLayout(null);
      f3.setResizable(false);
      f3.setDefaultCloseOperation(f3.EXIT_ON_CLOSE);
      f3.setVisible(true);  
      
    // ##############################################################################
    
      newstudent.addActionListener(new ActionListener(){    //new user actionListener button
          @Override
          public void actionPerformed(ActionEvent e1)
          {
              student_signup signup=new student_signup();
            //  f3.setVisible(false);
          }
      });
       login2.addActionListener(new ActionListener(){    //login actionListener button
          @Override
          public void actionPerformed(ActionEvent e2)
          {
              student_login login =new student_login();
  //            f3.setVisible(false);
          }
      });  
        about.addActionListener(new ActionListener(){    //About btn actionListener button
          @Override
          public void actionPerformed(ActionEvent e2)
          {
           About ab=new About();
          
          }
      });
        addadmin.addActionListener(new ActionListener(){    //addadmin btn actionListener button
          @Override
          public void actionPerformed(ActionEvent e2)
          {
           admin_signup ad=new admin_signup();
          //f3.setVisible(false);
          
          }
      });
        adminlogin.addActionListener(new ActionListener(){    //admin-login btn actionListener button
          @Override
          public void actionPerformed(ActionEvent e2)
          {
           admin_login al=new admin_login();
           //f3.setVisible(false);
          }
      });
    }
    public static void main(String args [])
    {
        Home hm=new Home();
    }
    
}