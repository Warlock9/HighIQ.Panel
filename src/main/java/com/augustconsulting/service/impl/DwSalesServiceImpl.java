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
	public void getFile(DWSales dSales) throws Exception {
		// TODO Auto-generated method stub

		String licenseEndDate = String.valueOf(dSales.getLincenseEndDate()).replace("-", "");

		String fLicenseEndDate = licenseEndDate.substring(2);

		Random rand = new Random();
		String licenseKey = String.valueOf(dSales.getClientSiteId() + rand.nextInt(99999999) + dSales.getSku()
				+ dSales.getNoOfRunners() + fLicenseEndDate);

		String encrptData = Security.encryptData(licenseKey);
		dSales.setLicenseKey(encrptData);
		dwSalesDao.updateDataToDb(dSales);

		File f = createTemFileWriteLicenseKey(System.currentTimeMillis(), encrptData);

		//Email send
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "imap.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "465"); // TLS Port
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
		props.put("mail.smtp.auth", "true"); // enable authentication

		// SSL Factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ankur.tiwari@highiq.ai", "a.n.k.u.r.23");
			}
		};

		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		// set message headers
		msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		msg.addHeader("format", "flowed");
		msg.addHeader("Content-Transfer-Encoding", "8bit");

		msg.setFrom(new InternetAddress("ankur.tiwari@highiq.ai", "ankur.tiwari@highiq.ai"));

		msg.setReplyTo(InternetAddress.parse("prafulla.gupta@augustconsulting.net", false));

		msg.setSubject("License Key", "UTF-8");
    
		msg.setSentDate(new Date());

		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Create a multipar message
		Multipart multipart = new MimeMultipart();
		DataSource source = new FileDataSource(f.getAbsolutePath());
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(f.getName());
		multipart.addBodyPart(messageBodyPart);

		// Send the complete message parts
		msg.setContent(multipart);

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prafulla.gupta@augustconsulting.net", false));
		System.out.println("Message is ready");
		Transport.send(msg);
		System.out.println("EMail Sent Successfully!!");
		f.getAbsoluteFile().delete();
	}

}
