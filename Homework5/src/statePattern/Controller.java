package statePattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import thesaurus.Thesaurus;
import thesaurus.ThesaurusImpl;
import ui.UserInterface;

public class Controller {
	private String word;
	private String synonym;
	private UserInterface gui;
	private Thesaurus th;
	private State state;
	private boolean working = true;
	
	public Controller() {
		gui = new UserInterface();
		th = new ThesaurusImpl ();
		th.JSONRead();
		word = null;
		synonym = null;
		state = null;
		
		gui.getBtnAddWord().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getData()) {
					System.out.println(word + "  " + synonym);
					gui.getLblNewLabel().setText(th.addSynonym(word, synonym));
					th.JSONWrite();
					for (String s : th.getThesaurus().get(word)) {
						if (s.equals(synonym) == false) {
							th.addSynonym(s, synonym);
							th.JSONWrite();
							th.addSynonym(synonym, s);
							th.JSONWrite();
						}
					}
					System.out.println(word + "  " + synonym);
					th.addSynonym(synonym, word);
					th.JSONWrite();
				} else {
					gui.getLblNewLabel().setText("ADD DATA! ");
				}
			}
		});

		gui.getBtnRemoveWord().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getData()) {
					th.removeDefinition(word);
					th.JSONWrite();
				} else {
					gui.getLblNewLabel().setText("ADD DATA! ");
				}
			}
		});

		gui.getBtnSearchButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getData()) {
					System.out.println(word + synonym);
					ArrayList<String> words = new ArrayList<String>();
					words = th.searchDefinition(word);
					System.out.println(words);
					gui.getComboBox().removeAllItems();
					for (String s : words)
						gui.getComboBox().addItem(s);
				} else {
					gui.getLblNewLabel().setText("ADD DATA! ");
				}
			}
		});

		gui.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gui.getComboBox().getSelectedItem() != null) {
					ArrayList<String> a = new ArrayList<String>();
					a = (ArrayList<String>) th.getThesaurus().get(gui.getComboBox().getSelectedItem());
					String s = new String();
					for (String s1 : a) {
						s = s + " " + s1;
					}
					gui.getSynonimsTextField().setText(s);
				}
			}
		});
		gui.getBtnCloseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				working =false;
				gui.getFrame().dispose();
				
			}
		});
		
		if(!isWorking()){
			System.out.println("ERR");
		}
	}

	public boolean getData() {
		
		word = (gui.getWordTextFiels().getText()).toString();
		synonym = (gui.getSynonimsTextField().getText()).toString();
		if (word.equals(null) || synonym.equals(null))
			return false;
		else
			return true;
	}
	
	public boolean isWorking() {
		return working;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}
