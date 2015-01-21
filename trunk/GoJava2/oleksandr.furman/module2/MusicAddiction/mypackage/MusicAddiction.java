import java.io.IOException;
import java.util.Scanner;

public class MusicAddiction {
		 public static void main(String[] args) throws IOException {
			 User user = new User();
			 user.userAuthorization();
			 
			 Search search = new Search();
			 search.searchByKeywords();
			 			 
			 System.out.println("Do you wanna play one of found audio tracks now?");
			 System.out.println("Enter Y to play or N to stop the program.");
			 Scanner scanner = new Scanner(System.in);
			 String yesOrNo = scanner.nextLine();
			 if(yesOrNo.equals("Y") | yesOrNo.equals("y")){
			 WebPlayer webPlayer = new WebPlayer();
			 webPlayer.player(search.trackName);
			 }
			}
}
