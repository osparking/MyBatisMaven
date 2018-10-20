package com.learning.spring.db.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 파일 이름: PetDaoImpl.java
 */
import org.mybatis.spring.SqlSessionTemplate;

import com.learning.spring.db.PetDVO;

public class PetDaoImpl implements PetDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<PetDVO> callReadAllPets() {
		HashMap<String, List<PetDVO>> inputMap = new HashMap<String, List<PetDVO>>();
		List<PetDVO> petList = new ArrayList<PetDVO>();
		inputMap.put("petData", petList);
		List<PetDVO> outputData = sqlSessionTemplate.selectList("callReadAllPets");
		return outputData;
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

	public void callPetOwnerFunction() {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", "스륵이");

		sqlSessionTemplate.selectOne("callPetOwnerFunction", inputMap);

		/**
		 * 함수 호출 반환 값 콘솔 출력
		 */
		System.out.println("--- 애완동물 주인 : " + inputMap.get("owner"));
	}
}