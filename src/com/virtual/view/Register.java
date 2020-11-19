/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.virtual.view;

/**
 *
 * @author Project GURU
 */
import com.virtual.EmailAndMobile;
import com.virtual.bean.User;
import com.virtual.dao.UserDao;
import com.virtual.dao.UserDaoImpl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Register
{
	private JFrame frame;
	private JLabel headerLabel,fnameLabel,lnameLabel,emailLabel,passwordLabel,addressLabel,contactLabel,RegisterLabel;
	
	private JTextField fnameText,lnameText,emailText,contactText,addressText;
	
	private JPasswordField passwordText;
	private JButton registerButton,clearButton, loginButton,backButton;
	
    
    private JPanel panel1,panel2;
    Boolean resultStatus=Boolean.FALSE;
	

	public Register()
	 {
		frame = new JFrame("REGISTRATION FORM");
		frame.setSize(800,600);
                frame.setLocationRelativeTo(null);
		//frame.setLocation(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1=new JPanel();
		panel1.setBounds(20,50,750,80);
		
		panel2 = new JPanel();
		panel2.setBounds(250,150,450,450);		
		
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("images/sky8.jpg")));
		
		
		panel2.setLayout(null);
		
		headerLabel=new JLabel("Virtual Trial Room");
		headerLabel.setBounds(110, 0, 160, 25);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
		headerLabel.setForeground(Color.BLACK);
		panel1.add(headerLabel);
		
		RegisterLabel=new JLabel("REGISTRATION");
		RegisterLabel.setBounds(90, 0, 200, 20);
		RegisterLabel.setFont(new Font("Arial", Font.BOLD, 22));
		RegisterLabel.setForeground(Color.RED);
		panel2.add(RegisterLabel);

		fnameLabel = new JLabel("First Name:");
		fnameLabel.setBounds(10, 30, 80, 25);
		panel2.add(fnameLabel);

		fnameText = new JTextField(20);
		fnameText.setBounds(100, 30, 160, 25);
		panel2.add(fnameText);
		
		lnameLabel = new JLabel("Last Name:");
		lnameLabel.setBounds(10, 70, 80, 25);
		panel2.add(lnameLabel);

		lnameText = new JTextField(20);
		lnameText.setBounds(100, 70, 160, 25);
		panel2.add(lnameText);
		
		emailLabel = new JLabel("Email-ID:");
		emailLabel.setBounds(10, 110, 80, 25);
		panel2.add(emailLabel);

		emailText = new JTextField(20);
		emailText.setBounds(100, 110, 160, 25);
		panel2.add(emailText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 150, 80, 25);
		panel2.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 150, 160, 25);
		panel2.add(passwordText);
		
		contactLabel = new JLabel("contact");
		contactLabel.setBounds(10, 190, 80, 25);
		panel2.add(contactLabel);

		contactText = new JTextField(20);
		contactText.setBounds(100, 190, 160, 25);
		panel2.add(contactText);

		addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 230, 80, 25);
		panel2.add(addressLabel);

		addressText = new JTextField(20);
		addressText.setBounds(100, 230, 160, 25);
		panel2.add(addressText);		
		

		registerButton = new JButton("Register");
		registerButton.setBounds(10, 270, 100, 25);
		registerButton.setForeground(Color.BLACK);
		panel2.add(registerButton);
		
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(180, 270, 80, 25);
		clearButton.setForeground(Color.BLACK);
		panel2.add(clearButton);
                
                backButton = new JButton("Back");
		backButton.setBounds(180, 310, 80, 25);
		backButton.setForeground(Color.BLACK);
		panel2.add(backButton);
                
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 310, 80, 25);
		loginButton.setForeground(Color.BLACK);
		panel2.add(loginButton);
		
		RegisterLabel.setForeground(new java.awt.Color(51, 51, 255));
		fnameLabel.setForeground(new java.awt.Color(51, 51, 255));
		lnameLabel.setForeground(new java.awt.Color(51, 51, 255));
		emailLabel.setForeground(new java.awt.Color(51, 51, 255));
		passwordLabel.setForeground(new java.awt.Color(51, 51, 255));
		contactLabel.setForeground(new java.awt.Color(51, 51, 255));
		addressLabel.setForeground(new java.awt.Color(0, 51, 255));
		       
		
		registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	registerButtonActionPerformed(evt);
            }
        });
		
		
		clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clearButtonActionPerformed(evt);
            }
        });
		
		loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	loginButtonActionPerformed(evt);
            }
        });
                backButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Home home = new Home(); //To change body of generated methods, choose Tools | Templates.
                    frame.dispose();
                }
            });
		
		passwordText.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	passwordTextActionPerformed(evt);
	            }
	        });
		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	 }
		
		private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) 
		{
	        String fname=fnameText.getText();
	        String lname=lnameText.getText();
	        String email=emailText.getText();
	        boolean validEmail =EmailAndMobile.isValidEmailAddress(email);
	        String password=passwordText.getText();
	        String contact=contactText.getText();
	        boolean validMobilNo =EmailAndMobile.isValidMobilNumber(contact);
	        String address=addressText.getText();        
	        
	        if(fnameText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter First Name");
	        }
	        else if(lnameText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter Last Name");
	        }
	        else if(emailText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter Email-ID");
	            
	        }
	        else if(validEmail==false)
	        {   
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Email Id");            
	        }
	        else if(passwordText.getText().length()==0)
	        {	           
	            JOptionPane.showMessageDialog(frame,"Please Enter Password");	            
	        }
	        else if(contactText.getText().length()==0)
	        {
	            JOptionPane.showMessageDialog(frame,"Please Enter Mobile");	            
	        }
	        else if(validMobilNo==false)
	        {    
	            JOptionPane.showMessageDialog(frame,"Please Enter Valid Mobile Number");   
	        }
	        else if(addressText.getText().length()==0)
	        {	            
	            JOptionPane.showMessageDialog(frame,"Please Enter Address");    
	        }	  
	                        
	        else
	        {
	        
	         User user=new User();
	         user.setFname(fname);
	         user.setLname(lname);
	         user.setEmail(email);
	         user.setPassword(password);
	         user.setContact(contact);
	         user.setAddress(address);
	         UserDao userDao = new UserDaoImpl();	         
	 		 
	        if(userDao.createUser(user))
	        {	        	 
		 		 //ed.sendEmail(email);
	         JOptionPane.showMessageDialog(frame,"User Registered Sucessfully !!!");
	        
	          LoginView login=new LoginView();
	          //login.setVisible(true);
	          frame.dispose();
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(frame,"User Registration Fail !!!");
	        }
	        }
		}
		
		private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) 
		 {
			//GEN-FIRST:event_jPasswordField1ActionPerformed
		        // TODO add your handling code here:
		 }
	       
		private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) 
		{	        
			fnameText.setText("");
			lnameText.setText("");
			emailText.setText("");
			passwordText.setText("");
	        contactText.setText("");
	        addressText.setText("");      
	     }
		
		 private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) 
		   {
		        LoginView login=new LoginView();
		        //login.setVisible(true);
		        frame.dispose();
		        
		   }
	
	
		 public static void main(String[] args)
			{
				
				new Register();
			}	
}