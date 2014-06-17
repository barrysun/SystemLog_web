package com.baihuogou.systemlog.model;

public class PV {
	
	public int Hour;
	public int ClickCount;
	public PV(){
		
	}
	public PV(int hour,int ClickCount){
		this.Hour=hour;
		this.ClickCount=ClickCount;
	}
	public int getHour() {
		return Hour;
	}
	public void setHour(int hour) {
		Hour = hour;
	}
	public int getClickCount() {
		return ClickCount;
	}
	public void setClickCount(int clickCount) {
		ClickCount = clickCount;
	}

}
