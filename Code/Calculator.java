//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame 
{
	int width;
	int height;
	Dimension screenSize;
	public void Calculator()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/3;
		height=screenSize.height/3;
		setLocation(screenSize.width/3+30,screenSize.height/5);
		
		setTitle("Calculator");
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		setResizable(false);
		//getContentPane().add(new CalculatorPanelA());

	}
	public static void main(String args[])
	{
		Calculator cl=new Calculator();
		cl.setVisible(true);
		cl.setSize(250,270);
		
	}
}

class CalculatorPanelA extends JPanel implements ActionListener
{
	JTextField display;
	JButton clear;
	double args = 0.0;
	String op = "=";
	boolean start = true;
	JPanel p,panel;
	public CalculatorPanelA()
	{
		setLayout(new BorderLayout());

		display = new JTextField(16);
		display.setEditable(false);
		display.setBackground(Color.white);

		clear = new JButton("C");

		panel = new JPanel();
		panel.add(display);
		panel.add(clear);

		add(panel,"North");

		p = new JPanel();
		p.setLayout(new GridLayout(4,4,5,5));

		String buttons = "789/456*123-0.=+";
		for(int i=0;i<buttons.length();i++)
			addButtons(buttons.substring(i,i+1));
		add(p,"Center");

		clear.addActionListener(this);
	}

	void addButtons(String s)
	{
		JButton b = new JButton(s);
		p.add(b);
		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if(s.equals("C"))
			display.setText("");
		else
		{
			if(s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.equals("."))
			{
				if(start)
					display.setText(s);
				else
					display.setText(display.getText()+s);
				start = false;
			}
			else
			{
				if(start)
				{
					if(s.equals("-"))
					{
						display.setText(s);
						start = false;
					}
					else
						op = s;
				}
				else
				{
					calculate(Double.parseDouble(display.getText()));
					op = s;
					start = true;
				}
			}
		}
	}
	void calculate(double x)
	{
		if(op.equals("+"))
			args += x;
		if(op.equals("-"))
			args -= x;
		if(op.equals("*"))
			args *= x;
		if(op.equals("/"))
			args /= x;
		if(op.equals("="))
			args = x;
		display.setText(""+args);
	}
}

