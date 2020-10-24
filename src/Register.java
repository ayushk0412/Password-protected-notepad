
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush
 */
public class Register extends JPanel implements ActionListener
{
    JLabel userL = new JLabel("Enter a Username: ");
    JTextField userTF = new JTextField();
    JLabel passL = new JLabel("Enter a Password: ");
    JPasswordField passTF = new JPasswordField();
    JLabel passLC = new JLabel("Re-enter the Password: ");
    JPasswordField passC = new JPasswordField();
    JButton register = new JButton("Register");
    JButton back = new JButton("Back"); 
    
     public Register()
{
JPanel loginP = new JPanel();
loginP.setLayout(new GridLayout(4,2));
loginP.add(userL);
loginP.add(userTF);
loginP.add(passL);
loginP.add(passTF);
loginP.add(passLC);
loginP.add(passC);
loginP.add(register);
loginP.add(back);
register.addActionListener(this);
back.addActionListener(this);
add(loginP);
}
    @Override
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()== register && passTF.getPassword().length >0 && userTF.getText().length() >0)
         {
         String pass = new String(passTF.getPassword());
         String confirm = new String(passC.getPassword());
         if(pass.equals(confirm))
         {
              //TO GET THE FULL CODE, SEND ME A MAIL AT ayushk0412@gmail.com, WITH THE SUBJECT "CODE REQUIRED"
             }
         }
         }
         if(e.getSource()== back)
         {
             Login login = (Login) getParent();
             login.cl.show(login, "login");
         }
     }
}

