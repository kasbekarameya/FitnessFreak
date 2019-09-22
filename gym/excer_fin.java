
//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
//import gym.com.valid.*;

public class excer_fin extends JFrame implements ActionListener,ItemListener{
    JButton generate;
    JButton rem1;
    JButton add1;
    JButton add2;
    JButton rem2;
    JButton add3;
    JButton rem3;
    JList list_1;
    JScrollPane sp_list_1;
    JList list_2;
    JScrollPane sp_list_2;
    JList list_3;
    JScrollPane sp_list_3;
    JList list_4;
    JScrollPane sp_list_4;
    JLabel cardio;
    JLabel upper;
    JLabel label_3;
    JButton addup,addfin1,addfin3;
    JButton remfin;
	Component c;
    DefaultListModel listModel_list_1,listModel_list_2,listModel_list_3,listModel_list_4,listModel_list_5,listModel_list_6;
	JLabel mid;
    JComboBox cmbmid;
    JLabel name;
    JTextField txtname;
    JLabel age;
    NumericTextField1 txtage;
    JLabel wt;
    NumericTextField txtwt;
    JLabel gender;
    JTextField txtgender;
	JLabel label_1;
    JTextField txthealth;
	

    public excer_fin() {
        excer1Layout customLayout = new excer1Layout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        generate = new JButton("Generate Exercise Card");
        getContentPane().add(generate);
		generate.addActionListener(this);
		generate.setToolTipText("Click here to generate an excercis card for he selected excercises");

        rem1 = new JButton("Remove");
        getContentPane().add(rem1);
		rem1.addActionListener(this);
		rem1.setToolTipText("Click here to remove an excersise from your set of exercises");

        add1 = new JButton("Add");
        getContentPane().add(add1);
		add1.addActionListener(this);
		add1.setToolTipText("Click here to add your desired set of exercises");

        add2 = new JButton("Add");
        getContentPane().add(add2);
		add2.addActionListener(this);
		add2.setToolTipText("Click here to add your desired set of exercises");

        rem2 = new JButton("Remove");
        getContentPane().add(rem2);
		rem2.addActionListener(this);
		rem2.setToolTipText("Click here to remove an excersise from your set of exercises");

        add3 = new JButton("Add");
        getContentPane().add(add3);
		add3.addActionListener(this);
		add3.setToolTipText("Click here to add your desired set of exercises");

        rem3 = new JButton("Remove");
        getContentPane().add(rem3);
		rem3.addActionListener(this);
		rem3.setToolTipText("Click here to remove an excersise from your set of exercises");

        listModel_list_1 = new DefaultListModel();
         try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select cardio  from cardio_ex");
			while(rs.next())
			{
					
					listModel_list_1.addElement(rs.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}     
			listModel_list_1.addElement("Cycling");
        list_1 = new JList(listModel_list_1);
        list_1.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        sp_list_1 = new JScrollPane(list_1);
        getContentPane().add(sp_list_1);
			//end of list_1

         listModel_list_2 = new DefaultListModel();
        try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select upper  from upper_ex");
			while(rs.next())
			{
					
					listModel_list_2.addElement(rs.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}     

        listModel_list_2.addElement("Shrugs");
        listModel_list_2.addElement("Flat db Press");
        list_2 = new JList(listModel_list_2);
        sp_list_2 = new JScrollPane(list_2);
		list_2.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        getContentPane().add(sp_list_2);
		//end of list 2

        listModel_list_3 = new DefaultListModel();
         try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select lower  from lower_ex");
			while(rs.next())
			{
					
					listModel_list_3.addElement(rs.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}     

         listModel_list_3.addElement("Squats");
        listModel_list_3.addElement("Lunges");
        list_3 = new JList(listModel_list_3);
		list_3.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        sp_list_3 = new JScrollPane(list_3);
        getContentPane().add(sp_list_3);

		//end of list3

        listModel_list_4 = new DefaultListModel();
        list_4 = new JList(listModel_list_4);
        sp_list_4 = new JScrollPane(list_4);
        getContentPane().add(sp_list_4);

        cardio = new JLabel("Cardio Exercises");
        getContentPane().add(cardio);

        upper = new JLabel("Upper Body Excercises");
        getContentPane().add(upper);

        label_3 = new JLabel("Lower Body Excercises");
        getContentPane().add(label_3);

        addup = new JButton("Add to final");
        getContentPane().add(addup);
		addup.addActionListener(this);
		addup.setToolTipText("Click here to add the selected item to the final list");

        remfin = new JButton("Remove");
        getContentPane().add(remfin);
		remfin.addActionListener(this);
		remfin.setToolTipText("Click here to remove the selected item from the final list");

		addfin1 = new JButton("Add to final");
        getContentPane().add(addfin1);
		addfin1.addActionListener(this);
		addfin1.setToolTipText("Click here to add the selected item to the final list");

		addfin3 = new JButton("Add to final");
        getContentPane().add(addfin3);
		addfin3.addActionListener(this);
		addfin3.setToolTipText("Click here to add the selected item to the final list");

		mid = new JLabel("Member Id");
        getContentPane().add(mid);

		cmbmid = new JComboBox();
		cmbmid.addItem("-----Select-----");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select mid from members");
			while(rst.next())
			{
					
					cmbmid.addItem(rst.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}
		
		
		cmbmid.addItemListener(this);
        getContentPane().add(cmbmid);

        name = new JLabel("Name");
        getContentPane().add(name);

        txtname = new JTextField("");
        getContentPane().add(txtname);

        age = new JLabel("* Age");
        getContentPane().add(age);

        txtage = new NumericTextField1();
        getContentPane().add(txtage);
		txtname.setEnabled(false);

        wt = new JLabel("* Weight in Kg");
        getContentPane().add(wt);

        txtwt = new NumericTextField();
        getContentPane().add(txtwt);

        gender = new JLabel("Gender");
        getContentPane().add(gender);
		

        txtgender = new JTextField("");
        getContentPane().add(txtgender);
		txtgender.setEnabled(false);

		label_1 = new JLabel("Any health problem?");
        getContentPane().add(label_1);

        txthealth = new JTextField("");
        getContentPane().add(txthealth );


        //setSize(getPreferredSize());
	setSize(new Dimension(800,750));
		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
              cmbmid.setSelectedItem("-----Select-----");
			  listModel_list_4.clear();
            }
        });
    }

    public static void main(String args[]) {
        excer_fin window = new excer_fin();
		try {
            
	      	      UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
             }
             catch (Exception ex) {
            	System.out.println("error------>"+ex);
        	}
       
        window.setTitle("excer1");
        window.pack();
        window.show();
    }
	public void actionPerformed(ActionEvent e)
      {
			
         if(e.getSource()==add1)
        {	
			 String text = JOptionPane.showInputDialog(c, "Add Item to be Entered into List");
        	 if (text != null && !text.equals(""))
        	 {
                 listModel_list_1.addElement(text);
		         addDb(text);
             }
        }

         if(e.getSource()==add2)
         {	
        	
       	    String text = JOptionPane.showInputDialog(c, "Add Item to be Entered into List");
        	if (text != null && !text.equals(""))
        	{
                listModel_list_2.addElement(text);
			    try
		        {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				PreparedStatement pstm=con.prepareStatement("insert into upper_ex(upper)values(?)");
				pstm.setString(1,text);
				pstm.executeUpdate();
        		}
		        catch(Exception e1)
		        {
			      System.out.println("error------>"+e1);
		        }
        	}
          }
  
         if(e.getSource()==add3)
        {	
        	
       	    String text = JOptionPane.showInputDialog(c, "Add Item to be Entered into List");
        	if (text != null && !text.equals(""))
        	{
                 listModel_list_3.addElement(text);
			     try
		         {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				PreparedStatement pstm=con.prepareStatement("insert into lower_ex(lower)values(?)");
				pstm.setString(1,text);
				pstm.executeUpdate();
        		}
		        catch(Exception e1)
		       {
			      System.out.println("error------>"+e1);
		       }
        	}
         }

		     	
	  if(e.getSource()==rem1)
	{
		int firstSelIx = list_1.getSelectedIndex();
		if(firstSelIx==-1)
		{
			Icon error=new ImageIcon("Warning_h.gif");
			JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to remove.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
		String sel = (String)listModel_list_1.getElementAt(firstSelIx);
		listModel_list_1.remove(firstSelIx);
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");

				PreparedStatement pstm=con.prepareStatement("DELETE from cardio_ex where cardio=?");
				pstm.setString(1,sel);
			
				int delete = pstm.executeUpdate();
       				 if(delete == 1){
          					System.out.println("Row is deleted.");
        				}
        				else{
          					System.out.println("Row is not deleted.");
       				 }

        		}
		catch(Exception e1)
		{
			System.out.println("error------>"+e1);
		}
		}
	}

		 if(e.getSource()==rem2)
		{
		int firstSelIx = list_2.getSelectedIndex();
		if(firstSelIx==-1)
		{
			Icon error=new ImageIcon("Warning_h.gif");
			JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to remove.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
		String sel = (String)listModel_list_2.getElementAt(firstSelIx);
		listModel_list_2.remove(firstSelIx);
		//String del=(String)list_1.getSelectedValue();
		
		
		System.out.println(firstSelIx);
		System.out.println(sel);	
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
					
				

							
				PreparedStatement pstm=con.prepareStatement("DELETE from upper_ex where upper=?");
				pstm.setString(1,sel);
				
				int delete = pstm.executeUpdate();
       				 if(delete == 1){
          					System.out.println("Row is deleted.");
        				}
        				else{
          					System.out.println("Row is not deleted.");
       				 }

        		}
		catch(Exception e1)
		{
			System.out.println("error------>"+e1);
		}
		}
	}

