package com.spotify;
import java.util.*;
import com.music.*;
import java.util.Random;

public class Database{
	
	public static List<Song> db;

	public static void init() {
		db = new ArrayList<Song>();
		addSong("Headlines - Drake", "spotify:track:7kfTqGMzIHFWeBeOJALzRf");
		addSong("Hotline Bling - Drake","spotify:track:6nmz4imkDcmtwMjocAzFSx");
		addSong("The Hills - The Weeknd","spotify:track:25khomWgBVamSdKw7hzm3l");
		addSong("Here - Alessia Cara","spotify:track:1wYZZtamWTQAoj8B812uKQ");
		addSong("Antidote - Travi$ Scott","spotify:track:0KaA33vmmUEY77YD6L3KFi");
		addSong("The Girl is Mine - 99 Souls","spotify:track:1zbTIdIbLYlXjtOqlHALh4");
		addSong("How Deep Is Your Love - Calvin Harris","spotify:track:22mek4IiqubGD9ctzxc69s");
		addSong("Lean On - Major Lazer, MØ, DJ Snake","spotify:track:4vS8VaBwJJV5Ry7UFIQuoo");
		addSong("Generate - Eric Prydz","spotify:track:63GNhuhywb3l3TKAEq8f0g");
		addSong("Opus - Eric Prydz","spotify:track:6gOZ71qsBFjXSJjBV5XdWP");
		addSong("Runaway (U & I) - Galantis","spotify:track:4qABfS1RaGVXdBhj2BQyhO");
		addSong("Atmosphere - Kaskade","spotify:track:3e9iivPr1NZ0ivSGgTdvn4");
		addSong("Waves (Robin Schulz Radio Edit) - Mr. Probz","spotify:track:5Sf3GyLEAzJXxZ5mbCPXTu");
		addSong("White Noise - Disclosure, AlunaGeorge","spotify:track:1wap9wHVL6wzhmQOuyhwMH");
		addSong("Counting Down The Days (Yotto Edit) - Above & Beyond","spotify:track:74NAAMyS6pjAIh8x46sAjG");
		addSong("All These Wounds - BT, Ilan Bluestone","spotify:track:3T4amFco8Ex2gjaadgyAiw");
		addSong("Hands - Gareth Emery","spotify:track:3JZ5bL6UYIeJ5x0SCXUQbO");
		addSong("Concrete Angel - Gareth Emery","spotify:track:51qqAnXJT4Ivgs19yDO2Uf");
		addSong("King (Arty Remix) - Years & Years","spotify:track:2JIOsfwXGIBXVi7o1rDg3L");
		addSong("The Only Way Is Up - Martin Garrix, Tiësto","spotify:track:0uvFFLI3Z6zidLLUsHDVVk");
		addSong("Five More Hours - Deorro x Chris ","spotify:track:6YwLgicpvVuMt1eE2OldwQ");
		addSong("Magnets - Disclosure, Lorde","spotify:track:2M0wZ9iOCsul9PgKCHnIWT");
		addSong("Roses - The Chainsmokers","spotify:track:3vv9phIu6Y1vX3jcqaGz5Z");
	}
	
	public static void addSong (String sname, String sid){
		
		Song newSong = new Song(sname, sid);
		db.add(newSong);
		
	}
	
	public static Song rmvSong (){
		Random random = new Random();
		int dbSize = db.size() - 1;
		int index = random.nextInt(dbSize);
		Song song = db.get(index);
		db.remove(index);
		return song;
	}
}
