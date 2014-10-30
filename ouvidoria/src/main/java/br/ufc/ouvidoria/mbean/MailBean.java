package br.ufc.ouvidoria.mbean;

import javax.faces.bean.ManagedBean;

import br.ufc.ouvidoria.Mail;

@ManagedBean
public class MailBean {

	public String from;
	public String to;
	public String subject;
	public String text;

	public void sendMail() {

		Mail mail = new Mail();

		mail.sendMail(text, subject, from, to);
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return from;
	}

	public String getText() {
		return from;
	}
}
