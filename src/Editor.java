
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayush
 */
public class Editor extends JPanel implements ActionListener{
    File file;
    JButton save = new JButton("Save");
    JButton savec = new JButton("Save and Close");
    JTextArea text = new JTextArea(80,60);
    public Editor(String s) throws FileNotFoundException, IOException
    {
    file = new File(s);
    save.addActionListener(this);
    savec.addActionListener(this);
    if(file.exists())
    {
    BufferedReader input = new BufferedReader(new FileReader(file));
    String line = input.readLine();
    while(line != null)
    {
    text.append(line+"\n");
    line = input.readLine();
    }
    input.close();
    }
   add(save);
   add(savec);
   add(text);     
    }
  

    
    @Override
    public void actionPerformed(ActionEvent e)
    { 
    
        try {
            FileWriter out = new FileWriter(file);
                    out.write(text.getText());
                    out.close();
                    if(e.getSource()==savec){
                    Login login = (Login) getParent();
                    login.cl.show(login,"fb");
                    }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

}