package menufunc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import UI.UML_Canvas;
import group.Grouper;

public class GroupObjectListener implements ActionListener {
	private UML_Canvas canvas=new UML_Canvas();
	private Grouper grouper = new Grouper();
	
	public void actionPerformed(ActionEvent e) {
		this.canvas=UML_Canvas.getInstance();
		int Obj_num = canvas.getSelectNum();
		if (Obj_num > 1){
			grouper.group();
			canvas.repaint();
		}
		else{
			JOptionPane.showMessageDialog(null,"Please select more than one objects.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
