package com.learning.spring.db.mybatis.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learning.spring.db.mybatis.PetDVO;

public class CoreMyBatisMain {

	public static void main(String[] args) {
		try {
			CoreMyBatisMain main = new CoreMyBatisMain();
			// Case 1. 하나의 영역 객체 읽기
			String name = "스륵이";
			PetDVO aPet = main.getPetObject(name);
			System.out.println("이름: " + name);
			System.out.println("\t종류: " + aPet.getSpecies());
			System.out.println("\t주인: " + aPet.getOwner());

			// Case 2. 애완동물 마리수 출력
//			List<PetDVO> allPets = main.getAllPetsData();
//			System.out.println("--- 애완동물 숫자 ----" + allPets.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static SqlSession getSqlSession() throws Exception {
		String resource = "core-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}

	public PetDVO getPetObject(String petName) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", petName);
		return (PetDVO) getSqlSession().selectOne("getPetObject", inputMap);
	}

	public List<PetDVO> getAllPetsData() throws Exception {
		return getSqlSession().selectList("getAllPets");
	}
}
