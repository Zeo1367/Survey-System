package com.view;
import java.awt.event.*;  
import javax.swing.*;  
import com.model.*;
import com.service.*;

public class AddAdmin {  
	
	public void add(){  
		
		JFrame f=new JFrame("SuperAdmin(Add Admin)");  
		
		final JTextField tf1 = new JTextField();  
		final JTextField tf2 = new JTextField();  
		JPasswordField tf3 = new JPasswordField();
		JPasswordField tf4 = new JPasswordField();
	    
	    tf1.setBounds(300,50, 100,30);  
	    tf2.setBounds(300,150, 100,30);  
	    tf3.setBounds(300,250, 100,30);  
	    tf4.setBounds(300,350, 100,30);  
	    
	    f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);
		
	    JLabel l1,l2,l3,l4;  
	    l1=new JLabel("Admin ID");  
	    l1.setBounds(50,50, 200,30);  
	    l2=new JLabel("Admin Name");  
	    l2.setBounds(50,150, 200,30);
	    l3=new JLabel("Admin Password");  
	    l3.setBounds(50,250, 200,30);  
	    l4=new JLabel("Confirm Password");  
	    l4.setBounds(50,350, 200,30);  
	    
	    f.add(l1); f.add(l2);f.add(l3);f.add(l4);  
	    
	    
	    JButton b1=new JButton("Add");  
	    JButton b2=new JButton("Cancel");  
	    
	    b1.setBounds(250,500,95,30);
	    b2.setBounds(450,500,95,30);
	    b1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e){
	    	
	    	Admin m=new Admin();
		  	  
		  	  m.setId(Integer.parseInt(tf1.getText()));
		  	  m.setName(tf2.getText());
		  	  m.setPass(tf3.getText());
		  	  
		  	  ServiceL ob=new ServiceL();
		  	  int x=ob.addAdmin_Srvc(m);
	f.dispose();
	        }  
	    });
	    b2.addActionListener(new ActionListener(){  
		    
		    public void actionPerformed(ActionEvent e){
		    
		    	WelcomePage w= new WelcomePage();
		    	w.add();
		    	f.dispose();
		
		        }  
		    });
	    f.add(b1);f.add(b2);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	} 
}
 