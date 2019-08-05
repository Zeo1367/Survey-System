package com.model;

public class Ques {
	int id,surveyId,type;
	String text,ch1,ch2,ch3,ch4;

	public int getId() {
		return id;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	public String getCh3() {
		return ch3;
	}
	public void setCh3(String ch3) {
		this.ch3 = ch3;
	}
	public String getCh4() {
		return ch4;
	}
	public void setCh4(String ch4) {
		this.ch4 = ch4;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
