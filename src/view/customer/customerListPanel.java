package view.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.customer.customer;

public class customerListPanel extends JFrame implements ListSelectionListener {
	private static final long serialVersionUID = 1L;

	JList<String> jlist;

	JLabel label;
	JPanel panel;

	public customerListPanel(ArrayList<customer> customerList) {
		panel = new JPanel();

		int i = 0;
		JTable table;
		JScrollPane scroll;
		String header[] = {"id","이름","나이","연락처","성별","주소"};
		String[][] data;
		data = new String[customerList.size()][13];
		
		String s = "";
		
		for (customer c : customerList) {
			System.out.println(c.isGender());
			s = Integer.toString(c.getCustomerID());
			data[i][0] = s;
			data[i][1] = c.getCustomerName();
			data[i][2] = Integer.toString(c.getAge());
			data[i][3] = c.getContactNumber();
			if (c.isGender()) {
				data[i][4] = "여자";
			} else {
				data[i][4] = "남자";
			}
			data[i][5] = c.getAddress();
			i++;
		}
		
		table = new JTable(data, header); // table=new JTable(데이터-2차원배열, 컬럼배열);
		scroll = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(600, 500));
		panel.add(scroll);
		
		panel.setBackground(Color.white);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		label.setText(jlist.getSelectedIndex() + 1 + " 선택 되었습니다.");
	}

}
