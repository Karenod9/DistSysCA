package client;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
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
import com.dsproject.employeeexpenseservice.Status;
import com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest;
import com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse;
import com.dsproject.employeeexpenseservice.AddExpenseClaimRequest;
import com.dsproject.employeeexpenseservice.AddExpenseClaimResponse;
import com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest;
import com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse;
import com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest;
import com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse;
import com.dsproject.employeeexpenseservice.ClaimStatus;
import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceBlockingStub;
import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceStub;
import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.Window;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JPanel;

public class MainGUIController2 implements ActionListener{

	private static ServiceInfo authenticationServicesInfo; 
	private static ServiceInfo empServiceInfo;
	private static AuthenticationServicesBlockingStub blockingStub;
	private static EmployeeExpenseServiceStub asyncStub;
	
	private static JFrame servicesPanelFrame, Loginframe, empExpenseServicesFrame, unaryExpClaimFrame, biDiExpClaimFrame, uploadExpRecFrame, expenseStatusFrame;
	private static JTextField usernameText, amountBox, passwordText;
	private static JTextField filePath;
	private static JTextArea serverResp;
	private static JButton addSingleExpense, addMultiExpense, uploadExpenseReceipts, checkPreviousClaims, expenseButton, bookingButton;
	private static JFileChooser fileChooser;
	private static int addExpense = 0;
	private static String location;
	private int respCode = -1;
	int loginOK = -1;
	private static JButton logoutButton;
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
		
		logoutButton = new JButton("Logout");
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
			
			empExpenseServicesFrame = new JFrame();
			empExpenseServicesFrame.setTitle("Employee Services: ");
			empExpenseServicesFrame.setBounds(100, 100, 492, 480);
			empExpenseServicesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel expensePanel = new JPanel();
			expensePanel.setLayout(null);
			expensePanel.setVisible(true);
			empExpenseServicesFrame.add(expensePanel);
			
			//expensePanel.add(Box.createRigidArea(new Dimension(30,30)));
			addSingleExpense = new JButton("Add One Expense Claim");
			addSingleExpense.setBounds(104, 115, 255, 63);
			expensePanel.add(addSingleExpense);
			addSingleExpense.addActionListener(this);
		
			//expensePanel.add(Box.createRigidArea(new Dimension(10,10)));
			addMultiExpense = new JButton("Add Multiple Expense Claims");
			addMultiExpense.setBounds(104, 29, 255, 63);
			expensePanel.add(addMultiExpense);
			addMultiExpense.addActionListener(this);
			
			//expensePanel.add(Box.createRigidArea(new Dimension(10,10)));
			uploadExpenseReceipts = new JButton("Upload Expense Receipts");
			uploadExpenseReceipts.setBounds(104, 205, 255, 63);
			expensePanel.add(uploadExpenseReceipts);
			uploadExpenseReceipts.addActionListener(this);
			
			//expensePanel.add(Box.createRigidArea(new Dimension(10,10)));
			checkPreviousClaims = new JButton("Expense Claims Status");
			checkPreviousClaims.setBounds(104, 293, 255, 63);
			expensePanel.add(checkPreviousClaims);
			checkPreviousClaims.addActionListener(this);
			
