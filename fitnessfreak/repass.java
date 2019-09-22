//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;

public class repass extends JFrame implements ActionListener{
    JLabel user;
    JLabel pass;
    JTextField chuname1;
    JPasswordField chpass1;
    static JButton login;
    JLabel user2;
    JTextField chuname2;
    JLabel pass2;
    JPasswordField chpass2;
    JButton clear;
	Connection conn;
	//String u_name=null;
	//String p_name=null;
	
    public repass() {
        loginLayout11 customLayout = new loginLayout11();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        user = new JLabel("User Name");
        getContentPane().add(user);

        pass = new JLabel("Password");
        getContentPane().add(pass);

        chuname1 = new JTextField("");
        getContentPane().add(chuname1);

        chpass1 = new JPasswordField("");
        getContentPane().add(chpass1);

        login = new JButton("Change");
        getContentPane().add(login);
		login.addActionListener(this);

		

        user2 = new JLabel("New User Name");
        getContentPane().add(user2);

        chuname2 = new JTextField("");
        getContentPane().add(chuname2);

        pass2 = new JLabel("New Password");
        getContentPane().add(pass2);

        chpass2 = new JPasswordField("");
        getContentPane().add(chpass2);
		chpass2.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyCode())==KeyEvent.VK_ENTER)
				{
			boolean flag=false;
			String s="";
			s=chuname1.getText();
			char a[]=chpass1.getPassword();
			String u_name=null;
			String p_name=null;
			try
			{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 conn=DriverManager.getConnection("jdbc:odbc:emp2");
				Statement stat=conn.createStatement();
				ResultSet set=stat.executeQuery("Select * from login_rep");
				set.next();
				 u_name=set.getString(1);
				 p_name=set.getString(2);
			}
			catch(Exception ex)
			{
			}
			if(s.equals(u_name) && a.length==p_name.length())
			{
				for(int i=0;i<p_name.length();i++)
				{
					if(a[i]==p_name.charAt(i))
					flag=true;
					else
					{
						flag=false;
						break;
					}
				}
			}
			if(flag==true)
			{
				if(chuname2.getText().equals("")|| chpass2.getPassword().length==0)
				{
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(repass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
				}
				else
				{

				try
				{

					PreparedStatement ps=conn.prepareStatement("UPDATE login_rep set u_name=?,pass=? where u_name=?");
					ps.setString(1,chuname2.getText());
					ps.setString(2,String.copyValueOf(chpass2.getPassword()));
					ps.setString(3,chuname1.getText());
					ps.execute();
					Icon info=new ImageIcon("info.png");
					JOptionPane.showMessageDialog(repass.this,"<html><font size=4 color=green>Password Is Changed</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
					dispose();
				}
				catch(Exception e2)
				{
				}
			}
			}
			else
			{
				 Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(repass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
			}
			}
			}
		});



        clear = new JButton("Clear");
        getContentPane().add(clear);
		clear.addActionListener(this);

        setSize(getPreferredSize());
		  setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	   

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        repass window = new repass();
		try {
           
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);
           
        }
        catch (Exception ex) {
            //ex.printStackTrace();
        }
        window.setTitle("Password Change");
        window.pack();
        window.show();
		window.getRootPane().setDefaultButton(login);
    }

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==clear)
		{
			chpass1.setText("");
			chpass2.setText("");
			chuname1.setText("");
			chuname2.setText("");
		}
		if(ae.getSource()==login)
		{System.out.println("here3");
			boolean flag=false;
			String s="";
			s=chuname1.getText();
		//	char a[]=chpass1.getPassword();
	String u_name=null;
	String p_name=null;
			try
			{  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 conn=DriverManager.getConnection("jdbc:odbc:emp2");
				Statement stat=conn.createStatement();
				String kk="Select * from login where u_name='"+s+"'";
								 System.out.println(kk);
				ResultSet set=stat.executeQuery("Select * from login_rep where u_name='"+s+"'");
				set.next();
				 u_name=set.getString(1);
				 p_name=set.getString(2);System.out.println("here2");
			}
			catch(Exception ex)
			{
			}
				if(chuname2.getText().equals("")|| chpass2.getPassword().length==0)
				{
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(repass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
				}
				else
				{

				try
				{
System.out.println("here1");
					PreparedStatement ps=conn.prepareStatement("UPDATE login_rep set u_name=?,pass=? where u_name=?");
					ps.setString(1,chuname2.getText());
					ps.setString(2,String.copyValueOf(chpass2.getPassword()));
					ps.setString(3,chuname1.getText());
					ps.execute();
					Icon info=new ImageIcon("info.png");
					JOptionPane.showMessageDialog(repass.this,"<html><font size=4 color=green>Password Is Changed</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
					dispose();
				}
				catch(Exception e2)
				{
				}
				}
			}
			else
			{
				 Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(repass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
			}


			
			
}//login over
	//}//action performed over

}

class loginLayout11 implements LayoutManager {

    public loginLayout11() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 408 + insets.left + insets.right;
        dim.height = 336 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+72,96,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+112,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+72,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+112,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+248,88,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+152,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+152,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+192,96,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+192,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+248,80,24);}
    }
}
