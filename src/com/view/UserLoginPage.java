package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.User;
import com.service.ServiceL;  

public class UserLoginPage {  
	
	public  void add() {  
		
		JFrame f=new JFrame("User Login");  
		
	    final JTextField tf1 = new JTextField();  
	    JPasswordField tf2 = new JPasswordField();
	    
	    tf1.setBounds(150,50, 100,30);  
	    tf2.setBounds(150,100, 100,30);  
	    
	    JLabel l1,l2,l3;  
	    l1=new JLabel("UserName");  
	    l1.setBounds(50,50, 100,30);  
	    l2=new JLabel("Password");  
	    l2.setBounds(50,100, 100,30);  
	    l3=new JLabel("New User? Signup !");  
	    l3.setBounds(500,50, 200,30); 
	    f.add(l1); f.add(l2);f.add(l3);  
	    
	    
	    JButton b1=new JButton("Submit");  
	    JButton b2=new JButton("Cancel");  
	    JButton b3=new JButton("Signup !");  
	    
	    b1.setBounds(50,200,95,30);
	    b2.setBounds(150,200,95,30);
	    b3.setBounds(500,150,95,30);
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	            
	    		User m = new User();
	    		m.setId(Integer.parseInt(tf1.getText()));
	    		m.setPass(tf2.getText());
	    		int userId=Integer.parseInt(tf1.getText());
	    		ServiceL s = new ServiceL();
	    		if(s.searchUser_srvc(m)){
	    			ViewQuestionUser viewQuestionUser = new ViewQuestionUser();
	    			viewQuestionUser.userID(userId);
	    			UserWorkArea uwa = new UserWorkArea();
	    			uwa.add(userId);
	    			f.dispose();
	    		}
	        }  
	    });
	    b2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		WelcomePage wp = new WelcomePage();
	    		wp.add();
	    		f.dispose();
	    	}  
	    });
	    b3.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	            UserSignUpPage usp = new UserSignUpPage();
	            usp.add();
	            f.dispose();
	        }  
	    });
	    
	    f.add(b1);f.add(b2);f.add(b3);
	    f.add(tf1);f.add(tf2);  
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  