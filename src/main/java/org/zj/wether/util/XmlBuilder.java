package org.zj.wether.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.zj.wether.vo.CountyListVo;

public class XmlBuilder {

	public static Object  xmlStrToObject(Class<CountyListVo> clazz, String xmlStr) throws Exception {
		
		Object xmlObject = null;
		Reader reader = null;

		JAXBContext context = JAXBContext.newInstance(clazz);

		// ���н�Xmlת�ɶ���ĺ��Ľӿ�
		Unmarshaller unmarshaller = context.createUnmarshaller();

		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);

		if (null != reader) {
			reader.close();
		}

		return xmlObject;
	}

}
