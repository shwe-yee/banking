package Coffee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public  class Menu extends JFrame implements ActionListener {
	
	JLabel lb1;
	JLabel lb2=new JLabel();
	JLabel lb3=new JLabel();
	
	JLabel lb4=new JLabel();
	JLabel lb5=new JLabel();
	JLabel lb6=new JLabel();
	JLabel lb7=new JLabel();
	JLabel lb8=new JLabel();
	JLabel lb9=new JLabel();
	JLabel lb10=new JLabel();
	JLabel lb11=new JLabel();
	JLabel lb12=new JLabel();
	JLabel lb13=new JLabel();
	JLabel lb14=new JLabel();
	JLabel lb15=new JLabel();
	JLabel lb16=new JLabel();
	JLabel lb17=new JLabel();
	JLabel lb18=new JLabel();
	JLabel lb19=new JLabel();
	JLabel lb20=new JLabel();
	JLabel lb21=new JLabel();
	JLabel lb22=new JLabel();
	JLabel lb23=new JLabel();
	JLabel lb24=new JLabel();
	JLabel lb25=new JLabel();

	JLabel lb26;
	
	JLabel lb27=new JLabel();
	JLabel lb28=new JLabel();
	JLabel lb29=new JLabel();
	
	JCheckBox choice=new JCheckBox("Buy");
	JButton btn1;
	JButton btn2=new JButton();
	JButton btn3=new JButton();
	JButton btn4=new JButton();
	JButton btn5=new JButton();
	JButton btn6=new JButton();
	JButton btn7=new JButton();
	JButton btn8=new JButton();
	JButton btn9=new JButton();
	JPanel p1,p2,picon,picon1,picon2,picon3;
	ImageIcon icon=new ImageIcon("D:\\Photo\\22.jpg");
	ImageIcon icon1=new ImageIcon("D:\\Photo\\33.jpg");
	ImageIcon icon2=new ImageIcon("D:\\Photo\\44.jpg");
	ImageIcon icon3=new ImageIcon("D:\\Photo\\55.jpg");
	ImageIcon icon4=new ImageIcon("D:\\Photo\\999.jpg");
	ImageIcon icon5=new ImageIcon("D:\\Photo\\66.jpg");
	ImageIcon icon6=new ImageIcon("D:\\Photo\\77.jpg");
	ImageIcon icon7=new ImageIcon("D:\\Photo\\777.jpg");

	
	
	Menu()
	{
		
	
	
		lb1=new JLabel(new ImageIcon("D:\\Photo\\pic.png"));
		
					
		btn1=new JButton("Coffee");
		btn1.addActionListener(this);
				
		 p1=new  JPanel();
		 p1.add(lb1);
		 p1.add(btn1);
		 p1.setBackground(Color.lightGray);

		 picon=new JPanel();
		 picon.add(lb2);
		 picon.add(lb6);
		 picon.add(lb7);
		 picon.add(btn2);
		 btn2.addActionListener(this);
		 picon.add(lb20);		
		 picon.add(lb22);
		 picon.add(lb23);
		 picon.add(btn3);
		 btn3.addActionListener(this);
		 picon.add(lb21);
		 picon.add(lb24);
		 picon.add(lb25);
		 picon.add(btn4);
		 btn4.addActionListener(this);
		 picon.setBackground(Color.gray);
		 		 
		 picon1=new JPanel();
		 picon1.add(lb3);  
		 picon1.add(lb8);
		 picon1.add(lb9);
		 picon1.add(btn5);
		 btn5.addActionListener(this);
		 picon1.add(lb14);		
		 picon1.add(lb16);
		 picon1.add(lb17);
		 picon1.add(btn6);
		 btn6.addActionListener(this);
		 picon1.add(lb15);
		 picon1.add(lb18);
		 picon1.add(lb19);
		 picon1.add(btn7);
		 btn7.addActionListener(this);
		 picon1.setBackground(Color.gray);

		 picon2=new JPanel();
		 picon2.add(lb4);
		 picon2.add(lb10);
		 picon2.add(lb11);
		 picon2.add(btn8);
		 btn8.addActionListener(this);
		 picon2.setBackground(Color.gray);
		 
		 picon3=new JPanel();
		 picon3.add(lb5);
		 picon3.add(lb12);
		 picon3.add(lb13);
		 picon3.add(btn9);
		 btn9.addActionListener(this);
		 picon3.setBackground(Color.gray);
		 		 
		 p2=new JPanel();
		 
		 p2.setLayout(new BorderLayout());
		
		 p2.add(p1,BorderLayout.CENTER);
		 p2.add(picon,BorderLayout.SOUTH);		
		 p2.add(picon1,BorderLayout.NORTH);
		 p2.add(picon2,BorderLayout.WEST);
		 p2.add(picon3,BorderLayout.EAST);
	
		 
		 
		 //Register Box
		 
		 
		 setContentPane(p2);
		 setTitle("Coffee Shop Menu");
		
		 setSize(1500,700);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
		{
			lb2.setIcon(icon);
			lb6.setText("Macchiato");		
			btn2.setText("Buy");
			
			lb3.setIcon(icon1);
			lb8.setText("Ristretto");			
			btn3.setText("Buy");
			lb14.setIcon(icon2);
			lb16.setText("Lacuity");			
			btn4.setText("Buy");
			lb15.setIcon(icon3);
			lb18.setText("Garfty");
			
			btn5.setText("Buy");
			
			lb4.setIcon(icon4);
			lb10.setText("Nassau");
	
			btn6.setText("Buy");
			lb20.setIcon(icon5);
			lb22.setText("Hawaiian");
	
			btn7.setText("Buy");
			lb21.setIcon(icon6);
			lb24.setText("Altercatte");
		
			btn8.setText("Buy");
			
			lb5.setIcon(icon7);
			lb12.setText("Caisson");
		
			btn9.setText("Buy");
		}
		if(e.getSource()==btn2)//1
		{
			
			 new RegisterFrame();
				}
		if(e.getSource()==btn3)
		{
			 new HawaiianRegister();
		}
		if(e.getSource()==btn4)
		{
			 new AltercatteRegister();
		}
		if(e.getSource()==btn5)
		{
			 new RistrettoRegister();
		}
		if(e.getSource()==btn6)
		{
			 new LacuityRegister();
		}
		if(e.getSource()==btn7)
		{
			new GarftyRegister();
		}
		if(e.getSource()==btn8)
		{
			new NassauRegister();
		}
		if(e.getSource()==btn9)
		{
			new CaissonRegister();
		}
		
	}

	
	public static void main(String[] args)
	{
		new Menu();
	}
	
	

}
