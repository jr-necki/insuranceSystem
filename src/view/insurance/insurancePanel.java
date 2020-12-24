package view.insurance;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.main.insuranceSystemMain;

public class insurancePanel implements ActionListener {
	
	// panel, buttons
	public JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private ArrayList<JButton> arr;
	private JButton btnLife;
	private JButton btnFire;
	private JButton btnCancer;
	private JButton btnCar;
	private JButton btnInsuranceList;
	
	// panels
	public lifeInsurancePanel lifeInsurancePanel; // 생명보험
	public fireInsurancePanel fireInsurancePanel; // 화재보험
	public cancerInsurancePanel cancerInsurancePanel; // 암보험
	public carInsurancePanel carInsurancePanel; // 자동차보험
	private insuranceListPanel insuranceListPanel; // 보험리스트

	public insurancePanel() {	
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.panel.setBackground(Color.white);
		
		this.panel1 = new JPanel();
		this.panel1.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
		this.panel1.setBackground(Color.white);
		this.panel1.setLayout(new GridLayout(2,2));
		this.btnLife = new JButton("생명보험");
		this.btnFire = new JButton("화재보험");
		this.btnCancer = new JButton("암보험");
		this.btnCar = new JButton("자동차보험");
		
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.white);
		this.btnInsuranceList = new JButton("보험리스트");
		this.btnInsuranceList.addActionListener(this);
		this.panel2.add(this.btnInsuranceList);
		
		this.panel.add(this.panel1);
		this.panel.add(this.panel2);
		
		// arrayList에 btn 추가
		this.arr = new ArrayList<>();
		this.arr.add(this.btnLife);
		this.arr.add(this.btnFire);
		this.arr.add(this.btnCancer);
		this.arr.add(this.btnCar);
		
		Dimension dimension = new Dimension(200,200);
		for(JButton btn:this.arr) {
			btn.setBackground(Color.white);
			btn.setForeground(new Color(0,177, 78));
			btn.setPreferredSize(dimension);
			btn.addActionListener(this);
			this.panel1.add(btn);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		this.panel.removeAll();
		this.panel.updateUI();
		
		if(actionEvent.getActionCommand().equals("생명보험")) {
			this.lifeInsurancePanel = new lifeInsurancePanel();
			this.panel.add(this.lifeInsurancePanel.mainPanel);			
		} else if(actionEvent.getActionCommand().equals("화재보험")) {
			this.fireInsurancePanel = new fireInsurancePanel();
			this.panel.add(this.fireInsurancePanel.mainPanel);
		} else if(actionEvent.getActionCommand().equals("암보험")) {
			this.cancerInsurancePanel = new cancerInsurancePanel();
			this.panel.add(this.cancerInsurancePanel.mainPanel);
		} else if(actionEvent.getActionCommand().equals("자동차보험")) {
			this.carInsurancePanel = new carInsurancePanel();
			this.panel.add(this.carInsurancePanel.mainPanel);
			
		} else if(actionEvent.getActionCommand().equals("보험리스트")) {
			if(actionEvent.getActionCommand().equals("보험리스트")) {
				this.panel.removeAll();
				this.panel.updateUI();	
				try {
					insuranceListPanel = new insuranceListPanel(insuranceSystemMain.insuranceDao.selectAll());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.panel.add(insuranceListPanel.panel);
			}
		}
	}
	
}
