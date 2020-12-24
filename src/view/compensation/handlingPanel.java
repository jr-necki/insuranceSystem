package view.compensation;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.cHandling;

public class handlingPanel implements MouseListener { // 처리하기
	// controller
	private cHandling cHandling = new cHandling();

	public JPanel panel;
	JPanel pacID = new JPanel();
	JPanel pcusID = new JPanel();
	JPanel pacType = new JPanel();
	JPanel pinsID = new JPanel();
	JPanel p3 = new JPanel();

	JTextField txtAccidentID = new JTextField(10);
	JTextField txtCustomerID = new JTextField(10);
	JTextField txtInsuranceID = new JTextField(10);
	JTextField txtAmount = new JTextField(10);

	JButton btn1, btn2;
	JButton btn = new JButton("확인");

	ArrayList<JPanel> al = new ArrayList<JPanel>();
	int id;

	public handlingPanel() {
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel l0 = new JLabel("사고 고유 ID ");
		pacID.add(l0);
		pacID.add(txtAccidentID);
		txtAccidentID.setText("1");
		btn.addMouseListener(this);
		pacID.add(btn);
		al.add(pacID);

		JLabel l1 = new JLabel("고객 ID ");
		pcusID.add(l1);
		pcusID.add(txtCustomerID);
		al.add(pcusID);

		JLabel l = new JLabel("보장액 ");
		pacType.add(l);
		pacType.add(txtAmount);
		al.add(pacType);

		JLabel l2 = new JLabel("가입 보험 ID ");
		pinsID.add(l2);
		pinsID.add(txtInsuranceID);
		al.add(pinsID);

		btn1 = new JButton("저장하기");
		btn2 = new JButton(" 취 소  ");
		btn1.addMouseListener(this);
		btn2.addMouseListener(this);
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		p3.add(btn1);
		p3.add(btn2);
		p3.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
		al.add(p3);

		for (JPanel p : al) {
			panel.add(p);
			panel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
			p.setBackground(Color.white);
		}
		panel.setBackground(Color.white);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btn) { // 사고id확인
			int id = Integer.parseInt(txtAccidentID.getText());
			cHandling.checkID(id);

			this.txtCustomerID.setText(Integer.toString(cHandling.checkID(id).getCustomerID()));
			this.txtInsuranceID.setText(Integer.toString(cHandling.checkID(id).getInsuranceID()));
			this.txtAmount.setText(Integer.toString(cHandling.showAmount(cHandling.checkID(id).getInsuranceID())));
		
		}else if (e.getSource() == btn1) { // 저장하기
			int accidentID=Integer.parseInt(txtAccidentID.getText());
			int customerID=Integer.parseInt(txtCustomerID.getText());
			int insuranceID=Integer.parseInt(txtInsuranceID.getText());
			int amount=Integer.parseInt(txtAmount.getText());
			cHandling.save(accidentID, customerID, insuranceID, amount);
			JOptionPane.showMessageDialog(null, "저장되었습니다!");

		} else if (e.getSource() == btn2) { // 취소
			txtAccidentID.setText("");
			txtCustomerID.setText("");
			txtInsuranceID.setText("");
			txtAmount.setText("");
			JOptionPane.showMessageDialog(null, "취소 되었습니다! 위의 Insurance System을 눌러 메뉴로 돌아가세요");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
