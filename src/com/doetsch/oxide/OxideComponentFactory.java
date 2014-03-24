package com.doetsch.oxide;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * OxideCompomentFactory is, intuitively, a factory class that instantiates
 * Swing UI components that adhere to the Oxide aesthetic.
 * 
 * @author Jacob Wesley Doetsch
 */
public class OxideComponentFactory {

	
	/**
	 * Creates a JButton instance that applies Oxide decoration as to
	 * adhere to the Oxide aesthetic standard.
	 * 
	 * @return the new JButton instance
	 */
	public JButton createButton () {
		
		JButton button = new JButton();
		applyControlComponentDefaults(button);
		
		return button;
	}
	
	/**
	 * Creates a JComboBox instance that applies Oxide decoration as to
	 * adhere to the Oxide aesthetic standard.
	 * 
	 * @return the new JComboBox instance
	 */
	public JComboBox<String> createComboBox () {
		
		JComboBox<String> comboBox = new JComboBox<String>();
		applyControlComponentDefaults(comboBox);
		
		return comboBox;
	}
	
	/**
	 * Creates a JPanel with a titled border that adheres to the Oxide
	 * aesthetic.
	 * 
	 * @param title the border title text
	 * @return the new titled JPanel instance
	 */
	public JPanel createTitledPanel (String title) {
		
		JPanel panel = new JPanel();
		applyControlComponentDefaults(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), title,
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				OxidePalette.oxideControlFontFace, OxidePalette.oxideControlFontColor));
		
		return panel;
	}
	
	/**
	 * Creates a JLabel that adheres to the Oxide aesthetic.
	 * 
	 * @param text the labels text
	 * @return the new JLabel instance
	 */
	public JLabel createLabel (String text) {
		
		JLabel label = new JLabel(text);
		applyControlComponentDefaults(label);
		
		return label;
	}

	/**
	 * Creates a JRadioButton instance that adheres to the Oxide aesthetic
	 * 
	 * @return the new JRadioButton instance
	 */
	public JRadioButton createRadioButton () {
		
		JRadioButton radioButton = new JRadioButton();
		applyControlComponentDefaults(radioButton);
		
		return radioButton;
	}
	
	/**
	 * Creates a JCheckBox instance that adheres to the Oxide aesthetic.
	 * 
	 * @return the new JCheckBox instance
	 */
	public JCheckBox createCheckBox () {
		
		JCheckBox checkBox = new JCheckBox();
		applyControlComponentDefaults(checkBox);
		
		return checkBox;
	}
	
	/**
	 * Creates a JTextField instance that adheres to the Oxide aesthetic.
	 * 
	 * @return the new JTextField instance
	 */
	public JTextField createTextField () {
		
		JTextField textField = new JTextField();
		applyControlComponentDefaults(textField);
		
		return textField;
	}
	
	/**
	 * Creates a JTextArea instance that adheres to the Oxide aesthetic.
	 * 
	 * @return the new JTextArea instance
	 */
	public JTextArea createTextArea () {
		
		JTextArea textArea = new JTextArea();
		applyControlComponentDefaults(textArea);
		
		return textArea;		
	}
	
	/**
	 * Creates a JList instance that adheres to the Oxide aesthetic.
	 * 
	 * @return the new JList instance
	 */
	public JList createList () {
		
		JList list = new JList();
		applyControlComponentDefaults(list);
		
		return list;
	}
	
	/*
	 * Applies the default control component font face and color. 
	 */
	private void applyControlComponentDefaults (JComponent component) {
		
		component.setFont(OxidePalette.oxideControlFontFace);
		component.setForeground(OxidePalette.oxideControlFontColor);
		
	}
	
}
