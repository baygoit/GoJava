

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class HelloWord extends JFrame{
		
public HelloWord (){	
      final JLabel label;
	  label = new JLabel();
	  label.setText("Hello world");
	  add(label);
	  label.setBounds(105, 79, 190, 40);
	  label.setFont(new Font("Nanum Myeongjo", Font.BOLD, 35));
	
	  setSize(400,250);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setTitle("Firs program on GoIt");
	  setLocationRelativeTo(null);
	  setLayout(null);
	  setVisible(true);
      setResizable(false);
	  label.setText("Hello world");	
 }	
	  public static void main(String[] args) {
		new HelloWord();	
     }
}
