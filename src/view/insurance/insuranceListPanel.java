package view.insurance;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.insurance.insurance;

public class insuranceListPanel {
	public JPanel panel;
	
	public insuranceListPanel(ArrayList<insurance> insuranceList) {
		this.panel = new JPanel();
		this.panel.setBackground(Color.white);
		
		String header[] = { "id", "보험이름", "만기일" };

		String[][] data;
		data = new String[insuranceList.size()][3];
		int i = 0;
		
		for (insurance insurance : insuranceList) {
			Date date = insurance.getContractCondition().getExpirationDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			data[i][0] = Integer.toString(insurance.getInsuranceID());
			data[i][1] = insurance.getInsuranceName();
			data[i][2] = dateFormat.format(date);
			i++;
		}
		
		JTable table = new JTable(data, header); 
		JScrollPane scroll = new JScrollPane(table);
		this.panel.add(scroll);	
	}

}
