package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.Admin;
import com.model.SuperAdmin;
import com.service.ServiceL;

public class AdminLoginPage {  
	
	public void add() {  
		
		JFrame f=new JFrame("Admin Login");  
		
	    final JTextField tf1=new JTextField();
	    JPasswordField tf2 = new JPasswordField();
		   
	    tf1.setBounds(150,50, 100,30);  
	    tf2.setBounds(150,100, 100,30);  
	    
	    JLabel l1,l2;  
	    l1=new JLabel("AdminId");  
	    l1.setBounds(50,50, 100,30);  
	    l2=new JLabel("Password");  
	    l2.setBounds(50,100, 100,30);  
	    f.add(l1); f.add(l2);  
	    
	    
	    JButton b1=new JButton("Submit");  
	    JButton b2=new JButton("Cancel");  
	    
	    b1.setBounds(50,200,95,30);
	    b2.setBounds(150,200,95,30);
	    
	    final JTextField tf3 = new JTextField();
	    JPasswordField tf4 = new JPasswordField();
		   
	    tf3.setBounds(550,50, 100,30);  
	    tf4.setBounds(550,100, 100,30);  
	    f.add(tf3);f.add(tf4);
	    JLabel l3,l4;  
	    l3=new JLabel("SuperAdminId");  
	    l3.setBounds(350,50, 100,30);  
	    l4=new JLabel("Password");  
	    l4.setBounds(350,100, 100,30);  
	    f.add(l3); f.add(l4);  
	    
	    
	    JButton b3=new JButton("Submit");  
	    JButton b4=new JButton("Cancel");  
	    
	    b3.setBounds(350,200,95,30);
	    b4.setBounds(450,200,95,30);
	    f.add(b3);f.add(b4);
	    b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	Admin m = new Admin();
		    	m.setId(Integer.parseInt(tf1.getText()));
		    	System.out.println(tf2.getText());
		    	m.setPass(tf2.getText());
				System.out.println(tf2.getText());
		    	m.setIdentity(0);
		    	ServiceL s = new ServiceL();
		    	if(s.searchAdmin_srvc(m)){
		    		
		    		AdminWorkArea awa = new AdminWorkArea();
		    		awa.add();
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
		    	
		    	SuperAdmin superAdmin = new SuperAdmin();
		    	superAdmin.setUsername(tf3.getText());
		    	superAdmin.setPass(tf4.getText());

		    	ServiceL s = new ServiceL();
		    	if(s.searchSuperAdmin_srvc(superAdmin)){
		    		
		    		SuperAdminWorkArea swa = new SuperAdminWorkArea();
		    		swa.add();
		    		f.dispose();
		    	}
		    	
		    }  
	    });
	    b4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	WelcomePage wp = new WelcomePage();
	            wp.add();
	            f.dispose();
		    }  
	    });

	    f.add(b1);f.add(b2);
	    f.add(tf1);f.add(tf2);  
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}

	public static void main(String[] args) {
		AdminLoginPage adminLoginPage = new AdminLoginPage();
		adminLoginPage.add();
	}
}  