package com.service;
import com.model.*;

import java.util.ArrayList;

import com.DAO.*;

public class ServiceL {
	DAO D;
	public ServiceL()
	{
		D=new DAO();
		
	}
	
	public int addAdmin_Srvc(Admin m)
	{
		return D.insertAdmin(m);
	}
	public int addUser_Srvc(User m)
	{
		return D.insertUser(m);
	}
	public int addSurvey(Survey m)
	{
		return D.insertSurvey(m);
	}
	public int addQues(Ques m)
	{
		return D.insertQues(m);
	}

	
	public int updateAdmin_srvc(Admin m){
		return D.updateAdmin(m);
	}
	
	public int countQues_srvc(){
		return D.countQues();
	}
    public int updateUser_srvc(User m){return D.updateUser(m);}
    public int updateQues_srvc(Ques m){return D.updateQuestion(m);}
    public int updateSurvey_srvc(Survey m){return D.updateSurvey(m);}

	public boolean searchSuperAdmin_srvc(SuperAdmin superAdmin){
		return D.searchSuperAdmin(superAdmin);
	}
	public boolean searchAdmin_srvc(Admin m){
		return D.searchAdmin(m);
	}
	public boolean searchUser_srvc(User m){
		return D.searchUser(m);
	}
	
	public ArrayList<Ques> viewQues_srvc(int surveyid){
		return D.viewQuestion(surveyid);
	}
	
	public int addChoice_srvc(int choice,int survey_id, int ques_id){ return D.addChoice(choice, survey_id, ques_id);
	}

	public int addResponse(int choice,int survey_id, int ques_id) {
		System.out.println("5"+ques_id);
		return D.insertResponse(choice, survey_id, ques_id); }

	public int deleteQuestionService(int questionId) {
		return D.deleteQuestionDAO(questionId);
	}
	public int deleteResponseService(int questionId) {
		return D.deleteResponseDAO(questionId);
	}

	public int maxQuesService() {
		return D.maxQuesDAO();
	}
}