 if(e.getSource()==rem3)
	{
		int firstSelIx = list_3.getSelectedIndex();
		if(firstSelIx==-1)
		{
			Icon error=new ImageIcon("Warning_h.gif");
			JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to remove.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
		String sel = (String)listModel_list_3.getElementAt(firstSelIx);
		listModel_list_3.remove(firstSelIx);
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			

							
				PreparedStatement pstm=con.prepareStatement("DELETE from lower_ex where lower=?");
				pstm.setString(1,sel);
			
				int delete = pstm.executeUpdate();
       				 if(delete == 1){
          					System.out.println("Row is deleted.");
        				}
        				else{
          					System.out.println("Row is not deleted.");
       				 }

        		}
		catch(Exception e1)
		{
			System.out.println("error------>"+e1);
		}
		}
	}

			if(e.getSource()==addup)
		  {
				
				int firstSelIx = list_2.getSelectedIndex();
				if(firstSelIx==-1)
				{
					Icon error=new ImageIcon("Warning_h.gif");
					JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to add.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
				}
				else
				{
					String sel = (String)listModel_list_2.getElementAt(firstSelIx);
					listModel_list_4.addElement(sel);
				
				

					try
					{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
						System.out.println("conn made");
					PreparedStatement pstm=con.prepareStatement("insert into cardiotab(Exercise)values(?)");
					pstm.setString(1,sel);
				
					int ins = pstm.executeUpdate();
       				if(ins == 1){
          					System.out.println("inserted");
        				}
        				else{
          					System.out.println("not inserted");
       				 }

        		}
				catch(Exception e1)
				{
					System.out.println("error------>"+e1);
				}
			  }
		  }


		if(e.getSource()==addfin1)
		  {
				
				int firstSelIx = list_1.getSelectedIndex();
				if(firstSelIx==-1)
		{
			Icon error=new ImageIcon("Warning_h.gif");
			JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to add.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
		}
		else
			  {
				String sel = (String)listModel_list_1.getElementAt(firstSelIx);
				listModel_list_4.addElement(sel);
				
				

				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				System.out.println("conn made");
				PreparedStatement pstm=con.prepareStatement("insert into cardiotab(Exercise)values(?)");
				pstm.setString(1,sel);
				
				int ins = pstm.executeUpdate();
       				 if(ins == 1){
          					System.out.println("inserted");
        				}
        				else{
          					System.out.println("not inserted");
       				 }

        		}
				catch(Exception e1)
				{
					System.out.println("error------>"+e1);
				}
			  }
		  }

		  if(e.getSource()==addfin3)
		  {
				
				int firstSelIx = list_3.getSelectedIndex();
				if(firstSelIx==-1)
				{
			Icon error=new ImageIcon("Warning_h.gif");
			JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to add.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
		}
		else
			  {
				String sel = (String)listModel_list_3.getElementAt(firstSelIx);
				listModel_list_4.addElement(sel);
				
				

				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				System.out.println("conn made");
				PreparedStatement pstm=con.prepareStatement("insert into cardiotab(Exercise)values(?)");
				pstm.setString(1,sel);
				
				int ins = pstm.executeUpdate();
       				 if(ins == 1){
          					System.out.println("inserted");
        				}
        				else{
          					System.out.println("not inserted");
       				 }
	
        		}
				catch(Exception e1)
				{
					System.out.println("error------>"+e1);
				}
			  }
		  }

		  if(e.getSource()==remfin)
	{
		int firstSelIx = list_4.getSelectedIndex();
		if(firstSelIx==-1)
		{
			Icon error=new ImageIcon("Warning_h.gif");
			JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose an excersise to remove.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
		String sel = (String)listModel_list_4.getElementAt(firstSelIx);
		listModel_list_4.remove(firstSelIx);
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				PreparedStatement pstm=con.prepareStatement("DELETE from cardiotab where Exercise=?");
				pstm.setString(1,sel);
			
				int delete = pstm.executeUpdate();
       				 if(delete == 1){
          					System.out.println("Row is deleted.");
        				}
        				else{
          					System.out.println("Row is not deleted.");
       				 }

        		}
				catch(Exception e1)
				{
					System.out.println("error------>"+e1);
				}
			}
	}

			if(e.getSource()==generate)
		  {
				if(listModel_list_4.isEmpty())
				{
				Icon error=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose some excersises.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
				}
				else if(txtname.getText().trim().equals("")||txtwt.getText().trim().equals("")||txtage.getText().trim().equals("")||txtgender.getText().trim().equals(""))
				{ 
	
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
					if(txtage.getText().trim().equals(""))
					txtage.requestFocus();
					if(txtwt.getText().trim().equals(""))
					txtwt.requestFocus();
				}

			  else if(cmbmid.getSelectedItem()=="-----Select-----")
			  {
				  Icon error=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(excer_fin.this,"<html><font size=4 color=red>Choose the member for whom you are making the card.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
			 
			  }
			  else
			  {
				exchart ex = new exchart();
				ex.setTitle("Excercise Card");
				String str=(String)cmbmid.getSelectedItem();
				String memname=txtname.getText();
				String memage=txtage.getText();
				String memwt=txtwt.getText();
				String memgen=txtgender.getText();
				String memhealth=txthealth.getText();

				ex.passdetails(str,memname,memage,memwt,memgen,memhealth);
				ex.setVisible(true);
				listModel_list_4.clear();
				cmbmid.setSelectedItem("-----Select-----");
				txtwt.setText("");
				txtage.setText("");
				txtgender.setText("");
				txthealth.setText("");
			  }

		  }
	  }//action performed

	  public void addDb(String text)
	{
        		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
					
				

								
				PreparedStatement pstm=con.prepareStatement("insert into cardio_ex(cardio)values(?)");
				pstm.setString(1,text);
				pstm.executeUpdate();
        		}
		catch(Exception e1)
		{
			System.out.println("error------>"+e1);
		}
	}
         	
			
	public void itemStateChanged(ItemEvent ie)
	{
		
		 if (ie.getStateChange() == ie.SELECTED)
		 {
    
		String str=(String)cmbmid.getSelectedItem();
		if(str=="-----Select-----")
			 {
			txtname.setText("");
			txtgender.setText("");
			txtage.setText("");
			txtwt.setText("");
			txthealth.setText("");
			
			 }
			 else
			 {
		try {
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			  Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
              PreparedStatement pst = con.prepareStatement("SELECT name,gender from members where mid=?");
			  pst.setString(1,str);
			  ResultSet rs=pst.executeQuery();
              while (rs.next())
			  {
                   txtname.setText(rs.getString("name"));
				   txtgender.setText(rs.getString("gender"));
			  }
				
                 		
              }
			
			catch (Exception e)
			{
				System.out.println("error :"+e);
           	}
			 }
		 }
	}
}

class excer1Layout implements LayoutManager {

    public excer1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 803 + insets.left + insets.right;
        dim.height = 652 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+616,168,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+24,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+24,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+24,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+24,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+568,insets.top+24,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+648,insets.top+24,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+56,176,208);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+56,176,208);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+56,184,208);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+360,200,248);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+264,168,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+264,176,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+264,176,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+296,104,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+328,72,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+296,96,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+592,insets.top+296,96,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+368,88,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+368,96,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+400,88,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+400,96,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+432,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+432,96,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+464,88,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+464,96,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+496,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+496,96,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+528,112,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+528,96,24);}
    }
}


