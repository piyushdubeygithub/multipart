package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.service.MultiPartService;

@RestController
public class MultiPartController {
	
	@Autowired
	MultiPartService multiPartService;
	
	@RequestMapping(value="api/v1/saveFile", method = RequestMethod.POST)
	public Map<String, Object> saveFile(HttpServletRequest request,MultipartFile file){
		Map<String, Object> result = new HashMap<>();
		result = multiPartService.saveFile(file);
		return result;
	}

}
