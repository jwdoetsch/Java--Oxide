package com.doetsch.oxide;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.AbstractBorder;

public interface OxideSkin {

	/**
	 * 
	 */
	public int getDecorationBorderWidth ();
	
	/*
	 * 
	 */
	public int getFrameBorderWidth ();
	
	/**
	 * @return
	 */
	public int getParentFrameTitleBarHeight ();
	
	/**
	 * @return
	 */
	public int getChildFrameTitleBarHeight ();
	
	/**
	 * Returns the Oxide frame's border color.
	 * 
	 * @param Color the Color representation of the border color
	 */
	public Color getFrameBorderColor ();

	/**
	 * @return
	 */
	public Color getDecorationBorderColor ();

	/**
	 * @return
	 */
	public Color getContentPanelColor ();

	/**
	 * @return
	 */
	public Color getMouseHoverBorderColor ();

	/**
	 * @return
	 */
	public Font getParentTitleFontFace ();
	
	/**
	 * @return
	 */
	public Color getParentTitleFontColor ();
	
	/**
	 * @return
	 */
	public Font getChildTitleFontFace ();
	
	/**
	 * @return
	 */
	public Color getChildTitleFontColor ();
	
	/**
	 * @return
	 */
	public Font getMenuButtonFontFace ();
	
	/**
	 * @return
	 */
	public Color getMenuButtonFontColor ();
	
	/**
	 * @return
	 */
	public Color getMenuButtonSelectedColor ();
	
	/**
	 * @return
	 */
	public Color getMenuButtonUnselectedColor ();
	
	/**
	 * @return
	 */
	public AbstractBorder getButtonHoverBorder ();
	
	/**
	 * @return
	 */
	public AbstractBorder getButtonDefaultBorder ();
	
	/**
	 * @return
	 */
	public Font getControlFontFace ();
	
	/**
	 * @return
	 */
	public Color getControlFontColor ();
	
	
	public Color getOxideShade1 ();	
}