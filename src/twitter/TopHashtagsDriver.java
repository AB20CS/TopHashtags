package twitter;

public class TopHashtagsDriver {

	public static void main(String[] args) throws Exception {
		TweetsFolder f = new TweetsFolder("Tweets2020");
		f.findTopThreeHashtags();

	}

}
