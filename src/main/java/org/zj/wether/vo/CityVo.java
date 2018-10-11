package org.zj.wether.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="city")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityVo {
	
	@XmlAttribute(name= "id")
	private String id;
	@XmlAttribute(name= "name")
	private String name;
	
	@XmlElement(name="county")
	private List<CountryVo> countryList;
	
	public List<CountryVo> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<CountryVo> countryList) {
		this.countryList = countryList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
