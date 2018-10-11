package org.zj.wether.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * <China>
	<province id="01" name="����">
		<city id="0101" name="����">
			<county id="010101" name="����" weatherCode="101010100" />
 * 
 * 
 */
@XmlRootElement(name="China")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountyListVo {
	
	@XmlElement(name="province")
	private List<ProvinceVo> provinceVo;

	public List<ProvinceVo> getProvinceVo() {
		return provinceVo;
	}

	public void setProvinceVo(List<ProvinceVo> provinceVo) {
		this.provinceVo = provinceVo;
	}
	
	
	
	
}
