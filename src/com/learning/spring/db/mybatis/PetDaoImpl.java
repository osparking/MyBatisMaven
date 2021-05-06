package com.learning.spring.db.mybatis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources; // ??
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 파일 이름: PetDaoImpl.java
 */
import org.mybatis.spring.SqlSessionTemplate;

import com.learning.db.mybatis.java.PetMapper;
import com.learning.spring.db.PetDVO;

public class PetDaoImpl implements PetDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	private static SqlSession getSqlSession() throws Exception {
		String resource = "java-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		sqlSessionFactory.getConfiguration().addMapper(PetMapper.class);
		return sqlSessionFactory.openSession();
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// @formatter:off
	public List<PetDVO> callReadAllPets() throws Exception {
		SqlSession sqlSession = getSqlSession();
		PetMapper mapper = sqlSession.getMapper(PetMapper.class);
		HashMap<String, List<PetDVO>> outputMap =
				new HashMap<String, List<PetDVO>>();
		return mapper.callReadAllPets();
//		List<PetDVO> outputData = sqlSessionTemplate.selectList("callReadAllPets");
//		return outputData;
	}
	// @formatter:on

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

	@Override
	public void callPetOwnerFunction() {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", "스륵이");

		sqlSessionTemplate.selectOne("callPetOwnerFunction", inputMap);

		/**
		 * 함수 호출 반환 값 콘솔 출력
		 */
		System.out.println("--- 애완동물 주인 : " + inputMap.get("owner"));
	}

	@Override
	public void callReadPet(PetDVO petDVO) throws Exception {
		// TODO Auto-generated method stub
		
	}
}