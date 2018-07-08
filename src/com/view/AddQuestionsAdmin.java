package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class AddQuestionsAdmin {  
	
	public static void main(String[] args) {  
		
		JFrame f=new JFrame("Add Questions");  
		
	    
	    JLabel l1,l2,l3;  
	    l1=new JLabel("Multiple Choice Questions");  
	    l1.setBounds(50,50, 200,30);
	    l2=new JLabel("Yes NO Questions");  
	    l2.setBounds(50,150, 200,30);  
	    l3=new JLabel("Descriptive  Questions");  
	    l3.setBounds(50,250, 200,30);  

	    
	    f.add(l1);f.add(l2);f.add(l3);  
	    
	    
	    JButton b1,b2,b3;
	    b1=new JButton("Add");  
	    b2=new JButton("Add");  
	    b3=new JButton("Add");  
	    
	    b1.setBounds(350,50,95,30);
	    b2.setBounds(350,150,95,30);
	    b3.setBounds(350,250,95,30);
	    
	    
	    f.add(b1);
	    f.add(b2);
	    f.add(b3);

	    b1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e){  
	        }  
	    });

	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  