package view.insurance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.cCancerInsurance;
import model.insurance.insurance.insuranceType;

public class cancerInsurancePanel implements ActionListener {
	// controller
	private cCancerInsurance cCancerInsurance = new cCancerInsurance();

	// panel
	public JPanel mainPanel;
	private ArrayList<JPanel> arr;
	// insurance
	private JLabel idLabel;
	private JTextField idField;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel descriptionLabel;
	private JTextField descriptionField;
	// contractCondition
	private JLabel cCIDLabel;
	private JTextField cCIDField;
	private JLabel expirationDateLabel;
	private JTextField expirationDateField;
	private JLabel guaranteeAmountLabel;
	private JTextField guaranteeAmountField;
	private JLabel paymentAmountLabel;
	private JTextField paymentAmountField;
	private JLabel paymentDayLabel;
	private JTextField paymentDayField;
	// save button
	private JButton saveButton;
	
	public cancerInsurancePanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		this.arr = new ArrayList<>();

		// insuranceID
		JPanel panel1 = new JPanel();
		this.idLabel = new JLabel("보험ID");
		this.idField = new JTextField(10);
		
		this.idField.setText(cCancerInsurance.getID());
		panel1.add(this.idLabel);
		panel1.add(this.idField);
		this.arr.add(panel1);

		// insuranceName
		JPanel panel2 = new JPanel();
		this.nameLabel = new JLabel("보험이름");
		this.nameField = new JTextField(10);
		this.nameField.setText("암보험");
		panel2.add(this.nameLabel);
		panel2.add(this.nameField);
		this.arr.add(panel2);

		// description
		JPanel panel3 = new JPanel();
		this.descriptionLabel = new JLabel("보험설명");
		this.descriptionField = new JTextField(30);
		this.descriptionField.setText("이 보험은 ");
		panel3.add(this.descriptionLabel);
		panel3.add(this.descriptionField);
		this.arr.add(panel3);

		// contractCondition - contractConditionID
		JPanel panel4 = new JPanel();
		this.cCIDLabel = new JLabel("계약조건ID");
		this.cCIDField = new JTextField(10);
		this.cCIDField.setText(cCancerInsurance.getID());
		panel4.add(this.cCIDLabel);
		panel4.add(this.cCIDField);
		this.arr.add(panel4);

		// contractCondition - expirationDate
		JPanel panel5 = new JPanel();
		this.expirationDateLabel = new JLabel("만기일(yyyy-MM-dd)");
		this.expirationDateField = new JTextField(10);
		this.expirationDateField.setText("2025-06-20");
		panel5.add(this.expirationDateLabel);
		panel5.add(this.expirationDateField);
		this.arr.add(panel5);

		// contractCondition - guaranteeAmount
		JPanel panel6 = new JPanel();
		this.guaranteeAmountLabel = new JLabel("보장액");
		this.guaranteeAmountField = new JTextField(20);
		this.guaranteeAmountField.setText("100000000");
		panel6.add(this.guaranteeAmountLabel);
		panel6.add(this.guaranteeAmountField);
		this.arr.add(panel6);

		// contractCondition - paymentAmount
		JPanel panel7 = new JPanel();
		this.paymentAmountLabel = new JLabel("월 기본 보험료");
		this.paymentAmountField = new JTextField(10);
		this.paymentAmountField.setText("20000");
		panel7.add(this.paymentAmountLabel);
		panel7.add(this.paymentAmountField);
		this.arr.add(panel7);

		// contractCondition - paymentDay
		JPanel panel8 = new JPanel();
		Calendar cal = Calendar.getInstance();
		String date = Integer.toString(cal.get(cal.DATE));
		this.paymentDayLabel = new JLabel("납입 날짜");
		this.paymentDayField = new JTextField(10);
		this.paymentDayField.setText(date); // 오늘날짜로 기본설정
		panel8.add(this.paymentDayLabel);
		panel8.add(this.paymentDayField);
		this.arr.add(panel8);

		// button
		JPanel panel9 = new JPanel();
		this.saveButton = new JButton("저장");
		this.saveButton.addActionListener(this);
		panel9.add(this.saveButton);
		this.arr.add(panel9);

		for (JPanel panel : this.arr) {
			this.mainPanel.add(panel);
			panel.setBackground(Color.white);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// insurance
		int insuranceID = Integer.parseInt(this.idField.getText());
		String insuranceName = this.nameField.getText();
		String description = this.descriptionField.getText();
		// contractCondition
		int contractConditionID = Integer.parseInt(this.cCIDField.getText());
		String date = this.expirationDateField.getText();

		int guaranteeAmount = Integer.parseInt(this.guaranteeAmountField.getText());
		int paymentAmount = Integer.parseInt(this.paymentAmountField.getText());
		int paymentDay = Integer.parseInt(this.paymentDayField.getText());

		if (actionEvent.getActionCommand().equals("저장")) {
			cCancerInsurance.makeInsurance(insuranceID, insuranceName, insuranceType.CANCERINSURANCE, description,
					contractConditionID, date, guaranteeAmount, paymentAmount, paymentDay);
			// set 완료 다이얼로그 띄우기
			JOptionPane.showMessageDialog(this.mainPanel, "보험ID: " + insuranceID + "\n" + "보험이름: " + insuranceName,
					"설계완료", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
