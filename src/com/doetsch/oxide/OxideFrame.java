package com.doetsch.oxide;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * OxideFrame is a JFrame with custom decoration. OxideFrame
 * enforces the Oxide aesthetic to maintain aesthetic compatibility
 * with metal, Java's native look and feel. 
 * 
 * @author Jacob Wesley Doetsch
 */
public class OxideFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8324107253333263909L;

	/*
	 * Draws a white border around the given JLabel when the
	 * mouse cursor is hovering over it. 
	 */
	private class LabelHoverListener implements MouseListener {
		
		//The label to pant the border around
		private JLabel label;
		
		/*
		 * Creates a LabelHoverListener instance that will draw a border 
		 * around the given JLabel. 
		 */
		private LabelHoverListener (JLabel label) {
			this.label = label;
		}
		
		@Override
		public void mouseClicked (MouseEvent arg0) {
		}

		/*
		 * Sets the JLabel's border to the default line border when
		 * the mouse cursor is hovered over it.
		 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseEntered (MouseEvent arg0) {
			label.setBorder(lineBorder);;
		}

		/*
		 * Removes the border from the JLabel once the mouse stops hovering
		 * over it.
		 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseExited (MouseEvent arg0) {
			label.setBorder(null);
		}

		@Override
		public void mousePressed (MouseEvent arg0) {
		}

		@Override
		public void mouseReleased (MouseEvent arg0) {
		}
	}
	
	/*
	 * Frame pane/panel component
	 */
	private JPanel framePane;
	private JPanel decorationPane;
	private JPanel contentPane;
	
	/*
	 * Title bar components
	 */
	private JLabel titleLabel;
	private JLabel miniLabel;
	private JLabel exitLabel;
	
	/*
	 * Declare and instantiate LabelHoverListener border
	 */
	private LineBorder lineBorder = new LineBorder(OxidePalette.mouseHoverBorderColor);
		
	/*
	 * Content pane dimensions
	 */
	private int contentPaneLeft = 300;
	private int contentPaneTop = 100;
	private int contentPaneWidth = 400;
	private int contentPaneHeight = 300;
	
	/*
	 * Decoration and frame border widths
	 */
	private int decorationBorderWidth  = 6;
	private int frameBorderWidth = 1;

	/*
	 * Height of the title
	 */
	private int titleLabelHeight = 24;

	private boolean isParentFrame;
	
	/**
	 * Creates an OxideFrame instance.
	 * 
	 * @param isParentFrame true if the OxideFrame should be considered a
	 * parent frame which has a title label height and font different from
	 * a child frame.
	 */
	public OxideFrame (boolean isParentFrame) {
		super();
		
		this.isParentFrame = isParentFrame;
		
		if (isParentFrame) {
			titleLabelHeight = 30;
			
		} else {
			titleLabelHeight = 18;
		}
		
		initFrame();
		resizeFrame();		
				
	}
	
	private void initFrame () {
		
		super.setUndecorated(true);
		
		/*
		 * Initialize and decorate the parent frame (window border)
		 */
		framePane = (JPanel) super.getContentPane();
		framePane.setBackground(OxidePalette.frameBorderColor);
		framePane.setLayout(null);
		framePane.setOpaque(true);
		
		/*
		 * Initialize and decorate the decoration panel
		 */
		decorationPane = new JPanel();
		decorationPane.setBackground(OxidePalette.decorationBorderColor);
		decorationPane.setLayout(null);
		decorationPane.setOpaque(true);
		framePane.add(decorationPane);
		
		/*
		 * Initialize decoration pane components
		 */
		{
			/*
			 * The title label
			 */
			titleLabel = new JLabel(" Title");
			titleLabel.setVerticalAlignment(JLabel.CENTER);
			titleLabel.setFont((isParentFrame) ? OxidePalette.titleFontFace : OxidePalette.subFrameTitleFontFace);
			titleLabel.setForeground((isParentFrame) ? OxidePalette.titleFontColor : OxidePalette.subFrameTitleFontColor);
			titleLabel.setBackground(OxidePalette.decorationBorderColor);
			titleLabel.setOpaque(true);
			titleLabel.addMouseListener(new LabelHoverListener(titleLabel));
			
			/*
			 * The minimize label/icon
			 */
			miniLabel = new JLabel();
			miniLabel.setBackground(OxidePalette.decorationBorderColor);
			miniLabel.setOpaque(true);
			miniLabel.setHorizontalAlignment(JLabel.CENTER);
			miniLabel.setVerticalAlignment(JLabel.CENTER);
			miniLabel.setIcon(new ImageIcon("minimize_icon_24x24.png"));
			miniLabel.addMouseListener(new LabelHoverListener(miniLabel));
			
			/*
			 * Exit label/icon
			 */
			exitLabel = new JLabel();
			exitLabel.setBackground(OxidePalette.decorationBorderColor);
			exitLabel.setOpaque(true);
			exitLabel.setHorizontalAlignment(JLabel.CENTER);
			exitLabel.setVerticalAlignment(JLabel.CENTER);
			exitLabel.setIcon(new ImageIcon("close_icon_24x24.png"));
			exitLabel.addMouseListener(new LabelHoverListener(exitLabel));
			
			decorationPane.add(titleLabel);
			decorationPane.add(miniLabel);
			decorationPane.add(exitLabel);
			
		}
		
		/*
		 * Initialize and decorate the content panel
		 */
		contentPane = new JPanel();
		contentPane.setBackground(OxidePalette.contentPaneBackgroundColor);
		contentPane.setLayout(null);
		contentPane.setOpaque(true);
		decorationPane.add(contentPane);
		
		
		
	}
	
	/*
	 * Resizes the decorating frame components with respect to the
	 * content pane's dimensions as specified by setBounds(..).
	 */
	private void resizeFrame () {
		
		/*
		 * Resize the parent frame
		 */
		super.setBounds(contentPaneLeft - decorationBorderWidth - frameBorderWidth,
				contentPaneTop - (2 * decorationBorderWidth) - titleLabelHeight - frameBorderWidth,
				contentPaneWidth + (2 * decorationBorderWidth) + (2 * frameBorderWidth),
				contentPaneHeight + (3 * decorationBorderWidth) + titleLabelHeight + (2 * frameBorderWidth));
		
		/*
		 * Resize and reposition the decoration pane
		 */
		decorationPane.setBounds(frameBorderWidth, frameBorderWidth,
				contentPaneWidth + (2 * decorationBorderWidth),
				contentPaneHeight + (3 * decorationBorderWidth) + titleLabelHeight);
		
		/*
		 * Resize and reposition decoration pane components
		 */
		{
			titleLabel.setBounds(decorationBorderWidth,
					decorationBorderWidth,
					contentPaneWidth - (2 * decorationBorderWidth) - (2 * titleLabelHeight),
					titleLabelHeight);
			
			miniLabel.setBounds(contentPaneWidth - (2 * titleLabelHeight),
					decorationBorderWidth,
					titleLabelHeight, titleLabelHeight);
			
			exitLabel.setBounds(contentPaneWidth + decorationBorderWidth - titleLabelHeight,
					decorationBorderWidth,
					titleLabelHeight, titleLabelHeight);		
			
		}
		
		/*
		 * Resize and reposition the content pane
		 */
		contentPane.setBounds(decorationBorderWidth,
				(2 * decorationBorderWidth) + titleLabelHeight,
				contentPaneWidth, contentPaneHeight);
		
	}
	
	/**
	 * Returns the content pane of the OxideFrame
	 * 
	 * @return the JPanel content pane of the frame
	 */
	@Override
	public JPanel getContentPane () {
		return contentPane;
	}

	/**
	 * Sets the location and dimensions of the content pane.
	 */
	@Override
	public void setBounds (Rectangle r) {
		setBounds(r.x, r.y, r.width, r.height);
	}
	
	/**
	 * Sets the location and dimensions of the content pane.
	 */
	@Override
	public void setBounds (int left, int top,
			int contentPaneWidth, int contentPaneHeight) {
		
		this.contentPaneLeft = left;
		this.contentPaneTop = top;
		this.contentPaneWidth = contentPaneWidth;
		this.contentPaneHeight = contentPaneHeight;
				
		resizeFrame();		
	}
	
	/**
	 * Test case: instantiates a frame of default size (no setBounds() call) and
	 * makes it visible.
	 */
	public static void main (String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
					OxideFrame frame = new OxideFrame(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
