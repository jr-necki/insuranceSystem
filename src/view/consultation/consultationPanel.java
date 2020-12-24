package view.consultation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class consultationPanel implements ActionListener {
	public JPanel panel;

	// 상담요청, 상담답변 패널
	private consultationRequestPanel consultationRequestPanel;
	private consultationAnswerPanel consultationAnswerPanel;
	
	public consultationPanel() {
		this.panel = new JPanel();
		
		JButton btn1 = new JButton("상담신청하기");
		JButton btn2 = new JButton("상담답변하기");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		this.panel.add(btn1);
		this.panel.add(btn2);
		this.panel.setBackground(Color.white);
		this.panel.setBorder(BorderFactory.createEmptyBorder(50,50,20,20));
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {		
		this.panel.removeAll();
		this.panel.updateUI();
		
		if(actionEvent.getActionCommand().equals("상담신청하기")) {
			this.consultationRequestPanel = new consultationRequestPanel();
			this.panel.add(this.consultationRequestPanel.mainPanel);
		} else if(actionEvent.getActionCommand().equals("상담답변하기")) {
			this.consultationAnswerPanel = new consultationAnswerPanel();
			this.panel.add(this.consultationAnswerPanel.mainPanel);
		}
	}
	
}
