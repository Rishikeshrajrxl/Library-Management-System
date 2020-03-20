import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class issue implements ActionListener
{

    public static JFrame f=new JFrame("Search Book");
    public static Container c=f.getContentPane();
    public static JLabel bookid,bookname,bookprice,publisher,pages,searching;
    public static JTextField idtxt,nametxt,pricetxt;
    public static JButton exit,issue;
    //public static String username;
    issue()
    {
      
        f.setBounds(440,150,400,350);
        c.setBackground(new Color(100,200,10,109));
        f.setLayout(null);
        
        searching=new JLabel("Issue BOOK.....");
        searching.setBounds(60,10,150,50);
        f.add(searching);
        searching.setForeground(Color.red);
        
        bookid=new JLabel("Username : ");
        bookid.setBounds(60,100,100,20);
        f.add(bookid);
        idtxt=new JTextField();
        idtxt.setBounds(130,100,150,30);
        f.add(idtxt);
        
        bookname=new JLabel("BookId : ");
        bookname.setBounds(60,150,100,20);
        f.add(bookname);
        nametxt=new JTextField();
        nametxt.setBounds(130,150,150,30);
        f.add(nametxt);
        
        bookprice=new JLabel("BookName : ");
        bookprice.setBounds(60,200,100,20);
        f.add(bookprice);
        pricetxt=new JTextField();
        pricetxt.setBounds(130,200,150,30);
        f.add(pricetxt);
        
        
        
        
        
        issue=new JButton("Issue");
        issue.setBounds(60,250,100,30);
        f.add(issue);
        issue.setBackground(Color.blue);
        issue.setForeground(Color.white);
        
        exit=new JButton("Exit");
        exit.setBounds(180,250,100,30);
        f.add(exit);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        
        issue.addActionListener(this);
        
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e1)
            {
                System.exit(0);
            }
        });
    }
    public static void main(String args[])
    {
        new issue();
        
    } 
    @Override
    public void actionPerformed(ActionEvent e2)
    {
        String bookId=idtxt.getText();
        String name,price;
        name=nametxt.getText();
        price=pricetxt.getText();
                
     
       if(name.isEmpty()|| bookId.isEmpty()|| price.isEmpty())
     {
           JOptionPane.showMessageDialog(f,"Fill the Credentials..");
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
        
       PreparedStatement p1=conn.prepareStatement("select * from studentdetail where username='"+bookId+"'");
       ResultSet r1=p1.executeQuery();
       if(r1.next())//checking username
       {
       PreparedStatement pcheck=conn.prepareStatement("select * from book where id='"+name+"' ");
        ResultSet rs=pcheck.executeQuery();
          if(rs.next()) //checking bookid
             {
              PreparedStatement ps=conn.prepareStatement("insert into issuedbook values(?,?,?)");
            //  ResultSet rs=ps.executeQuery();
        
              ps.setString(1, bookId);
              ps.setString(2,name);
              ps.setString(3,price);
       
             int i=ps.executeUpdate();
             conn.close();
             ps.close();
             JOptionPane.showMessageDialog(f,"Issued Successfully..");
             f.setVisible(false);
             
             }   
          else  //else insert into database.
             {
              JOptionPane.showMessageDialog(f,"No Book For This ID Found !");
            // student_login lp=new student_login ();   //calling the login page
             }
       }
       else
       {
           JOptionPane.showMessageDialog(f,"Invalid Username");
       }
        }catch(Exception ep)
        {
            System.err.println(ep);
        }
       
     }
    }
}