package org.zj.wether.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.zj.wether.service.CountyDataService;
import org.zj.wether.util.XmlBuilder;
import org.zj.wether.vo.CityVo;
import org.zj.wether.vo.CountryVo;
import org.zj.wether.vo.CountyListVo;
import org.zj.wether.vo.ProvinceVo;

@Service
public class CountyDataServiceImpl implements CountyDataService {

	@Override
	public List<CountryVo> listCounty() throws Exception {
		// 读取XML文件
		Resource resource = new ClassPathResource("cityList.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";

		while ((line = br.readLine()) != null) {
			buffer.append(line);
		}

		br.close();

		// XML转为Java对象
		CountyListVo countyList = (CountyListVo) XmlBuilder.xmlStrToObject(CountyListVo.class, buffer.toString());
		
		
		List<CountryVo>  countryVos = new ArrayList<>();
		
		List<ProvinceVo> provinceVo = countyList.getProvinceVo();
		
		provinceVo.forEach(city-> {
			CityVo cityVo = city.getCityVo();
			cityVo.getCountryList().forEach(count -> {
				countryVos.add(count);
			});
		});
		

		return countryVos;
	}

}