package com.doetsch.oxide;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.AbstractBorder;

/**
 * OxideSkin is an interface that declares and defines the member
 * method stubs necessary to decorate an OxideFrame. Implementing
 * classes define the specific component palette that can then be 
 * used to decorate an OxideFrame instance.
 * 
 * @author Jacob Wesley Doetsch
 */
public interface OxideSkin {

	/**
	 * Defines and returns the thickness, or width, of the frame's
	 * decoration border.
	 * 
	 * @return the border's thickness in pixels
	 */
	public int getDecorationBorderWidth ();
	
	/**
	 * Defines and returns the thickness, or width, of the frame's
	 * border.
	 * 
	 * @return the thickness in pixels
	 */
	public int getFrameBorderWidth ();
	
	/**
	 * Defines and returns the height of the OxideFrame title bar
	 * for parent windows.
	 * 
	 * @return the height of a parent frame's title bar
	 */
	public int getParentFrameTitleBarHeight ();
	
	/**
	 * Defines and returns the height of the OxideFrame title bar
	 * for child windows.
	 * 
	 * @return the height of a child frame's title bar
	 */
	public int getChildFrameTitleBarHeight ();
	
	/**
	 * Defines and returns the color of an OxideFrame's border.
	 * 
	 * @return a Color representation of the border color
	 */
	public Color getFrameBorderColor ();

	/**
	 * Defines and returns the color of an OxideFrame's decoration
	 * border.
	 * 
	 * @return a Color representation of the border color
	 */
	public Color getDecorationBorderColor ();

	/**
	 * Defines and returns the background color of the content panel.
	 *  
	 * @return a Color representation of the background color 
	 */
	public Color getContentPanelColor ();

	/**
	 * Defines and returns the color of the border that appears when
	 * the mouse cursor hovers an OxideMenuButton.
	 * 
	 * @return a Color representation of the border color
	 */
	public Color getMouseHoverBorderColor ();

	/**
	 * Defines and returns the font face of a parent frame's title.
	 * 
	 * @return a Font representation of the frame title's font face
	 */
	public Font getParentTitleFontFace ();
	
	/**
	 * Defines and returns the font color of a parent frame's title.
	 * 
	 * @return a Color representation of the frame title's font color
	 */
	public Color getParentTitleFontColor ();
	
	/**
	 * Defines and returns the font face of a parent frame's title.
	 * 
	 * @return a Font representation of the frame title's font face
	 */
	public Font getChildTitleFontFace ();
	
	/**
	 * Defines and returns the font color of a parent frame's title.
	 * 
	 * @return a Color representation of the frame title's font color
	 */
	public Color getChildTitleFontColor ();
	
	/**
	 * Defines and returns the font face of an OxideMenuButton's label.
	 * 
	 * @return a Font representation of an OxideMenuButton's label
	 */
	public Font getMenuButtonFontFace ();
	
	/**
	 * Defines and returns the font color of an OxideMenuButton's label.
	 * 
	 * @return a Color representation of an OxideMenuButton's label
	 */
	public Color getMenuButtonFontColor ();
	
	/**
	 * Defines and returns the background color of an OxideMenuButton when
	 * selected.
	 * 
	 * @return a Color representation of the OxideMenuButton's color
	 */
	public Color getMenuButtonSelectedColor ();
	
	/**
	 * Defines and returns the background color of an OxideMenuButton when
	 * not selected.
	 * 
	 * @return a Color representation of the OxideMenuButton's color
	 */
	public Color getMenuButtonUnselectedColor ();
	
	/**
	 * Defines and returns the border that appears when a mouse cursor
	 * hovers over an OxideMenuButton.
	 * 
	 * @return an AbstractBorder representation of the border 
	 */
	public AbstractBorder getButtonHoverBorder ();
	
	/**
	 * Defines and returns the border that surrounds OxideMenuButton
	 * components when the mouse cursor is not hovering over them.
	 * 
	 * @return an AbstractBorder representation of the border
	 */
	public AbstractBorder getButtonDefaultBorder ();
	
	/**
	 * Defines and returns the font face of Oxide UI components.
	 * 
	 * @return a Font representation of the font face
	 */
	public Font getControlFontFace ();
	
	/**
	 * Defines and returns the font color of Oxide UI components.
	 *  
	 * @return a Color representation of the font color
	 */
	public Color getControlFontColor ();
	
	/**
	 * Defines and returns the first skin-specific shade color used
	 * to manually decorate Swing UI components to adhere to the
	 * skin's defined aesthetic.
	 */
	public Color getShadeColor1 ();	
}