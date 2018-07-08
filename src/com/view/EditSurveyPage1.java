package com.view;
import java.awt.event.*;

import javax.swing.*;

import com.service.ServiceL;


public class EditSurveyPage1 {  
	int quesId;
	public void add(int surveyid) {  
		
		JFrame f=new JFrame("Edit Survey1");  
		
	   final JTextField tf1=new JTextField();
		   
	    tf1.setBounds(250,350, 100,30);  
	    

	    ServiceL s = new ServiceL();
		ServiceL serviceL = new ServiceL();
	    
//	    q = s.countQues_srvc();
		quesId=serviceL.maxQuesService();
//		if((q+1)==check){
//			quesId=q+1;
//		}

	    f.add(tf1);
	     
	    JLabel l1,l2;
	    l1=new JLabel("Enter Questions");  
	    l1.setBounds(50,100, 300,30);  
	    f.add(l1);
	    l2=new JLabel("Enter Question ID to Delete");  
	    l2.setBounds(50,350, 300,30);  
	    f.add(l2); 

	    
	    
	    JRadioButton rb1,rb2,rb3;   
	    ButtonGroup bg = new ButtonGroup();  
        rb1 = new JRadioButton("MCQs");
        rb2 = new JRadioButton("Yes/No");
        rb3 = new JRadioButton("Descriptive");
        rb1.setBounds(50,150,100,20);  
        rb2.setBounds(50,200,100,20);  
        rb3.setBounds(50,250,100,20);  
        f.add(rb1);f.add(rb2);f.add(rb3);
        bg.add(rb1);bg.add(rb2);bg.add(rb3);
	    JButton b1=new JButton("View Questions");  
	    JButton b2=new JButton("Delete Question");  
	    JButton b3=new JButton("Proceed");  
	    
	    b1.setBounds(50,550,195,30);
	    b2.setBounds(450,350,195,30);
	    b3.setBounds(450,250,195,30);
	    f.add(b3);
	    b2.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent e){  
	            ServiceL serviceL = new ServiceL();
	            if(serviceL.deleteResponseService(Integer.parseInt(tf1.getText()))==1)
				{
					if(serviceL.deleteQuestionService(Integer.parseInt(tf1.getText()))==1)
				     JOptionPane.showMessageDialog(null,"Your question with id "+tf1.getText()+" has been deleted! from the survey.");
				}
	        }  
	    });
	    b3.addActionListener(new ActionListener(){  
		    
		    public void actionPerformed(ActionEvent e){  
		           if(rb1.isSelected()){
		        	   MultipleChoiceQuestions multipleChoiceQuestions = new MultipleChoiceQuestions();
		        	   if(multipleChoiceQuestions.add(surveyid,quesId + 1)==1)
					   {
						   //System.out.println("1"+quesId+1);
					 	serviceL.addResponse(1,surveyid,quesId);
							System.out.println("4"+quesId+1);
						 JOptionPane.showMessageDialog(null,"Your question with id "+(quesId+1)+" has been added from the survey.");

					   }
		        	   f.dispose();
		           }
		           else if(rb2.isSelected()){
		        	   YesNoQuestions yesNoQuestions = new YesNoQuestions();
		        	   yesNoQuestions.add(surveyid,quesId + 1);
					   serviceL.addResponse(2,surveyid,quesId + 1);
		        	   f.dispose();
		           }
		           else{
		        	   DescriptionQuestion descriptionQuestion = new DescriptionQuestion();
		        	   descriptionQuestion.add(surveyid,quesId + 1);
					   serviceL.addResponse(3,surveyid,quesId + 1);
		        	   f.dispose();
		           }
		        }  
		    });
	    b1.addActionListener(new ActionListener(){  
		    
		    public void actionPerformed(ActionEvent e){  
		           
		    	ViewQuestionAdmin p=new ViewQuestionAdmin();
		    	p.view(surveyid);
		    	
		    	
		    	
		        }  
		    });
	    
	    f.add(b1);f.add(b2);
	    f.setSize(1000,1000);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    
	}  
	public static void main(String args[]){
		EditSurveyPage1 e = new EditSurveyPage1();
		e.add(362381);
	}
}  