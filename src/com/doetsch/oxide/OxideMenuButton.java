package com.doetsch.oxide;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

/**
 * OxideMenuButton utilizes a customized JLabel to implement 
 * the behavior of a button. OxideMenuButton also decorates itself
 * such that it adheres to the Oxide aesthetic; when the mouse 
 * cursor hovers over an OxideMenuButton it will be surrounded by
 * a thin white border, the OxideMenuButton is opaque and shows
 * a matte color the same as the OxideFrame's decoration color.
 * 
 */
public class OxideMenuButton extends JLabel {

	/*
	 * Satisfies Serializable 
	 */
	private static final long serialVersionUID = 2008351390536732476L;
	
	private AbstractAction action;	
	
	/**
	 * Creates an OxideMenuButton with the given text.
	 * 
	 * @param text a String representation of the button's text label
	 */
	public OxideMenuButton (String text) {
		super.setText(text);
		
		buildComponent();
		initBehavior();
	}
	
	/*
	 * Defines the button's decoration
	 */
	private void buildComponent () {
		this.setOpaque(true);
		this.setBackground(OxidePalette.menuButtonUnselectedColor);
		this.setForeground(OxidePalette.menuButtonFontColor);
		this.setFont(OxidePalette.menuButtonFontFace);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
	
	/*
	 * Defines the buttons behavior when hovered over and pressed
	 */
	private void initBehavior () {
		
		/*
		 * Define behavior regarding mouse actions
		 */
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked (MouseEvent e) {
			}

			/*
			 * When the cursor hovers over the button then draw a thin border
			 * around it
			 */
			@Override
			public void mouseEntered (MouseEvent e) {
				OxideMenuButton.this.setBorder(OxidePalette.buttonHoverBorder);
			}

			/*
			 * When the cursor stops hovering over the button then remove the
			 * thin border
			 */
			@Override
			public void mouseExited (MouseEvent e) {
				OxideMenuButton.this.setBorder(null);
			}

			/*
			 * Perform the action specified by the action listener
			 */
			@Override
			public void mousePressed (MouseEvent e) {
				if (action != null) {
					action.actionPerformed(null);
				}
				OxideMenuButton.this.setBackground(OxidePalette.menuButtonSelectedColor);
			}

			@Override
			public void mouseReleased (MouseEvent e) {
				OxideMenuButton.this.setBackground(OxidePalette.menuButtonUnselectedColor);
			}
			
		});
		
	}
	
	/**
	 * Sets the action to invoke when the button is pressed.
	 * 
	 * @param action the AbstractAction to invoke
	 */
	public void setActionListener (AbstractAction action) {
		this.action = action; 
	}
	
}