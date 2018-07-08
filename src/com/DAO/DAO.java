package com.DAO;
import com.model.*;

import java.sql.*;
import java.util.ArrayList;

import com.factory.SqlFactory;

public class DAO {
	
	SqlFactory S;
	PreparedStatement ps;
	int r;
	ResultSet rs;
	Connection con;
	public DAO()
	{
		S=new SqlFactory();
		con = S.getcon();
	}
	
public int insertAdmin(Admin m)
{
	try
	{
		ps=con.prepareStatement("Insert into admin values(?,?,?,?)");
		ps.setInt(1,m.getId());
		ps.setString(2,m.getName());
		ps.setString(3,m.getPass());
		ps.setInt(4, m.getIdentity());
		r=ps.executeUpdate();
			
	}catch(SQLException e){System.out.print(e);}
	
	return r;
	
}
public int insertUser(User m)
{
	try
	{
		ps=con.prepareStatement("Insert into user values(?,?,?,?,?,?)");
		ps.setInt(1,m.getId());
		ps.setString(2,m.getFirst_name());
		ps.setString(3,m.getLast_name());
		ps.setInt(4,m.getAge() );
		ps.setString(5, m.getPass());
		ps.setString(6, m.getGender());
		r=ps.executeUpdate();
		if(r>0)
			con.commit();
	}catch(SQLException e){System.out.print(e);}
	
	return r;

	
}
public int insertSurvey(Survey m)
{
	try
	{
		ps=con.prepareStatement("Insert into survey values(?,?)");
		ps.setInt(1,m.getId());
		ps.setString(2,m.getName());
		r=ps.executeUpdate();
		if(r>0)
			con.commit();
	}catch(SQLException e){System.out.print(e);}
	
	return r;
	

}

public int insertQues(Ques m)
{
	//System.out.println("3"+m.getId());
	try
	{
		ps=con.prepareStatement("Insert into question values(?,?,?,?,?,?,?,?)");
		ps.setInt(1,m.getId());
		ps.setInt(2,m.getSurveyId());
		ps.setString(3,m.getText());
		ps.setString(4,m.getCh1());
		ps.setString(5,m.getCh2());
		ps.setString(6,m.getCh3());
		ps.setString(7,m.getCh4());
		ps.setInt(8, m.getType());
		
		r=ps.executeUpdate();
	}catch(SQLException e) {
		System.out.print(e);
	 }

	
	return r;


}

public int insertResponse(int choice,int survey_id, int ques_id){
	System.out.println("6 "+ques_id);
		try
		{
			 if(choice == 1){
				ps=con.prepareStatement("insert into response values(?,?,?,?,?,?,?)");
				 ps.setInt(1, survey_id);
				ps.setInt(2, ques_id);
				 ps.setInt(3, choice);
				 ps.setInt(4, 0);
				 ps.setInt(5, 0);
				 ps.setInt(6, 0);
				 ps.setInt(7, 0);
				r = ps.executeUpdate();
			}else if(choice == 2){
				 ps=con.prepareStatement("insert into response values(?,?,?,?,?,?,?)");
				 ps.setInt(1, survey_id);
				 ps.setInt(2, ques_id);
				 ps.setInt(3, choice);
				 ps.setInt(4, 0);
				 ps.setInt(5, 0);
				 ps.setInt(6, 0);
				 ps.setInt(7, 0);
				 r=ps.executeUpdate();
			}else{}
        }catch(SQLException e){
			System.out.print(e);
		}

		return r;
	}

public int countQues()
{
	try
	{
		ps=con.prepareStatement("select COUNT(*) from question");

		rs = ps.executeQuery();
		if(rs.next())
			//rs is checked till last and the value of attribute at place 1 will be entered in r i.e. serial number
			r = rs.getInt(1);
		//System.out.println(r);
	}catch(SQLException e){System.out.print(e);}

	return r;

	
}



//*****************************************************UPDATE*******************************


public int updateSurvey(Survey survey) {
    try {
        ps = con.prepareStatement("Update survey set name=? where id=?");
        ps.setInt(2, survey.getId());
        ps.setString(1, survey.getName());
        r = ps.executeUpdate();
        if (r > 0) {
            con.commit();
        }

    } catch (SQLException se) {

        System.out.println(se);
    } finally {
        S.closecon();
    }
    return r;
}

public int updateAdmin(Admin admin) {
    try {
        ps = con.prepareStatement("Update admin set username=?, password=? where admin_id=?");
        ps.setInt(3, admin.getId());
        ps.setString(1, admin.getName());
        ps.setString(2, admin.getPass());
        r = ps.executeUpdate();
        if (r > 0) {
            con.commit();
        }

    } catch (SQLException se) {
        System.out.println(se);
    } finally {
        S.closecon();
    }
    return r;
}

public int updateQuestion(Ques question) {
    try {
        ps = con.prepareStatement("Update question set name=? where id=?");
        ps.setInt(2, question.getId());
        ps.setString(1, question.getText());
        r = ps.executeUpdate();
        if (r > 0) {
            con.commit();
        }

    } catch (SQLException se) {

        System.out.println(se);
    } finally {
        S.closecon();
    }
    return r;
}

public int updateUser(User user) {
    try {
        ps = con.prepareStatement("Update survey set first_name=?,last_name=?,age=?,password=?,gender=? where id=?");
        ps.setInt(6, user.getId());
        ps.setString(1, user.getFirst_name());
        ps.setString(2, user.getLast_name());
        ps.setInt(3, user.getAge());
        ps.setString(4, user.getPass());
        ps.setString(5, user.getGender());
        r = ps.executeUpdate();
        if (r > 0) {
            con.commit();
        }

    } catch (SQLException se) {

        System.out.println(se);
    } finally {
        S.closecon();
    }
    return r;
}


//***********************************************SEARCH*******************************************

public boolean searchAdmin(Admin m)
{	
	boolean flag = false;
	try
	{
		ps=con.prepareStatement("select * from admin where admin_id = ? && password = ? && identity = ?");
		ps.setInt(1,m.getId());
		ps.setString(2,m.getPass());
		ps.setInt(3,m.getIdentity());
		rs = ps.executeQuery();
		
		if(rs.next()){
			flag =  true;
		}
	}catch(SQLException e){
		System.out.print(e);
	}finally {
        S.closecon();
    }
	
	return flag;
	
}

