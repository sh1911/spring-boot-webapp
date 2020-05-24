package com.alien.bloodhelper.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.alien.bloodhelper.models.MailRequest;
import com.alien.bloodhelper.models.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component

public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private Configuration mailconfig;
	public MailResponse sendEmail(MailRequest req ,Map<String ,Object> model)
	{
		MimeMessage message=mailSender.createMimeMessage();
		MailResponse mailresponse=new MailResponse();
		try
		{
			MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			//helper.addAttachment("logo.png",new ClassPathResource("logo.png"));
			Template template=mailconfig.getTemplate("email-template.ftl");
			String html=FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			helper.setTo(req.getToId());
			helper.setText(html,true);
			helper.setSubject(req.getSubject());
			helper.setFrom(req.getFromId());
			mailSender.send(message);
			mailresponse.setMessage("Mail send to"+req.getToId());
			mailresponse.setStatus(Boolean.TRUE);
		}
		catch (MessagingException | IOException | TemplateException e) {
			mailresponse.setMessage("Mail sending failure" +e.getMessage());
		}
			return mailresponse;
					
		}
}
