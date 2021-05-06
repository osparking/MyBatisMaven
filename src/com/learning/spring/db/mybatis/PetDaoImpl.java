package com.learning.spring.db.mybatis;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

public class PetDaoImpl implements PetDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public void callReadPet() {
		HashMap<String, Object> inputMap = new HashMap<>();
		
		inputMap.put("name", "스륵이");
		inputMap.put("owner", "");
		inputMap.put("species", "");
		inputMap.put("sex", "");
		inputMap.put("birth", "");
		inputMap.put("death", "");
		sqlSessionTemplate.selectOne("callReadPet", inputMap);
		
		// Prints the procedure output data
		System.out.println("--- 소유자 : " + inputMap.get("owner"));
		System.out.println("--- 종류 : " + inputMap.get("species"));
		System.out.println("--- 암/수 : " + inputMap.get("sex"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date birth = (java.sql.Date)inputMap.get("birth");
		System.out.println("--- 출생 : " + birth.toLocalDate());
		
		Object dObj = inputMap.get("death");
		String death = (dObj == null ? "(생존)" : sdf.format(dObj));
		System.out.println("--- 사망 : " + death);
	}
}
