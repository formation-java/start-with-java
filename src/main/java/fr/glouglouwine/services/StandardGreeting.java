package fr.glouglouwine.services;

public class StandardGreeting implements Greeting {

	@Override
	public String getText(String msg) {
		return "You Said" + msg;
	}

	@Override
	public GreetingMessage getJson(String msg) {
		StandardGreetingMessage message = new StandardGreetingMessage();
		message.message = msg;
		return message;
	}

}
