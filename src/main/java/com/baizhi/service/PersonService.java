package com.baizhi.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.*;
public interface PersonService {
	public List<Person> queryAll();
	
	public void insertOne(Person person);
	
	public void deleteOne(Integer userid);
	
	public Person queryOneById(Integer userid);
	
	public void updateEmp(Person person);
	

	public Map getUser(int page, int rows);
	
	public int getCount();
	
	public Map getPersonByNamePage(@Param("name") String name, @Param("start") int start, @Param("end") int end);

	public int getCountByName(@Param("name") String name);
	
	public void deletePersons(int[] id);
	
	
	public Map queryPersonById(@Param("userid") Integer userid, @Param("start") int start, @Param("end") int end);
	public int getCountById(@Param("userid") Integer userid);
	
	public Map queryPersonByMobile(@Param("mobile") String mobile, @Param("start") int start, @Param("end") int end);
	public int getCountByMobile(@Param("mobile") String mobile);
	
		
	
	
	
	
	
}
