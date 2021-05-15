package com.sapient.day7;

import java.time.LocalDate;

import com.publicissapient.day2.Person;
import com.publicissapient.day3.Instructor;

public class Invitation<T extends Person> {

	private String subject;
	private String message;
	private LocalDate eventDate;
	private T recipient;

	public Invitation(String subject, String message, LocalDate eventDate, T recipient) {

		setSubject(subject);
		setMessage(message);
		setEventDate(eventDate);
		setRecipient(recipient);

	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public T getRecipient() {
		return recipient;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public void setRecipient(T recipient) {
		this.recipient = recipient;
	}

	public void sendInvitation() {

		StringBuffer sb = new StringBuffer();
		System.out.println(sb.append("\nSending out the email to ").append(recipient.getEmail_Id())
				.append("\n------------------- \n").append("Event Date: ").append(getEventDate()).append("\n")
				.append("Subject: ").append(getSubject()).append("\nDear: ").append(recipient.getName()).append(",\n")
				.append(getMessage()).append("\nThanks\n------------------ "));
	}

	public void sendInvitation(Invitation<? super Instructor> p) {
		p.sendInvitation();
	}

	public void forwardInvitation(Invitation<? super Instructor> invitation) {
		sendInvitation(invitation);
	}

}
