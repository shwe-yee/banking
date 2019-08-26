//package BankInfo;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountForm extends JFrame implements ActionListener,FocusListener {
	JPanel jrbPanel,p,btnPanel,core;
	JLabel lblAccno,lblAccName,lblNRC,lblAddress,lblAccType, lblSavingType, lblInitialAmount;
	JTextField tfAccno, tfAccName,tfNRC, tfInitialAmount;
	JTextArea taAddress;
	JComboBox jcbSavingType;
	JRadioButton jrbT1,jrbT2;
	JButton btnRegister, btnClear,btnCancel;
	ButtonGroup bgType;
	String[] sList = { "Current", "Fixed"};
    String st,s;
    //static String st1="";
  static int num=50;
   // static int num=Integer.parseInt(st1);
	public AccountForm(){
		this.setTitle("Account Information");
		this.setSize(500, 500);
		this.setLocation(450, 100);
		//this.setDefaultCloseOperation(HIDE_ON_CLOSE);				
		this.setVisible(true);
		
		lblAccno=new JLabel("Account No.");
		lblAccName=new JLabel("Customer Name");
		lblNRC=new JLabel("NRC No.");
		lblAddress=new JLabel("Address");
		lblAccType=new JLabel("Account Type");
		lblSavingType=new JLabel("Saving Type");
		lblInitialAmount=new JLabel("Initial Amount");
		
		tfAccno = new JTextField(15);
		tfAccno.setText(""+num);
		tfAccName= new JTextField(15);
		tfAccName.addFocusListener(this);
		tfNRC= new JTextField(15);
		taAddress=new JTextArea(2, 15);
		tfInitialAmount= new JTextField(15);
		tfInitialAmount.addFocusListener(this);
		
		bgType = new ButtonGroup();
		jrbT1 = new JRadioButton("Individual");
		jrbT2 = new JRadioButton("Joint");
		
		jrbT1.setSelected(true);
		s=jrbT1.getText();//If you don't select in any radio button, this 's' that original selected is used in actionPerformed()
	  // System.out.println(s);
		bgType.add(jrbT1);
		bgType.add(jrbT2);
		jrbPanel = new JPanel();
		jrbPanel.add(jrbT1);
		jrbPanel.add(jrbT2);
		jrbT1.addActionListener(this);
		jrbT2.addActionListener(this);
		
		jcbSavingType = new JComboBox();
		jcbSavingType.addItem("Current");
		jcbSavingType.addItem("Fixed");
		jcbSavingType.addItem("Other");		
		jcbSavingType.setSelectedIndex(0);
		
	    JScrollPane addressScrollPane = new JScrollPane(taAddress);
        
        btnRegister = new JButton("Register");
		btnClear= new JButton("Clear");
		btnCancel= new JButton("Cancel");
		btnRegister.addActionListener(this);
		btnClear.addActionListener(this);
		btnCancel.addActionListener(this);
		
		p=new JPanel();
		p.setLayout(new GridLayout(7,2));
		p.add(lblAccno);p.add(tfAccno);
		p.add(lblAccName); p.add(tfAccName);
		p.add(lblNRC);p.add(tfNRC);
		p.add(lblAddress); p.add(addressScrollPane);
		p.add(lblAccType);p.add(jrbPanel);
		p.add(lblSavingType);p.add(jcbSavingType);
		p.add(lblInitialAmount);p.add(tfInitialAmount);
		
		btnPanel=new JPanel();
		btnPanel.add(btnRegister); btnPanel.add(btnClear);btnPanel.add(btnCancel);
		
		core=new JPanel();
		core.add(p);
		core.add(btnPanel);
		
		this.add(core);		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new AccountForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jrbT1) {
			//s = jrbT1.getLabel();
			jrbT1.getText();
		}
		if (e.getSource() == jrbT2) {
			s = jrbT2.getLabel();
		}
		if (e.getSource() == btnRegister) {
			if(( tfAccno.getText().isEmpty()) || (tfAccName.getText().isEmpty()) || (tfNRC.getText().isEmpty())|| ( taAddress.getText().isEmpty()) || (tfInitialAmount.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null,"Please fill all account information",this.getTitle(),JOptionPane.WARNING_MESSAGE);
			}
			else{
				DBConnection dbcon = new DBConnection();
				Connection con = dbcon.getDBConnection("BankInfo");
				try {
					Statement stmt = con.createStatement();
					String query = "INSERT INTO CustomerAccount VALUES ("
							+ tfAccno.getText() + ",'" + tfAccName.getText()
							+ "','" + tfNRC.getText() + "','" + taAddress.getText()
							+ "','" + s + "','" + jcbSavingType.getSelectedItem()
							+ "'," + tfInitialAmount.getText() + ")";

					// INSERT A RECORD
					stmt.executeUpdate(query);
					
					JOptionPane.showMessageDialog(this,
							"Account Registration is Successful!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
					con.close();
				} catch (SQLException sqle) {
					System.out.println("SQL Exception thrown: " + sqle);
				}
				num++;tfAccno.setText(""+num);
				tfAccName.setText("");
				jrbT1.setSelected(true);
				tfNRC.setText("");
				taAddress.setText(null);
				tfInitialAmount.setText("");
				jcbSavingType.setSelectedIndex(0);
			}
			
		}
		if(e.getSource()==btnClear){			
			tfAccno.setText("");
			tfAccName.setText("");
			jrbT1.setSelected(true);
			tfNRC.setText("");
			taAddress.setText(null);
			tfInitialAmount.setText("");
			jcbSavingType.setSelectedIndex(0);						
		}
		if (e.getSource() == btnCancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			//System.out.println(JOptionPane.YES_OPTION);
			if (yn==0) 
				setVisible(false);
		}
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		if(arg0.getSource()==tfAccName){
			if(tfAccName.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please fill account name",this.getTitle(),JOptionPane.WARNING_MESSAGE);
				tfAccName.grabFocus();
			}
		}	
			if(arg0.getSource()==tfInitialAmount){
				if(tfInitialAmount.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please fill initial amount",this.getTitle(),JOptionPane.WARNING_MESSAGE);
				tfInitialAmount.grabFocus();
				}
			}
		
	}

}
