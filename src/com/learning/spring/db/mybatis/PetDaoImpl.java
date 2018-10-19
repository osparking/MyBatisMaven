package com.learning.spring.db.mybatis;

/**
 * 파일 이름: PetDaoImpl.java
 */
import org.mybatis.spring.SqlSessionTemplate;
import java.util.*;

public class PetDaoImpl implements PetDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void callReadPet() {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", "스륵이");
		inputMap.put("owner", "");
		inputMap.put("species", "");
		inputMap.put("sex", "");
		inputMap.put("birth", "");
		inputMap.put("death", "");
		sqlSessionTemplate.selectOne("callReadPet", inputMap);

		// Prints the procedure output data
		System.out.println("--- 소유자 : " + inputMap.get("owner"));
		System.out.println("--- 종류   : " + inputMap.get("species"));
		System.out.println("--- 암/수  : " + inputMap.get("sex"));
	}
}