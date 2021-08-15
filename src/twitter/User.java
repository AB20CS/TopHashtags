package twitter;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;

class Post {
	User poster;
	Date time;
	String message;
	
	public Post(User u, Date currentTime, String message) {
		this.poster = u;
		this.time = currentTime;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "@" + poster.username + " tweeted on " + time + ": " + message;
	}
}

class PostingControl {
	private HashSet<User> followers = new HashSet<User>();
	
	public void addFollower(User follower) {
		followers.add(follower);
	}
	
	public void updateFollowerFeeds(Post newPost) {
		for (User follower: followers) {
			follower.feed.add(newPost);
		}
	}
}

public class User {
	String username;
	HashSet<User> following;
	PostingControl postControl;
	LinkedHashSet<Post> feed = new LinkedHashSet<Post>();
	
	public User(String username) {
		this.username = username;
		following = new HashSet<User>();
		postControl = new PostingControl();
	}
	
	public void follow(User toFollow) throws IllegalArgumentException {
		if (this.equals(toFollow))
			throw new IllegalArgumentException("Invalid Request: User cannot follow themselves.");
		else if (this.following.contains(toFollow))
			throw new IllegalArgumentException("Invalid Request: User already follows given account.");
		else {
			following.add(toFollow);
			toFollow.postControl.addFollower(this);
		}
			
	}
	
	public void post(String message) {
		Post newPost = new Post(this, new Date(System.currentTimeMillis()), message);
		postControl.updateFollowerFeeds(newPost);
		
	}

	public void displayTweets() {
		System.out.println("----- Displaying Tweets -----");
		for (Post p: feed) {
			System.out.println(p + "\n");
		}
		feed.clear();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj.getClass() != getClass())
			return false;
		User u = (User) obj;
		return this.username == u.username;
	}
}
