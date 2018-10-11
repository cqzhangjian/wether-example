package org.zj.wether.service;

import org.zj.wether.vo.WeatherVo;

public interface WeatherReportService {

	WeatherVo getDataByCountyId(String countyId);

}
