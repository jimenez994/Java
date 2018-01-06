import java.util.HashMap;
import java.util.Set;
public class tracklist {

	public String track(String name) {
		HashMap<String, String> tracklist = new HashMap<String, String>();
		tracklist.put("Perfect", "I found a love for me\n" + 
				"Darling just dive right in\n" + 
				"And follow my lead\n" + 
				"Well I found a girl beautiful and sweet \n" + 
				"I never knew you were the someone waiting for me\n" + 
				"'Cause we were just kids when we fell in love");
		tracklist.put("Havana", "Hey\n" + 
				"Havana, ooh na-na (ay)\n" + 
				"Half of my heart is in Havana, ooh-na-na (ay, ay)\n" + 
				"He took me back to East Atlanta, na-na-na\n" + 
				"All of my heart is in Havana (ay)\n" + 
				"There's somethin' 'bout his manners (uh huh)\n" + 
				"Havana, ooh na-na (uh)");
		tracklist.put("Too good at goodbyes", "You must think that I'm stupid\n" + 
				"You must think that I'm a fool\n" + 
				"You must think that I'm new to this\n" + 
				"But I have seen this all before\n" + 
				"");
		tracklist.put("Thunder", "Just a young gun with a quick fuse\n" + 
				"I was uptight, wanna let loose\n" + 
				"I was dreaming of bigger things\n" + 
				"And wanna leave my own life behind\n" + 
				"Not a yes sir, not a follower\n" + 
				"Fit the box, fit the mold\n" + 
				"Have a seat in the foyer, take a number\n" + 
				"I was lightning before the thunder");
	
		Set<String> keys = tracklist.keySet();
		for(String key: keys){
            System.out.println(key+" : "+ tracklist.get(key));
        }
		
		String lyrics = tracklist.get(name);
		
		if (lyrics == null) {
			return "sorry try oher song ";
		}else {
			return lyrics;
		}
		
		
		
	}
}
