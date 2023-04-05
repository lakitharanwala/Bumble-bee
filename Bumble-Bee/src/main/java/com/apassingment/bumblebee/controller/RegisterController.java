package com.apassingment.bumblebee.controller;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.spi.RegisterableService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apassingment.bumblebee.dao.DbConnectionImpl;
import com.apassingment.bumblebee.dao.DbConnector;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.service.RegisterService;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
   private RegisterService registerService; 
	
	public RegisterController() {
		registerService=RegisterService.getRegisterService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewRegister(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		try {
			registerUser(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	private void viewRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/sign-up.jsp");
		rd.forward(request, response);
	}
	

	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MessagingException {
		 User user =new User(); 
	        user.setFirstName(request.getParameter("firstName"));
	        user.setLastName(request.getParameter("lastName"));
	        user.setNationalIdentificationNumber(request.getParameter("nic"));
	        user.setContact(request.getParameter("contact"));
	        user.setAddress(request.getParameter("addres"));
	        user.setEmial(request.getParameter("email"));
	        user.setUsername(request.getParameter("userName"));
	        user.setPassword(request.getParameter("password"));
	        
	       String msg="";
			try {
				registerService.RegisterUser(user);
				msg="user register succsefull email have sent to you provided email";
				String username = "bumblebeeassingment@gmail.com";
				 String password = "cfknqmjrkhaevrjf";
				    
				 Properties props = new Properties();
			        props.put("mail.smtp.auth", "true");
			        props.put("mail.smtp.starttls.enable", "true");
			        props.put("mail.smtp.host", "smtp.gmail.com");
			        props.put("mail.smtp.port", "587");
				

				Session session = Session.getInstance(props, new Authenticator() {
				    @Override
				    protected PasswordAuthentication getPasswordAuthentication() {
				        return new PasswordAuthentication(username, password);
				    }
				});
				
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("bumblebeeassingment@gmail.com"));
				message.setRecipients(
				  Message.RecipientType.TO, InternetAddress.parse(request.getParameter("email")));
				message.setSubject("Mail Subject");

				String msga = "You have succsesfull created the account vist our mobile app to buy first and pay later";

				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				mimeBodyPart.setContent(msga, "text/html; charset=utf-8");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(mimeBodyPart);

				message.setContent(multipart);

				Transport.send(message);
				
				MimeBodyPart attachmentBodyPart = new MimeBodyPart();
				attachmentBodyPart.attachFile(new File("path/to/file"));
			
				
				 
			} catch (ClassNotFoundException | SQLException e) {
				msg=e.getMessage();
				e.printStackTrace();
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/sign-in.jsp");
			rd.forward(request, response);
			
	}
	
	
	
	
}


