package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class WelcomePage {  
	
	public void add(){	
		JFrame frame=new JFrame("Button Example");
		
	 	
	    JLabel jLabel,jLabel1,jLabel2;
	    jLabel = new JLabel("Welcome To DC Survey System");
	    jLabel1 = new JLabel("Click here to login as a User");
	    jLabel2 = new JLabel("Click here to login as a Admin");
	    
	    
	    jLabel.setBounds(50,50, 600,80);
	    jLabel1.setBounds(50,150, 500,30);
	    jLabel2.setBounds(50,200, 500,30);
	    frame.add(jLabel);frame.add(jLabel1); frame.add(jLabel2);
	    
	    
	    JButton b1=new JButton("USER");
	    JButton b2=new JButton("ADMIN");
	    
	    b1.setBounds(600,150,95,30);
	    b2.setBounds(600,200,95,30);
	    
	    b2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminLoginPage adminLoginPage = new AdminLoginPage();
	    		adminLoginPage.add();
	    		frame.dispose();
	    	}  
	    });
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		UserLoginPage userLoginPage = new UserLoginPage();
	    		userLoginPage.add();
	    		frame.dispose();
	    	}  
	    });

	    frame.add(b1);frame.add(b2);
	    
	    frame.setSize(800,600);  
	    frame.setLayout(null);  
	    frame.setVisible(true);   
	}

	public static void main(String[] args) {
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.add();
	}
}  