package org.zj.wether.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zj.wether.service.WeatherDataService;
import org.zj.wether.vo.WeatherResponseVo;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);  
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";
	private final Long TIME_OUT = 1800L; // ���泬ʱʱ�� ��Ϊ��λ
	@Override
	public WeatherResponseVo getDataByCountyId(String countyId) {
		String uri = WEATHER_API + "?citykey=" + countyId;
		return this.doGetWeatherData(uri);
	}

	@Override
	public WeatherResponseVo getDataByCountyName(String countyName) {
		String uri = WEATHER_API + "?city=" + countyName;
		return this.doGetWeatherData(uri);
	}
	

	@Override
	public void syncDataByCountyId(String countyId) {
		String uri = WEATHER_API + "?citykey=" + countyId;
		this.saveWeatherData(uri);
	}
	
	private WeatherResponseVo doGetWeatherData(String uri) {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		String key = uri;
		String strBody = null;

		// �Ȳ黺�棬û���ٲ����
		if (!this.stringRedisTemplate.hasKey(key)) {
			logger.info("������ key " + key);
			
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
			

			if (response.getStatusCodeValue() == 200) {
				strBody = response.getBody();
			}

			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		} else {
			logger.info("���� key " + key + ", value=" + ops.get(key));
			
			strBody = ops.get(key);
		}

		ObjectMapper mapper = new ObjectMapper();
		WeatherResponseVo weather = null;

		try {
			weather = mapper.readValue(strBody, WeatherResponseVo.class);
		} catch (IOException e) {
			logger.error("JSON�����л��쳣��",e);
		}

		return weather;
	}
	
	private void saveWeatherData(String uri) {
	
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		String key = uri;
		String strBody = null;
 
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		if (response.getStatusCodeValue() == 200) {
			strBody = response.getBody();
		}

		ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
	 
	}


}
