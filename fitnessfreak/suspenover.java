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

public class suspenover extends JFrame implements ActionListener{
    JLabel current;
    JButton ok;
    JButton close;
    JPanel panel_1;
    JLabel label_1;
	DateField datefield;
    JLabel label_2;
    DateField datefield2;
    JLabel label_4;
	JTable table;
    DefaultTableModel model;

    public suspenover() {
        suspoverLayout customLayout = new suspoverLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Customer suspension Report");
        getContentPane().add(current);

		Icon info2=new ImageIcon("info.png");
        
        ok = new JButton(info2);
        getContentPane().add(ok);
		ok.setToolTipText("Display record between selected dates");


		Icon warn=new ImageIcon("printer_32.gif");
       
        close = new JButton(warn);
        getContentPane().add(close);
		close.setToolTipText("Print");
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
close.addActionListener(printAction);
		ok.addActionListener(this);

        //panel_1 = new JPanel();
        //getContentPane().add(panel_1);
		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

		String col[] = {"Member Id","Name","End Date","Period"};
		
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

        label_1 = new JLabel("Members whose suspension is getting over between");
        getContentPane().add(label_1);

        datefield = CalendarFactory.createDateField();
		getContentPane().add(datefield);

		datefield2 = CalendarFactory.createDateField();

        label_2 = new JLabel("and");
        getContentPane().add(label_2);

        //textfield_2 = new JTextField("textfield_2");
        //getContentPane().add(textfield_2);
		getContentPane().add(datefield2);
        label_4 = new JLabel("");
        getContentPane().add(label_4);
		

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
        suspenover window = new suspenover();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("suspover");
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
			String sql = "Select suspend.mid,name,end_date,period from suspend,members where members.mid=suspend.mid and end_date BETWEEN ? AND ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1,sqlDate);
			stmt.setDate(2,sqlDate2);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
			int count=0;
            //  Get column names
 
            
			columnNames.addElement("Member Id");
				columnNames.addElement("Name");
				columnNames.addElement("End Date");
				columnNames.addElement("Period");
            //  Get row data
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
				count++;
                for (int i = 1; i <= columns; i++)
                {
row.addElement( rs.getObject(i));

                }
 
                data.addElement( row );
            }
			label_4.setText("The total number of customers whose suspension period is gettong over are: "+count);
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

/*class suspoverLayout implements LayoutManager {

    public suspoverLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+648,insets.top+72,32,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+696,insets.top+72,32,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+80,272,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+80,88,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+80,32,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+560,insets.top+80,80,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+568,520,24);}
    }
}*/
class suspoverLayout implements LayoutManager {

    public suspoverLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+648,insets.top+72,32,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+696,insets.top+72,32,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+80,320,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+80,88,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+80,32,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+560,insets.top+80,80,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+568,520,24);}
    }
}

