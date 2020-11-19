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


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Home 
{
	JFrame frame;
	
	private JPanel panel1,panel2,panel3;
	private JLabel label1;
	private JButton homeButton,loginButton,RegisterButton;
	
	
   public Home()
   {
 	    frame = new JFrame("HomePage");
	    frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		panel1=new JPanel();
		panel1.setBounds(20,50,750,80);
		
		panel2=new JPanel();
		//panel2.setBounds(0,130,150,500);
		panel2.setBounds(10, 130, 1275, 60);
		panel2.setLayout(null);
		
		label1=new JLabel("Virtual Trial Room");
		label1.setBounds(110, 0, 160, 25);
		label1.setFont(new Font("Arial", Font.BOLD, 22));
		label1.setForeground(Color.black);
		panel1.add(label1);
		panel1.setOpaque(false);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(200, 10, 110, 50);
		panel2.add(homeButton);
		panel2.setOpaque(false);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(350, 10, 110, 50);
		panel2.add(loginButton);
		panel2.setOpaque(false);
		
			
		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(500, 10, 110, 50);
		panel2.add(RegisterButton);
		panel2.setOpaque(false);
		
		homeButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)	
		  {
			
			 Home home=new Home();
			 //login.setVisible(true);
			 frame.dispose();
		  }
		  
		}
		);
		 
	
		
		loginButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)	
			  {
				
				 LoginView login=new LoginView();
				 //login.setVisible(true);
				 frame.dispose();
			  }
			  
			}
			);
		 
		    
			
         RegisterButton.addActionListener(new ActionListener()
	       {
	         public void actionPerformed(ActionEvent e)	
	          {
		
		        Register register=new Register();
		        //register.setVisible(true);
		        frame.dispose();
	          }
	  
	       }
		);
            
	        frame.setContentPane(new JLabel(new ImageIcon("Images/sky8.jpg")));
	 	    frame.add(panel1);
	 	    frame.add(panel2);
	 	    //frame.add(panel3);
	 	    //frame.setLocation(200,200);
                    frame.setLocationRelativeTo(null);
	 		frame.setVisible(true);
     }
  
       public static void main(String args[])
        {
	       new Home();
        }
}

