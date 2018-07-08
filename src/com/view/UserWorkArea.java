package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class UserWorkArea {  
	
	public void add(int userId) {  
		
		JFrame f=new JFrame("User WorkArea");  
		
	    final JTextField tf1 = new JTextField();	    
	    tf1.setBounds(300,50, 200,30);  
	    f.add(tf1);
		
	    JLabel l1;  
	    l1=new JLabel("Enter SurveyID to give Survey");  
	    l1.setBounds(50,50, 200,30);  

	    f.add(l1);
	    
	    JButton b1=new JButton("Start Survey");  
	    

	    
	    b1.setBounds(50,100,195,30);
	    
	    b1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e){  
	    	ViewQuestionUser p=new ViewQuestionUser();
	    	p.view(Integer.parseInt(tf1.getText()));
	    	f.dispose();
	            
	        }  
	    });
	    
	    f.add(b1);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  
