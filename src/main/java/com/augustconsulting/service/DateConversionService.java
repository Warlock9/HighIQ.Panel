package com.augustconsulting.service;

import java.sql.Date;
import java.sql.Timestamp;

public interface DateConversionService {

	public Date getFromDate();
	
	public Date getToDate();
	
	public Date StringToSqlDateConversion(String date); 
	
	public Date getCurrentDate();
	
	String getAverage(Timestamp date1,long count);

	public String dateToString();



}
