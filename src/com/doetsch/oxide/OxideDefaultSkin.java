package com.doetsch.oxide;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * OxideDefaultSkin is an OxideSkin that defines the default decoration
 * and aesthetic palette; defining the font faces and colors, panel
 * colors, decoration colors, component colors and so on.
 */
public class OxideDefaultSkin implements OxideSkin {
	
	/**
	 * Creates a new OxideDefaultSkin instance.
	 */
	public OxideDefaultSkin () {
		
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getFrameBorderColor()
	 */
	public int getDecorationBorderWidth () {
		return 6; 
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getFrameBorderColor()
	 */
	public int getFrameBorderWidth () {
		return 2;
	}
	

	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getFrameBorderColor()
	 */
	public int getParentFrameTitleBarHeight () {
		return 30;
	}

	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getFrameBorderColor()
	 */
	@Override
	public int getChildFrameTitleBarHeight () {
		return 18;
	}
	

	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getFrameBorderColor()
	 */
	@Override
	public Color getFrameBorderColor () {
		return new Color(151, 151, 151);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getDecorationBorderColor()
	 */
	@Override
	public Color getDecorationBorderColor () {
		return new Color(122, 138, 153);
	}
	

	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getContentPanelColor()
	 */
	@Override
	public Color getContentPanelColor () {
		return new Color(238, 238, 238);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getMouseHoverBorderColor()
	 */
	@Override
	public Color getMouseHoverBorderColor () {
		return new Color(255, 255, 255);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getParentTitleFontFace()
	 */
	@Override
	public Font getParentTitleFontFace () {
		return new Font("Monospaced", Font.BOLD, 22);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getParentTitleFontColor()
	 */
	@Override
	public Color getParentTitleFontColor () {
		return new Color(255, 255, 255);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getChildTitleFontFace()
	 */
	@Override
	public Font getChildTitleFontFace () {
		return new Font("Monospaced", Font.BOLD, 18);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getChildTitleFontColor()
	 */
	@Override
	public Color getChildTitleFontColor () {
		return new Color(255, 255, 255);
	}
	
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getMenuButtonFontFace()
	 */
	@Override
	public Font getMenuButtonFontFace () {
		return new Font("Monospaced", Font.BOLD, 20);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getMenuButtonFontColor()
	 */
	@Override
	public Color getMenuButtonFontColor () {
		return new Color(255, 255, 255);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getMenuButtonSelectedColor()
	 */
	@Override
	public Color getMenuButtonSelectedColor () {
		return new Color(122, 138, 153);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getMenubuttonUnselectedColor()
	 */
	@Override
	public Color getMenubuttonUnselectedColor () {
		return new Color(163, 184, 204);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getButtonHoverBorder()
	 */
	@Override
	public AbstractBorder getButtonHoverBorder () {
		return new LineBorder(Color.WHITE);
	}
	
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getButtonDefaultBorder()
	 */
	@Override
	public AbstractBorder getButtonDefaultBorder () {
		return new EmptyBorder(0, 0, 0, 0);
	}


	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getControlFontFace()
	 */
	@Override
	public Font getControlFontFace () {
		return new Font("Monospaced", Font.PLAIN, 13);
	}
	
	/* (non-Javadoc)
	 * @see com.doetsch.oxide.OxideSkin#getControlFontColor()
	 */
	@Override
	public Color getControlFontColor () {
		return new Color(51, 51, 51);
	}

	@Override
	public Color getOxideShade1 () {
		return new Color(219, 229, 239);
	}




}
