package view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.compensation.handlingPanel;
import view.compensation.receptionPanel;
import view.consultation.consultationPanel;
import view.customer.customerPanel;
import view.insurance.insurancePanel;
import view.insuranceRegistration.insuranceRegistrationPanel;

public class mainFrame implements ActionListener, MouseListener {
	private JFrame frame = new JFrame();
	private Container container = frame.getContentPane();
	private JPanel panel = new JPanel();
	private JPanel viewPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JLabel imgLabel;
	private Color color = new Color(0, 177, 78);
	private Image img = null;
	private ArrayList<JButton> arr;
	private Dimension screenSize;

	// panels
	private customerPanel customerPanel;
	private insurancePanel insurancePanel;
	private insuranceRegistrationPanel insRegistrationPanel;
	private receptionPanel receptionPanel;
	private consultationPanel consultationPanel;
	private handlingPanel handlingPanel;

	public mainFrame() {		
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.frame.setLocation(screenSize.width/5, screenSize.height/5);
		this.frame.setPreferredSize(new Dimension(800, 700));
		this.arr = new ArrayList<>();

		try {
			File sourceImage = new File("img/insurance.png");
			this.img = ImageIO.read(sourceImage);
		} catch (IOException e) {
			System.out.println("이미지 파일 없음");
		}
		init();

		JLabel topLabel = new JLabel("INSURANCE SYSTEM");
		topLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		//panels
		this.topPanel.setBackground(color);
		this.topPanel.add(topLabel);
		this.topPanel.addMouseListener(this);
		this.topPanel.setToolTipText("메인으로");

		this.container.add(this.viewPanel);
		this.viewPanel.setLayout(new BorderLayout());
		this.viewPanel.add(this.bottomPanel, BorderLayout.SOUTH);
		this.viewPanel.add(this.topPanel, BorderLayout.NORTH);
		this.bottomPanel.setLayout(new BoxLayout(this.bottomPanel, BoxLayout.X_AXIS));

		this.panel.setBackground(Color.white);
		this.bottomPanel.setBackground(Color.white);
		this.mainPanel.setBackground(Color.white);
		this.mainPanel.add(this.imgLabel);
		this.panel.add(this.mainPanel);
		
        //buttons
		JButton btnConsultation = new JButton("상담하기");
		JButton btnCustomer = new JButton("고객가입");
		JButton btnInsurance = new JButton("보험설계");	
		JButton btnRegitsration = new JButton("보험가입");
		JButton btnAccident = new JButton("접수하기");
		JButton btnHandling = new JButton("처리하기");
		
		this.arr.add(btnConsultation);
		this.arr.add(btnCustomer);
		this.arr.add(btnInsurance);		
		this.arr.add(btnRegitsration);
		this.arr.add(btnAccident);
		this.arr.add(btnHandling);

		for (JButton i : this.arr) {
			i.setBackground(color);
			this.bottomPanel.add(i);
			i.addActionListener(this);
		}		
		//처음화면
		this.viewPanel.add(this.panel);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void init() {
		this.imgLabel = new JLabel(new ImageIcon(this.img));
	}

	public void showMain() {
		this.panel.add(this.mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		this.panel.removeAll();
		this.panel.updateUI();
		
		if (actionEvent.getActionCommand().equals("상담하기")) {
			this.consultationPanel = new consultationPanel();
			this.panel.add(this.consultationPanel.panel);
		} else if (actionEvent.getActionCommand().equals("고객가입")) {
			this.customerPanel = new customerPanel();
			this.panel.add(this.customerPanel.panel);
		} else if (actionEvent.getActionCommand().equals("보험설계")) {
			this.insurancePanel = new insurancePanel();
			this.panel.add(this.insurancePanel.panel);
		} else if (actionEvent.getActionCommand().equals("보험가입")) {
			this.insRegistrationPanel = new insuranceRegistrationPanel();
			this.panel.add(this.insRegistrationPanel.panel);
		} else if (actionEvent.getActionCommand().equals("접수하기")) {
			this.receptionPanel = new receptionPanel();
			this.panel.add(this.receptionPanel.panel);
		} else if (actionEvent.getActionCommand().equals("처리하기")) {
			this.handlingPanel = new handlingPanel();
			this.panel.add(this.handlingPanel.panel);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		panel.removeAll();
		panel.updateUI();
		panel.add(mainPanel);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
