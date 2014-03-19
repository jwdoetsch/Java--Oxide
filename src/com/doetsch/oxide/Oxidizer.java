package com.doetsch.oxide;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Oxidizer is a factory and transformer class that instantiates Oxide-styled
 * UI components and styles existing Swing UI components to meet the Oxide
 * aesthetic specification. 
 * 
 * @author Jacob Wesley Doetsch
 *
 */
public class Oxidizer {

	/**
	 * Styles and decorates the given JComponent to match the Oxide aesthetic.
	 *  
	 * @param component the JComponent to style
	 */
	public static void oxidize (JComponent component) {
		
		/*
		 * If the JComponent is a control component then apply
		 * the Oxide control component font face and color
		 */
		if ((component instanceof JButton) ||
			(component instanceof JLabel) ||
			(component instanceof JCheckBox) ||
			(component instanceof JComboBox)) {
			component.setFont(OxidePalette.oxideControlFontFace);
			component.setForeground(OxidePalette.oxideControlFontColor);
		}
		
	}
	
	/**
	 * Instantiates and returns a JPanel with a titled border.
	 * 
	 * @param title the String representation of the border title
	 * @return the new JPanel instance
	 */
	public JPanel createTitledPanel (String title) {
		JPanel titledPanel = new JPanel();
		titledPanel.setBorder(new TitledBorder(
				new EtchedBorder(), title,
				TitledBorder.LEFT, TitledBorder.TOP,
				OxidePalette.oxideControlFontFace, OxidePalette.oxideControlFontColor));
		return null;	
		
	}
	
}
