package twitter;

public class Feed {

	public static void main(String[] args) throws Exception {
		User a = new User("a");
		User b = new User("b");
		User c = new User("c");
		a.follow(c);
		b.post("Hi");
		a.follow(b);
		Thread.sleep(1000);
		c.post("Hello");
		Thread.sleep(2000);
		b.post("Hi again");
		a.displayTweets();
		Thread.sleep(3000);
		c.post("Hello again");
		a.displayTweets();
	}

}
