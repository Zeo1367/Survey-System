package com.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;

import javax.swing.*;

import com.model.Ques;
import com.model.Response;
import com.service.ServiceL;

public class ViewQuestionUser {
	Ques[] q;
	JFrame f; 
	JLabel j1;
	JRadioButton rb1,rb2,rb3,rb4;
	JButton jButton2,b1;
	ButtonGroup bg = new ButtonGroup();
	ArrayList<Ques> l = new ArrayList<Ques>();
	UserWorkArea userWorkArea;
	ServiceL m=new ServiceL();
	int localUserId,x,i=0,count=0,z=0;
	String text;


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
		JButton b1=new JButton("Next");
        b1.setBounds(50,400, 90, 30);
		b1.setEnabled(false);
		JButton b2= Submit();
		b2.setEnabled(false);
        f.getContentPane().add(b1);f.getContentPane().add(b2);
        if (count==x) {
			jButton2.setVisible(true);
			b1.setVisible(false);
			i=1;
			System.out.println("wooh");
		}
		rb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(true);b2.setEnabled(true);
			}
		});
		rb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(true);b2.setEnabled(true);
			}
		});
		rb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(true);b2.setEnabled(true);
			}
		});
		rb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(true);b2.setEnabled(true);
			}
		});

		b1.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e){
    	    	if(rb1.isSelected()){
    	    			ServiceL s = new ServiceL();
    	    			s.addChoice_srvc(1, q.getSurveyId(), q.getId());
				} else if(rb2.isSelected()){
		        	   ServiceL s = new ServiceL();
		        	   s.addChoice_srvc(2, q.getSurveyId(), q.getId());
    	    	} else if(rb3.isSelected()){
		        	   ServiceL s = new ServiceL();
		        	   s.addChoice_srvc(3, q.getSurveyId(), q.getId());
				} else{
		        	   ServiceL s = new ServiceL();
		        	   s.addChoice_srvc(4, q.getSurveyId(), q.getId());
				}

    	    	f.dispose();
				view(q.getSurveyId());
			}
		});
		b2.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e){
				  userWorkArea = new UserWorkArea();
				  userWorkArea.add(localUserId);
				  JOptionPane.showMessageDialog(null,"Thanks for your time and input!");
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
		b1=new JButton("Next");
        b1.setBounds(50,400, 90, 30);
        b1.setEnabled(false);
        JButton b2=Submit();
		b2.setEnabled(false);
        f.getContentPane().add(b1);f.getContentPane().add(b2);
		if (count==x) {
			b2.setVisible(true);
			b1.setVisible(false);
			i = 1;
		}
		rb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(true);b2.setEnabled(true);
			}
		});
		rb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(true);b2.setEnabled(true);
			}
		});

		b1.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	if(rb1.isSelected()){
    	    			ServiceL s = new ServiceL();
    	    			s.addChoice_srvc(1, q.getSurveyId(), q.getId());
		           }
		           else{
		        	   ServiceL s = new ServiceL();
		        	   s.addChoice_srvc(2, q.getSurveyId(), q.getId());
    	    	}

    	    	f.dispose();
    	    	view(q.getSurveyId());
                  	            
    	        }  
    	    });
		b2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
				  userWorkArea = new UserWorkArea();
				  userWorkArea.add(localUserId);
				  JOptionPane.showMessageDialog(null,"Thanks for your time and input!");
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


		JButton b1=new JButton("Next");
        b1.setBounds(50,400, 90, 30);
        JButton b2 = Submit();
		f.getContentPane().add(b1);f.getContentPane().add(b2);
		if (count==x) {
			jButton2.setVisible(true);
			b1.setVisible(false);
			i=1;
		}

        b1.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	text=ja.getText();
    	    	if(text.length()>0){
					f.dispose();
					view(q.getSurveyId());
				}else{
					JOptionPane.showMessageDialog(null,"Please! provide some response.");
				}
    	        }
    	    });
        
        b2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
				  userWorkArea = new UserWorkArea();
				  userWorkArea.add(localUserId);
                  f.dispose();
    	    	}
    	    });
}
	public void view(int surveyid){
		 l=m.viewQues_srvc(surveyid);
		 x=l.size()-1;
		 q = l.toArray(new Ques[100]);

		 if(l.size()!=count)
		{	if(q[count].getType() == 1){
				addMcq(q[count]);
			}else if(q[count].getType() == 2){
				addYesNo(q[count]);
			}else{
				addDesc(q[count]);
			}
			System.out.println("Done");
			count++;
		} else{
			System.exit(0);
		}
	}
	public JButton Submit() {
		jButton2 = new JButton("Submit");
		jButton2.setBounds(50, 400, 90, 30);
		if(i==0)
		{jButton2.setVisible(false);}
		return jButton2;
	}
	
	public static void main(String args[]) {

		ViewQuestionUser q = new ViewQuestionUser();
		q.view(362381);
	}

	public void userID(int userId) {
		localUserId = userId;
	}
}