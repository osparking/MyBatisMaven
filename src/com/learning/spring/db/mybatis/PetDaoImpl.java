package com.learning.spring.db.mybatis;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.learning.spring.db.PetDVO;

public class PetDaoImpl implements PetDAO {

	private SqlSessionTemplate sqlSessionTemplate;

	public List<PetDVO> getAllPetsData() {
		return sqlSessionTemplate.selectList("getAllPets");
	}

	public PetDVO getPetObject(String petName) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", petName);
		return (PetDVO) sqlSessionTemplate.selectOne("getPetObject", inputMap);
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllSpecies() {
		return (List<String>) (Object)sqlSessionTemplate.selectList("getAllSpecies");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PetDVO> selectByGender(String sex) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("sex", sex);
		return (List<PetDVO>)(Object)sqlSessionTemplate.selectList("selectByGender", inputMap);
	}

	@Override
	public int createPet(PetDVO petDVO) throws Exception {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("name", petDVO.getName());
		inputMap.put("owner", petDVO.getOwner());
		inputMap.put("species", petDVO.getSpecies());
		inputMap.put("sex", petDVO.getSex());
		inputMap.put("birth", petDVO.getBirth());
		inputMap.put("death", petDVO.getDeath());

		/**
		 * Get the sql session and commit the data
		 */
		sqlSessionTemplate.insert("createPet", inputMap);

		BigInteger newID = (BigInteger) inputMap.get("id");
		return newID.intValue();
	}

	@Override
	public void updatePetData(PetDVO petDVO) throws Exception {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();

		inputMap.put("owner", petDVO.getOwner());
		inputMap.put("death", petDVO.getDeath());
		inputMap.put("name", petDVO.getName());

		sqlSessionTemplate.update("updatePetData", inputMap);
	}

	@Override
	public int deletePet(String species, String name) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("species", species);
		inputMap.put("name", name);

		return sqlSessionTemplate.delete("deletePet", inputMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PetDVO> findAllSnakes() {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("species", "뱀");
		inputMap.put("sex", "m");
		inputMap.put("owner", "남%");

		return (List<PetDVO>)(Object)sqlSessionTemplate.selectList("findAllSnakes", inputMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PetDVO> findSnakePets() {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("species", "뱀");
		inputMap.put("sex", "m");
		inputMap.put("owner", "남%");
		return (List<PetDVO>)(Object) sqlSessionTemplate.selectList("findSnakePets", inputMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PetDVO> selectPetsIn() {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		List<String> speciesList = new ArrayList<String>();

		speciesList.add("강아지");
		speciesList.add("고양이");
		speciesList.add("뱀");
		inputMap.put("speciesList", speciesList);
		return (List<PetDVO>)(Object)sqlSessionTemplate.selectList("selectPetsIn", inputMap);
	}

	@Override
	public void updatePetDynamically(PetDVO petDVO) {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("birth", petDVO.getBirth());
		inputMap.put("death", petDVO.getDeath());
		inputMap.put("sex", petDVO.getSex());
		inputMap.put("name", petDVO.getName());
		sqlSessionTemplate.update("updatePetDynamically", inputMap);
	}
}
