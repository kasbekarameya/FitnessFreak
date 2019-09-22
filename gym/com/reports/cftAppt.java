//package gym.com.reports;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class cftAppt extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton close;
    JPanel panel_1;
    JTable table;
    DefaultTableModel model;
    //Vector data,columnNames,rowset;

    public cftAppt() {
        curcustLayout customLayout = new curcustLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

       current = new JLabel("Common Fitness Tests today");
        getContentPane().add(current);

        print = new JButton("Print");
        getContentPane().add(print);
		 ActionListener printAction = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          MessageFormat headerFormat = new MessageFormat("Memberships expiring");
          MessageFormat footerFormat = new MessageFormat("- {0} -");
          table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException pe) {
          System.err.println("Error printing: " + pe.getMessage());
        }
      }
    };
print.addActionListener(printAction);

        

        close = new JButton("Close");
        getContentPane().add(close);
        close.addActionListener(this);

		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		
		System.out.println(sqlDate);
		Vector columnNames = new Vector();
        Vector data = new Vector();
 
        try
        {
           
 
String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

String url = "jdbc:odbc:emp2";
           
            Class.forName( driver );
Connection connection = DriverManager.getConnection( url );
 
           
			String sql = "Select memname,empname,apptime from appointment where appdate=? and apptype=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1,sqlDate);
			stmt.setString(2,"CFT");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
			columnNames.addElement("Member Name.");
			columnNames.addElement("Employe Name");
			columnNames.addElement("Time");
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
		table=new JTable(data,columnNames){
			public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;}
		};
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
        cftAppt window = new cftAppt();
        try {
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

            
        }
        catch (Exception ex) {
           // ex.printStackTrace();
        }

        window.setTitle("CFT Appointments Today");
        window.pack();
        window.show();
    }

		public void actionPerformed(ActionEvent ae)
		{
			
			
			if(ae.getSource()==close)
		{
			
		dispose();

		}
		}
}

