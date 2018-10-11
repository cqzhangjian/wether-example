package org.zj.wether.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.wether.service.WeatherDataService;
import org.zj.wether.service.WeatherReportService;
import org.zj.wether.vo.WeatherVo;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	WeatherDataService weatherDataService;
	
	public WeatherVo getDataByCountyId(String countyId) {
		
		
		
		return weatherDataService.getDataByCountyId(countyId).getData();
	}

}
