package com.learning.spring.db;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class PetDVO implements Serializable {
	private String name;
	private String owner;
	private String species;
	private String sex;
	private Date birth;
	private Date death;

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
		return "애완동물 [이름=" + name + ", 소유자=" + owner + ", 종류=" + species + ", 암수=" + sex + ", 출생=" + birth + ", 사망="
				+ death + "]";
	}

}
