package com.gojava2.helloweb;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.jl.player.Player;

public class HelloWorldServlet extends HttpServlet {
	  
	private String ENCODING = "UTF-8";
	private String URL_BEGINNING = "http://translate.google.com/translate_tts?ie=";
	private String URL_QUERY = "&q=";
	private String URL_TL = "&tl=";
	private String USER_AGENT_LITERAL = "User-Agent"; // Pretend internet browser...
	private String USER_AGENT = "Mozilla/4.7";		// and google will not ban us.
	
	private InputStream input;
	private BufferedInputStream audio;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		say(request.getParameter("sent"), request.getParameter("lang"));
		response.sendRedirect("HelloWorld.jsp");
	}
	
	public void say(String sentence, String language) {
		try {			
			sentence = URLEncoder.encode(sentence, ENCODING);
			
			String sURL = URL_BEGINNING + ENCODING + URL_TL + language + URL_QUERY + sentence;
			URL url = new URL(sURL);
			
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.addRequestProperty(USER_AGENT_LITERAL, USER_AGENT);
		
			input = urlConn.getInputStream();
			audio = new BufferedInputStream(input);
			
			new Player(audio).play();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				audio.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}