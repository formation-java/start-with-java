package fr.glouglouwine.services;

public class GreetingService implements Greeting {

	private static final GreetingService INSTANCE = new GreetingService();
	private StandardGreeting standardGreeting;
	private GangstaGreeting gangstaGreeting;
	private GreetingStyle greetingStyle;

	private GreetingService() {
		this.greetingStyle = GreetingStyle.STANDARD;
		this.standardGreeting = new StandardGreeting();
		this.gangstaGreeting = new GangstaGreeting();
	}

	public static GreetingService getInstance() {
		return INSTANCE;
	}

	public void setGreetingStyle(GreetingStyle greetingStyle) {
		this.greetingStyle = greetingStyle;
	}

	@Override
	public String getText(String msg) {
		return getCurrentGreeting().getText(msg);
	}

	@Override
	public GreetingMessage getJson(String msg) {
		return getCurrentGreeting().getJson(msg);
	}

	private Greeting getCurrentGreeting() {
		switch (greetingStyle) {
		case GANGSTA:
			return gangstaGreeting;
		case STANDARD:
			return standardGreeting;
		default:
			throw new RuntimeException("Unknown greeting");
		}
	}
}
