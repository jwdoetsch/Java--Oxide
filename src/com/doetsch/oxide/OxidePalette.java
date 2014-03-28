package com.doetsch.oxide;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * OxidePalette provides static declarations of the component backgrounds,
 * foregrounds, font faces, font colors and other Oxide UI component parameters.
 * The colors and font faces are specified and chosen with respect towards 
 * ornamental compatibility with Metal, Java's cross-platform look and feel, and
 * define the Oxide aesthetic.
 * 
 * @author Jacob Wesley Doetsch
 */
public class OxidePalette {

	/**
	 * Defines the color of the outer-most frame border that surrounds the decoration pane.
	 */
	public static final Color frameBorderColor = new Color(51, 51, 51);
	
	/**
	 * Defines the color of the decoration pane/border.
	 */
	public static final Color decorationBorderColor = new Color(122, 138, 153);
	
	/**
	 * Defines the background color of the content pane.
	 */
	public static final Color contentPaneBackgroundColor = new Color(238, 238, 238);
	
	/**
	 * Defines the color of the border applied by LabelHoverListener in OxideFrame.
	 */
	public static final Color mouseHoverBorderColor = new Color(255, 255, 255);
//	
	/**
	 * Defines the font face of the title label text for parent frames.
	 */
	public static final Font titleFontFace = new Font("Monospaced", Font.BOLD, 22);
	
	/**
	 * Defines the font color of the title label text for parent frames.
	 */
	public static final Color titleFontColor = new Color(255, 255, 255);
	
	/**
	 * Defines the font face of the title label text for child frames.
	 */
	public static final Font subFrameTitleFontFace = new Font("Monospaced", Font.BOLD, 18);
	
	/**
	 * Defines the font color of the title label text for child frames.
	 */
	public static final Color subFrameTitleFontColor = new Color(255, 255, 255);
	
	/**
	 * Defines the font face of Oxide menu buttons.
	 */
	public static final Font menuButtonFontFace = new Font("Monospaced", Font.BOLD, 20);
	
	/**
	 * Defines the font color of OxideMenuButtons.
	 */
	public static final Color menuButtonFontColor = new Color(255, 255, 255);
	
	/**
	 * Defines the background color of unselected Oxide menu buttons.
	 */
	public static final Color menuButtonSelectedColor = new Color(122, 138, 153);
	
	/**
	 * Defines the background color of selected Oxide menu buttons.
	 */
	public static final Color menuButtonUnselectedColor = new Color(163, 184, 204);
//	
	/**
	 * Defines the border and it's color that surrounds Oxide menu buttons upon which
	 * the mouse cursor is hovering.
	 */
	public static final LineBorder buttonHoverBorder = new LineBorder(Color.WHITE);
	
	/**
	 * Defines the border and it's color that surrounds Oxide menu buttons upon which
	 * the mouse cursor isn't hovering.
	 */
	public static final EmptyBorder buttonDefaultBorder = new EmptyBorder(0, 0, 0, 0);
//	
//	/**
//	 * Defines Oxide palette color 1.
//	 */
//	public static final Color oxideShade1 = new Color(219, 229, 239);
//	
////	/**
////	 * Defines the aesthetic and decoration for Oxide-styled titled JPanels.
////	 */
////	public static final Font titledPanelFontFace = new Font("Monospaced", Font.PLAIN, 13);
////	public static final Color titledPanelFontColor = new Color(51, 51, 51);
////	public static final Color titledPanelBorderColor = new Color(122, 138, 153);
////
////	public static final Border titledPanelBorder = new EtchedBorder(EtchedBorder.LOWERED);

	/**
	 * Defines the font face of Oxide-styled UI control components such as JButton and JLabel.
	 */
	public static final Font oxideControlFontFace = new Font("Monospaced", Font.PLAIN, 13);
	
	/**
	 * Defines the font color of Oxide-styled UI control components.
	 */
	public static final Color oxideControlFontColor = new Color(51, 51, 51);

}
