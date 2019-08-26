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

public class DeleteAccount extends JFrame implements ActionListener {
	JPanel p1,btnPanel;
	JLabel lblAccno;
	JTextField tfAccno;
	JButton btnSearch,btnDelete,btnCancel;
	
    String st,s;
    
	public DeleteAccount(){
		this.setTitle("Delete Account Form");
		setLayout(new FlowLayout());
		this.setSize(500, 150);
		this.setLocation(450, 200);
		this.setVisible(true);
		
		lblAccno=new JLabel("Account No.");		
		tfAccno = new JTextField(15);
		btnSearch = new JButton("Search");
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnCancel= new JButton("Cancel");
		btnSearch.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		p1=new JPanel();
		p1.setLayout(new GridLayout(1, 2));
		p1.add(lblAccno);p1.add(tfAccno);
		btnPanel=new JPanel();
		btnPanel.setLayout(new GridLayout(1, 3));
		btnPanel.add(btnSearch);btnPanel.add(btnDelete);btnPanel.add(btnCancel);
		add(p1);add(btnPanel);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DeleteAccount();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getDBConnection("BankInfo");
			try {
				Statement stmt = con.createStatement();
				String query = "Select * from CustomerAccount where AccNo="+tfAccno.getText();
				String s = null;
				// SELECT Query
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()){
					s=rs.getInt("AccNo")+","+rs.getString("AccName")+","+rs.getString("NRC")
							+","+rs.getString("Address")+","+rs.getString("AccType")+","+rs.getString("SavingType")+","+rs.getInt("InitialAmount");
				}
				if(s==null){
					JOptionPane.showMessageDialog(this,
							"Account was not found!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
					btnDelete.setEnabled(false);
				}
				else{
					JOptionPane.showMessageDialog(this, "Account Information is\n"+s, this.getTitle(),
						JOptionPane.INFORMATION_MESSAGE);
					btnDelete.setEnabled(true);
				}
				/*int yn=JOptionPane.showConfirmDialog(this,
						"Account Information is\n"+s, this.getTitle(),
						JOptionPane.YES_NO_OPTION);
				if(yn==0){
					query = "Delete from CustomerAccount where AccNo="+tfAccno.getText();
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(this,
							"Account Deletion is Successful!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
				}				*/
				con.close();
			} catch (SQLException sqle) {
				System.out.println("SQL Exception thrown: " + sqle);
			}			
		}					
		if(e.getSource()==btnDelete){
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.getDBConnection("BankInfo");
			try {
				Statement stmt = con.createStatement();
			int yn=JOptionPane.showConfirmDialog(this,
					"Are you sure to delete it?", this.getTitle(),
					JOptionPane.YES_NO_OPTION);
			if(yn==0){
				String query = "Delete from CustomerAccount where AccNo="+tfAccno.getText();
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(this,
						"Account Deletion is Successful!", this.getTitle(),
						JOptionPane.INFORMATION_MESSAGE);
			}
			con.close();
			}catch (SQLException sqle) {
				System.out.println("SQL Exception thrown: " + sqle);
			}	
		}
		if (e.getSource() == btnCancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			if (yn==0) 
				setVisible(false);
				//System.exit(0);
			}
		
	}
}
