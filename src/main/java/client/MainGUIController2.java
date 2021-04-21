package client;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dsproject.authenticationservices.AuthenticationServicesGrpc;
import com.dsproject.authenticationservices.LoginRequest;
import com.dsproject.authenticationservices.LoginResponse;
import com.dsproject.authenticationservices.LogoutRequest;
import com.dsproject.authenticationservices.LogoutResponse;
import com.dsproject.authenticationservices.AuthenticationServicesGrpc.AuthenticationServicesBlockingStub;
import com.dsproject.authenticationservices.AuthenticationServicesGrpc.AuthenticationServicesStub;


import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc;
import com.dsproject.employeeexpenseservice.AddExpenseClaimRequest;
import com.dsproject.employeeexpenseservice.AddExpenseClaimResponse;
import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceBlockingStub;
import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceStub;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;

public class MainGUIController2 implements ActionListener{

	private static ServiceInfo authenticationServicesInfo; 
	private static ServiceInfo empServiceInfo;
	private static AuthenticationServicesBlockingStub blockingStub;
	private static AuthenticationServicesStub asyncStub;
	
	private static JFrame servicesPanelFrame, Loginframe, empExpenseServicesFrame, unaryExpClaimFrame;
	private static JTextField usernameText, amountBox, passwordText;
	private static JTextArea serverResp;
	private static JButton addSingleExpense, addMultiExpense, uploadExpenseReceipts, checkPreviousClaims, expenseButton, bookingButton;

