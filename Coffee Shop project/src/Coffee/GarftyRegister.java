package Coffee;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GarftyRegister extends JFrame implements ActionListener {
	/**
 * 
 */
private static final long serialVersionUID = 11;
	JPanel p,btnPanel,core;
	JLabel lbName,lbPrice,lbName1,lbPrice1,lbCount;
	JTextField tfCount,tfTotal;
	
	JButton btnTotal,btnRegister, btnClear,btnCancel;

	String[] sList = { "Current", "Fixed"};
  String st,s;
   					public GarftyRegister(){
	
		
		lbName=new JLabel("Coffee Type : ");
		
		lbPrice=new JLabel("Price : ");
		lbName1=new JLabel("Garfty");
		lbPrice1=new JLabel("2000.00 $");
		lbCount=new JLabel("Count : ");
	 btnTotal=new JButton("Total Price : ");
	 btnTotal.addActionListener(this);
		
	 
	
		tfCount =new JTextField(10);
		tfTotal= new JTextField(10);
	
        btnRegister = new JButton("Register");
		btnClear= new JButton("Clear");
		btnCancel= new JButton("Cancel");
		btnRegister.addActionListener(this);
	btnClear.addActionListener(this);
		btnCancel.addActionListener(this);
		
		p=new JPanel();
		p.setLayout(new GridLayout(7,2));
		p.add(lbName); p.add(lbName1);
		p.add(lbPrice); p.add(lbPrice1);
		p.add(lbCount);p.add(tfCount);
		p.add(btnTotal); p.add(tfTotal);
		
		btnPanel=new JPanel();
		btnPanel.add(btnRegister); btnPanel.add(btnClear);btnPanel.add(btnCancel);
		
		core=new JPanel();
		core.add(p);
		core.add(btnPanel);
		core.setBackground(Color.pink);
		setContentPane(core);
		//this.add(core);		
	//this.setVisible(true);
		setTitle("Register Form ");
		setSize(500, 250);
		setLocation(450, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new RegisterFrame();
	}


	
	public void actionPerformed(ActionEvent e) {
		
		String s2=tfCount.getText();
	//	int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		double c=1.00;
		if(e.getSource()==btnTotal)
		{
			
			c=2000.00*b;
		}
		String re=String.valueOf(c);
		tfTotal.setText(re);

		
		if (e.getSource() == btnRegister) {
			if((  (tfCount.getText().isEmpty()) || (tfTotal.getText().isEmpty())))
					{
				JOptionPane.showMessageDialog(null,"Please fill all account information",this.getTitle(),JOptionPane.WARNING_MESSAGE);
			}
			else{
				DataBase dbcon = new DataBase();
				Connection con = dbcon.getDBConnection("CoffeeMenu");
				try {
					Statement stmt = (Statement) con.createStatement();
					String query = "INSERT INTO CustomerAccount VALUES("+ tfCount.getText()+",'"+tfTotal.getText()+"')";

					// INSERT A RECORD
					((java.sql.Statement) stmt).executeUpdate(query);
					
					JOptionPane.showMessageDialog(this,"Account Registration is Successful!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
					con.close();
				} catch (SQLException sqle) {
					System.out.println("SQL Exception thrown: " + sqle);
				}
				
				tfCount.setText("");
				tfTotal.setText("");
				
			}
			
		}
		if(e.getSource()==btnClear){			
			
			tfCount.setText("");
			tfTotal.setText("");
								
		}
		if (e.getSource() == btnCancel) {
			int yn=JOptionPane.showConfirmDialog(this, "Are you sure to exit?","Confimation",JOptionPane.YES_NO_OPTION);
			//System.out.println(JOptionPane.YES_OPTION);
			if (yn==0) 
				setVisible(false);
		}
	}
}
