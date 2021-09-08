package twitter;

import java.util.Scanner;

public class TopHashtagsDriver {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner();
		String folderName = input.next();
		
		TweetsFolder f = new TweetsFolder(folderName);
		f.findTopThreeHashtags();
		
		input.close();
	}

}
