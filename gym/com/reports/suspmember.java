//package gym.com.reports;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class suspmember extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton close;
    JPanel panel_1;
    JTable table;
    

    public suspmember() {
        curcustLayout customLayout = new curcustLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Currently Suspended Members");
        getContentPane().add(current);

        print = new JButton("Print");
        getContentPane().add(print);
       // print.addActionListener(this);
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
		Vector columnNames = new Vector();
        Vector data = new Vector();
 
        try
        {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
   			String url = "jdbc:odbc:emp2";
		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
            Class.forName( driver );
            Connection connection = DriverManager.getConnection( url );
 			String sql = "Select members.mid,name,home_phone,cell_phone from members,suspend where '"+sqlDate+"' BETWEEN suspend.start_date AND suspend.end_date";
			Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
           	int columns = md.getColumnCount();
 
            columnNames.add("Membe Id");
            columnNames.add("Name");
			columnNames.add("Phone No.");
			columnNames.add("Mobile No.");
	
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
 
		table = new JTable(data, columnNames){
		public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell
		};
 
		JScrollPane scrollPane = new JScrollPane( table,vertical,horizontal );
		getContentPane().add( scrollPane );
 
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        suspmember window = new suspmember();
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

            // start application
           // new MinFrame();
        }
        catch (Exception ex) {
           // ex.printStackTrace();
        }

        window.setTitle("Suspended Member Report");
        window.pack();
        window.show();
    }

		public void actionPerformed(ActionEvent ae)
		{
			/*if(ae.getSource()==print)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}*/
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