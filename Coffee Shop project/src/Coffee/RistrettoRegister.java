package Coffee;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RistrettoRegister extends JFrame implements ActionListener {
	/**
 * 
 */
private static final long serialVersionUID = 11;
	JPanel p,btnPanel,core;
	JLabel lbName,lbPrice,lbName1,lbPrice1,lbCount;
	JTextField tfName,tfPrice,tfCount,tfTotal;
	
	JButton btnTotal,btnRegister, btnClear,btnCancel;
   					public RistrettoRegister(){
	
		
		lbName=new JLabel("Coffee Type : ");
		
		lbPrice=new JLabel("Price : ");
			lbCount=new JLabel("Count : ");
	 btnTotal=new JButton("Total Price : ");
	 btnTotal.addActionListener(this);
		
	 tfName =new JTextField(10);
		tfPrice= new JTextField(10);
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
		p.add(lbName); p.add(tfName);
		p.add(lbPrice); p.add(tfPrice);
		p.add(lbCount);p.add(tfCount);
		p.add(btnTotal); p.add(tfTotal);
		
		btnPanel=new JPanel();
		btnPanel.add(btnRegister); btnPanel.add(btnClear);btnPanel.add(btnCancel);
		
		core=new JPanel();
		core.add(p);
		core.add(btnPanel);
		core.setBackground(Color.pink);
		setContentPane(core);
		
		setTitle("Register Form ");
		setSize(500, 250);
		setLocation(450, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new RistrettoRegister();
	}

	
	public void actionPerformed(ActionEvent e) {
		
		String s1=tfPrice.getText();
		String s2=tfCount.getText();
		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		int c=1;
		if(e.getSource()==btnTotal)
		{
			c=a*b;
			String re=String.valueOf(c);
			tfTotal.setText(re);
		}
		

		
		else if (e.getSource() == btnRegister) {
			if((  (tfName.getText().isEmpty())||( tfPrice.getText().isEmpty())||(tfCount.getText().isEmpty()) || (tfTotal.getText().isEmpty())))
					{
				JOptionPane.showMessageDialog(null,"Please fill all account information",this.getTitle(),JOptionPane.WARNING_MESSAGE);
			}
			else{
				DataBase dbcon = new DataBase();
				//DBConnection dbcon = new DBConnection();
				Connection con = dbcon.getDBConnection("coffeemenu");
				try {
					Statement stmt = (Statement) con.createStatement();
					String query = "INSERT INTO total VALUES('"+ tfName.getText()+",'"+tfPrice.getText()+"','"+tfCount.getText()+"','"+tfTotal.getText()+"')";
					// INSERT A RECORD
					((java.sql.Statement) stmt).executeUpdate(query);
					
					JOptionPane.showMessageDialog(this,"Account Registration is Successful!", this.getTitle(),
							JOptionPane.INFORMATION_MESSAGE);
					con.close();
				} 
				catch (SQLException sqle) {
					System.out.println("SQL Exception thrown: " + sqle);
				}
			
		/*else if ( e.getSource()==btnRegister )
		{
			String url="jdbc:mysql://localhost:3306/coffeemenu";
			String username="root";
			String password="";
			 Connection con;
			 Statement stmt;
			 
			 String query="INSERT INTO total VALUES ("+ tfName.getText()+",'"+tfPrice.getText()+"','"+tfCount.getText()+"','"+tfTotal.getText()+"')";
			 
			 try {
				 con=DriverManager.getConnection(url,username,password);
				 stmt=(Statement) con.createStatement();
				 int res=((java.sql.Statement) stmt).executeUpdate(query);
				 con.close();
			 }
			 catch(SQLException sqle)
			 {
				 System.out.print("SQL exception thrown" + sqle );
			 }
			 finally
			 {
				 this.dispose();
			 }
		}
*/				
				
				
				
				
				
				tfName.setText("");
				tfPrice.setText("");
				tfCount.setText("");
				tfTotal.setText("");
				
			}
			
		}
		if(e.getSource()==btnClear){			
			
			tfName.setText("");
			tfPrice.setText("");
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
