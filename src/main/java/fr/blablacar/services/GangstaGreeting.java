package fr.blablacar.services;

import java.time.LocalDateTime;

public class GangstaGreeting implements Greeting {

	@Override
	public String getText(String msg) {
		StringBuilder sb = new StringBuilder("YO MAN !");
		sb.append(" I Heard You said :").append("[").append(msg).append("] @ "+LocalDateTime.now());
		return sb.toString();
	}

	@Override
	public GreetingMessage getJson(String msg) {
		GangstaGreetingMessage message = new GangstaGreetingMessage();
		message.message = GangstaGreetingMessage.welcome+" "+msg;
		message.dateTime = LocalDateTime.now();
		return message;
	}

}
