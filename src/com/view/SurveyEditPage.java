package com.view;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

import com.model.Survey;
import com.service.ServiceL;  

public class SurveyEditPage {  
	
	public  void add() {  
		
		JFrame f=new JFrame("Survey Edit");  
		
	    final JTextField tf1=new JTextField();
	    tf1.setBounds(150,250, 100,30);  
	    
	    f.add(tf1);
	    int min=100000,max=1239420;
    	int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
	     
	    JLabel l1;  
	    l1=new JLabel("Enter Survey ID");  
	    l1.setBounds(50,250, 100,30);  
	    f.add(l1); 
	    
	    JButton b1=new JButton("Create New Survey");  
	    JButton b2=new JButton("Edit Survey");  
	    
	    b1.setBounds(50,100,195,30);
	    b2.setBounds(50,300,195,30);
	    
	    b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	String name = JOptionPane.showInputDialog(null,"Enter Your Survey Name");
		    	if(name!=null){
		    	Survey survey= new Survey();
		    	ServiceL serviceL = new ServiceL();
		    	survey.setId(randomNum);
		    	survey.setName(name);
		    	serviceL.addSurvey(survey);
		    	JOptionPane.showMessageDialog(null,"Your SurveyID is "+randomNum+" ");
		    	
		    	}
		    }  
	    });
	    b2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		     EditSurveyPage1 es1 = new EditSurveyPage1();
		     es1.add(Integer.parseInt(tf1.getText()));
		     f.dispose();
		    }  
	    });

	    
	    f.add(b1);f.add(b2);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}  