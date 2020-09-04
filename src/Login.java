
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayush
 */
public class Login  extends JPanel implements ActionListener
{
    JLabel userL = new JLabel("USERNAME: ");
    JTextField userTF = new JTextField();
   JLabel passL = new JLabel("PASSWORD: ");
    JPasswordField passTF = new JPasswordField();
    JPanel loginP = new JPanel(new GridLayout(4,4));
    JPanel panel = new JPanel();
    JButton login = new JButton("LogIn");
    JButton register = new JButton("Register");
    CardLayout cl;
    Login()
    {
        setLayout(new CardLayout());
      
        loginP.add(userL);
        loginP.add(userTF); 
        loginP.add(passL); 
        loginP.add(passTF); 
        login.addActionListener(this);
        register.addActionListener(this);
        loginP.add(login);
        loginP.add(register);
        panel.add(loginP);
        add(panel, "login");
        cl = (CardLayout) getLayout();

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==login)
        {
            try {
                BufferedReader input = new BufferedReader(new FileReader("passwords.txt"));
                String pass = null;
                String line = input.readLine();
                while(line != null)
                {
                StringTokenizer st = new StringTokenizer(line);
                if(userTF.getText().equals(st.nextToken()))
                    pass = st.nextToken();
                line = input.readLine();
                }
                input.close();
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException ex) {
                  
                }
                 md.update(new String(passTF.getPassword()).getBytes());//add pass bytes to digest
                 byte byteData[]=md.digest(); //get hash byte // currently iske paas bytes decimal me hai
                 StringBuffer sb = new StringBuffer(); //convert karega hex me
                 for(int i =0; i < byteData.length; i++)
                    sb.append(Integer.toString((byteData[i] & 0xFF) + 0x100, 16).substring(1)); //conversion in hexa
            if(pass.equals(sb.toString()))
            { 
                add(new FileBrowser(userTF.getText()),"fb");
                cl.show(this,"fb");
            }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        if(e.getSource()==register)
        {
        add(new Register(), "register");
        cl.show(this, "register");
        }
    }
    public static void main(String []ar)
    {
    JFrame frame = new JFrame("Text Editor");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700,600);
    
    
    Login login = new Login();
    frame.add(login);
    frame.setVisible(true);
    

}
}