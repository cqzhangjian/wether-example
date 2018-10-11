package org.zj.wether.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="province")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProvinceVo {
	
	@XmlAttribute(name= "id")
	private String id;
	@XmlAttribute(name= "name")
	private String name;
	@XmlElement(name="city")
	private CityVo cityVo;
	
	public CityVo getCityVo() {
		return cityVo;
	}
	public void setCityVo(CityVo cityVo) {
		this.cityVo = cityVo;
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
