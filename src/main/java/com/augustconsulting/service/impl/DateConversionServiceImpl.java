package com.augustconsulting.service.impl;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augustconsulting.service.DateConversionService;

@Service
@Transactional
public class DateConversionServiceImpl implements DateConversionService {

	@Override
	public java.sql.Date getFromDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -60);
		Date todate1 = cal.getTime();
		java.sql.Date sqlDate = new java.sql.Date(todate1.getTime());
		return sqlDate;
	}

	@Override
	public java.sql.Date getToDate() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	@Override
	public java.sql.Date StringToSqlDateConversion(String date) {
		java.sql.Date sqlDate=java.sql.Date.valueOf(date);
		return sqlDate;
	}
	
	@Override
	public java.sql.Date getCurrentDate() {
		
		return new java.sql.Date (System.currentTimeMillis());
		
	}
	
	@Override
	public String getAverage(Timestamp date1, long count) {
		// TODO Auto-generated method stub
		String average="00:00:00";	
		try {
				long difference = getToDate().getTime() - date1.getTime();
				//long differenceSeconds = (difference /count)/ 1000 % 60;
				long differenceMinutes = (difference/count) / (60 * 1000) % 60;
				long differenceHours = (difference/count) /(60 * 60 * 1000) % 24;
				long differenceDays = (difference/count) /(24 * 60 * 60 * 1000);
				DecimalFormat mFormat = new DecimalFormat("00");

				average = mFormat.format(Double.valueOf(differenceDays)) + ":"
						+ mFormat.format(Double.valueOf(differenceHours)) + ":"
						+ mFormat.format(Double.valueOf(differenceMinutes));
			
			}catch(NullPointerException ex) {
				return average;
			}
		return average;
	}

	@Override
	public String dateToString() {
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf1 =   new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime =sdf1.format(dt);
		return currentDateTime;
	}

}
