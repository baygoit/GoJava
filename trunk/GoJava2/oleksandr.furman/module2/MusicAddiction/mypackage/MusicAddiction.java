package mypackage;

import java.io.IOException;
import java.util.Scanner;

public class MusicAddiction {
	public static void main(String[] args) throws IOException {
		User user = new User();
		user.userAuthorization();

		Search search = new Search();
		search.searchByKeywords();

		WebPlayer webPlayer = new WebPlayer();
		webPlayer.player(search.trackName);

	}
}
