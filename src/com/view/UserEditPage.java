package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class UserEditPage {  
	
	public static void main(String[] args) {  
		
		JFrame f=new JFrame("Admin WorkArea");  
		
	    final JTextField tf1 = new JTextField();	    
	    tf1.setBounds(50,100, 200,30);  
	    f.add(tf1);
		
	    JLabel l1, l2;  
	    l1=new JLabel("Enter UserID to Delete");  
	    l1.setBounds(50,50, 200,30);  
	    l2=new JLabel("View Users");  
	    l2.setBounds(50,150, 200,30);  

	    f.add(l1); f.add(l2);
	    
	    JButton b1=new JButton("Delete");  
	    JButton b2=new JButton("View");  
	    

	    
	    b1.setBounds(300,100,195,30);
	    b2.setBounds(300,150,195,30);
	    
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