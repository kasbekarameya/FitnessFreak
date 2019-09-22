//package gym.com.reports;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class duedate extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton close;
    JPanel panel_1;
    JTable table;
    DefaultTableModel model;
    //Vector data,columnNames,rowset;

    public duedate() {
        curcustLayout customLayout = new curcustLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

       current = new JLabel("Payments due today");
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
			String sql = "Select payment.mid,name,owing from payment,members where members.mid=payment.mid and next_duedate=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1,sqlDate);
			
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
           
 
            for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement( md.getColumnName(i) );
            }
			while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
					row.addElement( rs.getObject(i));

                }
 
                data.addElement( row );
            }
			//model.setDataVector(data,columnNames);	
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
        duedate window = new duedate();
        try {
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

            
        }
        catch (Exception ex) {
           // ex.printStackTrace();
        }

        window.setTitle("Pyment duedates Today");
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

