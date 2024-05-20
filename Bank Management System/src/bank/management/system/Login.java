package bank.management.system;

import javax.swing.*;
import java.sql.*;//for resultset
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

	JButton login,clear,signup;
	JTextField cardtextfield;
	JPasswordField pintextfield;
	
	Login(){
		setTitle("MyBank:ATM");
		
		setLayout(null);//will get back to the custom layout once again.
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/ATM.jpg"));//this will locate the resource and load the image
		Image i2=i1.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);//creating a image object so that the image size in the frame can be set ..
		ImageIcon i3=new ImageIcon(i2);//i2 can't be directly in the label that's why need to convert i2 to imageicon and then add in the label.. 
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);//to add some label to the frame,we need to use the label 

		JLabel text=new JLabel("Welcome to My Bank ATM");//jlabel is majorly there to add in the some content 
		text.setFont(new Font("Open Sans", Font.BOLD,30));
		text.setBounds(200,40,500,40);
		add(text);
		
		JLabel cardNo=new JLabel("Card Number:");//jlabel is majorly there to add in the some content 
		cardNo.setFont(new Font("Open Sans", Font.BOLD,20));
		cardNo.setBounds(120,160,160,40);
		add(cardNo); 
		
		cardtextfield=new JTextField();
		cardtextfield.setBounds(300,150,250,30);
		add(cardtextfield);
		
		JLabel pin=new JLabel("Pin:");//jlabel is majorly there to add in the some content 
		pin.setFont(new Font("Open Sans", Font.BOLD,20));
		pin.setBounds(120,210,400,40);
		add(pin);
		
		pintextfield=new JPasswordField();
		pintextfield.setBounds(300,220,250,30);
		add(pintextfield);
		
		login=new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear=new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup=new JButton("SIGN UP!");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);//setting the content pane background as white
		setSize(800,450);
		setVisible(true);
		setLocation(400,200);
		 
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardtextfield.setText("");
			pintextfield.setText("");
		}
		else if(ae.getSource()==login) {
			Conn conn=new Conn();
			String cardnumber=cardtextfield.getText();
			String pinnumber=pintextfield.getText();//this is depicting ki it is a passwordfield
			String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
			try {
				ResultSet rs=conn.s.executeQuery(query);//all the queries data needs to be stored in this resultset
				if(rs.next()) {
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()==signup) {//if we directly click to the signup button it will redirect to the signup page 
			setVisible(false);
			new SignOne().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();//so that immediately the frame will open as soon the main class opens
		
	}

}
