import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class search implements ActionListener
{

    public static JFrame f=new JFrame("Search Book");
    public static Container c=f.getContentPane();
    public static JLabel bookid,bookname,bookprice,publisher,pages,searching;
    public static JTextField idtxt,nametxt,pricetxt,publishertxt,pagetxt;
    public static JButton search,exit,issue;
    //public static String username;
    search()
    {
      
        f.setBounds(440,100,400,500);
        c.setBackground(new Color(100,200,10,109));
        f.setLayout(null);
        
        searching=new JLabel("SEARCHING  BOOK.....");
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
        
        search=new JButton("Search");
        search.setBounds(30,400,100,30);
        f.add(search);
        search.setBackground(Color.blue);
        search.setForeground(Color.white);
        
        issue=new JButton("Issue");
        issue.setBounds(250,400,100,30);
        f.add(issue);
        issue.setBackground(Color.blue);
        issue.setForeground(Color.white);
        
        exit=new JButton("Exit");
        exit.setBounds(140,400,100,30);
        f.add(exit);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        search.addActionListener(this);
        issue.addActionListener(this);
        
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        
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
        new search();
        
    } 
    @Override
    public void actionPerformed(ActionEvent e2)
    {
        String bookId=idtxt.getText();
        String name,page,price,publisher;
        
        
        try
        {

            Connection conn;
            conn=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/library","root","sagarmatha0school");
            if(e2.getSource()==search)
        {
            PreparedStatement pre=conn.prepareStatement("Select * from book where id='"+bookId+"' ");
            ResultSet rs=pre.executeQuery();
            if(rs.next())
            {
                name=rs.getString(2);
                price=rs.getString(4);
                publisher=rs.getString(3);
                page=rs.getString(5);
                
                nametxt.setText(name);
                publishertxt.setText(publisher);
                pricetxt.setText(price);
                pagetxt.setText(price);
                
            }
            else
            {
              JOptionPane.showMessageDialog(f,"No Book Found");
              pre.close();
              rs.close();
            
            }
        }  
            if(e2.getSource()==issue)
            {
                new issue();
            }
            
            conn.close();
        }catch(Exception exe)
        {   
            
        }
    }
}