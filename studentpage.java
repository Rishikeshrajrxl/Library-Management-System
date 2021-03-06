import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;


class studentpage 
{
    public static JFrame f=new JFrame("Welcome To Student Corner"); 
    public static ImageIcon backImg=new ImageIcon("G:\\my-java-projects\\images\\back.png");
    public static ImageIcon issueImg=new ImageIcon("G:\\my-java-projects\\images\\issuebook.png");
    public static ImageIcon returnImg=new ImageIcon("G:\\my-java-projects\\images\\return.png");
    public static ImageIcon searchImg=new ImageIcon("G:\\my-java-projects\\images\\booksearch.png");
    public static ImageIcon listImg=new ImageIcon("G:\\my-java-projects\\images\\list.png");

    public static Container c=f.getContentPane();
    public static JPanel p1,p2,p3;
    public static JButton backbtn;
    public static JLabel username,listlevel;
    public static JButton issuebtn,returnbtn,exitbtn,searchbtn ,booklist;
    
    studentpage(String name)
    {
        home_p1();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        c.setBackground(Color.blue);
        f.setLayout(null);
        f.setBounds(330,90,600,500);
        f.setResizable(false);
        
        backbtn=new JButton(backImg);
        f.add(backbtn);
        backbtn.setBounds(5,5,30,20);
        JLabel backlevel=new JLabel("Back");
        backlevel.setBounds(40,5,100,20);
        backlevel.setForeground(Color.white);
        f.add(backlevel);
        
        username=new JLabel("Username :  "+name);
        username.setBounds(400,5,100,20);
        username.setForeground(Color.white);
        f.add(username);
        f.setVisible(true);
        
        backbtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e1)
            {
                f.revalidate();
                p2.setVisible(false);
                home_p1();  
                
            }
        });
    }
    public void home_p1()
    {
        p1=new JPanel();
        f.add(p1);
        p1.revalidate();
        p1.setVisible(true);
        p1.setBounds(100,40,500,450);
        p1.setBackground(new Color(200,200,200,200));
        p1.setLayout(null);
        
        issuebtn=new JButton("Issued");
        issuebtn.setBounds(100,100,100,30);
        p1.add(issuebtn);
                
        returnbtn=new JButton("Return");
        returnbtn.setBounds(250,100,100,30);
        p1.add(returnbtn);
        
        JLabel issue=new JLabel(issueImg);
        issue.setBounds(100,5,100,100);
        p1.add(issue);
        
        JLabel listlevel=new JLabel(listImg);
        listlevel.setBounds(250,150,100,100);
        p1.add(listlevel);
        
        JLabel returnlevel=new JLabel(returnImg);
        returnlevel.setBounds(250,5,100,100);
        p1.add(returnlevel);
        
        JLabel booksearch=new JLabel(searchImg);
        booksearch.setBounds(120,180,50,50);
        p1.add(booksearch);
        
        searchbtn=new JButton("Search");
        searchbtn.setBounds(100,240,100,30);
        p1.add(searchbtn);
        
        booklist=new JButton("Books");
        booklist.setBounds(250,240,100,30);
        p1.add(booklist);
        
        exitbtn=new JButton("Exit");
        exitbtn.setBounds(180,370,100,30);
        p1.add(exitbtn);
        
       
        issuebtn.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
                p1.setVisible(false);
                issuefun_p2();
            }
            
        });
        
         returnbtn.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
             p1.setVisible(false);
             returnfun_p3();
            }
            
        });
         exitbtn.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
            
        });
        
         searchbtn.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
                new search();
            }
            
        });
        
        
    }
    public void issuefun_p2()   //panel 2
    { 
        
        p2=new JPanel();
        f.add(p2);
        p2.setVisible(true);
        p2.setBounds(100,40,500,450);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        
        String data[][]={{"101","rishi"},{"102","kesh"}};
        String column[]={"ID","name"};
        JTable jt=new JTable(data,column);
        jt.setBounds(10,100,400,400);
        p2.add(jt);
        
        
        
    }
    public void returnfun_p3()
    {
        p1.removeAll();
        
        p3=new JPanel();
        f.add(p3);
        
        p3.setVisible(true);
        p3.setBounds(100,40,500,450);
        p3.setBackground(Color.red);  
    }
    
    public static void main(String arg[]) 
    {
      studentpage st=new studentpage("Rishi");  
   
    }

    
}