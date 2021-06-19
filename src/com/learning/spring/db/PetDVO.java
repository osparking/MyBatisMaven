package com.learning.spring.db;

import java.io.Serializable;
import java.util.Date;
import com.learning.Util;

@SuppressWarnings("serial")
public class PetDVO implements Serializable {
	private int id;
	private String name;
	private String owner;
	private String species;
	private String sex;
	private Date birth;
	private Date death;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getDeath() {
		return death;
	}

	public void setDeath(Date death) {
		this.death = death;
	}

	@Override
	public String toString() {
		String bDay = Util.getY4MMDD(birth);
		String dDay = Util.getY4MMDD(birth);
		String output = "애완동물 [이름=" + name + ", 소유자=" + owner;
		output += ", 종류=" + species + ", 암수=" + sex;
		output += ", 출생=" + bDay + ", 사망="	+ dDay + "]"; 
		return  output; 
	}

}
