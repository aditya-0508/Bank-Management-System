package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignOne extends JFrame implements ActionListener {

	long rando;
	JTextField nametextField,fnametextField,emailtextField,citytextField,pintextField;
	JButton next;
	JRadioButton female,male;
	JDateChooser dateChooser;
	
	SignOne(){
		setTitle("Account details for the new user");
		setLayout(null);
		
		Random ran=new Random();
		rando= Math.abs((ran.nextLong()%9000L)+1000L);
		
		JLabel formno=new JLabel("Application Form No..."+rando);
		formno.setFont(new Font("Open Sans", Font.BOLD,32));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personDetails=new JLabel("Page 1:Add the Personal Details");
		personDetails.setFont(new Font("Open Sans", Font.BOLD,32));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Open Sans", Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nametextField=new JTextField();
		nametextField.setFont(new Font("Raleway",Font.BOLD,14));
		nametextField.setBounds(300,140,400,30);
		add(nametextField);
		
		JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Open Sans", Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnametextField=new JTextField();
		fnametextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnametextField.setBounds(300,190,400,30);
		add(fnametextField);
		
		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Open Sans",Font.BOLD,20));
		dob.setBounds(100,230,200,30);
		add(dob);
		
		dateChooser=new JDateChooser();
		dateChooser.setBounds(300,230,200,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Open Sans",Font.BOLD,20));
		gender.setBounds(100,280,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450,290,80,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email=new JLabel("Email:");
		email.setFont(new Font("Open Sans",Font.BOLD,20));
		email.setBounds(100,330,200,30);
		add(email);
		
		emailtextField=new JTextField();
		emailtextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailtextField.setBounds(300,330,400,30);
		add(emailtextField);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Open Sans",Font.BOLD,20));
		city.setBounds(100,370,200,30);
		add(city);
		
		citytextField=new JTextField();
		citytextField.setFont(new Font("Raleway",Font.BOLD,14));
		citytextField.setBounds(300,370,400,30);
		add(citytextField);
		
		JLabel pincode=new JLabel("Pincode:");
		pincode.setFont(new Font("Open Sans",Font.BOLD,20));
		pincode.setBounds(100,410,200,30);
		add(pincode);
		
		pintextField=new JTextField();
		pintextField.setFont(new Font("Raleway",Font.BOLD,14));
		pintextField.setBounds(300,410,400,30);
		add(pintextField);
		
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(580,520,80,30);
		next.addActionListener(this);//for listening to the actions of the same
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,650);
		setVisible(true);
		setLocation(400,200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno=""+ rando;//long
		String name=nametextField.getText();//to get the value from the name field
		String fname=fnametextField.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();//need to make it as JTextField for it to work..
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailtextField.getText();
		String city=citytextField.getText();
		String pin=pintextField.getText();
		
		//to hit the database
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is required");//to suspend the operation and show a msg been displayed
			}
			else {
				Conn c=new Conn();
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+city+"','"+email+"','"+pin+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);//to close the current frame of signupone and then redirect to next frame
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new SignOne();
	}

}
