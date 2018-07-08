package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.Ques;
import com.service.ServiceL;  

public class MultipleChoiceQuestions {  
//	public void reset(){
//		textArea.setText("");
//	}
	int q,s;
	public int add(int surveyId,int quesId) {
		q=quesId;
		JFrame f=new JFrame("Add MCQs");  
		
		JTextArea textArea = new JTextArea("Questions Goes Here !");
        textArea.setBounds(200,50, 400,150);
        f.add(textArea);
        
        
	    final JTextField tf1 = new JTextField();  
	    final JTextField tf2 = new JTextField();  
	    final JTextField tf3 = new JTextField();
	    final JTextField tf4 = new JTextField();
	    
	    tf1.setBounds(200,250, 200,30);  
	    tf2.setBounds(200,300, 200,30);  
	    tf3.setBounds(200,350, 200,30);  
	    tf4.setBounds(200,400, 200,30);  
	    f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);
        
	    JLabel l1,l2,l3,l4,l5,l6;  
	    l1=new JLabel("Add Question Statement");  
	    l1.setBounds(50,50, 200,30);  
	    l2=new JLabel("Add Options :");  
	    l2.setBounds(50,210, 100,30);
	    l3=new JLabel("Choice 1 :");  
	    l3.setBounds(50,250, 100,30);
	    l4=new JLabel("Choice 2 :");  
	    l4.setBounds(50,300, 100,30);
	    l5=new JLabel("Choice 3 :");  
	    l5.setBounds(50,350, 100,30);
	    l6=new JLabel("Choice 4 :");  
	    l6.setBounds(50,400, 100,30);
	    f.add(l1); f.add(l2);f.add(l3); f.add(l4);f.add(l5); f.add(l6);  
	    
	    
	    JButton b1=new JButton("Add"); 
	    JButton b2=new JButton("Done");
	    
	    b2.setBounds(450,500,95,30);
	    b1.setBounds(350,500,95,30);
	    
	    
	    f.add(b1);f.add(b2);
	    b1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e) {
			//System.out.println("2"+q);
			Ques m = new Ques();
			m.setId(q);
			m.setSurveyId(surveyId);
			m.setText(textArea.getText());
			m.setCh1(tf1.getText());
			m.setCh2(tf2.getText());
			m.setCh3(tf3.getText());
			m.setCh4(tf4.getText());
			m.setType(1);

			ServiceL serviceL = new ServiceL();
			 s = serviceL.addQues(m);
		}
	    });
	    
	    b2.addActionListener(new ActionListener(){  
		    
		    public void actionPerformed(ActionEvent e){
		    
		    	EditSurveyPage1 editSurveyPage1= new EditSurveyPage1();
		    	editSurveyPage1.add(surveyId);
		    	f.dispose();
		
		        }  
		    });

	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    return s;
	}  
}