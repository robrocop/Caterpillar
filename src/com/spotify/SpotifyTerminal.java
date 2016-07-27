package com.spotify;

public class SpotifyTerminal {
	public static void play (String id) {

		try {
			Process pr = Runtime.getRuntime().exec("osascript SpotifyTest2.app/ " + id);
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
