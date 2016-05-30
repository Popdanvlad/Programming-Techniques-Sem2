package thesaurus;

import java.util.ArrayList;
import java.util.HashMap;

public interface Thesaurus {

	public String addSynonym(String word, String synonym);

	public  ArrayList<String> getSynonyms(String word);

	public  ArrayList<String> searchDefinition(String regex);

	public  void removeDefinition(String word);

	public void removeSynonym(String word, String synonym);

	public void JSONRead();
	
	public void JSONWrite();

	public HashMap<String, ArrayList<String>> getThesaurus();

}