package com.learning.db.mybatis.java;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learning.spring.db.PetDVO;
import com.learning.spring.db.mybatis.PetDAO;

public class PetDAOAnno implements PetDAO {
	private static SqlSession getSqlSession() throws Exception {
		String resource = "java-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory 
			= new SqlSessionFactoryBuilder().build(inputStream);
		sqlSessionFactory.getConfiguration().addMapper(PetMapper.class);
		return sqlSessionFactory.openSession();
	}

	public List<PetDVO> callReadAllPets() throws Exception {
		SqlSession sqlSession = getSqlSession();
		PetMapper mapper = sqlSession.getMapper(PetMapper.class);
		return mapper.callReadAllPets();
	}

	public void callReadPet(PetDVO petDVO) throws Exception {
		SqlSession sqlSession = getSqlSession();
		PetMapper mapper = sqlSession.getMapper(PetMapper.class);

		mapper.callReadPet(petDVO); 
	}
}