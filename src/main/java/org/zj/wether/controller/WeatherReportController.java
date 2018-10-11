package org.zj.wether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zj.wether.service.CountyDataService;
import org.zj.wether.service.WeatherReportService;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	@Autowired
	private CountyDataService countyDataService;

	@Autowired
	private WeatherReportService weatherReportService;

	@GetMapping("/countyId/{countyId}")
	public ModelAndView getReportByCityId(@PathVariable("countyId") String countyId, Model model) throws Exception {
		model.addAttribute("title", "ÌìÆøÔ¤±¨");
		model.addAttribute("countyId", countyId);
		model.addAttribute("countyList", countyDataService.listCounty());
		model.addAttribute("report", weatherReportService.getDataByCountyId(countyId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
