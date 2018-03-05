package com.rw.finance.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;

public class FileUtils {
	/**
	 * 获取文件后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		String suffix = null;
		try {
			suffix = fileName.substring(fileName.lastIndexOf("."));
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return suffix;
	}

	/**
	 * 根据base64字符串头获取文件后缀
	 * 
	 * @param base64
	 * @return
	 */
	public static String getSuffixByBase64(String base64) {
		try {
			String[] base = base64.split(";");
			String suffix = base[0].split("/")[1];
			return "." + suffix;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 对图片BASE64 解码
	 * 
	 * @param base64
	 * @param destFilePath
	 */
	public static void getFileByBase64(String base64, String filePath) {
		try {
			base64 = base64.split(",")[1];
			File destFile = new File(filePath);
			if(!destFile.getParentFile().exists()){
				destFile.getParentFile().mkdirs();
			}
			byte[] result = Base64.decodeBase64(base64);
			FileOutputStream out = new FileOutputStream(filePath);
			out.write(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public static void main(String[] orgs) throws IOException {
		File file = new File("C:/Users/Administrator/Desktop/设计/V4/V4/1首页.jpg");
		;
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		System.err.println(new String(Base64.encodeBase64(buffer)));
	}*/
}
