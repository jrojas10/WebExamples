package tag;

public class numToText {
	public static String toText(String s) 
	{
		return s.replaceAll("1","One ")
			.replace("2", "Two ")
			.replace("3", "Three ")
			.replace("4", "Four ")
			.replace("5", "Five ")
			.replace("6", "Six ")
			.replace("7", "Seven")
			.replace("8", "Eight ")
			.replace("9", "Nine ")
			.replace("0", "Zero ");
	}
	
	public static String leetTalk( String s )
    {
        return s.replaceAll( "f", "ph" )
            .replace( 'a', '4' )
            .replace( 'e', '3' )
            .replace( 'l', '1' )
            .replace( 'o', '0' )
            .replace( 's', 'z' );
    }
}


