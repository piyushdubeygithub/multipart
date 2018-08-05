package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MultiPartService {

	public Map<String, Object> saveFile(MultipartFile file){
		Map<String, Object> result = new HashMap<>();
		System.out.println("file================="+file);
		String fileName = file.getOriginalFilename();
		String filePath = "/home/piyush/Videos/"+fileName;
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
		Logger log= 	Logger.getLogger(MultiPartService.class.getName());
		log.log(log.getLevel().ALL, "Context", e);
		log.warning(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName", fileName);
		result.put("filePath", filePath);
		return result;
	}
}
