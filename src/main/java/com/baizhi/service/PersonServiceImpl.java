package com.baizhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.entity.Person;
import com.baizhi.mapper.PersonMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@Log4j
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonMapper personMapper;
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Person> queryAll() {
		List<Person> list = personMapper.queryAll();
		return list;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void insertOne(Person person) {
		personMapper.insert(person);
		//自定义实现方法
		//personMapper.insertOne(person);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteOne(Integer userid) {
		//通用mapper自带方法
		personMapper.deleteByPrimaryKey(userid);

		//自定义实现方法
		//personMapper.deleteOne(userid);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Person queryOneById(Integer userid) {
		Person e = personMapper.queryOneById(userid);
		return e;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateEmp(Person emp) {
		//通用mapper自带
		Person e = personMapper.selectByPrimaryKey(emp.getId());
		//自定义方法
		//Person e = personMapper.queryOneById(emp.getId());
		System.out.println("������"+e);
		e.setBirthday(emp.getBirthday());
		e.setCity(emp.getCity());
		e.setEmail(emp.getEmail());
		e.setMobile(emp.getMobile());
		e.setName(emp.getName());
		e.setTelphone(emp.getTelphone());
		//通用mapper自带方法
		personMapper.updateByPrimaryKey(e);
		//自定义方法
		//personMapper.updatePerson(e);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Map getUser(int page, int rows) {

	int start=(page-1)*rows+1;
	int end = page*rows;
	List<Person> list = personMapper.getPersonByPage(start,end);
	

	int total = personMapper.getCount();
	

	Map map = new HashMap();
	map.put("rows", list);
	map.put("total", total);
	
	return map;
}

	public int getCount() {

		return personMapper.getCount();
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Map getPersonByNamePage(String name, int page, int rows) {

		int start=(page-1)*rows+1;
		int end = page*rows;
		List<Person> list = personMapper.getPersonByNamePage(name,start,end);

		int total = personMapper.getCountByName(name);
		if(list==null){System.out.println("list----kong");}
		else{for(Person p:list){
			log.info(p); //测试是否查询到，以日志方式输出到控制台
		}}

		Map map = new HashMap();
		map.put("rows", list);
		map.put("total", total);
		
		return map;
	}

	public int getCountByName(String name) {
		return 0;
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deletePersons(int[] id) {
		personMapper.deletePersons(id);
	}

	public Map queryPersonById(Integer userid, int page, int rows) {

				int start=(page-1)*rows+1;
				int end = page*rows;
				List<Person> list = personMapper.queryPersonById(userid,start,end);
				

				int total = personMapper.getCountById(userid);
				if(list==null){System.out.println("list----kong");}
				else{for(Person p:list){ log.info(p);}}

				Map map = new HashMap();
				map.put("rows", list);
				map.put("total", total);
				
				return map;
	}

	public int getCountById(Integer userid) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public Map queryPersonByMobile(String mobile, int page, int rows) {
		int start=(page-1)*rows+1;
		int end = page*rows;
		List<Person> list = personMapper.queryPersonByMobile(mobile,start,end);
		

		int total = personMapper.getCountByMobile(mobile);
		if(list==null){System.out.println("list----kong");}
		else{for(Person p:list){log.info(p);}}

		Map map = new HashMap();
		map.put("rows", list);
		map.put("total", total);
		
		return map;
	}

	public int getCountByMobile(String mobile) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
