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
		logger.info("Start ��������ͬ������");
		
		// ��ȡ�����б�
		List<CountryVo> countryVoList = null;
		try {
			countryVoList = countyDataServiceImpl.listCounty();
		} catch (Exception e) {
			logger.error("��ȡ������Ϣ�쳣��", e);
		}
		
		for (CountryVo county : countryVoList) {
			String countyId = county.getWeatherCode();
			logger.info("��������ͬ�������У�countyId:" + countyId);
			
			// ���ݳ���ID��ȡ����
			weatherDataServiceImpl.syncDataByCountyId(countyId);
		}
		
		logger.info("End ��������ͬ������");
	}

}
