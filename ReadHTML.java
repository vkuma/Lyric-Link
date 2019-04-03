import java.net.URL;
import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadHTML {

    public static String getLyrics( String spec ) throws MalformedURLException, IOException {
    
        URL url = new URL( spec );

        StringBuilder LyricsUnedit = new StringBuilder();
        StringBuilder LyricsEdit = new StringBuilder();
        
        //sets variable so that it reads the line of the HTML document 
        BufferedReader in = new BufferedReader(new InputStreamReader( url.openStream() ) );

        String line = null;
        String FinalEdit;
        
        //converts the entire HTML to text
        while ( ( line = in.readLine() ) != null ) {
            LyricsUnedit.append(line);
        	LyricsUnedit.append("\n");
        }

        //closes link to URL
        in.close();
        
        //imports the lyrics from the HTML converted document from SrtingBuilder LyricsEdit to StringBuilder LyricsUnedit
        LyricsEdit.append( LyricsUnedit.substring(LyricsUnedit.indexOf("<!-- start of lyrics -->")+("<!-- start of lyrics -->").length(), LyricsUnedit.indexOf("<!-- end of lyrics -->")) );
        //deletes all instances of the <br> and the <br /> tag in the 
        FinalEdit = LyricsEdit.toString().replace("<br>", "");//to edit plyrics
        FinalEdit = FinalEdit.replace("<br />", "");//to edit azlyrics

		return FinalEdit;
      
    }

    public static void main( String[] args )throws MalformedURLException, IOException {
    	//System.out.println( getLyrics("http://www.plyrics.com/lyrics/anarbor/alwaysdirtyneverclean.html") );
    	System.out.println( getLyrics("http://www.azlyrics.com/lyrics/anarbor/alwaysdirtyneverclean.html") );
    }
}
