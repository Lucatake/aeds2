package src;
import java.lang.Object;
import java.util.*;


class Musica {
	private String id, nome, key;
	private double acousticness, danceability, energy, instrumentalness, valence, liveness, loudness, speechiness;
	private int durationms, popularity, year;
	private float tempo;
	private Date realeasedate;
	private List artists;

	public static boolean isFim(String s){
	      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	   }

	public static String gets(String id) {
		
	}
	
	public static String sets(String id) {
			
		}
	
	public static String clone(String id) {
		
	}
	
	public static String imprimir(String id) {
		
		
		MyIO.println(id+" ## "+artists" ## "name" ## "realeasedate" ## "acousticness" ## "danceability" ## "instrumentalness" ## "liveness" ## "loudness" ## "speechiness" ## "energy" ## "duration);	
	}
	
	public static String ler(String id) {
		
		
		
	}

	
	public static void main(String args[]) {
		
	}
	
}
