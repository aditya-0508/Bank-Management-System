package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JTextField pantextField, aadhartextField;
    JButton next;
    JComboBox<String> religion, category, income, education, occupation;
    JRadioButton eyes, enos, ees, eos;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        setTitle("Account details for the new user");
        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2: Add the Additional Details");
        additionalDetails.setFont(new Font("Open Sans", Font.BOLD, 23));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Open Sans", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[] = {"Select", "Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Open Sans", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcat[] = {"Select", "General", "OBC", "ST", "SC", "Other"};
        category = new JComboBox<>(valcat);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Open Sans", Font.BOLD, 20));
        dob.setBounds(100, 230, 200, 30);
        add(dob);

        String incomecategory[] = {"Select", "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Other"};
        income = new JComboBox<>(incomecategory);
        income.setBounds(300, 230, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational Qualifications:");
        gender.setFont(new Font("Open Sans", Font.BOLD, 20));
        gender.setBounds(100, 280, 300, 30);
        add(gender);

        String eduval[] = {"Select", "12th Pass", "Graduate", "PostGraduate", "PH.D", "Other"};
        education = new JComboBox<>(eduval);
        education.setBounds(400, 280, 300, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel email = new JLabel("Occupation:");
        email.setFont(new Font("Open Sans", Font.BOLD, 20));
        email.setBounds(100, 330, 200, 30);
        add(email);

        String occval[] = {"Select", "Salaried", "Student", "Business", "Non-Salaried", "Other"};
        occupation = new JComboBox<>(occval);
        occupation.setBounds(300, 330, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel city = new JLabel("Pan Number:");
        city.setFont(new Font("Open Sans", Font.BOLD, 20));
        city.setBounds(100, 370, 200, 30);
        add(city);

        pantextField = new JTextField();
        pantextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pantextField.setBounds(300, 370, 400, 30);
        add(pantextField);

        JLabel pincode = new JLabel("Aadhar Number:");
        pincode.setFont(new Font("Open Sans", Font.BOLD, 20));
        pincode.setBounds(100, 410, 200, 30);
        add(pincode);

        aadhartextField = new JTextField();
        aadhartextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhartextField.setBounds(300, 410, 400, 30);
        add(aadhartextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Open Sans", Font.BOLD, 20));
        senior.setBounds(100, 450, 200, 30);
        add(senior);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 450, 60, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        enos = new JRadioButton("No");
        enos.setBounds(450, 450, 60, 30);
        enos.setBackground(Color.WHITE);
        add(enos);

        ButtonGroup seniorgrp = new ButtonGroup();
        seniorgrp.add(eyes);
        seniorgrp.add(enos);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Open Sans", Font.BOLD, 20));
        existing.setBounds(100, 490, 200, 30);
        add(existing);

        ees = new JRadioButton("Yes");
        ees.setBounds(300, 490, 60, 30);
        ees.setBackground(Color.WHITE);
        add(ees);

        eos = new JRadioButton("No");
        eos.setBounds(450, 490, 60, 30);
        eos.setBackground(Color.WHITE);
        add(eos);

        ButtonGroup existinggrp = new ButtonGroup();
        existinggrp.add(ees);
        existinggrp.add(eos);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(580, 540, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 650);
        setVisible(true);
        setLocation(400, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String ssenior = null;
        if (eyes.isSelected()) {
            ssenior = "Yes";
        } else if (enos.isSelected()) {
            ssenior = "No";
        }
        String sexisting = null;
        if (ees.isSelected()) {
            sexisting = "Yes";
        } else if (eos.isSelected()) {
            sexisting = "No";
        }
        String span = pantextField.getText();
        String saadhar = aadhartextField.getText();

        // to hit the database
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + ssenior + "','" + sexisting + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
            setVisible(false);
            // Proceed to the next step (e.g., new SignUpThree(formno).setVisible(true));
            new SignUpThree(formno).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}

