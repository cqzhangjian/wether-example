package org.zj.wether.service;

import java.util.List;

import org.zj.wether.vo.CountryVo;

public interface CountyDataService {

	/**
	 * ��ȡ�����б�.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<CountryVo> listCounty() throws Exception;
}