package org.zj.wether.vo;

/**
 * 
 *   ��Ӧ����������Ϣ��
 * @author mrzhang
 *
 */
public class WeatherResponseVo {

	private WeatherVo data;  //����
	private String status;   //״̬
	private String desc;    // ��Ϣ����
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
