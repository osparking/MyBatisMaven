package com.learning.spring.db.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.learning.spring.db.PetDVO;

public class PetDaoImpl implements PetDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<PetDVO> getAllPetsData() {
		List<PetDVO> result = sqlSessionTemplate.selectList("getAllPets"); 
		return result;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate
			sqlSessionTemplate) { 
		this.sqlSessionTemplate = sqlSessionTemplate; 
	}
}
