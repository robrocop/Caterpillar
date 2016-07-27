package com.twilio;

import com.music.ActiveSongs;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SendingService {

	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC09b34d194921b4d7fbdebce89575a6bb";
	public static final String AUTH_TOKEN = "5945315ca88d07c9670c04173a2d96e5";

	public static void send(String number, String body) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Build a filter for the MessageList
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", body));
		params.add(new BasicNameValuePair("To", number));
		params.add(new BasicNameValuePair("From", "+16475609308"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
	}

	public static void send(String number) {
		
		String messageBody = "";
		
		for (String letter : ActiveSongs.letterToSongMap.keySet()){
			messageBody += letter + ": " +
					ActiveSongs.letterToSongMap.get(letter).name + "\n";
		}
		
		try {
			send(number, messageBody);
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
		
	}
}