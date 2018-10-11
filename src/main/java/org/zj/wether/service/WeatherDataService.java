package org.zj.wether.service;

import org.zj.wether.vo.WeatherResponseVo;

/**
 *   天气数据服务
 * @author mrzhang
 *
 */
public interface WeatherDataService {

	
	WeatherResponseVo getDataByCountyId(String countyId);

	
	WeatherResponseVo getDataByCountyName(String countyName);
	
	
	void syncDataByCountyId(String countyId);
	
	
}
