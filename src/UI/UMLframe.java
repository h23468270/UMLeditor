package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

public class UMLframe extends JFrame{
	
	private static UML_Canvas canvas = new UML_Canvas() ;
	private UML_Toolbox toolbox = new UML_Toolbox();
	private UML_Menu menulist = new UML_Menu();
	
	public UMLframe() {
		canvas = UML_Canvas.getInstance() ;
		
		this.setTitle("UML editor");
		this.setBounds(10, 10, 1280, 720);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(canvas, BorderLayout.CENTER);
		this.add(menulist,BorderLayout.NORTH);
		this.add(toolbox , BorderLayout.WEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}


}
