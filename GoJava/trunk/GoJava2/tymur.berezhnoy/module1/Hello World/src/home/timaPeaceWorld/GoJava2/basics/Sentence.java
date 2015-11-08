package home.timaPeaceWorld.GoJava2.basics;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javazoom.jl.player.Player; // The Java mp3 player (i found it in the Internet)

public class Sentence {
	
	private static String ENCODING = "UTF-8";
	private static String URL_BEGINNING = "http://translate.google.com/translate_tts?ie=";
	private static String URL_QUERY = "&q=";
	private static String URL_TL = "&tl=";
	private static String USER_AGENT_LITERAL = "User-Agent"; // Pretend internet browser...
	private static String USER_AGENT = "Mozilla/4.7";		// and google will not ban us.
	
	private InputStream input;
	private BufferedInputStream audio;
	
	public void say(String sentence, String language){
		try{			
			sentence = URLEncoder.encode(sentence, ENCODING);
			
			String sURL = URL_BEGINNING + ENCODING + URL_TL + language + URL_QUERY + sentence;
			URL url = new URL(sURL);
			
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.addRequestProperty(USER_AGENT_LITERAL, USER_AGENT);
		
			input = urlConn.getInputStream();
			audio = new BufferedInputStream(input);
			
			new Player(audio).play();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				input.close();
				audio.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
