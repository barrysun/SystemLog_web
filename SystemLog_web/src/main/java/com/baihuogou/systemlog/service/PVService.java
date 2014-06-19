package com.baihuogou.systemlog.service;

import java.util.Calendar;
import java.util.List;

import com.baihuogou.systemlog.dao.PVDao;
import com.baihuogou.systemlog.dao.impl.PVDaoImpl;
import com.baihuogou.systemlog.model.PV;

public class PVService {
	
	public static PVDao pvDao=null;
	
	public static String pVStr(Calendar cal,String MethodType) throws NumberFormatException, Exception{
		pvDao=new PVDaoImpl();
		List<PV> pvList=pvDao.pvHourByDate(cal,MethodType);
		StringBuilder str=new StringBuilder();
		for(int i=0;i<24;i++){
			str.append(","+pvList.get(i).getClickCount());
		}
		return str.substring(1);
	}
}
