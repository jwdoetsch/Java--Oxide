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
 */
public class OxideMenuButton extends JLabel {

	/*
	 * Satisfies Serializable 
	 */
	private static final long serialVersionUID = 2008351390536732476L;
	private boolean isSelected;
	private AbstractAction action;	
	private OxideSkin skin;
	
	/**
	 * Creates an OxideMenuButton with the given text.
	 * 
	 * @param text a String representation of the button's text label
	 */
	public OxideMenuButton (String text, OxideSkin skin) {
		super.setText(text);
		
		this.skin = skin;
		
		buildComponent();
		initBehavior();
		
		
	}
	
	/*
	 * Defines the button's decoration
	 */
	private void buildComponent () {
		this.setOpaque(true);
		isSelected = false;
		this.setBackground(skin.getMenuButtonUnselectedColor());
		this.setForeground(skin.getMenuButtonFontColor());
		this.setFont(skin.getMenuButtonFontFace());
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
				OxideMenuButton.this.setBorder(skin.getButtonHoverBorder());
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
				
				setSelected (true);
			}

			@Override
			public void mouseReleased (MouseEvent e) {
			}
			
		});
		
	}
	
	/**
	 * Returns the action invoked when the button is pressed.
	 * 
	 * @return the AbstractAction invoked whent he button is pressed
	 */
	public AbstractAction getActionListener () {
		return action;
	}
	
	/**
	 * Sets the action to invoke when the button is pressed.
	 * 
	 * @param action the AbstractAction to invoke
	 */
	public void setActionListener (AbstractAction action) {
		this.action = action; 
	}
	
	/**
	 * 
	 */
	public boolean isSelected () {
		return this.isSelected;
	}
	
	public void setSelected (boolean isSelected) {
		this.isSelected = isSelected;
		
		if (isSelected) {
			OxideMenuButton.this.setBackground(skin.getMenuButtonSelectedColor());
		} else {
			OxideMenuButton.this.setBackground(skin.getMenuButtonUnselectedColor());
		}
		
	}
	
}
