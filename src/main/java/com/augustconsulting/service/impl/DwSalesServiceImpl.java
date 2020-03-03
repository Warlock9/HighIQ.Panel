package com.augustconsulting.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.augustconsulting.dao.DwSalesDao;
import com.augustconsulting.model.ComponentBundle;
import com.augustconsulting.model.CustomerSites;
import com.augustconsulting.model.DWSales;
import com.augustconsulting.service.DateConversionService;
import com.augustconsulting.service.DwSalesService;
import com.augustconsulting.utility.Security;

@Service

public class DwSalesServiceImpl implements DwSalesService {

	@Autowired
	private DwSalesDao dwSalesDao;
	@Autowired
	DateConversionService dateService;

	@Override
	public void insertingDataToDb(DWSales dwSal) {
		// TODO Auto-generated method stub
		try {
			dwSal.setCreatedDate(dateService.getToDate());
			dwSal.setUpdatedDate(dateService.getToDate());
			dwSal.setLicenseStatus("Pending");
			dwSalesDao.insertingDataToDb(dwSal);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateDataToDb(DWSales dwSal) {
		// TODO Auto-generated method stub
		dwSal.setUpdatedDate(dateService.getToDate());
		dwSalesDao.updateDataToDb(dwSal);

	}

	@Override
	public void deleteFromDb(int id) {
		// TODO Auto-generated method stub
		dwSalesDao.deleteFromDb(id);

	}

	@Override
	public List<DWSales> fetchingDataFromDb() {
		// TODO Auto-generated method stub
		return dwSalesDao.fetchingDataFromDb();
	}

	@Override
	public List<CustomerSites> fetchingCLientSiteDetails() {
		// TODO Auto-generated method stub
		return dwSalesDao.fetchingCLientSiteDetails();
	}

	@Override
	public List<ComponentBundle> fetchingSKU() {
		// TODO Auto-generated method stub
		return dwSalesDao.fetchingSKU();
	}

	@Override
	public DWSales fetchingDataFromDb(Integer saleId) {
		// TODO Auto-generated method stub
		return dwSalesDao.fetchingDataFromDb(saleId);
	}

	@Override
	public void getFileToMail(DWSales dSales,String toMail) throws Exception {
		// TODO Auto-generated method stub

		String licenseEndDate = String.valueOf(dSales.getLincenseEndDate()).replace("-", "");

		String fLicenseEndDate = licenseEndDate.substring(2);

		
		Random rand = new Random();
		 String clientSiteId=dSales.getClientSiteId();
		 String sku=dSales.getSku();
		 
		 String botrunners=String.valueOf(dSales.getNoOfRunners());
		 
		  if(clientSiteId.length()==1) {
			  clientSiteId="0000"+clientSiteId;
		  }
		  if(clientSiteId.length()==2) {
			  clientSiteId="000"+clientSiteId;
		  }
		  if(clientSiteId.length()==3) {
			  clientSiteId="00"+clientSiteId;
		  }
		  if(clientSiteId.length()==4) {
			  clientSiteId="0"+clientSiteId;
		  }
			
		
		  // for sku code
		  if(sku.length()==1) {
			  sku="0000"+sku;
		  }
		  if(sku.length()==2) {
			  sku="000"+sku;
		  }
		  if(sku.length()==3) {
			  sku="00"+sku;
		  }
		  if(sku.length()==4) {
			  sku="0"+sku;
		  }
		  
		// for no of bot runners
		  
		  if(botrunners.length()==1) {
			  botrunners="000"+botrunners;
		  }
		  if(botrunners.length()==2) {
			  botrunners="00"+botrunners;
		  }
		  if(botrunners.length()==3) {
			  botrunners="0"+botrunners;
		  }
		  
		String licenseKey = String.valueOf(clientSiteId+ rand.nextInt(99999999)+sku+ botrunners + fLicenseEndDate);

		System.out.println(licenseKey+" >>>>>>>>>>>>>>");
		String encrptData = Security.encryptData(licenseKey);
		//update key and status
		dSales.setLicenseKey(encrptData);
		dSales.setLicenseStatus("Generated");
		dwSalesDao.updateDataToDb(dSales);

		/* creating a License key file and send to email */

		File licenseFile = createTemFileWriteLicenseKey(System.currentTimeMillis(), encrptData);
		sendMail("imap.gmail.com", "465", "ankurtiwari69@gmail.com", "a.n.k.u.r.25",
				toMail, "License Key", licenseFile);

	}

	@Override
	public String sendMail(String host, String port, String fromMail, String password, String toMail, String subject,
			File licenseFile) {
		String exceptionMessage = "";
		try {

			// Email send

			Properties props = new Properties();
			props.put("mail.smtp.host", host); // SMTP Host
			props.put("mail.smtp.port", port); // TLS Port
			props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
			props.put("mail.smtp.auth", "true"); // enable authentication

			// SSL Factory
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			// create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromMail, password);
				}
			};

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromMail, fromMail));

			msg.setReplyTo(InternetAddress.parse(toMail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setText("", "UTF-8");

			msg.setSentDate(new Date());

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Create a multipar message
			Multipart multipart = new MimeMultipart();
			DataSource source = new FileDataSource(licenseFile.getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(licenseFile.getName());
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
			System.out.println("Message is ready");
			Transport.send(msg);
			System.out.println("EMail Sent Successfully!!");
			licenseFile.getAbsoluteFile().delete();

		} catch (Exception ex) {
			System.out.println("Mail fail");
			ex.printStackTrace();
			exceptionMessage = ex.getMessage();
		}
		return exceptionMessage;
	}

	@Override
	public CustomerSites fetchingClientSiteEmailID(Integer clientSiteId) {
		return dwSalesDao.fetchingClientSiteEmailID(clientSiteId);
	}

	@Override
	public DWSales fetchingDataByLicenseKey(String key) {
		return dwSalesDao.fetchingDataByLicenseKey(key);
	}

	@Override
	public long getActiveLicences() {
		
		return dwSalesDao.getActiveLicences();
	}

	@Override
	public long getGeneratedLincenseCurrentMonth() {
		return dwSalesDao.getGeneratedLincenseCurrentMonth();
	}

}
