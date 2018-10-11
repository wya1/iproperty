/**
 * 
 */
package com.wya1.iproperty.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wya1.iproperty.constant.Constant;

/**
 * @author 任远曼
 * @date 2018年10月3日
 */
@RestController
@RequestMapping("file")
public class FileController {
	/**
	 * 编辑器图片上传实现
	 * 
	 * @param file
	 * @param CKEditorFuncNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("upload")
	public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) {
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		UUID uuid = UUID.randomUUID();
		String newFileName = uuid.toString().replace("-", "") + suffixName;
		String path = Constant.FILE_PATH + newFileName;
		String accessPath=Constant.ACCESS_START_PATH + newFileName;;
		// 使用架包 common-io实现图片上传
		try {
			File file2 = new File(path);
			FileUtils.copyInputStreamToFile(file.getInputStream(), file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/javascript\">");
		sb.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + accessPath + "','')");
		sb.append("</script>");

		return sb.toString();
	}

}
