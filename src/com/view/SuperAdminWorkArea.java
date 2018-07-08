package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class SuperAdminWorkArea {  
	
	public  void add() {  
		
		JFrame f=new JFrame("SuperAdmin");  
		
	    JLabel l1,l2;  
	    l1=new JLabel("Add New Admin");  
	    l1.setBounds(50,50, 200,30);
	    f.add(l1);
//	    l2=new JLabel("View Admins");  
//	    l2.setBounds(50,150, 200,30);  
//	     f.add(l2);  
	    
	    
	    JButton b1=new JButton("Add");  
	    JButton b2=new JButton("View");
	    JButton b3=new JButton("Logout");
	    
	    b1.setBounds(250,50,95,30);
	    b2.setBounds(250,150,95,30);
	    b3.setBounds(250,250,95,30);
	    b1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		
	    		AddAdminPage ap = new AddAdminPage();
	    		ap.add();
		    }  
		});

	    b3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		            AdminLoginPage adminLoginPage= new AdminLoginPage();
		            adminLoginPage.add();
		            f.dispose();
		    }  
	    });
//	    
	    f.add(b1);f.add(b3);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  