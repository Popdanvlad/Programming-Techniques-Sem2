package thesaurus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class ThesaurusImpl<JSONObject> implements Thesaurus {
	private HashMap<String, ArrayList<String>> thesaurus;
	private final String defaultDefinitionFile = "C:\\Users\\Dan\\Desktop\\Homework5\\user.json";

	public ThesaurusImpl() {
		thesaurus = new HashMap<String, ArrayList<String>>();
	}

	public boolean synonymExists(ArrayList<String> syn, String synWord) {
		for (String s : syn) {
			System.out.println(s + "" + synWord);
			if (synWord.equals(s)) {
				return true;
			}

			else {
				if (s.toLowerCase().contains(synWord.toLowerCase())) {
					return true;
				}
				if (synWord.toLowerCase().contains(s.toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Adds a synonym to a word.
	 * 
	 * @param word
	 * @param synonym
	 */
	public String addSynonym(String word, String synonym) {
		ArrayList<String> syn = new ArrayList<>();
		if (thesaurus.containsKey(word)) {
			syn = thesaurus.get(word);
			if (synonymExists(syn, synonym)) {
				return "Synonym already exists!";
			} else {
				syn.add(synonym);
				return "Synonym is added!";
			}
		} else {
			syn.add(synonym);
			thesaurus.put(word, syn);
			return "Word and its synonym are added!";
		}
	}

	/**
	 * Gets all the synonyms for a word
	 * 
	 * @param word
	 * @return an array of synonyms
	 */
	public ArrayList<String> getSynonyms(String word) {
		return thesaurus.get(word);
	}

	public HashMap<String, ArrayList<String>> getThesaurus() {
		return thesaurus;
	}

	public void setThesaurus(HashMap<String, ArrayList<String>> thesaurus) {
		this.thesaurus = thesaurus;
	}

	/**
	 * Searches for words based on a regular expression
	 * 
	 * @param regex
	 *            the regular expression to search for
	 * @return an array list of string with the resulting words
	 */
	public ArrayList<String> searchDefinition(String regex) {
		assert isConsistent() : "Not consistent";
		assert regex.isEmpty() == false : "The word" + " must not be null";
		ArrayList<String> results = new ArrayList<String>();
		try {

			regex = regex.replace("?", ".?");
			regex = regex.replace("*", ".*");

			Pattern p = Pattern.compile(regex);
			for (String candidate : thesaurus.keySet()) {
				Matcher m = p.matcher(candidate);
				if (m.find()) {
					results.add(candidate);
				}
			}
		} catch (PatternSyntaxException e) {
			System.out.println("Incorrect pattern syntax: " + regex);
		}
		assert results == null : "Incorrect search, retuns NULL!";
		return results;

	}

	/**
	 * Assesses the consistency of the thesaurus
	 * 
	 * @return
	 */
	public boolean isConsistent() {
		ArrayList<String> thesaurusKeys = new ArrayList<>();
		thesaurusKeys.addAll(thesaurus.keySet());
		for (String s : thesaurusKeys) {
			ArrayList<String> synonyms = thesaurus.get(s);
			for (String syn : synonyms) {
				if (thesaurus.containsKey(syn) == false) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Remove a word from the thesaurus. This means removing it both as a
	 * definition and any occurence it may have as a synonym for other words.
	 * 
	 * @param word
	 *            -- the word to remove
	 */
	public void removeDefinition(String word) {
		if (thesaurus.containsKey(word)) {
			thesaurus.remove(word);
			for (String s : thesaurus.keySet()) {
				removeSynonym(s, word);
			}
		}
		try {
			for (String s : thesaurus.keySet()) {
				if (thesaurus.get(s).isEmpty()) {
					thesaurus.remove(s);
					break;
				}
			}
		} catch (ConcurrentModificationException e) {

		}

	}

	/**
	 * Removes a synonym from the list of synonyms of a word
	 * 
	 * @param word
	 *            -- the word from which to remove the synonym
	 * @param synonym
	 *            -- the synonym to be removed
	 */
	public void removeSynonym(String word, String synonym) {
		if (thesaurus.containsKey(word)) {
			thesaurus.get(word).remove(synonym);
		}
	}

	/**
	 * Saves the current state of the thesaurus to the default definition file
	 */

	public void JSONWrite() {
		try {
			ObjectMapper mapper = new ObjectMapper();

			// write JSON to a file
			mapper.writeValue(new File(defaultDefinitionFile), thesaurus);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads definitions from an user-specified file
	 * 
	 */

	public void JSONRead() {
		try {

			ObjectMapper mapper = new ObjectMapper();

			Map<String, ArrayList<String>> map = mapper.readValue(new File(defaultDefinitionFile),
					new TypeReference<Map<String, ArrayList<String>>>() {
					});
			thesaurus = (HashMap<String, ArrayList<String>>) map;

			System.out.println(thesaurus.toString());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
