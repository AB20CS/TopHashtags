package twitter;

// Driver

public class Feed {

	public static void main(String[] args) throws Exception {
		User andy = new User("Andy");
		User bob = new User("Bob");
		User cathy = new User("Cathy");
		andy.follow(cathy);
		bob.post("Hi");
		andy.follow(bob);
		Thread.sleep(1000);
		cathy.post("Hello");
		Thread.sleep(2000);
		bob.post("Hi again");
		andy.displayTweets();
		Thread.sleep(3000);
		cathy.post("Hello again");
		andy.displayTweets();
	}

}
