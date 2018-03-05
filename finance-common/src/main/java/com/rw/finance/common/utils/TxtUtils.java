package com.rw.finance.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TxtUtils {
	/**
	 * 编码
	 */
	private static final String CharSet="GBK";
	/**
	 * 写入
	 * @param file
	 * @param line
	 */
	public static void write(File file,String line){
		try {                 
			FileOutputStream out = new FileOutputStream(file,true);
			try {
				out.write(line.getBytes(CharSet));
				out.write("\n".getBytes(CharSet));
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 读取txt文件
	 * @param filePath
	 */
	public static List<String> read(File file){
		List<String> lines=new ArrayList<String>();
		try {                 
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),CharSet);
			BufferedReader bufferedReader = new BufferedReader(read);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			read.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        return lines;  
    }
}
