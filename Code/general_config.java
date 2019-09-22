//package gym.com.freak;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
//import gym.com.valid.*;

public class general_config
		extends JFrame implements ActionListener
{
	private		JTabbedPane tabbedPane;
	private		JPanel		panel1;
	private		JPanel		panel2;
	//private		JPanel		panel3;
	private		JPanel		panel4;
	//JButton ok;
	//JButton can;
	   	 JTextField name;
   		 JTextField add;
    		JTextField state;
    		JTextField tax;
    		NumericTextField1 phone;
    		NumericTextField1 fax;
    		JTextField email;

   	 JTextField cuname;
   	 JTextField newuname;
   	 JPasswordField cpass;
   	 JPasswordField newpass;
   	 JPasswordField confirm;
   	 JButton chang;
   	 JButton can;
	JButton ok;
   	 ResultSet rs;
	ResultSet rs1;
	Connection connection;
	Connection con;
	Statement stmt;
	Statement stmt1;
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
 
		String cont;
            String url = "jdbc:odbc:emp2";
			String nam,ph,ad,stat,fa,em,ta;
   		 JButton ok1;
		     JButton can1;
		  JTextArea textarea_1;

	public general_config()
	{
		
		
		setTitle( "General Configuration" );
		setSize( 550, 600 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
	//	createPage3();
		

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Gym", panel1 );
		tabbedPane.addTab( "Contract", panel2 );
		//tabbedPane.addTab( "Login", panel3 );
		
		topPanel.add( tabbedPane, BorderLayout.NORTH );

	setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.FRAME);


	}

	public void createPage1()
	{
		panel1 = new JPanel();
		Border blackline1;
	blackline1 = BorderFactory.createTitledBorder("Gym Configuration");
	panel1.setBorder(blackline1);
		JLabel label_1;
    		JLabel label_2;
    		JLabel label_3;
   		 JLabel label_4;
    		JLabel label_5;
    		JLabel label_6;
    		JLabel label_7;

    		
				
		gymconfigLayout customLayout1 = new gymconfigLayout();
		panel1.setFont(new Font("Helvetica", Font.PLAIN, 12));
                panel1.setLayout(customLayout1);

        label_1 = new JLabel("Gym Name");
        panel1.add(label_1);

        label_2 = new JLabel("Address");
        panel1.add(label_2);

        label_3 = new JLabel("State");
        panel1.add(label_3);

        label_4 = new JLabel("Tax Number");
        panel1.add(label_4);

        label_5 = new JLabel("Phone Number");
        panel1.add(label_5);

        label_6 = new JLabel("Fax Number");
        panel1.add(label_6);

        label_7 = new JLabel("Email");
        panel1.add(label_7);

        name = new JTextField();
        panel1.add(name);

        add = new JTextField();
        panel1.add(add);

        state = new JTextField();
        panel1.add(state);

        tax = new JTextField();
        panel1.add(tax);

        phone = new NumericTextField1();
        panel1.add(phone);

        fax = new NumericTextField1();
        panel1.add(fax);

        email = new JTextField();
        panel1.add(email);

        ok = new JButton("OK");
	ok.addActionListener(this);
        panel1.add(ok);

        can = new JButton("Cancel");
        panel1.add(can);
	can.addActionListener(this);


        try
        {

 	     Class.forName( driver );
            connection = DriverManager.getConnection(url);
           //  Read data from a table
 
            String sql ="Select name,address,state,tax_no,phone_no,fax_no,email from general_config";
            stmt = connection.createStatement();
            rs = stmt.executeQuery( sql );

	}
	catch(Exception ex)
        {
            System.out.println( ex );
        }

        panel1.setSize(getPreferredSize());
	showRecord(rs);

	}
	public void showRecord(ResultSet rs)
	{
	try
	{
                while(rs.next())
		{
		name.setText(rs.getString(1));
		add.setText(rs.getString(2));
		state.setText(rs.getString(3));	
		tax.setText(rs.getString(4));	
		phone.setText(rs.getString(5));
		fax.setText(rs.getString(6));     
		email.setText(rs.getString(7));
		
		//connection.close();
		}
		nam=name.getText();
		ad=add.getText();
		stat=state.getText();
		ta=tax.getText();
		ph=phone.getText();
		fa=fax.getText();
		em=email.getText();

	}
	catch(Exception e)
	{
	  System.out.println( e );
	}
	}
	public void createPage2()
	{

		panel2 = new JPanel();
    		JLabel label_1;
   		
   		 JScrollPane sp_textarea_1;

		Border blackline2;
	blackline2 = BorderFactory.createTitledBorder("Membership Contract Terms");
	panel2.setBorder(blackline2);
        contractLayout customLayout2 = new contractLayout();

        panel2.setFont(new Font("Helvetica", Font.PLAIN, 12));
        panel2.setLayout(customLayout2);

        label_1 = new JLabel("This is the terms and conditions displayed on the members contract.");
        panel2.add(label_1);

     //   textarea_1 = new JTextArea("The information contained in this membership agreement is\n correct. And I agree to be bound by the terms and conditions\n outlined above and on the reverse of this form.\n I agree that in the event of any conflict between the\n original copy of this agreement and any carbon copy of,\n the orginal shall govern.");
        textarea_1 = new JTextArea();
		sp_textarea_1 = new JScrollPane(textarea_1);
        panel2.add(sp_textarea_1);

        ok1 = new JButton("OK");
        panel2.add(ok1);
		ok1.addActionListener(this);

        can1 = new JButton("Cancel");
        panel2.add(can1);
		can1.addActionListener(this);

		try{
		String sql1 ="select contract from general_config where name=?";
         PreparedStatement pstmt = connection.prepareStatement(sql1);
			pstmt.setString(1,nam);
           ResultSet rstt = pstmt.executeQuery();
         while(rstt.next())
		{
		textarea_1.setText(rstt.getString(1));
		textarea_1.setLineWrap(true);
		}
		}catch(Exception ec){System.out.println( ec );}
		cont=textarea_1.getText();
		panel2.setSize(getPreferredSize());

	}

	/*public void createPage3()
	{
	panel3 = new JPanel();
	Border blackline3;
	blackline3 = BorderFactory.createTitledBorder("Login Configuration");
	panel3.setBorder(blackline3);
     JLabel uname;
	 JLabel pass;
	 JLabel nuname;
	 JLabel npass;
	 JLabel conf;
        newloginLayout customLayout = new newloginLayout();

         panel3.setFont(new Font("Helvetica", Font.PLAIN, 12));
         panel3.setLayout(customLayout);

        uname = new JLabel("Current User Name");
         panel3.add(uname);

        pass = new JLabel("Current Password");
         panel3.add(pass);

        nuname = new JLabel("New User Name");
         panel3.add(nuname);

        npass = new JLabel("New Password");
        panel3.add(npass);

        conf = new JLabel("Confirm Password");
         panel3.add(conf);

        cuname = new JTextField();
      //  cuname.setEditable(false);
         panel3.add(cuname);

        newuname = new JTextField();
       // newuname.setEditable(false);
         panel3.add(newuname);

        cpass = new JPasswordField(10);
       //  cpass.setEditable(false);
         panel3.add(cpass);

        newpass = new JPasswordField(10);
       // newpass.setEditable(false);
         panel3.add(newpass);

        confirm = new JPasswordField();
       // confirm.setEditable(false);
         panel3.add(confirm);

        chang = new JButton("OK");
         panel3.add(chang);
	chang.addActionListener(this);
         

        can = new JButton("Cancel");
        panel3.add(can);

	

      panel3.setSize(getPreferredSize());
	}*/
	public void actionPerformed(ActionEvent xe)
	{
		if(xe.getSource()==ok)
		{
		regexx ob=new regexx();
		boolean b=ob.email(email.getText());
		if(b)
			{
			if(phone.getText().length()!=0 && phone.getText().length()>13 || phone.getText().length()<8)
				{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=red>Invalid phone number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
				}
				else
				{
		try
		{
		  PreparedStatement pstm;
		pstm=connection.prepareStatement("update general_config set name=?,address=?,state=?,tax_no=?,phone_no=?,fax_no=?,email=? where name=?");
	
			pstm.setString(1,name.getText());
			pstm.setString(2,add.getText());
			pstm.setString(3,state.getText());
			pstm.setString(4,tax.getText());
			pstm.setString(5,phone.getText());
			pstm.setString(6,fax.getText());
			pstm.setString(7,email.getText());
			pstm.setString(8,nam);
			   int response = JOptionPane.showConfirmDialog(general_config.this,
             "Are you sure you want to update?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response) {
            case JOptionPane.YES_OPTION: 
             pstm.executeUpdate();
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=green>The Record has been Updated</font></html>","Updated",JOptionPane.ERROR_MESSAGE,check);

		//	 JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=red>The Record has been Updated</font></html>");
               break;

            case JOptionPane.NO_OPTION: 
				show();
		 }   
			}
		
			catch(Exception r)
      	 	 	{
            			System.out.println("error"+r );
					
      		 	} 
				}
		}
		else
			 JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=red>Invalid email id</font></html>");

		}
		if(xe.getSource()==ok1)
		{
		try{
		PreparedStatement pstm1=connection.prepareStatement("update general_config set contract=? where name=?");
		pstm1.setString(1,textarea_1.getText());
		pstm1.setString(2,nam);
	  int response1 = JOptionPane.showConfirmDialog(general_config.this,
             "Are you sure you want to update?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response1) {
            case JOptionPane.YES_OPTION: 
             pstm1.executeUpdate();
			 JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=red>The Record has been Updated</font></html>");
               break;

            case JOptionPane.NO_OPTION: 
		//		textarea_1.setText(cont);
				show();
		 }   

		}catch(Exception ec){System.out.println( ec );}

		}
		if(xe.getSource()==can)
		{

		name.setText(nam);
		add.setText(ad);
		state.setText(stat);	
		tax.setText(ta);	
		phone.setText(ph);
		fax.setText(fa);     
		email.setText(em);

		 JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=red>The Change has been cancelled</font></html>");

		}
				if(xe.getSource()==can1)
		{

			textarea_1.setText(cont);
	//		 JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=red>The Change has been cancelled</font></html>");
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(general_config.this,"<html><font size=4 color=green>The Change has been cancelled</font></html>","Updated",JOptionPane.ERROR_MESSAGE,check);

		}
	}



	





    // Main method to get things started
	public static void main( String args[] )
	{
		// Create an instance of the test application
		general_config mainFrame= new general_config();
		mainFrame.setVisible( true );
			try {
            			// select Look and Feel
	      	                   UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(mainFrame);

	          
        		}
        	catch (Exception ex) {
            	ex.printStackTrace();
        	}
	}
}



class gymconfigLayout implements LayoutManager {

    public gymconfigLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 542 + insets.left + insets.right;
        dim.height = 441 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+56,152,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+96,152,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+136,152,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+176,152,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+216,152,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+256,152,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+296,152,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+56,160,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+96,160,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+136,160,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+176,160,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+216,160,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+256,160,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+296,160,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+360,96,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+360,96,24);}
    }
}


class contractLayout implements LayoutManager {

    public contractLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 574 + insets.left + insets.right;
        dim.height = 504 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+32,304,64);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+112,336,240);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+392,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+368,insets.top+392,88,24);}
    }
}
class newloginLayout implements LayoutManager {

    public newloginLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 621 + insets.left + insets.right;
        dim.height = 455 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+72,144,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+120,144,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+168,144,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+216,144,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+264,144,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+72,136,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+168,136,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+120,136,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+216,136,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+264,136,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+328,96,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+328,96,24);}
    }
}
