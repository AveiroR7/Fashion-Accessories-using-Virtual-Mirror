/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.virtual.view;
import com.virtual.view.VTR;
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
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Project GURU
 */
public class LoginView 
{
	private JFrame frame;
	private JPanel panel1, panel2;
	private JLabel emailLabel,passwordLabel,loginLabel,headerLabel;
	private JTextField emailText;
	private JPasswordField passwordText;
	private JButton loginButton,clearButton, registerButton,backButton;
	Boolean resultStatus=Boolean.FALSE;
	
	public LoginView() 
	 {
            frame=new JFrame("LOGIN FORM");
	    frame.setSize(800,600);
	    //frame.setLocation(200,200);
            frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBounds(200,160,600,440);
		
		panel1=new JPanel();
		panel1.setBounds(20,50,750,120);
		
		panel2 = new JPanel();
		panel2.setBounds(250,200,300,300);
		
		
		panel2.setOpaque(false);
		frame.setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("Images/sky8.jpg")));
		
		
		panel2.setLayout(null);
		
		headerLabel=new JLabel("Virtual Trial Room");
		headerLabel.setBounds(110, 0, 160, 25);
		//headerLabel.setSize(headerLabel.getPreferredSize());
		headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
		headerLabel.setForeground(Color.BLACK);
		panel1.add(headerLabel);
		
		loginLabel=new JLabel("LOGIN");
		loginLabel.setBounds(110, 0, 160, 25);
		loginLabel.setFont(new Font("Arial", Font.BOLD, 22));
		loginLabel.setForeground(Color.RED);
		panel2.add(loginLabel);

		emailLabel = new JLabel("Email-ID");
		emailLabel.setBounds(10, 30, 80, 25);
		panel2.add(emailLabel);

		emailText = new JTextField(20);
		emailText.setBounds(100, 30, 160, 25);
		panel2.add(emailText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 70, 80, 25);
		panel2.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 70, 160, 25);
		panel2.add(passwordText);

		loginButton = new JButton("Login");
		loginButton.setBounds(50, 130, 80, 25);
		panel2.add(loginButton);
		
		loginButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)	
		  {
			  /*String email=emailText.getText();
			  String pass= passwordText.getText();
			 
			   
			  if(emailText.getText().length()==0)
		        {
		            JOptionPane.showMessageDialog(frame,"Please Enter User Name");
		        }
		        else if(passwordText.getText().length()==0)
		        {
		           
		            JOptionPane.showMessageDialog(frame,"Please Enter Password");
		            
		        }
		        else
		        {  			       			       
			       UserDao userDao = new UserDaoImpl();			   
			       User user = userDao.selectUser(email, pass);
			      if(user.getEmail()!=null&&user.getPassword()!=null) 
			       {	*/
                                   ArrayList<File> categoryList = new ArrayList<File>();
                                   File f1=new File("images/M.png");
                                   File f2 = new File("images/F.png");
                                   File f3 = new File("images/K.png");
                                   categoryList.add(f1);
                                   categoryList.add(f2);
                                   categoryList.add(f3);
				    SplitPanel sp = new SplitPanel(categoryList);
				    //sp.setVisible(true);
                                    SplitPanel.main(null);
				     frame.dispose();
			      /* } 
			     else
			       {

				     JOptionPane.showMessageDialog(null,"Wrong Password / Username");
				     emailText.setText("");
				     passwordText.setText("");
				     emailText.requestFocus();
			       }
		        }*/
		    }
		  
		   }
		   );
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(180, 130, 80, 25);
		panel2.add(clearButton);
		
		
		registerButton = new JButton("New User");
		registerButton.setBounds(50, 170, 100, 25);
		panel2.add(registerButton);
                
                backButton = new JButton("Back");
		backButton.setBounds(180, 170, 80, 25);
		panel2.add(backButton);
				
		loginLabel.setForeground(new java.awt.Color(51, 51, 255));
		emailLabel.setForeground(new java.awt.Color(51, 51, 255));
		passwordLabel.setForeground(new java.awt.Color(51, 51, 255));
		
		registerButton.addActionListener(new java.awt.event.ActionListener()
		   {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	registerButtonActionPerformed(evt);
            }
        });
		
		clearButton.addActionListener(new java.awt.event.ActionListener()
		   {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clearButtonActionPerformed(evt);
            }
        });
		backButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Home home = new Home(); //To change body of generated methods, choose Tools | Templates.
                    frame.dispose();
                }
            });
		
	    panel1.setOpaque(false);
		panel2.setOpaque(false);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	 }
	
	private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) 
	   {
	        Register register=new Register();
	        //register.setVisible(true);
	        frame.dispose();
	        
	   }
	
	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) 
	  {
        
		emailText.setText("");
        passwordText.setText("");
      
      }
		
	
}