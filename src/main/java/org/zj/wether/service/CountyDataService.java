package org.zj.wether.service;

import java.util.List;

import org.zj.wether.vo.CountryVo;

public interface CountyDataService {

	/**
	 * 获取城市列表.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<CountryVo> listCounty() throws Exception;
}