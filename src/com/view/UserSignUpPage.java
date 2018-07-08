package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.User;
import com.service.ServiceL;  

public class UserSignUpPage {  
	
	public void add() {  
		
		JFrame f=new JFrame("User SignUp");  
		
	    final JTextField tf1=new JTextField();  
	    final JTextField tf2=new JTextField();  
	    final JTextField tf3=new JTextField();
	    final JTextField tf4=new JTextField();  
	    final JPasswordField tf5 = new JPasswordField();  
	    final JPasswordField tf6 = new JPasswordField();  
	    final JTextField tf7=new JTextField();  
		
	    
	    tf1.setBounds(300,50, 100,30);  
	    tf2.setBounds(300,100, 100,30);
	    tf3.setBounds(300,150, 100,30);  
	    tf4.setBounds(300,200, 100,30);
	    tf5.setBounds(300,250, 100,30);  
	    tf6.setBounds(300,300, 100,30);  
	    tf7.setBounds(300,350, 100,30);  
	    
	    
	    f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);f.add(tf7);

  

	    
	    JLabel l1,l2,l3,l4,l5,l6,l7;
	    
	    l1=new JLabel("UserID");
	    l1.setBounds(50,50, 100,30);
	    l2=new JLabel("First Name");
	    l2.setBounds(50,100, 100,30);  
	    l3=new JLabel("Last Name");
	    l3.setBounds(50,150, 100,30);  
	    l4=new JLabel("Age");
	    l4.setBounds(50,200, 100,30);  
	    l5=new JLabel("Password");  
	    l5.setBounds(50,250, 100,30);  
	    l6=new JLabel("Confrim Password");  
	    l6.setBounds(50,300, 200,30);  
	    l7=new JLabel("Gender");  
	    l7.setBounds(50,350, 100,30);  
	    
	    
	    f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);  
	    
	    
	    JButton b1=new JButton("Submit");  
	    JButton b2=new JButton("Cancel");   
	    
	    b1.setBounds(50,400,95,30);
	    b2.setBounds(150,400,95,30);
	    
	    b1.addActionListener(new ActionListener(){   
		    public void actionPerformed(ActionEvent e){  
		    		
		    	User m = new User();
		    	m.setId(Integer.parseInt(tf1.getText()));
		    	m.setFirst_name(tf2.getText());
		    	m.setLast_name(tf3.getText());
		    	m.setAge(Integer.parseInt(tf4.getText()));
		    	m.setPass(tf5.getText());
		    	m.setGender(tf7.getText());
		    	
		    	ServiceL s = new ServiceL();
		    	if(s.addUser_Srvc(m) != 0){
		    		UserLoginPage usp = new UserLoginPage();
		    		usp.add();
		    		f.dispose();
		    	}
		    }  
	    });
	    
	    b2.addActionListener(new ActionListener(){   
		    public void actionPerformed(ActionEvent e){  
		           UserLoginPage usp = new UserLoginPage();
		           usp.add();
		           f.dispose();
		    }  
	    });

	    
	    f.add(b1);f.add(b2);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  