package twitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TweetsFolder {
	File directory;
	
	public TweetsFolder(String directoryLocation) {
		this.directory = new File(directoryLocation);
	}
		
	public HashMap<String, Integer> extractHashtags(File tweetFile) throws FileNotFoundException {
		HashMap<String, Integer> hashtags = new HashMap<String, Integer>();
		Scanner input = new Scanner(tweetFile, "UTF-8");
		
		Pattern hashtagPattern = Pattern.compile("#[\\w]+");
		Matcher hashtagMatcher;
		String nextToken;

		while (input.hasNext()) {
			nextToken = input.next().toLowerCase();
			hashtagMatcher = hashtagPattern.matcher(nextToken);
			if (hashtagMatcher.matches()) {
				nextToken = hashtagMatcher.group();
				if (!hashtags.containsKey(nextToken))
					hashtags.put(nextToken, 1);
				else
					hashtags.put(nextToken, hashtags.get(nextToken)+1);	
			}
		}
		input.close();
		return hashtags;
	}
	
	public LinkedHashMap<String, Integer> findTopThreeValues(HashMap<String, Integer> map) {
		LinkedHashMap<String, Integer> topThree = new LinkedHashMap<String, Integer>();
		
		String topTag;
		int topVal;
		
		for (int i = 0; i < 3; i++) {
			topVal = -1;
			topTag = "";
			for(String key: map.keySet()) {
				if ((map.get(key) > topVal) && (!topThree.keySet().contains(key))) {
					topVal = map.get(key);
					topTag = key;
				}
			}
			topThree.put(topTag, topVal);
		}

		return topThree;
	}
	
	public void findTopThreeHashtags() throws Exception {
		if (this.directory.exists() && this.directory.isDirectory()) {
			for(File e: this.directory.listFiles()) {
				System.out.println(e.getName().substring(0, e.getName().indexOf('.')) + ": "); 
				
				int count = 1;
				LinkedHashMap<String, Integer> topThree = findTopThreeValues(extractHashtags(e));
				for(String tag: topThree.keySet()) {
					System.out.println("\tNumber " + count + " - " + tag + " (" +  topThree.get(tag) + " occurrences)");
					count++;
				}
			}
		}
	
	}
}
