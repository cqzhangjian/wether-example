package org.zj.wether.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.zj.wether.service.CountyDataService;
import org.zj.wether.service.WeatherDataService;
import org.zj.wether.vo.CountryVo;

public class WeatherDataSyncJob extends QuartzJobBean {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class); 
	
	@Autowired
	private CountyDataService countyDataServiceImpl;
	
	@Autowired
	private WeatherDataService weatherDataServiceImpl;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Start 天气数据同步任务");
		
		// 读取城市列表
		List<CountryVo> countryVoList = null;
		try {
			countryVoList = countyDataServiceImpl.listCounty();
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
		}
		
		for (CountryVo county : countryVoList) {
			String countyId = county.getWeatherCode();
			logger.info("天气数据同步任务中，countyId:" + countyId);
			
			// 根据城市ID获取天气
			weatherDataServiceImpl.syncDataByCountyId(countyId);
		}
		
		logger.info("End 天气数据同步任务");
	}

}
