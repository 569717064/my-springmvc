package com.woniu.j_upload;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	/**
	  	1.导入fileupload依赖
	 	2.必须使用CommonsMultipartFile来接受客户端传来的图片的信息（名字和2进制）,
	 		且在该参数前也必须加@RequestParam 
		3.还必须在spring-servlet中，配置一个文件上传解析器！！
	 */
	@RequestMapping("upload")
	public String upload(@RequestParam CommonsMultipartFile photo,HttpServletRequest req) throws IllegalStateException, IOException {
		//获取上传的文件名
		String oldName = photo.getOriginalFilename();
		//获取文件的后缀
		String ext = oldName.substring(oldName.lastIndexOf("."));
		String newName = UUID.randomUUID()+ext;
		//获取web应用在服务器中所在的真实目录！
		String path = req.getServletContext().getRealPath("/upload");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		//将文件存盘
		photo.transferTo(new File(path,newName));
		return "j";    
	}
	
	
	
	/**
	 	多文件上传，要使用CommonsMultipartFile[]数组来接收数据
	 */
	@RequestMapping("upload2")
	public String upload2(@RequestParam CommonsMultipartFile[] photos,HttpServletRequest req) throws IllegalStateException, IOException {
		if (photos.length > 1) {
			for (int i = 0; i < photos.length; i++) {
				//获取上传的文件名
				String oldName = photos[i].getOriginalFilename();
				//获取文件的后缀
				String ext = oldName.substring(oldName.lastIndexOf("."));
				String newName = UUID.randomUUID()+ext;
				//获取web应用在服务器中所在的真实目录！
				String path = req.getServletContext().getRealPath("/upload");
				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs();
				}
				//将文件存盘
				photos[i].transferTo(new File(path,newName));
			}
			return "j";
		}else {
			req.setAttribute("uploadError", "上传文件不能为空");
			return "error"; //错误页面，提示用户上传文件不能为空       
		}
	}
}