	private int respCode = -1;
	int loginOK = -1;
	
/*	
 * DONE: LOGIN (CLIENT/GUI)
 * DONE: SINGLE EXPENSE CLAIM (CLIENT/GUI)
 * TO DO:
 * NEXT IMPLEMENT ADD MULTI EXPENSE CLAIMS(CLIENT/GUI)
 * 
 * 
 * 
 * 
 * 
 * 
 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIController2 window = new MainGUIController2();
					window.Loginframe.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUIController2() {
		String authentication_service_type = "_AuthenticationServices._tcp.local.";
		discoverAuthenticationServices(authentication_service_type);
		
		String emp_service_type = "_EmployeeExpenseService._tcp.local.";
		discoverEmployeeExpenseServices(emp_service_type);
		
		String host = "localhost";
//		int port = 50051;
		
		System.out.println(host);
				
//		@SuppressWarnings("deprecation")
//		String host = authenticationServicesInfo.getHostAddress();
//		int port = authenticationServicesInfo.getPort();
		

		
//		blockingStub = AuthenticationServicesGrpc.newBlockingStub(channel);
//		asyncStub = AuthenticationServicesGrpc.newStub(channel);
		
		
		
		initializeGUI();
		
		//onLoginWindow();
		//empExpenseServices();
		//singleExpenseClaimPanel();
		
//		if(loginOK == 0) {
//			System.out.println("LOGGED IN..");
//			
//			onLoginWindow();
//			
//		}

//		if(respCode == 0) {
//			System.out.println("LOGGED IN..");
//			frame.dispose();
//			onLoginWindow();
//			frame2.setVisible(true);
//		}
		

			
	}

	/**
	 * Login Screen GUI
	 */
	private void initializeGUI() {
		
		Loginframe = new JFrame();
		Loginframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Loginframe.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		Loginframe.setTitle("Please Login to Access Services");
		Loginframe.setBounds(100, 100, 450, 300);
		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loginframe.getContentPane().setLayout(null);

		
		JLabel usernameLabel = new JLabel("Username : ");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(43, 40, 124, 27);
		Loginframe.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password : ");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(43, 101, 124, 27);
		Loginframe.getContentPane().add(passwordLabel);
		
		usernameText = new JTextField();
		usernameText.setBounds(196, 39, 180, 33);
		Loginframe.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		
		passwordText = new JPasswordField();
		passwordText.setColumns(10);
		passwordText.setBounds(196, 101, 180, 33);
		Loginframe.getContentPane().add(passwordText);
		passwordText.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setBounds(43, 166, 112, 33);
		Loginframe.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				String password = passwordText.getText();
				
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
				blockingStub = AuthenticationServicesGrpc.newBlockingStub(channel);
				
				LoginRequest req = LoginRequest.newBuilder()
						.setUsername(username)
						.setPassword(password)
						.build();
				LoginResponse response = blockingStub.login(req);
				System.out.println(response.getResponseMessage());
				respCode = response.getResponseCode(); 
				System.out.println(response.getResponseCode());
			
				JOptionPane.showMessageDialog(null, response.getResponseMessage());
				
				try {
					
					System.out.println("Loading...");
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//if login successful (response code = 0) 
				//close login frame & call the servicesPanel method and set it to visible.
				
				if(respCode == 0) {
					System.out.println("LOGGED IN..");
					Loginframe.dispose();
					servicesPanel();
					servicesPanelFrame.setVisible(true);
				}
				
			}
		});
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		logoutButton.setBounds(264, 166, 112, 33);
		Loginframe.getContentPane().add(logoutButton);
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				int logout = 1;
				LogoutRequest req = LogoutRequest.newBuilder()
						.setRequestMessage(logout)
						.build();

				LogoutResponse response = blockingStub.logout(req);
				System.out.println(response.getResponseMessage());
				JOptionPane.showMessageDialog(null, response.getResponseMessage());
			}
		});
		
	}
	
	
		//x y w h
		public void servicesPanel() {
			JPanel panel = new JPanel();
			
			servicesPanelFrame = new JFrame();
			servicesPanelFrame.setTitle("Employee Services : ");
			servicesPanelFrame.setSize(400, 250);
			servicesPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			servicesPanelFrame.setVisible(true);
			
			servicesPanelFrame.add(panel);
			
			
			expenseButton = new JButton("Expense Services");
			expenseButton.setBounds(210, 80, 80, 80);
			panel.add(expenseButton);
			
			bookingButton = new JButton("Room Booking Services");
			bookingButton.setBounds(210, 80, 80, 80);
			panel.add(bookingButton);
			
			expenseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					servicesPanelFrame.dispose();
					empExpenseServices();
					empExpenseServicesFrame.setVisible(true);
				}
				
			});
			
	}
		
		
		private JPanel empExpenseServices() {
			
			JPanel expensePanel = new JPanel();
			expensePanel.setLayout(new BoxLayout(expensePanel, BoxLayout.PAGE_AXIS));
			
			empExpenseServicesFrame = new JFrame();
			empExpenseServicesFrame.setTitle("Employee Services: ");
			empExpenseServicesFrame.setSize(400, 250);
			empExpenseServicesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			empExpenseServicesFrame.add(expensePanel);
			
			expensePanel.add(Box.createRigidArea(new Dimension(30,30)));
			addSingleExpense = new JButton("Add One Expense Claim");
			addSingleExpense.setBounds(210, 80, 80, 80);
			expensePanel.add(addSingleExpense);
			addSingleExpense.addActionListener(this);
		
			expensePanel.add(Box.createRigidArea(new Dimension(10,10)));
			addMultiExpense = new JButton("Add Multiple Expense Claims");
			addMultiExpense.setBounds(210, 80, 80, 80);
			expensePanel.add(addMultiExpense);
			addMultiExpense.addActionListener(this);
			
			expensePanel.add(Box.createRigidArea(new Dimension(10,10)));
			uploadExpenseReceipts = new JButton("Upload Expense Receipts");
			uploadExpenseReceipts.setBounds(210, 80, 80, 80);
			expensePanel.add(uploadExpenseReceipts);
			addMultiExpense.addActionListener(this);
			
			expensePanel.add(Box.createRigidArea(new Dimension(10,10)));
			checkPreviousClaims = new JButton("Check Status of Previous Expense Claims");
			checkPreviousClaims.setBounds(210, 80, 80, 80);
			expensePanel.add(checkPreviousClaims);
			addMultiExpense.addActionListener(this);
			
			return expensePanel;
		}
		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			String label = button.getActionCommand();
			
			
			
			
			if(label.equals("Add One Expense Claim")) {
				System.out.println("Add Single Expense Claim Loading...");
				empExpenseServicesFrame.dispose();
				
				singleExpenseClaimPanel();
				
				
				

				
				
			}
			
			
		}
		public static void singleExpenseClaimPanel() {
			
			unaryExpClaimFrame = new JFrame("Add an Expense Claim");
			unaryExpClaimFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			unaryExpClaimFrame.setBounds(100, 100, 535, 497);
			unaryExpClaimFrame.setVisible(true);
			
			JPanel unaryExpClaimPanel = new JPanel();
			unaryExpClaimFrame.add(unaryExpClaimPanel);
			unaryExpClaimPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			unaryExpClaimPanel.setLayout(null);
			unaryExpClaimPanel.setVisible(true);

			
			String[] deptOptions = {"IT","Sales","Marketing","HR","Finance","Logistics","Purchasing"};
			final JComboBox<String> deptOptionsBox = new JComboBox<String>(deptOptions);
			deptOptionsBox.setBounds(229, 29, 229, 32);
			unaryExpClaimPanel.add(deptOptionsBox);
			
			JLabel departmentLabel = new JLabel(" Select Department : ");
			departmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			departmentLabel.setBounds(47, 29, 143, 32);
			unaryExpClaimPanel.add(departmentLabel);
			
			
			String[] expenseTypeOptions = {"Catering","Stationary","Cleaning","Equipment","Travel","Misc"};
			final JComboBox<String> expTypeOptBox = new JComboBox<String>(expenseTypeOptions);
			expTypeOptBox.setBounds(229, 78, 229, 32);
			unaryExpClaimPanel.add(expTypeOptBox);
			
			JLabel expenseTypeLabel = new JLabel(" Select Expense Type : ");
			expenseTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			expenseTypeLabel.setBounds(47, 78, 143, 32);
			unaryExpClaimPanel.add(expenseTypeLabel);
			
			amountBox = new JTextField();
			amountBox.setBounds(229, 132, 136, 32);
			unaryExpClaimPanel.add(amountBox);
			amountBox.setColumns(10);

			
			
			JLabel amountLabel = new JLabel(" Claim amount : ");
			amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			amountLabel.setBounds(47, 132, 143, 32);
			unaryExpClaimPanel.add(amountLabel);
			
			
			JButton sendBtn = new JButton(" Send ");
			sendBtn.setBounds(63, 217, 107, 32);
			unaryExpClaimPanel.add(sendBtn);
			
			JButton backBtn = new JButton(" Back ");
			backBtn.setBounds(287, 217, 107, 32);
			unaryExpClaimPanel.add(backBtn);
			
			sendBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a) {
					
				
	//--TO DO ------------------------------------------------------------CHANGE PORT NUMBER
					ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60600).usePlaintext().build();
					EmployeeExpenseServiceGrpc.EmployeeExpenseServiceBlockingStub blockingStub = EmployeeExpenseServiceGrpc.newBlockingStub(channel);
