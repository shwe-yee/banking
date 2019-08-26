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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepositForm extends JFrame implements ActionListener,FocusListener {
	JPanel jrbPanel,p,btnPanel,core;
	JLabel lblAccno,lblAccName,lblNRC,lblAddress,lblAccType, lblSavingType, lblInitialAmount;
	JTextField tfAccno, tfAccName,tfNRC, tfInitialAmount;
	JTextArea taAddress;
	JComboBox jcbSavingType;
	JRadioButton jrbT1,jrbT2;
	JButton btnDeposit, btnClear,btnCancel;
	ButtonGroup bgType;
	String[] sList = { "Current", "Fixed"};
    String st,s;
	public DepositForm(){
		this.setTitle("Deposit Form");
		this.setSize(500, 400);
		this.setLocation(450, 150);
		//this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		this.setVisible(true);
		
		lblAccno=new JLabel("Account No.");
		lblAccName=new JLabel("Account Name");
		lblNRC=new JLabel("NRC No.");
		lblAddress=new JLabel("Address");
		lblAccType=new JLabel("Account Type");
		lblSavingType=new JLabel("Saving Type");
		lblInitialAmount=new JLabel("Initial Amount");
		
		tfAccno = new JTextField(15);
		tfAccno.addFocusListener(this);
		tfAccName= new JTextField(15);
		
		tfNRC= new JTextField(15);
		taAddress=new JTextArea(2, 15);
		tfInitialAmount= new JTextField(15);
		tfInitialAmount.addFocusListener(this);
		
		bgType = new ButtonGroup();
		jrbT1 = new JRadioButton("Individual");
		jrbT2 = new JRadioButton("Joint");
		
		jrbT1.setSelected(true);
		//st=jrbT1.getLabel();
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
        
	    btnDeposit = new JButton("Deposit");	
	    btnClear = new JButton("Clear");
		btnCancel= new JButton("Cancel");
		btnDeposit.addActionListener(this);
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
		btnPanel.add(btnDeposit); btnPanel.add(btnClear);btnPanel.add(btnCancel);
		
		core=new JPanel();
		core.add(p);
		core.add(btnPanel);
		
		this.add(core);		
		this.setVisible(true);
		tfAccName.setEnabled(false); tfNRC.setEnabled(false);taAddress.setEnabled(false);
		jrbPanel.setEnabled(false);jrbT1.setEnabled(false);jrbT2.setEnabled(false);
		jcbSavingType.setEnabled(false);
		tfInitialAmount.setEnabled(false);
	}
	public static void main(String[] args) {
		new DepositForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDeposit) {
			
		if(!(tfAccno.getText().isEmpty())){
				
			/*String amt=JOptionPane.showInputDialog(this, "Please enter your deposit amount");
			int amount=Integer.parseInt(amt);*/
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getDBConnection("BankInfo");
			try {
				Statement stmt = con.createStatement();
				String query = "Select * from CustomerAccount where AccNo="+tfAccno.getText();
				String s = null;
				// SELECT Query
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next()){
					
					String amt=JOptionPane.showInputDialog(this, "Please enter your deposit amount");
					int amount=Integer.parseInt(amt);
					
					String query1 = "Update CustomerAccount Set InitialAmount=InitialAmount+"
							+ amount+" where Accno="+tfAccno.getText();

					// INSERT A RECORD
					stmt.executeUpdate(query1);
					
					queryAccountInformation();	
					
					JOptionPane.showMessageDialog(this,
							"Deposit is Successful!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(this,"Account was not found!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
						clearForm();
				}
				
				con.close();
			} catch (SQLException sqle) {
				System.out.println("SQL Exception thrown: " + sqle);
			}	
			
		}
		else{
			JOptionPane.showMessageDialog(this,"Account number must be fill.!", this.getTitle(),
					JOptionPane.INFORMATION_MESSAGE);
		}
		}
		if(e.getSource()==btnClear){
			clearForm();
		}
		if (e.getSource() == btnCancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
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
		if(arg0.getSource()==tfAccno){
			if(!(tfAccno.getText().isEmpty()))
				queryAccountInformation();
			}	
	}
	void queryAccountInformation(){
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection("BankInfo");
		//int flag=0;
		try {
			Statement stmt = con.createStatement();
			String query = "Select * from CustomerAccount where AccNo="+tfAccno.getText();
			String s = null;
			// SELECT Query
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				//flag=1;
				tfAccName.setText(rs.getString("AccName"));
				tfNRC.setText(rs.getString("NRC"));
				taAddress.setText(rs.getString("Address"));
				if(jrbT1.getLabel().equals(rs.getString("AccType")))//if(jrbT1.getText().equals(rs.getString("AccType")))
					jrbT1.setSelected(true);
				else jrbT2.setSelected(true);
				jcbSavingType.setSelectedItem(rs.getString("SavingType"));
				tfInitialAmount.setText(""+rs.getInt("InitialAmount"));
			}
		/*	if(flag==0) {
				JOptionPane.showMessageDialog(this,"Account was not found!", this.getTitle(),
					JOptionPane.INFORMATION_MESSAGE);
				clearForm();
			}*/
			con.close();
		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}
	void clearForm(){
		tfAccno.setText("");
		tfAccName.setText("");
		jrbT1.setSelected(true);
		tfNRC.setText("");
		taAddress.setText(null);
		tfInitialAmount.setText("");
		jcbSavingType.setSelectedIndex(0);	
	}
}
