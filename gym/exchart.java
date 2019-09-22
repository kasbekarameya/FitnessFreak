//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

public class exchart extends JFrame implements ActionListener{
    JPanel panel_1;
    JButton ok;
    JButton print;
	JLabel label_1;
    JLabel label_2;
    JLabel label_5;
    JLabel lblmid;
    JLabel lblname;
    JLabel lblgen;
    JLabel age;
    JLabel wt;
    JLabel health;
    JLabel lblage;
    JLabel lblwt;
    JLabel lblhealth;
	JTable table;

    public exchart() {
        exchartLayout customLayout = new exchartLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        //panel_1 = new JPanel();
        //getContentPane().add(panel_1);

		Vector columnNames = new Vector();
        Vector data = new Vector();
 
        try
        {
            //  Connect to the Database
 
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			String url = "jdbc:odbc:emp2";
            Class.forName( driver );
			Connection connection = DriverManager.getConnection( url );
 
            //  Read data from a table
 
            String sql = "Select * from cardiotab";
			Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
            //  Get column names
 
            for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement( md.getColumnName(i) );
            }
 
            //  Get row data
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
					row.addElement( rs.getObject(i));

                }
 
                data.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
 
        //  Create table with database data
 
 table = new JTable(data, columnNames);
 
JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
		TableColumn column1 = table.getColumnModel().getColumn(1);
			 column1.setPreferredWidth(5);
			 TableColumn column2 = table.getColumnModel().getColumn(2);
			 column2.setPreferredWidth(5);
			 TableColumn column3 = table.getColumnModel().getColumn(3);
			 column3.setPreferredWidth(5);
  

 

        ok = new JButton("OK");
        getContentPane().add(ok);
		ok.addActionListener(this);

        print = new JButton("Print");
        getContentPane().add(print);
			ActionListener printAction = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          MessageFormat headerFormat = new MessageFormat("Number of customers in each program");
          MessageFormat footerFormat = new MessageFormat("- {0} -");
          table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException pe) {
          System.err.println("Error printing: " + pe.getMessage());
        }
      }
    };
print.addActionListener(printAction);

		

		label_1 = new JLabel("Member Id");
        getContentPane().add(label_1);

        label_2 = new JLabel("Name");
        getContentPane().add(label_2);

        label_5 = new JLabel("Gender");
        getContentPane().add(label_5);

        lblmid = new JLabel("label_6");
        getContentPane().add(lblmid);

        lblname = new JLabel("label_7");
        getContentPane().add(lblname);

        lblgen = new JLabel("label_8");
        getContentPane().add(lblgen);

        age = new JLabel("Age");
        getContentPane().add(age);

        wt = new JLabel("Weight");
        getContentPane().add(wt);

        health = new JLabel("Any health problem");
        getContentPane().add(health);

        lblage = new JLabel("label_6");
        getContentPane().add(lblage);

        lblwt = new JLabel("label_6");
        getContentPane().add(lblwt);

        lblhealth = new JLabel("label_7");
        getContentPane().add(lblhealth);

        setSize(getPreferredSize());
		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				Statement st = con.createStatement();
        		String sql = "DELETE FROM cardiotab";
				int delete = st.executeUpdate(sql);
				System.out.println(delete);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
		
		dispose();
                
            }
        });
    }

    public static void main(String args[]) {
        exchart window = new exchart();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("exchart");
        window.pack();
        window.show();
    }

	public void passdetails(String str,String name, String age,String wt,String gen,String health)
        {
			lblmid.setText(str);
			lblname.setText(name);
			lblage.setText(age);
			lblwt.setText(wt);
			lblgen.setText(gen);
			lblhealth.setText(health);
		}
	public void actionPerformed(ActionEvent e)
	{
	/*	if(e.getSource()==print)
		{
			
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
		}
		*/
		if(e.getSource()==ok)
		{
			try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				Statement st = con.createStatement();
        		String sql = "DELETE FROM cardiotab";
				int delete = st.executeUpdate(sql);
				System.out.println(delete);
        }
		catch (Exception ex) {
            ex.printStackTrace();
        }
		}
		dispose();		
	}
	
}

/*class exchartLayout implements LayoutManager {

    public exchartLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 638 + insets.left + insets.right;
        dim.height = 657 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+48,520,544);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+616,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+616,72,24);}
    }
}*/
class exchartLayout implements LayoutManager {

    public exchartLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 638 + insets.left + insets.right;
        dim.height = 657 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+128,488,488);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+624,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+624,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+24,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+56,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+88,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+24,80,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+56,80,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+88,80,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+24,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+56,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+88,112,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+24,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+56,72,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+88,144,24);}
    }
}
