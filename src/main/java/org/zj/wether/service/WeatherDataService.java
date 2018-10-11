package org.zj.wether.service;

import org.zj.wether.vo.WeatherResponseVo;

/**
 *   �������ݷ���
 * @author mrzhang
 *
 */
public interface WeatherDataService {

	
	WeatherResponseVo getDataByCountyId(String countyId);

	
	WeatherResponseVo getDataByCountyName(String countyName);
	
	
	void syncDataByCountyId(String countyId);
	
	
}
