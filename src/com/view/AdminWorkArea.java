package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class AdminWorkArea {  
	
	public void add() {  
		
		JFrame f=new JFrame("Admin WorkArea");  

		
	    JLabel l1,l2,l3;  
	    l1=new JLabel("Create/Edit Survey");  
	    l1.setBounds(50,50, 200,30);  
	    l2=new JLabel("Add/View Users");  
	    l2.setBounds(50,150, 200,30);  
	    l3=new JLabel("Report Generation");  
	    l3.setBounds(50,250, 200,30);  

	    f.add(l1); f.add(l2);f.add(l3);  
	    
	    
	    JButton b1=new JButton("Survey Related");  
	    JButton b2=new JButton("Users Related");  
	    JButton b3=new JButton("Report Related"); 
	    JButton b4=new JButton("Logout"); 

	    
	    b1.setBounds(250,50,195,30);
	    b2.setBounds(250,150,195,30);
	    b3.setBounds(250,250,195,30);
	    b4.setBounds(250,350,195,30);
	    
	    b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	SurveyEditPage sep = new SurveyEditPage();
		    	sep.add();
		    	f.dispose();
		    }  
	    });
	    
	    b2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		
		    }  
	    });

	    b3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		
		    }  
	    });
	    b4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		            AdminLoginPage adminLoginPage= new AdminLoginPage();
		            adminLoginPage.add();
		            f.dispose();
		    }  
	    });
	    f.add(b1);f.add(b2);f.add(b3);f.add(b4);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  