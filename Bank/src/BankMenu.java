//package BankInfo;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class BankMenu extends JFrame implements ActionListener, ItemListener{
	JMenu mnuAc,mnuTrans,mnuHelp;
	JMenuItem createItem,deleteItem,exitItem, depositItem, withdrawItem, transferItem,aboutItem;
	JMenuBar menuBar;
	public BankMenu() {
		//super("Bank Information System");
		setTitle("Bank Information System");
		createItem=new JMenuItem("Create an Account");
		deleteItem=new JMenuItem("Delete an Account");
		exitItem=new JMenuItem("Exit");
		
		mnuAc = new JMenu("Account");
		mnuAc.setMnemonic(KeyEvent.VK_A);
		mnuAc.add(createItem);
		mnuAc.add(deleteItem);
		mnuAc.addSeparator();
		mnuAc.add(exitItem);
			
		createItem.setMnemonic(KeyEvent.VK_C);
		createItem.addActionListener(this);
		deleteItem.setMnemonic(KeyEvent.VK_D);
		deleteItem.addActionListener(this);
		exitItem.setAccelerator(
		KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));	
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(this);
		
		depositItem=new JMenuItem("Deposit");
		withdrawItem=new JMenuItem("Withdraw");
		transferItem=new JMenuItem("Transfer");
		
		mnuTrans = new JMenu("Transaction");
		mnuTrans.setMnemonic(KeyEvent.VK_T);
		mnuTrans.add(depositItem);
		mnuTrans.add(withdrawItem);
		mnuTrans.addSeparator();
		mnuTrans.add(transferItem);	
		
		depositItem.addActionListener(this);
		withdrawItem.addActionListener(this);
		transferItem.addActionListener(this);
		
		aboutItem=new JMenuItem("About the System");
		mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic(KeyEvent.VK_H);
		mnuHelp.add(aboutItem);
		
		// create a menu bar and use it in this JFrame
		menuBar = new JMenuBar();
		menuBar.add(mnuAc);
		menuBar.add(mnuTrans);
		menuBar.add(mnuHelp);
		setJMenuBar(menuBar);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(getMaximumSize());
		setVisible(true);
	}
	public static void main(String[] args) {
		new BankMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitItem)
		    System.exit(0);
		if(e.getSource()==createItem)
			new AccountForm();
		if(e.getSource()==deleteItem)
			new DeleteAccount();
		if(e.getSource()==depositItem)
			new DepositForm();
		if(e.getSource()==withdrawItem)
			new WithdrawForm();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

}
