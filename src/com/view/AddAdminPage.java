package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.Admin;
import com.service.ServiceL;  

public class AddAdminPage {  
	
	public void add() {  
		
		JFrame f=new JFrame("SuperAdmin(Add Admin)");  
		
		final JTextField tf1 = new JTextField();  
		final JTextField tf2 = new JTextField();  
		JPasswordField tf3 = new JPasswordField();
		JPasswordField tf4 = new JPasswordField();
		final JTextField tf5 = new JTextField();  
		 
	    tf1.setBounds(300,50, 100,30);  
	    tf2.setBounds(300,150, 100,30);  
	    tf3.setBounds(300,250, 100,30);  
	    tf4.setBounds(300,350, 100,30);  
	    tf5.setBounds(300,450, 100,30);
	    
	    f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);
		
	    JLabel l1,l2,l3,l4,l5;  
	    l1=new JLabel("Admin ID");  
	    l1.setBounds(50,50, 200,30);  
	    l2=new JLabel("Admin Name");  
	    l2.setBounds(50,150, 200,30);
	    l3=new JLabel("Admin Password");  
	    l3.setBounds(50,250, 200,30);  
	    l4=new JLabel("Confirm Password");  
	    l4.setBounds(50,350, 200,30);  
	    l5=new JLabel("Identity (0 - Admin/ 1 - SuperAdmin)");  
	    l5.setBounds(50,450, 200,30);  
	    
	    f.add(l1); f.add(l2);f.add(l3);f.add(l4);f.add(l5);
	    
	    
	    JButton b1=new JButton("Add");  
	    JButton b2=new JButton("Cancel");  
	    
	    b1.setBounds(50,550,95,30);
	    b2.setBounds(250,550,95,30);
	    
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		
	    		Admin ma = new Admin();
		    	ma.setId(Integer.parseInt(tf1.getText()));
		    	ma.setName(tf2.getText());
		    	ma.setPass(tf3.getText());
		    	ma.setIdentity(Integer.parseInt(tf5.getText()));
		    	ServiceL s = new ServiceL();
		    	s.addAdmin_Srvc(ma);
	    	}  
	    });
	    b2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		
	    		SuperAdminWorkArea swa = new SuperAdminWorkArea();
	    		swa.add();
	    		f.dispose();
	    	}  
	    });
	    f.add(b1);f.add(b2);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  