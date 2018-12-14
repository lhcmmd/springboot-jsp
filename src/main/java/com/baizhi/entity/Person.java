package com.baizhi.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_person")//表明
public class Person {
	@Id//主键
	@KeySql(sql = "select t_person_seq.nextval from dual",order= ORDER.BEFORE)
	private Integer id;
	@Column(name="name")
	private String name;
	private String mobile;
	private String telphone;
	private String email;
	private String city;
	@JSONField(format="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	
}
