package com.learning.spring.db.mybatis.core;

import java.io.InputStream;
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

			// Printing pets data
			List<PetDVO> allPets = main.getAllPetsData();
			System.out.println("--- 애완동물 숫자 ----" + allPets.size());
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

	public List<PetDVO> getAllPetsData() throws Exception {
		return getSqlSession().selectList("getAllPets");
	}
}
