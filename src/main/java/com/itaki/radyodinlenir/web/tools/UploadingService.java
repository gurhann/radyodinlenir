package com.itaki.radyodinlenir.web.tools;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itaki.radyodinlenir.util.PageUtils;

@Service
public class UploadingService {
	@Autowired
	ServletContext context;

	public String uploadImage(MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				String uploadsDir = "/resources/radiologos/";
				String realPathtoUploads = context.getRealPath(uploadsDir);
				if (!new File(realPathtoUploads).exists()) {
					new File(realPathtoUploads).mkdir();
				}
				String filePath = realPathtoUploads + PageUtils.convertCleanUrl(file.getOriginalFilename());
				;
				File dest = new File(filePath);
				file.transferTo(dest);
				return file.getOriginalFilename();
			} catch (Exception ex) {
				
				return null;
			}

		} else {

			return null;
		}

	}

}
