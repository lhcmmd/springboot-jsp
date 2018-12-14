package com.baizhi.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.*;
import tk.mybatis.mapper.common.Mapper;

public interface PersonMapper extends Mapper<Person>  {
	public List<Person> queryAll();
	
	public void insertOne(Person person);
	
	public void deleteOne(Integer userid);
	public Person queryOneById(Integer userid);
	
	public List<Person> queryPersonById(@Param("userid") Integer userid, @Param("start") int start, @Param("end") int end);
	public int getCountById(@Param("userid") Integer userid);
	
	
	public void updatePerson(Person person);
	
	public int getCount();
	
	public List<Person> getPersonByPage(@Param("start") int start, @Param("end") int end);
	
	public List<Person> getPersonByNamePage(@Param("name") String name, @Param("start") int start, @Param("end") int end);
	
	public int getCountByName(@Param("name") String name);

	public void deletePersons(int[] id);
	
	public List<Person> queryPersonByMobile(@Param("mobile") String mobile, @Param("start") int start, @Param("end") int end);
	public int getCountByMobile(@Param("mobile") String mobile);
	
}
