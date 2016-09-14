package com.itaki.radyodinlenir.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itaki.radyodinlenir.persistence.dao.ApplicationConfigDAO;
import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-persistence-context.xml", "classpath:config/dao-context.xml" })
@Transactional
public class ApplicationConfigDAOTest {

	@Autowired
	private ApplicationConfigDAO configDAO;

	private static ApplicationConfig config1;
	private static ApplicationConfig config2;
	private static ApplicationConfig config3;

	@BeforeClass
	public static void init() {
		config1 = createDummyConfig(1, "name1", "desc1");
		config2 = createDummyConfig(2, "name2", "desc2");
		config3 = createDummyConfig(3, "name3", "desc3");
	}

	@Test
	public void config_table_initial_have_tree_items() {
		List<ApplicationConfig> findAll = configDAO.findAll();
		assertEquals(3, findAll.size());
	}

	@Test
	public void get_config_by_name() {
		ApplicationConfig applicatonConfigByName = configDAO.getApplicatonConfigByName("name2");
		assertEquals(applicatonConfigByName, config2);
	}

	@Test
	public void get_config_by_page() {
		List<ApplicationConfig> applicationConfigListByPage = configDAO.getApplicationConfigListByPage(1, 2);
		assertEquals(2, applicationConfigListByPage.size());
		assertEquals(config2, applicationConfigListByPage.get(0));
		assertEquals(config3, applicationConfigListByPage.get(1));
		applicationConfigListByPage = configDAO.getApplicationConfigListByPage(0, 1);
		assertEquals(1, applicationConfigListByPage.size());
		assertEquals(config1, applicationConfigListByPage.get(0));

	}

	public static ApplicationConfig createDummyConfig(int id, String name, String desc) {
		ApplicationConfig config = createDummyConfig(name, desc);
		config.setId(id);
		return config;
	}

	public static ApplicationConfig createDummyConfig(String name, String desc) {
		ApplicationConfig config = new ApplicationConfig();
		config.setName(name);
		config.setDescription(desc);
		return config;
	}

}
