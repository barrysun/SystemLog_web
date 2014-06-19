package com.baihuogou.systemlog.dao;

import java.util.Calendar;
import java.util.List;

import com.baihuogou.systemlog.model.PV;

public interface PVDao {
	
	public List<PV> pvHourByDate(Calendar cal,String MethodType) throws NumberFormatException, Exception;

}
