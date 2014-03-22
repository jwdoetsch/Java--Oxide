package com.doetsch.oxide;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
		button.setFont(OxidePalette.oxideControlFontFace);
		button.setForeground(OxidePalette.oxideControlFontColor);
		
		return button;
	}
	
	/**
	 * Creates a JComboBox instance that applies Oxide decoration as to
	 * adhere to the Oxide aesthetic standard.
	 * 
	 * @return the new JComboBox instance
	 */
	public JComboBox createComboBox () {
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(OxidePalette.oxideControlFontFace);
		comboBox.setForeground(OxidePalette.oxideControlFontColor);
		
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
		panel.setFont(OxidePalette.oxideControlFontFace);
		panel.setForeground(OxidePalette.oxideControlFontColor);
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
		label.setFont(OxidePalette.oxideControlFontFace);
		label.setForeground(OxidePalette.oxideControlFontColor);
		
		return label;
	}

	/**
	 * Creates a JradioButton instance that adheres to the Oxide aesthetic
	 * 
	 * @return the new JRadioButton instance
	 */
	public JRadioButton createRadioButton () {
		
		JRadioButton radioButton = new JRadioButton();
		radioButton.setFont(OxidePalette.oxideControlFontFace);
		radioButton.setForeground(OxidePalette.oxideControlFontColor);
		
		return radioButton;
	}
	
}
