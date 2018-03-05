package com.rw.finance.server.dao;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.utils.TxtUtils;
import com.rw.finance.server.BaseTest;

public class BankInfoDaoTest extends BaseTest{

	@Autowired
	private BankInfoDao bankInfoDao;
	/**
	 * 添加银行支持基础数据
	 */
	//@Test
	public void add(){
		System.out.println();
	}
	//@Test
	public void listTest(){
		
	}
	/**
	 * 读取卡bin数据
	 */
	//@Test
	public void bin(){
		List<BankInfo> bankInfos=bankInfoDao.findAll();
		bankInfos.forEach(b->{
			b.setCardbins("");
		});
		bankInfoDao.save(bankInfos);
		File file=new File("C:/Users/Administrator/Desktop/BIN.txt");
		List<String> lines=TxtUtils.read(file);
		for(String l:lines){
			String [] details=l.split(" ");
			System.err.println(details[1]);
			BankInfo bankInfo=bankInfoDao.findByBankcodeLike(details[1].trim());
			if(StringUtils.isEmpty(bankInfo)){
				continue;
			}
			String f=",";
			if(StringUtils.isEmpty(bankInfo.getCardbins())){
				f="";
			}
			bankInfo.setCardbins(bankInfo.getCardbins()+f+details[details.length-1]);
			bankInfoDao.saveAndFlush(bankInfo);
		}
	}
}
