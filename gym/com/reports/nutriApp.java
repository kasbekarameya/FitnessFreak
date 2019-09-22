//package gym.com.reports;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;

public class nutriApp extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton close;
    JPanel panel_1;
    JTable table;
    DefaultTableModel model;
    //Vector data,columnNames,rowset;

    public nutriApp() {
        curcustLayout customLayout = new curcustLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

       current = new JLabel("Nutritionist Appointments Today");
        getContentPane().add(current);

        print = new JButton("Print");
        getContentPane().add(print);
        print.addActionListener(this);

        close = new JButton("Close");
        getContentPane().add(close);
        close.addActionListener(this);

		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

		//String col[] = {"Mem ID","Name"};
		//String data[][] = {{"",""}};
		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		
		System.out.println(sqlDate);
		Vector columnNames = new Vector();
        Vector data = new Vector();
 
        try
        {
            //  Connect to the Database
 
String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

String url = "jdbc:odbc:emp2";
           
            Class.forName( driver );
Connection connection = DriverManager.getConnection( url );
 
           
            //String sql = "Select mid,prog_name from mem_prog where end_date BETWEEN '"+sqlDate+"' AND '"+sqlDate+"'";
			String sql = "Select members.mid,name,cell_phone from food_sugg,members where members.mid=food_sugg.mid and sugg_date=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1,sqlDate);
			
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
           
 
           /* for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement( md.getColumnName(i) );
            }*/
			columnNames.addElement("Member Id.");
			columnNames.addElement("Name");
			columnNames.addElement("Cell No.");
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
 
        
		


		//model=new DefaultTableModel(data,col);
		table=new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane( table,vertical,horizontal );
		 getContentPane().add( scrollPane );
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
        nutriApp window = new nutriApp();
        try {
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

            
        }
        catch (Exception ex) {
           // ex.printStackTrace();
        }

        window.setTitle("Nutritionist Appointments Today");
        window.pack();
        window.show();
    }

		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==print)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}
			
			if(ae.getSource()==close)
		{
			
		dispose();

		}
		}
}
/*
class curcustLayout implements LayoutManager {

    public curcustLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 915 + insets.left + insets.right;
        dim.height = 621 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+64,184,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+552,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+496,insets.top+552,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+104,832,432);}
    }
}
*/