			JButton backBtn = new JButton("Back");
			backBtn.setBounds(349, 380, 102, 38);
			expensePanel.add(backBtn);
			backBtn.addActionListener(this);
			
//			logoutButton = new JButton("Logout");
//			logoutButton.setBounds(30, 380, 102, 38);
//			expensePanel.add(logoutButton);
			
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
				
			}if(label.equals("Add Multiple Expense Claims")) {
				System.out.println("Add Multiple Expense Claims Loading...");
				empExpenseServicesFrame.dispose();
				multiExpensePanel();
				
			}if(label.equals("Upload Expense Receipts")) {
				System.out.println("Upload Expense Receipts Loading...");
				empExpenseServicesFrame.dispose();
				uploadExpReceiptPanel();
				
			}if(label.equals("Expense Claims Status")) {
				System.out.println("Check Expense Claims Status Loading...");
				empExpenseServicesFrame.dispose();
				expenseClaimStatusPanel();
				
			}else if(label.equals("Back")) {
				empExpenseServicesFrame.dispose();
				servicesPanelFrame.setVisible(true);
				
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
				
					ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
					EmployeeExpenseServiceGrpc.EmployeeExpenseServiceBlockingStub blockingStub = EmployeeExpenseServiceGrpc.newBlockingStub(channel);
						
						double totalAmt;

						try {
							totalAmt = Double.parseDouble(amountBox.getText());
	
							String department = deptOptionsBox.getSelectedItem().toString();
							String expenseType = expTypeOptBox.getSelectedItem().toString();
							int expenseClaimNo;
				
							Random ran = new Random();
							expenseClaimNo = ran.nextInt((100000 - 10) + 1)+ 10;
					
					
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

		
		public static void multiExpensePanel() {
			
			biDiExpClaimFrame = new JFrame("Add an Expense Claim");
			biDiExpClaimFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			biDiExpClaimFrame.setBounds(100, 100, 671, 619);
			biDiExpClaimFrame.setVisible(true);
			
			JPanel biDiExpClaimPanel = new JPanel();
			biDiExpClaimFrame.add(biDiExpClaimPanel);
			biDiExpClaimPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			biDiExpClaimPanel.setLayout(null);
			biDiExpClaimPanel.setVisible(true);

			
			String[] deptOptions = {"IT","Sales","Marketing","HR","Finance","Logistics","Purchasing"};
			final JComboBox<String> deptOptionsBox = new JComboBox<String>(deptOptions);
			deptOptionsBox.setBounds(229, 29, 229, 32);
			biDiExpClaimPanel.add(deptOptionsBox);
			
			JLabel departmentLabel = new JLabel(" Select Department : ");
			departmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			departmentLabel.setBounds(47, 29, 143, 32);
			biDiExpClaimPanel.add(departmentLabel);
			
			
			String[] expenseTypeOptions = {"Catering","Stationary","Cleaning","Equipment","Travel","Misc"};
			final JComboBox<String> expTypeOptBox = new JComboBox<String>(expenseTypeOptions);
			expTypeOptBox.setBounds(229, 78, 229, 32);
			biDiExpClaimPanel.add(expTypeOptBox);
			
			JLabel expenseTypeLabel = new JLabel(" Select Expense Type : ");
			expenseTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			expenseTypeLabel.setBounds(47, 78, 143, 32);
			biDiExpClaimPanel.add(expenseTypeLabel);
			
			amountBox = new JTextField();
			amountBox.setBounds(229, 132, 136, 32);
			biDiExpClaimPanel.add(amountBox);
			amountBox.setColumns(10);

			
			JLabel amountLabel = new JLabel(" Claim amount : ");
			amountLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			amountLabel.setBounds(47, 132, 143, 32);
			biDiExpClaimPanel.add(amountLabel);
			
			
			JButton addBtn = new JButton("Add");
			addBtn.setBounds(72, 281, 102, 38);
			biDiExpClaimPanel.add(addBtn);
			
			JButton finshBtn = new JButton("Finish");
			finshBtn.setBounds(235, 281, 102, 38);
			biDiExpClaimPanel.add(finshBtn);
			
			JButton backBtn = new JButton(" Back ");
			backBtn.setBounds(416, 281, 102, 38);
			biDiExpClaimPanel.add(backBtn);
			
			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					biDiExpClaimFrame.dispose();
					empExpenseServicesFrame.setVisible(true);
				}
			});
			
			
			addBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a) {
					
					finshBtn.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent a) {
							addExpense = 1;
							
						}
					});
					
				
					ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
					//EmployeeExpenseServiceGrpc.EmployeeExpenseServiceStub asyncStub = EmployeeExpenseServiceGrpc.newStub(channel);
					asyncStub = EmployeeExpenseServiceGrpc.newStub(channel);
					CountDownLatch latch = new CountDownLatch(1);
					
					StreamObserver<AddMultiExpenseClaimResponse> responseObserver = new StreamObserver <AddMultiExpenseClaimResponse>() {
						int count = 0;
						double runningTotal = 0.0;
						DecimalFormat df = new DecimalFormat("###.##");
						
						@Override
						public void onNext(AddMultiExpenseClaimResponse res) {
							try {
								runningTotal = res.getRunningTotal();
								Thread.sleep(0);
								System.out.println("Sending expense claim : " + "Total amount sent : "+ df.format(runningTotal));
								System.out.println(res.getClaimResult());
								
								serverResp.append("Total amount sent : " + res.getRunningTotal());
								serverResp.append("Claim status : " + res.getClaimResult());
								
								count += 1;
								System.out.println("------------------------------------------------");
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						}
						
						@Override
						public void onError(Throwable t) {
							System.out.println("ERROR - Client=side - multi-expense");
							serverResp.append("ERROR - WRITTEN Client=side - multi-expense");
							t.printStackTrace();
							latch.countDown();
						}
						
						@Override
						public void onCompleted() {
							serverResp.append("... received " + count + " expense requests" + " Total amount sent : " + df.format(runningTotal));
							System.out.println("Expenses sent!");
							System.out.println("... received " + count + " expense requests" + " Total amount sent : " + df.format(runningTotal));
							latch.countDown();
						}
					};
					
					StreamObserver<AddMultiExpenseClaimRequest> requestObserver = asyncStub.addMultiExpenseClaim(responseObserver);
					
					double totalAmt;
					try {
						try {
							//do {
								totalAmt = Double.parseDouble(amountBox.getText());

								String department = deptOptionsBox.getSelectedItem().toString();
								String expenseType = expTypeOptBox.getSelectedItem().toString();
								int expenseClaimNo;
			
								Random ran = new Random();
								expenseClaimNo = ran.nextInt((100000 - 10) + 1)+ 10;
					
					
					
								expenseClaimNo = ran.nextInt((100000 - 10) + 1)+ 10;
							
								requestObserver.onNext(AddMultiExpenseClaimRequest.newBuilder()
									.setExpenseClaimNo(expenseClaimNo)
									.setDepartment(department)
									.setExpenseType(expenseType)
									.setAmount(totalAmt)
									.build());
							
							
								try {
									Thread.sleep(1000);
								}catch (InterruptedException e) {
									e.printStackTrace();
								}
							
							//}while(addExpense == 1);
							
						System.out.println("Loading......");
						requestObserver.onCompleted();
						
						
						finshBtn.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent a) {
								
								requestObserver.onCompleted();
						
								
							}
								
								
						});

						//requestObserver.onCompleted();
						
						try {
							latch.await(3, TimeUnit.SECONDS);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
					}catch(NumberFormatException fe) {
						serverResp.setForeground(Color.RED);
						serverResp.append("\n ERROR: Please enter a valid amount \n");
					}
						
				}catch (RuntimeException e) {
					e.printStackTrace();
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
			
			biDiExpClaimPanel.add(scrollPane);
			
			
			
		}
		
		
		public static void uploadExpReceiptPanel() {
			
			uploadExpRecFrame = new JFrame("Upload expense Receipt");
			uploadExpRecFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			uploadExpRecFrame.setBounds(100, 100, 755, 520);
			uploadExpRecFrame.setVisible(true);
			
			JPanel uploadExpRecPanel = new JPanel();
			uploadExpRecFrame.add(uploadExpRecPanel);
			uploadExpRecPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			uploadExpRecPanel.setLayout(null);
			uploadExpRecPanel.setVisible(true);
			
			JButton chooseFileBtn = new JButton("Choose File");
			chooseFileBtn.setBounds(24, 95, 114, 34);
			uploadExpRecPanel.add(chooseFileBtn);
			
			JButton uploadBtn = new JButton ("Upload");
			uploadBtn.setBounds(290, 160, 114, 34);
			uploadExpRecPanel.add(uploadBtn);
			
			JButton backBtn2 = new JButton("Back");
			backBtn2.setBounds(615, 11, 114, 34);
			uploadExpRecPanel.add(backBtn2);
			backBtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					uploadExpRecFrame.dispose();
					empExpenseServicesFrame.setVisible(true);
					
				}
			});
			
			
			JProgressBar progressBar = new JProgressBar();
			progressBar.setBounds(227, 205, 234, 25);
			progressBar.setValue(0);
			
			progressBar.setStringPainted(true);
			uploadExpRecPanel.add(progressBar);
			
			filePath = new JTextField();
			filePath.setBounds(148, 100, 581, 25);
			uploadExpRecPanel.add(filePath);
			filePath.setColumns(10);
			filePath.setText("No file selected");

			chooseFileBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a) {
					File f = new File("src\\main\\resources\\uploadTest\\");
					JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
					
					int fc = fileChooser.showOpenDialog(null);
					if(fc == JFileChooser.APPROVE_OPTION) {
						filePath.setText(fileChooser.getSelectedFile().getAbsolutePath());
						location = fileChooser.getSelectedFile().getAbsolutePath();
						System.out.println(location);
						location = location.replace("\\", "\\\\");
						System.out.println(location);
					}else 
						
						filePath.setText("Cancelled");
				}
					
			});
			
			uploadBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent c) {
					
					serverResp.append("\nUploading....");
					ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
					asyncStub = EmployeeExpenseServiceGrpc.newStub(channel);
					
					
					CountDownLatch latch = new CountDownLatch(1);
					StreamObserver<UploadExpenseReceiptsResponse> responseObserver = new StreamObserver<UploadExpenseReceiptsResponse>() {
						
							@Override
							public void onNext(UploadExpenseReceiptsResponse value) {
								//response from server
								//called once
								
								System.out.println("File upload status : " + value.getStatus());
								serverResp.append("\nFILE LOCATION : " + value.getFileName());
								serverResp.append("\nSTATUS : " + value.getStatus());
								serverResp.append("\nSIZE " +value.getSize());
								
							}

							@Override
							public void onError(Throwable t) {
								//error from the server
								System.out.println("ERROR in file upload");
								serverResp.append("ERROR in file upload");
							}

							@Override
							public void onCompleted() {
								//server is finished
								//called right after onNext()
								progressBar.setIndeterminate(false);
								progressBar.setValue(100);
								System.out.println("Finished");
								serverResp.append("\nFinished ");
								latch.countDown();
							}
							
						};
						
						StreamObserver<UploadExpenseReceiptsRequest> requestObserver = asyncStub.uploadExpenseReceipts(responseObserver);
						
						System.out.println(location);
						File file = new File(location);
						if(!file.exists()) {
							System.out.println("File does not exist");
							return;
						}else {
							try {
								long actualFileSize = file.length();
								int chunkSize = (int) actualFileSize / 4;
								BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(file));
								
								
								int buffSize = chunkSize;
								byte[] byteBuff = new byte[buffSize];
								int size = 0;
								
								
								
								try {
									while((size = buffIn.read(byteBuff) ) >0) {
										progressBar.setIndeterminate(true);
										ByteString bString = ByteString.copyFrom(byteBuff, 0 , (int) actualFileSize);

										requestObserver.onNext(UploadExpenseReceiptsRequest.newBuilder()
												.setData(bString)
												.setFileName(location)
												.setSize(size)
												.setActualFileSize(actualFileSize)
												.build());
										
										
										System.out.println("Uploading File...");
										
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
									//progressBar.setIndeterminate(false);
									requestObserver.onCompleted();
									buffIn.close();
									
									
								} catch (IOException e) {
									e.printStackTrace();
								}
								
							}catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							
						try {
							latch.await(3L, TimeUnit.SECONDS);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}	
					}
				}
					
			});
			
			
			serverResp = new JTextArea();
			serverResp.setEditable(false);
			serverResp.setLineWrap(true);
			serverResp.setWrapStyleWord(true);
			serverResp.setBackground(UIManager.getColor("Button.background"));
			serverResp.setForeground(Color.BLACK);
			serverResp.setBounds(39, 268, 642, 177);
			
			JScrollPane scrollPane = new JScrollPane(serverResp);
			scrollPane.setBackground(UIManager.getColor("Button.background"));
			scrollPane.setBounds(39, 268, 642, 177);
			scrollPane.setBorder(null);
			uploadExpRecPanel.add(scrollPane);
			
		
	}
		
		
		public static void expenseClaimStatusPanel() {
			
			expenseStatusFrame = new JFrame("Claim Expense Status");
			expenseStatusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			expenseStatusFrame.setBounds(100, 100, 790, 596);
			expenseStatusFrame.setVisible(true);
			
			JPanel expStatusPanel = new JPanel();
			expStatusPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			expStatusPanel.setLayout(null);
			expStatusPanel.setVisible(true);
			expenseStatusFrame.add(expStatusPanel);
			
			JButton expenseStatusBtn = new JButton("Claim Status : ");
			expenseStatusBtn.setBounds(260, 32, 248, 39);
			expStatusPanel.add(expenseStatusBtn);
			
			expenseStatusBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			EmployeeExpenseServiceBlockingStub blockingStub = EmployeeExpenseServiceGrpc.newBlockingStub(channel);
			
			
			int checkExpenses =1;
				CheckExpenseClaimRequest req = CheckExpenseClaimRequest.newBuilder()
						.setCheckAllExpenses(checkExpenses).build();
				
				try {
					Iterator<CheckExpenseClaimResponse> response = blockingStub.checkExpenseClaim(req);
					while(response.hasNext()) {
						CheckExpenseClaimResponse res = response.next();
						System.out.println("Claim no : " + res.getClaimNumber() + " || " +  "Amount : €" + res.getAmount() + " || " + "Status : " + res.getStatus());
						serverResp.append("Claim no : " + res.getClaimNumber() + " || " +  "Amount : €" + res.getAmount() + " || " + "Status : " + res.getStatus());
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}catch(StatusRuntimeException e) {
					e.printStackTrace();
				}
				}
			});
				
				serverResp = new JTextArea();
				serverResp.setEditable(false);
				serverResp.setLineWrap(true);
				serverResp.setWrapStyleWord(true);
				serverResp.setBackground(UIManager.getColor("Button.background"));
				serverResp.setForeground(Color.BLACK);
				serverResp.setBounds(10, 104, 754, 442);
				
				JScrollPane scrollPane = new JScrollPane(serverResp);
				//scrollPane.setBackground(UIManager.getColor("Button.background"));
				scrollPane.setBounds(10, 104, 754, 442);
				scrollPane.setBorder(null);
				expStatusPanel.add(scrollPane);
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


