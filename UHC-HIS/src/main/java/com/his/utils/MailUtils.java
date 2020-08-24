package com.his.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.his.dto.UserDTO;

@Component
public class MailUtils {
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendUserAccUnlockMail1(UserDTO userDTO) {
		boolean isSent = false;
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(userDTO.getEmail());
			msg.setSubject("Account Creation Acknowledement Mail");
			msg.setText(getUnlockAccUserBody(userDTO));
			mailSender.send(msg);
			isSent = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
	
	
	public boolean sendUserAccUnlockMail2(UserDTO userDTO) {
		boolean isSent = false;
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(userDTO.getEmail());
			helper.setSubject("unlock your Account for Verification ");
			helper.setText(getUnlockAccUserBody(userDTO), true);
			mailSender.send(msg);
			isSent = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
		
	}
	
	
	
	private String getUnlockAccUserBody(UserDTO userDTO) throws IOException {
		StringBuffer sb = new StringBuffer();
		//file reader read data char by char
		FileReader fr = new FileReader("UNLOCK-ACC-MAIL-CONTENT.txt");
		//Buffer reader read data line by line
		BufferedReader br = new BufferedReader(fr);
		String readLine = br.readLine();
		
		while(readLine != null) {
			sb.append(readLine);
			readLine = br.readLine();
		}
		br.close();
		
		// format mail body
				String mailBody = sb.toString();
				mailBody = mailBody.replace("{FNAME}", userDTO.getFirstName());
				mailBody = mailBody.replace("{LNAME}", userDTO.getLastName());
				mailBody = mailBody.replace("{TEMP-PWD}", userDTO.getPassword());
				mailBody = mailBody.replace("{EMAIL}", userDTO.getEmail());
				mailBody = mailBody.replace("{ROLE}", userDTO.getRoleName());

		return mailBody;
		
	};
}
