package com.itaki.radyodinlenir.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.itaki.radyodinlenir.exception.ApplicationConfigNotFoundException;
import com.itaki.radyodinlenir.persistence.dao.ApplicationConfigDAO;
import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationConfigServiceImplTest {
	@Mock
	private ApplicationConfigDAO configDAO;

	@InjectMocks
	private ApplicationConfigServiceImpl configService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void there_is_not_config_must_throw_config_not_found_exception() {
		Mockito.when(configDAO.findOne(1)).thenReturn(null);
		try {
			configService.getApplicationConfigById((byte) 1);
			fail("ApplicationConfigNotFoundException  must be throw.");
		} catch (ApplicationConfigNotFoundException e) {
		}
	}

	@Test
	public void there_is_result_on_get_by_id() {
		ApplicationConfig config = createDummyConfig();
		Mockito.when(configDAO.findOne(1)).thenReturn(config);
		try {
			ApplicationConfigDTO configDTO = configService.getApplicationConfigById((byte) 1);
			assertTrue(configDTO.equals(createDummyConfigDTO()));
		} catch (ApplicationConfigNotFoundException e) {
			fail();
		}
	}

	@Test
	public void there_is_no_item_for_update_must_throw_exceptionn() {
		ApplicationConfigDTO config = createDummyConfigDTO();
		config.setName("name2");
		Mockito.when(configDAO.findOne((byte) 1)).thenReturn(null);
		try {
			configService.updateApplicationConfig(config);
			fail("ApplicationConfigNotFoundException  must be throw.");
		} catch (ApplicationConfigNotFoundException e) {
		}
	}


	private ApplicationConfig createDummyConfig() {
		ApplicationConfig config = new ApplicationConfig();
		config.setId((byte) 1);
		config.setName("name");
		config.setDescription("desc");
		return config;
	}

//	private ApplicationConfig createDummyConfig(byte id, String name, String description) {
//		ApplicationConfig config = new ApplicationConfig();
//		config.setId(id);
//		config.setName(name);
//		config.setDescription(description);
//		return config;
//	}

	private ApplicationConfigDTO createDummyConfigDTO() {
		ApplicationConfigDTO config = new ApplicationConfigDTO();
		config.setId((byte) 1);
		config.setName("name");
		config.setDescription("desc");
		return config;
	}

//	private ApplicationConfigDTO createDummyConfigDTO(byte id, String name, String description) {
//		ApplicationConfigDTO config = new ApplicationConfigDTO();
//		config.setId(id);
//		config.setName(name);
//		config.setDescription(description);
//		return config;
//	}

}
