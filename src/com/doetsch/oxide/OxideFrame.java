package com.doetsch.oxide;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
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
	private OxideMenuButton minimizeButton;
	private OxideMenuButton closeButton;
	
	/*
	 * Declare and instantiate LabelHoverListener border
	 */
	//private LineBorder lineBorder = new LineBorder(bbbb.mouseHoverBorderColor);
		
	/*
	 * Content pane dimensions
	 */
	private int contentPaneLeft = 300;
	private int contentPaneTop = 100;
	private int contentPaneWidth = 640;
	private int contentPaneHeight = 380;
	
//	/*
//	 * Decoration and frame border widths
//	 */
	private int decorationBorderWidth;
	private int frameBorderWidth;
//
//	/*
//	 * Height of the title
//	 */
	private int titleLabelHeight;

	private boolean isParentFrame;
	
	private OxideSkin skin;
	
	/**
	 * Creates an OxideFrame instance.
	 * 
	 * @param isParentFrame true if the OxideFrame should be considered a
	 * parent frame which has a title label height (30px) and font different from
	 * a child frame (18px).
	 */
	public OxideFrame (boolean isParentFrame, OxideSkin skin) {
		super();
		
		this.isParentFrame = isParentFrame;
		this.skin = skin;
		
		initFrame();
		initBehavior();
	}
	
	/*
	 * Initializes and builds the Oxide frame's decoration
	 */
	private void initFrame () {
		
		titleLabelHeight = (isParentFrame ?
				skin.getParentFrameTitleBarHeight() : skin.getChildFrameTitleBarHeight());
		decorationBorderWidth = skin.getDecorationBorderWidth();
		frameBorderWidth = skin.getFrameBorderWidth();
		
		super.setUndecorated(true);
		super.setVisible(true);
		
		/*
		 * Initialize and decorate the parent frame (window border)
		 */
		framePane = (JPanel) super.getContentPane();
		framePane.setBackground(skin.getFrameBorderColor());
		framePane.setLayout(null);
		framePane.setOpaque(true);
		
		/*
		 * Initialize and decorate the decoration panel
		 */
		decorationPane = new JPanel();
		decorationPane.setBackground(skin.getDecorationBorderColor());
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
			titleLabel.setFont((isParentFrame) ?
					skin.getParentTitleFontFace() : skin.getChildTitleFontFace());
			titleLabel.setForeground((isParentFrame) ?
					skin.getParentTitleFontColor() : skin.getChildTitleFontColor());
			titleLabel.setBackground(skin.getDecorationBorderColor());
			titleLabel.setOpaque(true);
			
			/*
			 * The minimize button
			 */
			minimizeButton = new OxideMenuButton("", skin);
			minimizeButton.setIcon(new ImageIcon((isParentFrame ?
					OxideFrame.class.getResource("resources/icons/minimize_icon_24x24.png") :
						OxideFrame.class.getResource("resources/icons/minimize_icon_18x18.png"))));
			minimizeButton.setOpaque(false);

			
			/*
			 * Exit button
			 */
			closeButton = new OxideMenuButton("", skin);
			closeButton.setIcon(new ImageIcon((isParentFrame ? 
					OxideFrame.class.getResource("resources/icons/close_icon_24x24.png") :
						OxideFrame.class.getResource("resources/icons/close_icon_18x18.png"))));
			closeButton.setOpaque(false);
			
			
			decorationPane.add(titleLabel);
			decorationPane.add(minimizeButton);
			decorationPane.add(closeButton);
			
		}
		
		/*
		 * Initialize and decorate the content panel
		 */
		contentPane = new JPanel();
		contentPane.setBackground(skin.getContentPanelColor());
		contentPane.setLayout(null);
		contentPane.setOpaque(true);
		decorationPane.add(contentPane);
		
		/*
		 * Draw the frame for the first time
		 */
		resizeFrame();
		
	}
	
	private void initBehavior () {
		
		/*
		 * Define the default frame close button operation
		 */
		closeButton.setActionListener(new AbstractAction() {

			/*
			 * Disposes the frame when the close button is selected
			 */
			@Override
			public void actionPerformed (ActionEvent e) {
				OxideFrame.this.dispose();
			}
			
		});
		
		/*
		 * Define the default frame minimize operation
		 */
		minimizeButton.setActionListener(new AbstractAction() {

			/*
			 * Minimizes the frame when the minimize button is selected
			 */
			@Override
			public void actionPerformed (ActionEvent arg0) {
				OxideFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
			
		});
		
	}
	
	/**
	 * Updates the location of the OxideFrame such that the frame appears
	 * centered within the screen. 
	 */
	public void centerInViewport () {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds ((screenSize.width / 2) - (contentPaneWidth / 2),
				(screenSize.height / 2) - (contentPaneHeight / 2),
				contentPaneWidth, contentPaneHeight);
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
			titleLabel.setBounds(0,	0,
					contentPaneWidth - (2 * titleLabelHeight),
					titleLabelHeight + (2 * decorationBorderWidth));
			
			minimizeButton.setBounds(contentPaneWidth - (2 * titleLabelHeight),
					decorationBorderWidth,
					titleLabelHeight, titleLabelHeight);
			
			closeButton.setBounds(contentPaneWidth + decorationBorderWidth - titleLabelHeight,
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
	 * @return a JPanel representation of the content pane
	 */
	@Override
	public JPanel getContentPane () {
		return contentPane;
	}
	
	/**
	 * Sets the location and dimensions of the content pane.
	 * 
	 * @param r a Rectangle representation of the x and y position
	 * of the top-left corner of the frame's content pane and the
	 * content pane's width and height 
	 */
	@Override
	public void setBounds (Rectangle r) {
		setBounds(r.x, r.y, r.width, r.height);
	}
	
	/**
	 * Sets the location and dimensions of the content pane.
	 * 
	 * @param left the new x position of the top-left corner of the frame's content pane
	 * @param top the new y position of the top-left corner of the frame's content pane
	 * @param contentPaneWidth the new width of the frame's content pane 
	 * @param contentPaneHeight the new height of the frame's content pane
	 */
	@Override
	public void setBounds (int left, int top,
			int contentPaneWidth, int contentPaneHeight) {
		
		//super.setBounds(left, top, 400, 300);
		
		this.contentPaneLeft = left;
		this.contentPaneTop = top;
		this.contentPaneWidth = contentPaneWidth;
		this.contentPaneHeight = contentPaneHeight;
				
		resizeFrame();		
	}
	
	/**
	 * Sets the frame's title text.
	 * @param title a String representation of the title
	 */
	@Override
	public void setTitle (String title) {
		super.setTitle(title);
		titleLabel.setText(" " + title);
	}
	
	/**
	 * Returns the frame's minimize button's behavior when pressed.
	 * 
	 * @return the AbstractAction defining the behavior
	 */
	public AbstractAction getMinimizeButtonBehavior () {
		return minimizeButton.getActionListener();
	}
	
	/**
	 * Sets the frame's minimize button's behavior when pressed.
	 * 
	 * @param action the AbstractAction defining the behavior when the
	 * button is pressed
	 */
	public void setMinimizeButtonBehavior (AbstractAction action) {
		minimizeButton.setActionListener(action);		
	}
	
	/**
	 * Retur ns the frame's close button's behavior when pressed.
	 * 
	 * @return the AbstractAction defining the behavior
	 */
	public AbstractAction getCloseButtonBehavior () {
		return closeButton.getActionListener();
	}
	
	/**
	 * Sets the frame's close button's behavior when pressed.
	 * 
	 * @param action the AbstractAction defining the behavior when the
	 * button is pressed
	 */
	public void setCloseButtonBehavior (AbstractAction action) {
		closeButton.setActionListener(action);
	}
	
	/**
	 * Returns the OxideSkin that is decorating the frame.
	 * 
	 * @return the OxideSkin that's decorating the frame
	 */
	public OxideSkin getOxideSkin () {
		return this.skin;		
	}
	
	/**
	 * Sets the OxideSkin that will decorate the frame and it's components.
	 * 
	 * @param skin an OxideSkin that defines the palette with which
	 * to decorate the frame and it's components
	 */
	public void setOxideSkin (OxideSkin skin) {
		this.skin = skin;
		initFrame();
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
					OxideFrame frame = new OxideFrame(true, new OxideDefaultSkin());
					frame.setTitle("Oxide Frame Title");
					frame.centerInViewport();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
