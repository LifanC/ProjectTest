package com.project.controller;

import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

@RestController
public class TestController {
	@GetMapping("upload")
	public ModelAndView uploadForm() {
		return new ModelAndView("fileUpload");
	}
	private static final String UPLOAD_DIRECTORY = "C:\\ecilpse_JavaWeb\\project_product-management\\src\\main\\resources\\static";
	@PostMapping("upload")
	public ModelAndView uploadPhoto(MultipartFile file) throws IOException {
		String path = UPLOAD_DIRECTORY;
		String filename = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		System.out.println(path + File.separator + filename);
		ModelAndView view=new ModelAndView("datahtml/success");
		String address=path + File.separator;
		String tname=filename;
		view.addObject("success", address);
		view.addObject("filesuccess", tname);
		return view;
	
    }  
}