//					try {
						
						double totalAmt;

//					}catch(NumberFormatException ie) {
//						serverResp.append("");
//					}
						
						try {
						totalAmt = Double.parseDouble(amountBox.getText());
	
			
					
					String department = deptOptionsBox.getSelectedItem().toString();
					String expenseType = expTypeOptBox.getSelectedItem().toString();
					int expenseClaimNo;
				
					Random ran = new Random();
					expenseClaimNo = ran.nextInt((100000 - 10) + 1)+ 10;
					
					
					
//					String doubString = String.valueOf(totalAmt);
//					final String isPrice = "^\\d{0,8}(\\.\\d{1,4})?$";
//					Pattern pat = Pattern.compile(isPrice);
//					Matcher matcher = pat.matcher(doubString);
//					if(matcher.matches()) {
					
					
					
						AddExpenseClaimRequest req = AddExpenseClaimRequest.newBuilder()
								.setExpenseClaimNo(expenseClaimNo)
								.setDepartment(department)
								.setExpenseType(expenseType)
								.setTotalAmt(totalAmt)
								.build();
						

				
						AddExpenseClaimResponse response = blockingStub.addExpenseClaim(req);

						try {
							Thread.sleep(1000);
							serverResp.setForeground(Color.BLACK);
							serverResp.append(response.getClaimResult());
							System.out.println(response.getClaimResult());
						}catch (InterruptedException e) {
							e.printStackTrace();
						}
					}catch(NumberFormatException fe) {
						serverResp.setForeground(Color.RED);
						
						serverResp.append("\n ERROR: Please enter a valid amount \n");
					}	
				}
			});

			serverResp = new JTextArea();
			serverResp.setEditable(false);
			serverResp.setLineWrap(true);
			serverResp.setWrapStyleWord(true);
			serverResp.setBackground(UIManager.getColor("Button.background"));
			serverResp.setForeground(Color.BLACK);
			
			JScrollPane scrollPane = new JScrollPane(serverResp);
			scrollPane.setBackground(UIManager.getColor("Button.background"));
			scrollPane.setBounds(36, 291, 450, 124);
			scrollPane.setBorder(null);
			
			unaryExpClaimPanel.add(scrollPane);
			
			
			backBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a) {
					unaryExpClaimFrame.dispose();
					empExpenseServicesFrame.setVisible(true);

						
				}
					
			});

			
	}

		
		public static void checkInput(JTextField input) {
			int valid = -1;
//			final String isInt = "^-?\\\\d+$";	
//			final String isDouble = "^-?\\d+(\\.\\d+)?$";
			final String isPrice = "^\\d{0,8}(\\.\\d{1,4})?$";
			if(Pattern.matches(isPrice, (CharSequence) input)) {
				valid = 0;
			}else
				valid = 1;			
		}

	
		
		
		
		
		
		
		
		
	
	
	private void discoverAuthenticationServices(String service_type) {
		System.out.println("discoverAuthenticationServices");
		
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Authentication Services resolved : " +event.getInfo());
					
					authenticationServicesInfo = event.getInfo();
					
					//String[] host = authenticationServicesInfo.getHostAddresses();
					//int port = authenticationServicesInfo.getPort();
					
					int port = authenticationServicesInfo.getPort();
					System.out.println("RESOLVING : .......");
					System.out.println("resolving " + service_type + " with properties as follows: ...");
					System.out.println(" Port: " + port);
					System.out.println(" Type:"+ event.getType());
					System.out.println(" Name: " + event.getName());
					System.out.println(" Description: " + authenticationServicesInfo.getNiceTextString());
					System.out.println(" Host: " + authenticationServicesInfo.getHostAddresses()[0]);					
					
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					// TODO Auto-generated method stub
					
				}
			});
			jmdns.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	private void discoverEmployeeExpenseServices(String service_type) {
		System.out.println("discoverEmployeeExpenseServices");
		
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Employee Expense Services resolved : " +event.getInfo());
					
					empServiceInfo = event.getInfo();
					
					//String[] host = authenticationServicesInfo.getHostAddresses();
					//int port = authenticationServicesInfo.getPort();
					
					int port = empServiceInfo.getPort();
					System.out.println("RESOLVING : .......");
					System.out.println("resolving " + service_type + " with properties as follows: ...");
					System.out.println(" Port: " + port);
					System.out.println(" Type:"+ event.getType());
					System.out.println(" Name: " + event.getName());
					System.out.println(" Description: " + empServiceInfo.getNiceTextString());
					System.out.println(" Host: " + empServiceInfo.getHostAddresses()[0]);					
					
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					// TODO Auto-generated method stub
					
				}
			});
			jmdns.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}


