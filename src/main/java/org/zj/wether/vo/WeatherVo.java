package org.zj.wether.vo;

import java.util.List;

/**
 * 
 * @author mrzhang
 *  天气信息类
 *
 */
public class WeatherVo {

	private String city;
	private String aqi;
	private String ganmao;
	private String wendu;
	
	private YesterDayVo yesterday;
	private List<ForecastVo> forecast;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public YesterDayVo getYesterday() {
		return yesterday;
	}
	public void setYesterday(YesterDayVo yesterday) {
		this.yesterday = yesterday;
	}
	public List<ForecastVo> getForecast() {
		return forecast;
	}
	public void setForecast(List<ForecastVo> forecast) {
		this.forecast = forecast;
	}
	
	
	
	
	
	
}