	public boolean searchSuperAdmin(SuperAdmin superAdmin)
	{
		boolean flag = false;
		try
		{
			ps=con.prepareStatement("select * from super_admin where username = ? && password = ? ");
			ps.setString(1,superAdmin.getUsername());
			ps.setString(2,superAdmin.getPass());
			rs = ps.executeQuery();

			if(rs.next()){
				flag =  true;
			}
		}catch(SQLException e){
			System.out.print(e);
		}finally {
			S.closecon();
		}

		return flag;

	}
public boolean searchUser(User m)
{	
	boolean flag = false;
	try
	{
		ps=con.prepareStatement("select * from user where user_id = ? && password = ?");
		ps.setInt(1,m.getId());
		ps.setString(2,m.getPass());
		rs = ps.executeQuery();
		
		if(rs.next()){
			flag =  true;
		}
	}catch(SQLException e){
		System.out.print(e);
	}finally {
        S.closecon();
    }
	
	return flag;
	
}


//******************************************************VIEW************************************



public ArrayList<Ques> viewQuestion(int surveyID)
{
	ArrayList<Ques> l = new ArrayList<Ques>();
	try
	{  
		ps=con.prepareStatement("select * from question where survey_id = ?");
		ps.setInt(1,surveyID);
	    rs = ps.executeQuery();
		
		
		while(rs.next()){
			Ques q=new Ques();
			q.setId(rs.getInt(1));
			q.setSurveyId(rs.getInt(2));
			q.setText(rs.getString(3));
			q.setCh1(rs.getString(4));
			q.setCh2(rs.getString(5));
			q.setCh3(rs.getString(6));
			q.setCh4(rs.getString(7));
			q.setType(rs.getInt(8));
			
			l.add(q);
//			System.out.println(q.getText());
			
		}
	}catch(SQLException e){
		System.out.print(e);
	}
//	System.out.println(ques.getText());
//	Iterator<Ques> it=l.iterator();
	
//	while(it.hasNext())
//	{
//		
//		Ques ques = it.next();
////		System.out.println(ques.getText());
//		ques=it.next();
//		/*if(ques.getType() == 1){
//			addMcq(ques);
//		}else if(ques.getType() == 2){
//			addYesNo(ques);
//		}else{
//			addDesc(ques);
//		}*/
////		System.out.println("Done");
//		
//	}
	return l;
	
}


	public int addChoice(int ch,int s, int q){
		try
		{  //System.out.println(s+" "+q);
			ps=con.prepareStatement("select ch1,ch2,ch3,ch4 from response where survey_id = ? && ques_id = ?");
			ps.setInt(1, s);
			ps.setInt(2, q);
		    rs = ps.executeQuery();
		    if(rs.next())
			{ if(ch == 1){
		    	r = rs.getInt(1);
		    	//System.out.println(r);
			    ps=con.prepareStatement("update response set ch1 = ? where survey_id = ? && ques_id = ?");
			    r = r+1;
			    ps.setInt(1, r);
			    ps.setInt(2, s);
				ps.setInt(3, q);
				r = ps.executeUpdate();


		    }else if(ch == 2){
		    	r = rs.getInt(2);
			    ps=con.prepareStatement("update response set ch2 = ? where survey_id = ? && ques_id = ?");
			    r = r+1;
			    ps.setInt(1, r);
			    ps.setInt(2, s);
				ps.setInt(3, q);
				r = ps.executeUpdate();


		    }else if(ch == 3){
		    	r = rs.getInt(3);
			    ps=con.prepareStatement("update response set ch3 = ? where survey_id = ? && ques_id = ?");
			    r = r+1;
			    ps.setInt(1, r);
			    ps.setInt(2, s);
				ps.setInt(3, q);
				r = ps.executeUpdate();


		    }else{
		    	r = rs.getInt(4);
			    ps=con.prepareStatement("update response set ch4 = ? where survey_id = ? && ques_id = ?");
			    r = r+1;
			    ps.setInt(1, r);
			    ps.setInt(2, s);
				ps.setInt(3, q);
				r = ps.executeUpdate();

		    }}
			
			
		}catch(SQLException e){
			System.out.print(e);
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.countQues();
	}


    public int deleteQuestionDAO(int questionId) {
     try {
     	ps = con.prepareStatement("Delete from question where ques_id=? ");
     	ps.setInt(1,questionId);
     	r= ps.executeUpdate();

	 }catch(SQLException se) {
		 System.out.println(se);
	 }finally {
     	S.closecon();
	 }
	return r;
	}

	public int deleteResponseDAO(int questionId) {
		try {
			ps = con.prepareStatement("Delete from response where ques_id=? ");
			ps.setInt(1,questionId);
			r= ps.executeUpdate();

		}catch(SQLException se) {
			System.out.println(se);
		}
		return r;
	}

	public int maxQuesDAO() {
		try {
			ps= con.prepareStatement("select max(ques_id) from question");
			rs=ps.executeQuery();
			if(rs.next()){
				r=rs.getInt(1);
			}
			//System.out.println(r);
		}catch(SQLException se) {
			System.out.println(se);
		}
		return r;

	}
}