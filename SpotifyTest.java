public class SpotifyTest {
	public static void main (String args[]) {
		try {
			Process pr = Runtime.getRuntime().exec("osascript SpotifyTest2.app/ " + args[0]);
			pr.waitFor();
		} catch (Exception e) {

		}
	}
}