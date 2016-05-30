package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class UserInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField synonimsTextField;
	private JButton btnSearchButton;
	private JButton btnAddWord;
	private JButton btnRemoveWord;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JTextField wordTextFiels;
	private JFrame frame;
	private JButton btnCloseButton;

	public JFrame getFrame() {
		return frame;
	}

	public JButton getBtnCloseButton() {
		return btnCloseButton;
	}

	public UserInterface() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 726, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		wordTextFiels = new JTextField();
		wordTextFiels.setBounds(111, 53, 281, 25);
		contentPane.add(wordTextFiels);
		wordTextFiels.setColumns(10);

		btnSearchButton = new JButton("SEARCH");
		btnSearchButton.setBounds(111, 141, 110, 25);
		contentPane.add(btnSearchButton);

		synonimsTextField = new JTextField();
		synonimsTextField.setBounds(111, 100, 281, 25);
		contentPane.add(synonimsTextField);
		synonimsTextField.setColumns(10);

		btnAddWord = new JButton("Add WORD");
		btnAddWord.setBounds(277, 141, 115, 25);
		contentPane.add(btnAddWord);

		btnRemoveWord = new JButton("Remove WORD");
		btnRemoveWord.setBounds(111, 176, 131, 25);
		contentPane.add(btnRemoveWord);

		JLabel lblWord = new JLabel("WORD:");
		lblWord.setBounds(28, 57, 56, 16);
		contentPane.add(lblWord);

		JLabel lblSy = new JLabel("Synonyms:");
		lblSy.setBounds(17, 104, 69, 16);
		contentPane.add(lblSy);

		comboBox = new JComboBox();
		comboBox.setBounds(457, 95, 237, 34);
		contentPane.add(comboBox);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(116, 198, 401, 16);
		contentPane.add(lblNewLabel);

		JLabel lblSeeSugestions = new JLabel("See sugestions:");
		lblSeeSugestions.setBounds(490, 53, 115, 25);
		contentPane.add(lblSeeSugestions);
		
		btnCloseButton = new JButton("CLOSE");
		btnCloseButton.setBounds(295, 177, 97, 25);
		contentPane.add(btnCloseButton);
		frame.setVisible(true);

	}

	public JButton getBtnSearchButton() {
		return btnSearchButton;
	}

	public JButton getBtnAddWord() {
		return btnAddWord;
	}

	public JButton getBtnRemoveWord() {
		return btnRemoveWord;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JTextField getSynonimsTextField() {
		return synonimsTextField;
	}

	public JTextField getWordTextFiels() {
		return wordTextFiels;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}


}
