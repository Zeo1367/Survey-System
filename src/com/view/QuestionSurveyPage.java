package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class QuestionSurveyPage {  
	
	public static void main(String[] args) {  
		
		JFrame f=new JFrame("Questions");  
		int count = 0;
		boolean flag = true;
	    
		JLabel l;
		
	    	    
	    
	    JButton b1=new JButton("Add");  
	    JButton b2=new JButton("Cancel");  
	    
	    b1.setBounds(250,500,95,30);
	    b2.setBounds(450,500,95,30);
	    b1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e){  
	
	        }  
	    });
	    
	    f.add(b1);f.add(b2);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  