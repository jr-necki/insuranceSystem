package view.consultation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import control.cConsultationRequest;

public class consultationRequestPanel implements ActionListener, Runnable {
	// controller
	private cConsultationRequest cConsultationRequest = new cConsultationRequest();

	public JPanel mainPanel;
	private ArrayList<JPanel> arr;	
	private JButton saveButton;
	private JButton okButton;
	private JButton removeButton;
	private JLabel now;
	private Thread thread;
	private JLabel name;
	private JLabel number;
	private JLabel inquiry;
	private JTextArea contents;
	private JTextField enquirerName;
	private JTextField contactNumber;
	private Border border;
			
	public consultationRequestPanel() {		
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		this.arr = new ArrayList<>();
		
		// time
		JPanel panel1 = new JPanel();
		this.now = new JLabel();
		this.now.setFont(new Font("Font", Font.ROMAN_BASELINE, 15));
	    if (thread == null) {
		   thread = new Thread(this);
		   thread.start();
	    }
	    panel1.add(this.now);
		this.arr.add(panel1);
		
		// name
		JPanel panel2 = new JPanel();
		this.name = new JLabel("성함");
		this.enquirerName = new JTextField(10);
		this.enquirerName.setText("홍길동");
		panel2.add(this.name);
		panel2.add(this.enquirerName);
		this.arr.add(panel2);
		
		// contact number
		JPanel panel3 = new JPanel();
		this.number = new JLabel("연락처");
		this.contactNumber = new JTextField(20);
		this.contactNumber.setText("010-1234-1234");
		panel3.add(this.number);
		panel3.add(this.contactNumber);
		this.arr.add(panel3);
		
		// contents
		JPanel panel4 = new JPanel();
		this.inquiry = new JLabel("문의내용");
		this.contents = new JTextArea("내용을 입력하세요" + "\n" + "저장을 먼저 누르고 상담신청을 누르세요",10,45);
		this.border = BorderFactory.createLineBorder(Color.BLACK);
		this.contents.setBorder(this.border);
		panel4.add(this.inquiry);
		panel4.add(this.contents);
		this.arr.add(panel4);
		
		// buttons
		JPanel panel5 = new JPanel();
		this.saveButton = new JButton("저장");
		this.saveButton.setBackground(Color.white);
		this.removeButton = new JButton("삭제");
		this.removeButton.setBackground(Color.white);
		this.okButton = new JButton("상담신청");
		this.okButton.setBackground(Color.white);
		this.saveButton.addActionListener(this);
		this.removeButton.addActionListener(this);
		this.okButton.addActionListener(this);
		panel5.add(this.saveButton);
		panel5.add(this.removeButton);
		panel5.add(this.okButton); 
		panel5.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
		this.arr.add(panel5);
		
		for(JPanel panel:this.arr) {
			this.mainPanel.add(panel);
			panel.setBackground(Color.white);
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent actionEvent) {		
		String name = this.enquirerName.getText();
		String contactNum = this.contactNumber.getText();
		String inquiryDetails = this.contents.getText();
		
		if(actionEvent.getActionCommand().equals("저장")) { // 고객 정보, 상담내용 저장
			this.cConsultationRequest.saveContents(name, contactNum, inquiryDetails);
			
		} else if(actionEvent.getActionCommand().equals("삭제")) { // 입력란을 모두 공백으로 만듦
			this.enquirerName.setText("");
			this.contactNumber.setText("");
			this.contents.setText("");
			
		} else if(actionEvent.getActionCommand().equals("상담신청")) { // 저장한 내용들 -> 상담사에게 상담신청
			this.cConsultationRequest.requestConsultation();
						
			// 다이얼로그
			JOptionPane.showMessageDialog(null,
					"문의해주셔서 감사합니다. 확인 후 입력하신 연락처로 연락드리겠습니다.",
					"안내창",
					JOptionPane.INFORMATION_MESSAGE);	
		}
	}

	@Override
	public void run() {
		while(true){
	        Calendar cal = Calendar.getInstance();
	        String clock = cal.get(Calendar.YEAR) + "/" +
	                    (cal.get(Calendar.MONTH)+1) + "/" +
	                    cal.get(Calendar.DATE) + "  " +
                        cal.get(Calendar.HOUR) + ":" +
	                    cal.get(Calendar.MINUTE) + ":" +
	                    cal.get(Calendar.SECOND);
	        this.now.setText(clock);
	        try{
	        	Thread.sleep(1000);
	        }catch(InterruptedException e){
	        	e.printStackTrace();
	        }
		}
	}

}
