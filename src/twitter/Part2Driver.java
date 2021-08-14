package twitter;

/**
 * Driver for CSCB07 Assignment 2: Part 2
 * @author Anindro Bhattacharya
 *
 */

public class Part2Driver {

	public static void main(String[] args) throws Exception {
		TweetsFolder f = new TweetsFolder("Tweets2020");
		f.findTopThreeHashtags();

	}

}
