package org.zj.wether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zj.wether.service.WeatherDataService;
import org.zj.wether.vo.WeatherResponseVo;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;

	@GetMapping("/countyId/{countyId}")
	public WeatherResponseVo getReportByCityId(@PathVariable("countyId") String countyId) {
		return weatherDataService.getDataByCountyId(countyId);
	}

	@GetMapping("/countyName/{countyName}")
	public WeatherResponseVo getReportByCityName(@PathVariable("countyName") String countyName) {
		return weatherDataService.getDataByCountyName(countyName);
	}

}