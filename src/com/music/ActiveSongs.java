package com.music;

import java.util.HashMap;
import java.util.Map;

import com.spotify.Database;

public class ActiveSongs {
	public static Map<String, Song> letterToSongMap = new HashMap<String, Song>();
	public static Map<String, Integer> songVotesMap = new HashMap<String, Integer>();
	
	public static void init () {
		addSongToList("A", Database.rmvSong());
		addSongToList("B", Database.rmvSong());
		addSongToList("C", Database.rmvSong());
		addSongToList("D", Database.rmvSong());
		addSongToList("E", Database.rmvSong());
	}
	
	private static void addSongToList(String letter, Song song) {
		letterToSongMap.put(letter, song);
		songVotesMap.put(letter, 0);
	}

	public static Song popHighestSong() {
		int highestVote = 0;
		String highestLetter = null;
		for(String letter : songVotesMap.keySet()) {
			int tempVote = songVotesMap.get(letter);
			if (tempVote >= highestVote) {
				highestVote = tempVote;
				highestLetter = letter;
			}
		}
		Song song = letterToSongMap.get(highestLetter);
		songVotesMap.remove(highestLetter);
		letterToSongMap.remove(highestLetter);
		addSongToList(highestLetter, Database.rmvSong());
		return song;
	}
	
	public static void increaseVote (String letter) {
		int currVotes = songVotesMap.get(letter);
		songVotesMap.put(letter, currVotes + 1);
	}
	
}
