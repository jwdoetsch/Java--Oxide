package com.doetsch.oxide;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractAction;
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
	

//	/*
//	 * Draws a white border around the given JLabel when the
//	 * mouse cursor is hovering over it. 
//	 */
//	private class LabelHoverListener implements MouseListener {
//		
//		//The label to pant the border around
//		private JLabel label;
//		
//		//The action to undertake when the mouse clicks the component
//		private AbstractAction onClickAction;
//		
//		/*
//		 * Creates a LabelHoverListener instance that will draw a border 
//		 * around the given JLabel. 
//		 */
//		private LabelHoverListener (JLabel label, AbstractAction onClickAction) {
//			this.label = label;
//			this.onClickAction = onClickAction;
//		}
//		
//
//
//		/*
//		 * Sets the JLabel's border to the default line border when
//		 * the mouse cursor is hovered over it.
//		 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
//		 */
//		@Override
//		public void mouseEntered (MouseEvent arg0) {
//			label.setBorder(lineBorder);;
//		}
//
//		/*
//		 * Removes the border from the JLabel once the mouse stops hovering
//		 * over it.
//		 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
//		 */
//		@Override
//		public void mouseExited (MouseEvent arg0) {
//			label.setBorder(null);
//		}
//
//		@Override
//		public void mouseClicked (MouseEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mousePressed (MouseEvent arg0) {
//		}
//
//		@Override
//		public void mouseReleased (MouseEvent arg0) {
//		}
//
//
//
//
//	}
//	
	/**
	 * DragAnchorLabel is the implementation of a JLabel that acts as
	 * a drag anchor point for the frame to allow the position of the 
	 * frame to change by dragging.
	 * 
	 * @author Jacob Wesley Doetsch
	 */
	private class DragAnchorLabel extends JLabel {

		/*
		 * Generated serial ID to satisfy Serializable.
		 */
		private static final long serialVersionUID = -473202219857073619L;
		
		//The initial position of the cursor before dragging occurs
		private Point dragAnchorLocation;
		
		/*
		 * Creates a DragAnchorLabel instance with the label defines
		 * by the given text.
		 * 
		 * @param text a String representation of the label's text
		 */
		private DragAnchorLabel () {
			super();
			
			build();		
		}
		
		/*
		 * Adds the appropriate action listener components to handle and 
		 * control the dragging action.
		 */
		private void build () {
			
			/*
			 * Add an action  listener that sets the drag anchor point once dragging
			 * is initiated by an initial mouse click
			 */
			this.addMouseListener(new MouseListener() {

				public void mouseClicked (MouseEvent e) {
				}

				/*
				 * Changes the cursor to a move cursor when the label is hovered over
				 */
				public void mouseEntered (MouseEvent e) {
					setCursor(new Cursor(Cursor.MOVE_CURSOR));
				}

				public void mouseExited (MouseEvent e) {
				}

				/*
				 * Record the mouse cursor's location with regards to view port
				 */
				public void mousePressed (MouseEvent e) {
					dragAnchorLocation = e.getLocationOnScreen();
				}

				public void mouseReleased (MouseEvent e) {
				}
				
			});
			
			
			/*
			 * Add an action listener that handles the drag action
			 */
			this.addMouseMotionListener(new MouseMotionListener() {

				/*
				 * Record the mouse cursor's current location as it is dragged, adding the
				 * different between the current location and the anchor location to the 
				 * position of the content pane.
				 */
				@Override
				public void mouseDragged (MouseEvent e) {
					
					//Record the cursors current position with regards to the viewport
					Point currentCursorLocation = e.getLocationOnScreen();
					
					/*
					 * Add the different between the cursor's current position and the cursor's
					 * previous position (the anchor point) to the content pane's position. The 
					 * content pane's position respects the viewport directly, not it's parent 
					 * panel (the decorationframe) nor the parent frame
					 */
					OxideFrame.this.contentPaneLeft += (currentCursorLocation.x - dragAnchorLocation.x);
					OxideFrame.this.contentPaneTop += (currentCursorLocation.y - dragAnchorLocation.y);
					
					/*
					 * Consider the current position as the future previous position by updating
					 * the drag anchor point accordingly
					 */
					dragAnchorLocation.x = currentCursorLocation.x;
					dragAnchorLocation.y = currentCursorLocation.y;
					
					/*
					 * Resize/redraw the frame's decoration components with respect to the
					 * content pane's new position.
					 */
					resizeFrame();
				}

				@Override
				public void mouseMoved (MouseEvent arg0) {
				}
				
			});			
		}
		
	}
	
	
	/*
	 * Satisfies Serializable.
	 */
	private static final long serialVersionUID = -8324107253333263909L;
		
	/*
	 * Frame pane/panel component
	 */
	private JPanel framePane;
	private JPanel decorationPane;
	private JPanel contentPane;
	
	/*
	 * Title bar components
	 */
	private DragAnchorLabel titleLabel;
	private OxideMenuButton miniLabel;
	private OxideMenuButton exitLabel;
	
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
		initBehavior();
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
			titleLabel = new DragAnchorLabel();
			titleLabel.setVerticalAlignment(JLabel.CENTER);
			titleLabel.setFont((isParentFrame) ? OxidePalette.titleFontFace : OxidePalette.subFrameTitleFontFace);
			titleLabel.setForeground((isParentFrame) ? OxidePalette.titleFontColor : OxidePalette.subFrameTitleFontColor);
			titleLabel.setBackground(OxidePalette.decorationBorderColor);
			titleLabel.setOpaque(true);
			
			/*
			 * The minimize button
			 */
			miniLabel = new OxideMenuButton("");
			miniLabel.setIcon(new ImageIcon((isParentFrame ? "minimize_icon_24x24.png" : "minimize_icon_18x18.png")));
			//miniLabel.setBackground(OxidePalette.decorationBorderColor);
			miniLabel.setOpaque(false);
			miniLabel.setActionListener(new AbstractAction() {

				@Override
				public void actionPerformed (ActionEvent arg0) {
					OxideFrame.this.setExtendedState(JFrame.ICONIFIED);
				}
				
			});
			
			/*
			 * Exit button
			 */
			exitLabel = new OxideMenuButton("");
			exitLabel.setIcon(new ImageIcon((isParentFrame ? "close_icon_24x24.png" : "close_icon_18x18.png")));
			//exitLabel.setBackground(OxidePalette.decorationBorderColor);
			exitLabel.setOpaque(false);
			exitLabel.setActionListener(new AbstractAction() {

				@Override
				public void actionPerformed (ActionEvent e) {
					OxideFrame.this.dispose();
				}
				
			});
			
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
	
	private void initBehavior () {
		
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
//			titleLabel.setBounds(decorationBorderWidth,
//					decorationBorderWidth,
//					contentPaneWidth - (2 * decorationBorderWidth) - (2 * titleLabelHeight),
//					titleLabelHeight);
			titleLabel.setBounds(0,
					0,
					contentPaneWidth - (2 * titleLabelHeight),
					titleLabelHeight + (2 * decorationBorderWidth));
			
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
	
	@Override
	public void setTitle (String title) {
		super.setTitle(title);
		titleLabel.setText(" " + title);
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
					OxideFrame frame = new OxideFrame(true);
					frame.setTitle("dfScan Title");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
