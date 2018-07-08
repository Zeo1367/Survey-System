package com.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;

import javax.swing.*;

import com.model.Ques;
import com.model.Response;
import com.service.ServiceL;

public class ViewQuestionAdmin {
	Ques[] q;
	JFrame f; 
	JLabel j1;
	JRadioButton rb1,rb2,rb3,rb4;
	JButton jButton1,b2;
	ButtonGroup bg = new ButtonGroup();
	ArrayList<Ques> l = new ArrayList<Ques>();
	ServiceL m=new ServiceL();
	int x,i=0,count=0, localSurveyId;
	
	
	
	public void addMcq(Ques q){
		f = new JFrame("Question");
		j1 = new JLabel(q.getText());
		j1.setBounds(50, 50, 500, 90);
		f.getContentPane().add(j1);
		rb1 = new JRadioButton(q.getCh1());
        rb2 = new JRadioButton(q.getCh2());
        rb3 = new JRadioButton(q.getCh3());
        rb4 = new JRadioButton(q.getCh4());
        rb1.setBounds(50,150,100,20);  
        rb2.setBounds(50,200,100,20);  
        rb3.setBounds(50,250,100,20);
        rb4.setBounds(50,300,100,20);
        f.getContentPane().add(rb1);f.getContentPane().add(rb2);f.getContentPane().add(rb3);f.getContentPane().add(rb4);
        bg.add(rb1);bg.add(rb2);bg.add(rb3);bg.add(rb4);
	    f.setSize(800,600); 
	    f.setLayout(null);
	    f.setVisible(true);
		b2=new JButton("Next");
        b2.setBounds(150,400, 90, 30);
        JButton b1=Back();
        f.getContentPane().add(b2);f.getContentPane().add(b1);
		if (count==x) {
			jButton1.setVisible(true);
			b2.setVisible(false);
			i=1;
		}
		b2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	f.dispose();
    	    	view(q.getSurveyId());
                  	            
    	        }  
    	    });
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
				editSurveyPage1.add(localSurveyId);
				f.dispose();
			}
		});
	}	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void addYesNo(Ques q){
		f = new JFrame("Questions");
		j1 = new JLabel(q.getText());
		j1.setBounds(50, 50, 500, 90);
		f.getContentPane().add(j1);  
        rb1 = new JRadioButton("Yes");
        rb2 = new JRadioButton("No");
        rb1.setBounds(50,150,100,20);  
        rb2.setBounds(50,200,100,20);  
        f.getContentPane().add(rb1);f.getContentPane().add(rb2);
        bg.add(rb1);bg.add(rb2);
	    f.setSize(800,600);  
	    f.getContentPane().setLayout(null);  
	    f.setVisible(true);   
		b2=new JButton("Next");
        b2.setBounds(150,400, 90, 30);
		JButton b1=Back();
		f.getContentPane().add(b2);f.getContentPane().add(b1);
		if (count==x) {
			jButton1.setVisible(true);
			b2.setVisible(false);
			i=1;
		}
        b2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	f.dispose();
    	    	view(q.getSurveyId());
			}
    	    });
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
				editSurveyPage1.add(localSurveyId);

				f.dispose();
			}
		});

	}
	public void addDesc(Ques q){
		f = new JFrame("Questions");
		j1 = new JLabel(q.getText());
		j1.setBounds(50, 50, 500, 90);
		f.getContentPane().add(j1);
		JTextArea ja = new JTextArea("");  
        ja.setBounds(50,100, 400,150);        	    
        f.getContentPane().add(ja);
        f.setSize(800,600);  
	    f.getContentPane().setLayout(null);  
	    f.setVisible(true);
        b2=new JButton("Next");
        b2.setBounds(150,400, 90, 30);
		JButton b1=Back();
		f.getContentPane().add(b2);f.getContentPane().add(b1);
		if (count==x) {
			jButton1.setVisible(true);
			b2.setVisible(false);
			i=1;
		}
        b2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	  f.dispose();
                  view(q.getSurveyId());
    	        }  
    	    });
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
				editSurveyPage1.add(localSurveyId);
				f.dispose();
			}
		});
	}
	



	public void view(int surveyid) {
		localSurveyId = surveyid;

		l = m.viewQues_srvc(surveyid);
		x=l.size()-1;
		q = l.toArray(new Ques[100]);

		if (l.size() != count) {
			if (q[count].getType() == 1) {
				addMcq(q[count]);
			} else if (q[count].getType() == 2) {
				addYesNo(q[count]);
			} else {
				addDesc(q[count]);
			}
			count++;
		} else {
			System.exit(0);
		}
	}
		public JButton Back() {
			jButton1 = new JButton("Back to Edit");
			jButton1.setBounds(50, 400, 90, 30);
			if(i==0)
			{jButton1.setVisible(false);}
			return jButton1;
		}


	
//	public static void main(String args[]){
//
//	ViewQuestionAdmin q= new ViewQuestionAdmin();
//	q.view(185833);
//}
}