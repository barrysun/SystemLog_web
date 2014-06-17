package com.baihuogou.systemlog.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.baihuogou.systemlog.dao.PVDao;
import com.baihuogou.systemlog.model.PV;
import com.baihuogou.systemlog.utils.Db;

public class PVDaoImpl implements PVDao {

	private static String pvSQL="select count(*) as pv_count from system_nginx_log_%s where time_local like '%s';";
	public List<PV> pvHourByDate(Calendar cal) throws NumberFormatException, Exception {
		List<PV> pvList=new ArrayList<PV>();
		Date date=cal.getTime();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateStr=df.format(date);
		String year=dateStr.substring(0,4);
		for(int i=0; i<24;i++ ){
		 pvList.add(new PV(i,Integer.parseInt(Db.ExecuteQuery(String.format(pvSQL, dateStr.toString(),"%"+year+":"+(i<10?"0"+i:i)+"%"), null).get(0).get("pv_count").toString())));
		}
		return pvList;
	}
	

}
