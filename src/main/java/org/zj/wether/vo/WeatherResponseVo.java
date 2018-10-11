package org.zj.wether.vo;

/**
 * 
 *   响应天气数据信息类
 * @author mrzhang
 *
 */
public class WeatherResponseVo {

	private WeatherVo data;  //数据
	private String status;   //状态
	private String desc;    // 消息描述
	public WeatherVo getData() {
		return data;
	}
	public void setData(WeatherVo data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
