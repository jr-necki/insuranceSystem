package view.insuranceRegistration;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import control.cInsuranceRegistration;

public class insuranceRegistrationPanel implements ActionListener {
	// controller
	private cInsuranceRegistration cInsuranceRegistration = new cInsuranceRegistration();
	
	public JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panelResult = new JPanel();
	JPanel insuranceType = new JPanel();
	JPanel panelRegistID = new JPanel();
	JPanel panelCustomerID = new JPanel();
	JPanel panelInsID = new JPanel();
	JPanel panelDate = new JPanel();
	JTextField txtID, txtInsuranceID, txtDate, txtGrade, txtArea;
	JButton btn = new JButton("가입하기");
	ArrayList<JPanel> al = new ArrayList<>();
	
	int cusId;
	int insId;

	public insuranceRegistrationPanel() {
		this.panel.setLayout(new GridLayout(2, 1));

		JLabel lbCustomerID = new JLabel("고객ID ");
		txtID = new JTextField(10);
		JButton btnCheck = new JButton("고객ID확인");
		btnCheck.addActionListener(this);
		panelCustomerID.add(lbCustomerID);
		panelCustomerID.add(txtID);
		panelCustomerID.add(btnCheck);
		al.add(panelCustomerID);
		al.add(panelResult);

		JLabel lbInsuranceID = new JLabel("보험ID ");
		txtInsuranceID = new JTextField(10);
		JButton btnCheck1 = new JButton("보험ID확인");
		btnCheck1.addActionListener(this);
		panelInsID.add(lbInsuranceID);
		panelInsID.add(txtInsuranceID);
		panelInsID.add(btnCheck1);
		al.add(panelInsID);

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		for (JPanel p : al) {
			p.setBackground(Color.white);
			panel1.add(p);
		}
		panel.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 177, 78), 1), ""));
		panel.add(panel1);
		panel.add(panel2);
		this.btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if (e.getActionCommand().equals("고객ID확인")) {
			cusId = Integer.parseInt(txtID.getText());
			if (cInsuranceRegistration.checkCustomerID(cusId)) {
				// 다이얼로그 출력
				JOptionPane.showMessageDialog(null, "확인.");
			} else {
				JOptionPane.showMessageDialog(null, "해당 id가 존재하지 않습니다.");
			}
			
		} else if (e.getActionCommand().equals("보험ID확인")) {
			insId = Integer.parseInt(txtInsuranceID.getText());
			if (cInsuranceRegistration.checkInsuranceID(insId)) {
				// 다이얼로그 출력
				JOptionPane.showMessageDialog(null, "확인.");
				
				// panel update
				panel2.removeAll();
				panel2.updateUI();
				
				JPanel insPanel = new JPanel();
				insPanel.setBackground(Color.WHITE);
				insPanel.setLayout(new GridLayout(2, 1));
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
					
				p1.add(new JLabel("고객id " + cusId));
				p1.add(new JLabel(" 이름 " + cInsuranceRegistration.getCustomer().getCustomerName()));
				p1.add(new JLabel(" 요율 " + cInsuranceRegistration.getInsurance().calculateRate(cInsuranceRegistration.getCustomer())));
				p1.add(new JLabel("월 납부액" + cInsuranceRegistration.getInsurance().getContractCondition().getPaymentAmount() 
						* cInsuranceRegistration.getInsurance().calculateRate(cInsuranceRegistration.getCustomer())));
				
				p2.add(btn);
				insPanel.add(p1);
				insPanel.add(p2);
				panel2.add(insPanel);
			} else {
				JOptionPane.showMessageDialog(null, "해당 id가 존재하지 않습니다.");
			}
		
		} else if(e.getActionCommand().equals("가입하기")) {
			cInsuranceRegistration.register();
			// 다이얼로그 출력
			JOptionPane.showMessageDialog(null,
					cInsuranceRegistration.getCustomer().getCustomerName() + "님 " 
			+ cInsuranceRegistration.getInsurance().getInsuranceID() + "가입되셨습니다!");
		}
	}
	
}