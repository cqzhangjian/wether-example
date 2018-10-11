package org.zj.wether;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zj.wether.service.CountyDataService;
import org.zj.wether.vo.CountryVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WetherExampleApplicationTests {
	
	@Autowired
	CountyDataService  countyDataService;
	

	@Test
	public void contextLoads() throws Exception {
		List<CountryVo> listCounty = countyDataService.listCounty();
		System.out.println(listCounty.size());
	}

}
