package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.model.Ques;
import com.service.ServiceL;

public class DescriptionQuestion {
	int q;
	public void add(int surveyId,int quesId){
		q=quesId;
	JFrame f=new JFrame("Add Descriptive Question");  
	
	JTextArea textArea = new JTextArea("Questions Goes Here !");
    textArea.setBounds(200,50, 400,150);
    f.add(textArea);

    JLabel l1;  
    l1=new JLabel("Add Question Statement");  
    l1.setBounds(50,50, 200,30);  
    f.add(l1);   
    
    
    JButton b1=new JButton("Add");
    JButton b2=new JButton("Done");
    
    b2.setBounds(450,500,95,30);
    
    b1.setBounds(350,250,95,30);
    
    
    f.add(b1);f.add(b2);
    b1.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){

    	 Ques m=new Ques();
 	    m.setId(quesId);
 	    m.setSurveyId(surveyId);
 	    m.setText(textArea.getText());
 	    m.setCh1(null);
 	    m.setCh2(null);
 	    m.setCh3(null);
 	    m.setCh4(null);
 	    m.setType(3);

 	    ServiceL n=new ServiceL();
 	    int s=n.addQues(m);
		if(s==1)
		{q++;}
	}


    });
    
    b2.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e){
	    
	    	EditSurveyPage1 w= new EditSurveyPage1();
	    	w.add(surveyId);
	    	f.dispose();
	
	        }  
	    });
    

    f.setSize(1000,1000);  
    f.setLayout(null);  
    f.setVisible(true);   

}
}
