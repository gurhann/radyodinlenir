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

import com.itaki.radyodinlenir.persistence.dao.RadioStationDAO;
import com.itaki.radyodinlenir.persistence.model.MusicType;
import com.itaki.radyodinlenir.persistence.model.RadioStation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-persistence-context.xml", "classpath:config/dao-context.xml" })
@Transactional
public class RadioStationDAOTest {

	@Autowired
	private RadioStationDAO radioStationDAO;

	public static RadioStation radioStation1;
	public static RadioStation radioStation2;
	public static RadioStation radioStation3;

	public static MusicType musicType1;
	public static MusicType musicType2;

	@BeforeClass
	public static void init() {
		musicType1 = MusicTypeDAOImplTest.createMusicType(1, "name1", (short) 1);
		musicType2 = MusicTypeDAOImplTest.createMusicType(2, "name2", (short) 2);
		radioStation1 = createDummyRadioStation(1, "name1", "description1", "logo1", "cleanUrl1", "streamUrl1", "embeddedUrl1", 1, 1, "seoKeywords1", "seoDescription1", musicType1, true);
		radioStation2 = createDummyRadioStation(2, "name2", "description2", "logo2", "cleanUrl2", "streamUrl2", "embeddedUrl2", 2, 2, "seoKeywords2", "seoDescription2", musicType2, true);
		radioStation3 = createDummyRadioStation(3, "name3", "description3", "logo3", "cleanUrl3", "streamUrl3", "embeddedUrl3", 3, 3, "seoKeywords3", "seoDescription3", musicType1, true);
	}

	@Test
	public void get_radio_station_by_name() {
		RadioStation radioStationByName = radioStationDAO.getRadioStationByName("name1");
		assertEquals(radioStation1, radioStationByName);
	}

	@Test
	public void get_radio_station_by_clean_url() {
		RadioStation radioStationByCleanUrl = radioStationDAO.getRadioStationWithCleanUrl("cleanUrl2");
		assertEquals(radioStation2, radioStationByCleanUrl);
	}

	@Test
	public void get_radio_station_by_page() {
		List<RadioStation> page1 = radioStationDAO.getRadioStationForPager(1, 2);
		List<RadioStation> page2 = radioStationDAO.getRadioStationForPager(2, 2);
		assertEquals(radioStation3, page1.get(0));
		assertEquals(radioStation2, page1.get(1));
		assertEquals(radioStation1, page2.get(0));
	}

	@Test
	public void get_radio_station_by_music_type() {
		List<RadioStation> pageByMusicType1 = radioStationDAO.getRadioStationForPagerWithMusicType(1, 2, 1);
		List<RadioStation> pageByMusicType2 = radioStationDAO.getRadioStationForPagerWithMusicType(1, 2, 2);
		assertEquals(radioStation3, pageByMusicType1.get(0));
		assertEquals(radioStation1, pageByMusicType1.get(1));
		assertEquals(radioStation2, pageByMusicType2.get(0));
	}

	@Test
	public void get_radio_station_count() {
		int musicType1Count = radioStationDAO.getRadioStationsCountWithMusicTypeId(musicType1.getId());
		int musicType2Count = radioStationDAO.getRadioStationsCountWithMusicTypeId(musicType2.getId());
		assertEquals(2, musicType1Count);
		assertEquals(1, musicType2Count);
	}

	public static RadioStation createDummyRadioStation(int id, String name, String descsription, String logo, String cleanUrl, String streamUrl, String embeddedUrl, int hitCount, int priority,
			String seoKeywords, String seoDescription, MusicType musicType, boolean isEnabled) {
		RadioStation radioStation = new RadioStation();
		radioStation.setId(id);
		radioStation.setName(name);
		radioStation.setDescription(descsription);
		radioStation.setLogo(logo);
		radioStation.setCleanUrl(cleanUrl);
		radioStation.setStreamUrl(streamUrl);
		radioStation.setEmbeddedUrl(embeddedUrl);
		radioStation.setHitCount(hitCount);
		radioStation.setPriority(priority);
		radioStation.setSeoKeywords(seoKeywords);
		radioStation.setSeoDescription(seoDescription);
		radioStation.setEnabled(isEnabled);
		radioStation.setMusicType(musicType);
		return radioStation;
	}

}
