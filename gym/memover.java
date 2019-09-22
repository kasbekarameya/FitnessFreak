//package gym.com.reports;

import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class memover extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton ok;
    JPanel panel_1;
    JLabel label_1;
    DateField datefield;
    JLabel label_2;
    DateField datefield2;
	JTable table;
    DefaultTableModel model;
    Vector data,columnNames,rowset;

    public memover() {
        suspmemLayout customLayout = new suspmemLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Memberships expiring");
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

        ok = new JButton("OK");
        getContentPane().add(ok);
		ok.addActionListener(this);

		datefield = CalendarFactory.createDateField();
		datefield2 = CalendarFactory.createDateField();

        //panel_1 = new JPanel();
        //getContentPane().add(panel_1);
		
		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

		String col[] = {"Member ID","Name","Programme Name","Start Date","End Date"};
		
			String data[][] = {{"",""}};

		
 
 model=new DefaultTableModel(data,col);
		table=new JTable(model){
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);
 //	table.setAutoResizeMode(AUTO_RESIZE_OFF);
                    if (o != null)
                    {
                        return o.getClass();
                    }
                }
 
                return Object.class;
           }
	 public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell
        };
 
JScrollPane scrollPane = new JScrollPane( table ,vertical,horizontal);
        getContentPane().add( scrollPane );
 
		

        label_1 = new JLabel("Memberships expiring between ");
        getContentPane().add(label_1);

        
        getContentPane().add(datefield);

        label_2 = new JLabel("and");
        getContentPane().add(label_2);

        
        getContentPane().add(datefield2);

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
        memover window = new memover();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("Report");
        window.pack();
        window.show();
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			Date choosed = (Date) datefield.getValue();
		Date choosed2 = (Date) datefield2.getValue();
	//	java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
		java.sql.Date sqlDate2 = new java.sql.Date(choosed2.getTime());
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
 
            //  Read data from a table
 	//String leave="On Leave";
            //String sql = "Select mid,prog_name from mem_prog where end_date BETWEEN '"+sqlDate+"' AND '"+sqlDate+"'";
			String sql = "Select members.mid,name,prog_name,start_date,end_date from mem_prog,members where end_date BETWEEN ? AND ? and members.mid=mem_prog.mid";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1,sqlDate);
			stmt.setDate(2,sqlDate2);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
            //  Get column names
 
            /*for (int i = 1; i <= columns; i++)
            {
columnNames.addElement( md.getColumnName(i) );
            }*/
			columnNames.addElement("Member Id");
				columnNames.addElement("Name");
				columnNames.addElement("Programme Name");
				columnNames.addElement("Start Date");
				columnNames.addElement("End Date");
           
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
row.addElement( rs.getObject(i));

                }
 
                data.addElement( row );
            }
			model.setDataVector(data,columnNames);	
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
 
        //  Create table with database data
		}
	}

}

class suspmemLayout implements LayoutManager {

    public suspmemLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+16,216,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+568,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+496,insets.top+568,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+80,176,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+80,88,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+80,32,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+560,insets.top+80,80,24);}
    }
}
