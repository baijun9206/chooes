package com.peugeot;

import com.peugeot.study.StudyProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JamApplicationTests {

	private static final Log log = LogFactory.getLog(JamApplicationTests.class);

	@Autowired
	private StudyProperties studyProperties;

	@Test
	public void contextLoads() {
		Assert.assertEquals("柏世民",studyProperties.getName());
		System.out.println(studyProperties.getGame());
		System.out.println(studyProperties.getValue());
		System.out.println(studyProperties.getNumber());
		System.out.println(studyProperties.getDesc());
	}



}
