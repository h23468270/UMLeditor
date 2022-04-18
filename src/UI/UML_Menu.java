package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import group.Group;

import javax.swing.JOptionPane;

public class UML_Menu extends JMenuBar{
	private UML_Canvas canvas=new UML_Canvas();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenuItem changeName=new JMenuItem("Change object name");
	private JMenuItem groupObj=new JMenuItem("Group object");
	private JMenuItem UngroupObj=new JMenuItem("Ungroup object");
	private Group group = new Group();
	
	public UML_Menu() {
		this.canvas=UML_Canvas.getInstance();
		
		this.add(this.file);
		this.add(this.edit);
		
		this.edit.add(this.changeName);
		this.changeName.addActionListener(new ChangeNameListener());
		this.edit.add(this.groupObj);
		this.groupObj.addActionListener(new GroupObjectListener());
		this.edit.add(this.UngroupObj);
		this.UngroupObj.addActionListener(new UngroupObjectListener());
		
		
	}
	
	private void ChangeObjName() {
		
		if(this.canvas.getSelectObj() != null ) {
			
			final JFrame inputTextFrame = new JFrame("Change Object Name");
			inputTextFrame.setSize(300, 80);
			inputTextFrame.getContentPane().setLayout(new GridLayout(1, 1));
			
			JPanel panel = null;
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			final JTextField NameText =  new JTextField(canvas.getSelectObj().getObjectName());
			
			panel.add(NameText);
			inputTextFrame.getContentPane().add(panel);
			
			JButton OK = new JButton("OK");
			panel.add(OK);
			
			JButton cancel = new JButton("Cancel");
			panel.add(cancel);

			inputTextFrame.getContentPane().add(panel);
			
			inputTextFrame.setLocationRelativeTo(null);
			inputTextFrame.setVisible(true);
			
			OK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					canvas.changeObjName(NameText.getText());
					inputTextFrame.dispose();
				}
			});
			
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inputTextFrame.dispose();
				}
			});	

		}
		else
		{
			JOptionPane.showMessageDialog(null,"Please select one and only one object.","Error",JOptionPane.ERROR_MESSAGE);
		}

	}	
	
	class ChangeNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ChangeObjName();
		}
	}
	
	class GroupObjectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int Obj_num = canvas.getSelectNum();
			if (Obj_num > 1){
				group.group();
				canvas.repaint();
			}
			else{
				JOptionPane.showMessageDialog(null,"Please select more than one objects.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class UngroupObjectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int Obj_num = canvas.getSelectNum();
			if(Obj_num == 1 && canvas.getSelectObj().isGroup()) {
				group.ungroup();
				canvas.repaint();
			}
			else {
				JOptionPane.showMessageDialog(null,"Please select one and only one group.","Error",JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	
	
}
