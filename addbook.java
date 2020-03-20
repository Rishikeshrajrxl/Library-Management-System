import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class addbook implements ActionListener
{
    public static JFrame f=new JFrame("Add Book");
    public static Container c=f.getContentPane();
    public static JLabel bookid,bookname,bookprice,publisher,pages,searching;
    public static JTextField idtxt,nametxt,pricetxt,publishertxt,pagetxt;
    public static JButton add,exit;
    addbook()
    {
        f.setBounds(440,100,400,500);
        c.setBackground(new Color(100,200,10,109));
        f.setLayout(null);
        
        searching=new JLabel("Adding BOOK.....");
        searching.setBounds(60,10,150,50);
        f.add(searching);
        searching.setForeground(Color.red);
        
        bookid=new JLabel("BookID : ");
        bookid.setBounds(60,100,100,20);
        f.add(bookid);       
        idtxt=new JTextField();
        idtxt.setBounds(130,100,150,30);
        f.add(idtxt);
        
        bookname=new JLabel("Name : ");
        bookname.setBounds(60,150,100,20);
        f.add(bookname);
        nametxt=new JTextField();
        nametxt.setBounds(130,150,150,30);
        f.add(nametxt);
        
        bookprice=new JLabel("price : ");
        bookprice.setBounds(60,250,100,20);
        f.add(bookprice);
        pricetxt=new JTextField();
        pricetxt.setBounds(130,250,150,30);
        f.add(pricetxt);
        
        publisher=new JLabel("Publisher : ");
        publisher.setBounds(60,200,100,20);
        f.add(publisher);
        publishertxt=new JTextField();
        publishertxt.setBounds(130,200,150,30);
        f.add(publishertxt);
      
        pages=new JLabel("Pages : ");
        pages.setBounds(60,300,100,20);
        f.add(pages);
        pagetxt=new JTextField();
        pagetxt.setBounds(130,300,150,30);
        f.add(pagetxt);
        
        add=new JButton("Add");
        add.setBounds(70,400,100,30);
        f.add(add);
        add.setBackground(Color.blue);
        add.setForeground(Color.white);
        
        exit=new JButton("Exit");
        exit.setBounds(180,400,100,30);
        f.add(exit);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        add.addActionListener(this);
        
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
        new addbook();        
    }
    
    @Override
     public void actionPerformed(ActionEvent e2)
    {
        String name,price,publisher,page,id;
        id=idtxt.getText();
        name=nametxt.getText();
        price=pricetxt.getText();
        publisher=publishertxt.getText();
        page=pagetxt.getText();
        
        
        if(id.isEmpty()||name.isEmpty()||price.isEmpty()||publisher.isEmpty()||page.isEmpty())
        {
            JOptionPane.showMessageDialog(f,"Fill all the Box");
        }else
        {   
          try
        {
        //creating connection
        Connection conn;
        conn=DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/library","root","sagarmatha0school");
        
        //creare statement
        // first check whether the username already exist or not
        PreparedStatement pcheck=conn.prepareStatement("select * from book where id='"+id+"' ");
        ResultSet rs=pcheck.executeQuery();
          if(rs.next())
             {
              JOptionPane.showMessageDialog(f,"Already exists");  //if exist
             }   
          else  //else insert into database.
             {
              PreparedStatement ps=conn.prepareStatement("insert into book values(?,?,?,?,?)");
           
              ps.setString(1, id);
              ps.setString(2,name);
              ps.setString(3,publisher);
              ps.setString(4, price);
              ps.setString(5,page);
       
             int i=ps.executeUpdate();
             conn.close();
             ps.close();
             JOptionPane.showMessageDialog(f,"Added Successfully");
             }
        }catch(Exception ep)
        {
            System.err.println(ep);
        }
        }
    }
}