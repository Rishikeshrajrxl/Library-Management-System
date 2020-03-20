


//     starting page

import javax.swing.*;
import java.awt.*;
 
class loading 
{ 
       public static JFrame f5=new JFrame("Loading....");
       public static  JProgressBar pb=new JProgressBar(0,3000);  //progress bar
        
     public void  load()
    {
        ImageIcon loadImg=new ImageIcon("G:\\my-java-projects\\images\\loading.png");
        ImageIcon bookImg=new ImageIcon("G:\\my-java-projects\\images\\booksearch.png");
        JLabel book=new JLabel(bookImg);
        JLabel txt=new JLabel("<html>Smart Library 1.01 </html>");
        JLabel wait=new JLabel("<html>Please Wait..... </html>");
        Container c=f5.getContentPane();
        Font fnt=new Font("Arial",Font.BOLD,20);
        
        book.setBounds(120,180,100,100);
        f5.add(book);
        
        c.setBackground(new Color(100,200,10,109));
        pb.setBounds(70,110,200,30);//progress bar
        pb.setStringPainted(true);
        pb.setBackground(Color.white);
        pb.setForeground(Color.black);
        //pb.setValue(0);
        f5.add(pb);
       
        
        txt.setBounds(70,30,200,50);
        f5.add(txt);
        txt.setForeground(Color.red);
        txt.setFont(fnt);
        
        wait.setBounds(100,150,200,20);
        f5.add(wait);
       
        f5.setBounds(420,140,350,400);
        f5.setIconImage(loadImg.getImage());
       
        f5.setLayout(null);
        f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
        f5.setResizable(false);
        f5.setVisible(true);
     
        int i=0;
        while(i<=3000)
        {
            pb.setValue(i);
            i+=20;
            try{
                Thread.sleep(70);       
            }catch(Exception e)
            {               
            }
        }     
    }
    public static void main (String args[])
    {
        loading lod=new loading();
        lod .load();
        f5.setVisible(false);
        Home h=new Home();
        
      
    }
    
}