-- Application Config
insert into application_config(id,name,description) values(1, 'name1', 'desc1');
insert into application_config(id,name,description) values(2, 'name2', 'desc2');
insert into application_config(id,name,description) values(3, 'name3', 'desc3');

-- Music Type
insert into music_category(id,name,priority,clean_url) values(1, 'name1', 1,'url1');
insert into music_category(id,name,priority,clean_url) values(2, 'name2', 2,'url2');
insert into music_category(id,name,priority,clean_url) values(3, 'name3', 3,'url3');
insert into music_category(id,name,priority,clean_url) values(4, 'name4', 4,'url4');

-- Contact Request
insert into contact_request(id,name,message,email,was_answered,send_date) values(1, 'name1', 'message1', 'mail1',0,PARSEDATETIME('12/12/2016 12:12','dd/MM/yyyy HH:mm'));
insert into contact_request(id,name,message,email,was_answered,send_date) values(2, 'name2', 'message2', 'mail2',0,PARSEDATETIME('12/12/2016 13:12','dd/MM/yyyy HH:mm'));
insert into contact_request(id,name,message,email,was_answered,send_date) values(3, 'name3', 'message3', 'mail3',0,PARSEDATETIME('12/12/2016 14:12','dd/MM/yyyy HH:mm'));
insert into contact_request(id,name,message,email,was_answered,send_date) values(4, 'name4', 'message4', 'mail4',1,PARSEDATETIME('12/12/2016 12:12','dd/MM/yyyy HH:mm'));
insert into contact_request(id,name,message,email,was_answered,send_date) values(5, 'name5', 'message5', 'mail5',1,PARSEDATETIME('12/12/2016 12:11','dd/MM/yyyy HH:mm'));
insert into contact_request(id,name,message,email,was_answered,send_date) values(6, 'name6', 'message6', 'mail6',1,PARSEDATETIME('12/12/2016 12:03','dd/MM/yyyy HH:mm'));


-- Radio Station
insert into radio_station(id,name,description,logo,clean_url,stream_url,embedded_url,hit_count,priority,seo_keywords,seo_description,music_type_id,is_enabled)
	values (1,'name1','description1','logo1','cleanUrl1','streamUrl1','embeddedUrl1',1,1,'seoKeywords1','seoDescription1',1,1);
insert into radio_station(id,name,description,logo,clean_url,stream_url,embedded_url,hit_count,priority,seo_keywords,seo_description,music_type_id,is_enabled)
	values (2,'name2','description2','logo2','cleanUrl2','streamUrl2','embeddedUrl2',2,2,'seoKeywords2','seoDescription2',2,1);
insert into radio_station(id,name,description,logo,clean_url,stream_url,embedded_url,hit_count,priority,seo_keywords,seo_description,music_type_id,is_enabled)
	values (3,'name3','description3','logo3','cleanUrl3','streamUrl3','embeddedUrl3',3,3,'seoKeywords3','seoDescription3',1,1);