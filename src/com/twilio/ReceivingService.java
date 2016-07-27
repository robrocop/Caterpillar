package com.twilio;


import com.music.ActiveSongs;
import com.spotify.Database;
import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.*;
import com.twilio.sdk.resource.instance.*;
import com.twilio.sdk.resource.list.*;


public class ReceivingService implements Runnable{
	// capitalize everything in hashmap
	public static Map<String, Boolean> cellAdded_voted = new HashMap<String, Boolean>();


	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC09b34d194921b4d7fbdebce89575a6bb";
	public static final String AUTH_TOKEN = "5945315ca88d07c9670c04173a2d96e5";

	public void run() {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Skip through old messages
		int currMessages = 0;
		MessageList messages = client.getAccount().getMessages();
		for (Message message : messages) {
			currMessages++;
		}

		while (true) {
			MessageList newMessages = client.getAccount().getMessages();
			
			for (Message message : newMessages){
//				System.out.println(message.getBody());
			};
			
			int numOfMessages = newMessages.getEnd() + 1;
			if (numOfMessages > currMessages) {

				newMessages = client.getAccount().getMessages();
				for (Message message : newMessages) {
					if (numOfMessages <= currMessages)
						break;
					currMessages++;
					// Process messages here
					System.out.println("from: " + message.getFrom() + " message: " + message.getBody());

					if (cellAdded_voted.containsKey(message.getFrom()) && cellAdded_voted.containsValue(false)) {

						//song choices being sent in
						cellAdded_voted.put(message.getFrom(), true);

						String userChoice = message.getBody().toUpperCase();
						ActiveSongs.increaseVote(userChoice);
						
					} else if (!cellAdded_voted.containsKey(message.getFrom())) {
						cellAdded_voted.put(message.getFrom(), false);
						SendingService.send(message.getFrom());
						currMessages++;
					} else {
						// not allowed to vote more than once
						continue;
					}
				}
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}