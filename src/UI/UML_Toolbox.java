package UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.List;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;

import mode.*;
import object.*;
import painter.*;

public class UML_Toolbox  extends JPanel{
	
	private int ToolNum = 6;
	private ToolButton Btn_tmp=null;
	private UML_Canvas canvas=new UML_Canvas();
	private final ToolButton[] Buttonlist = new ToolButton[ToolNum];
	private final String[] Button_name= {"select","association","generalization","composition","class","use case"};
	private final Mode[] mode= {
			new SelectMode(),
			new drawLineMode(new AssLinePainter()),
			new drawLineMode(new GenLinePainter()),
			new drawLineMode(new ComLinePainter()),
			new drawObjMode(new ClassPainter()),
			new drawObjMode(new UseCasePainter())};
	//public JLabel test=new JLabel("Start");
	
	public UML_Toolbox(){
		this.canvas=UML_Canvas.getInstance();
		this.setLayout(new GridLayout(ToolNum,1,10,20));
		this.setBackground(Color.black);
		
		for(int i = 0; i < ToolNum; i++) {
			this.Buttonlist[i]=new ToolButton(this.Button_name[i],this.mode[i]);
			this.Buttonlist[i].addActionListener(new ToolBtn_Act());
			this.add(this.Buttonlist[i]);
		}	
		//this.add(test);
	}
	
	class ToolBtn_Act implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(Btn_tmp != null)
				Btn_tmp.DisOnClick() ;
			Btn_tmp = (ToolButton) e.getSource();
			Btn_tmp.OnClick();
			canvas.setModetype(Btn_tmp.getMode());
			//canvas.setModeName(Btn_tmp.getBtnName());
			//test.setText(Btn_tmp.getBtnName());
			canvas.reloadMode();
			canvas.resetElementList();
			canvas.resetSelectObj();
			canvas.repaint();
			//System.out.println(Btn_tmp.getBtnName());
		}
	}

	
}
