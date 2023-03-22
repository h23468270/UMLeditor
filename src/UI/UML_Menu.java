package UI;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import menufunc.ChangeNameListener;
import menufunc.GroupObjectListener;
import menufunc.UngroupObjectListener;


public class UML_Menu extends JMenuBar{
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenuItem changeName=new JMenuItem("Change object name");
	private JMenuItem groupObj=new JMenuItem("Group object");
	private JMenuItem UngroupObj=new JMenuItem("Ungroup object");
	
	public UML_Menu() {		
		this.add(this.file);
		this.add(this.edit);
		
		this.edit.add(this.changeName);
		this.changeName.addActionListener(new ChangeNameListener());
		this.edit.add(this.groupObj);
		this.groupObj.addActionListener(new GroupObjectListener());
		this.edit.add(this.UngroupObj);
		this.UngroupObj.addActionListener(new UngroupObjectListener());
		
		
	}

	
	
}
