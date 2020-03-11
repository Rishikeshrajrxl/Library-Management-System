
/////About page////
import javax.swing.*;
import java.awt.*;

class About
{
    
    About()
    {
        ImageIcon aboutImg=new ImageIcon("G:\\my-java-projects\\images\\about.png");//favImage
        ImageIcon profileImg=new ImageIcon("G:\\my-java-projects\\images\\profile.png");//profile Image
        JFrame f4=new JFrame("About");
        JLabel profile=new JLabel(profileImg);
        Container c=f4.getContentPane();
        JLabel txt1=new JLabel("<html>Library  Management  System<br> Version 1.01<br> Copyright @2020<br><br><br>"
                + "Contact: rishikeshrajrxl@gmail.com<br> Github: https://github.com/Rishikeshrajrxl<br>"
                + "Website: rishikeshraj.com</html>");
        
        
        profile.setBounds(40,60,120,150);
        f4.add(profile);
        
        c.setBackground(new Color(100,200,10,109));
        txt1.setBounds(230,40,290,200);
        f4.add(txt1);
        
        f4.setIconImage(aboutImg.getImage());    //favIcon
        //c.setBackground(Color.gray);
        f4.setBounds(400,190,500,280);
        f4.setLayout(null);
        f4.setDefaultCloseOperation(f4.EXIT_ON_CLOSE);
        f4.setResizable(false);
        f4.setVisible(true);
        
    }
    public static void main(String args[])
    {
      loading ld=new loading();
      
    }
}