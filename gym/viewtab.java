//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.JTable;


public class viewtab extends JFrame {
    JPanel panel_1;
    JLabel label_1;
    public JTextField mid;
    JLabel label_2;
    public JTextField name;
    JTable table;
    DefaultTableModel model;
	Connection con;

    public viewtab() {
        viewtabLayout customLayout = new viewtabLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        panel_1 = new JPanel();
			 int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;		     
	int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    	String col[] = {"Programme Name","Status","Payment Date","Method","Amount Paid","Installment","Next due date","Owing","Price","Bank Name","Cheque Number","Account Number","Paid For"};
		String data[][] = {{"","","","","","","","","","","","",""}};

		model=new DefaultTableModel(data,col);
		table=new JTable(model)
						        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);
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


			JScrollPane sp=new JScrollPane(table,vertical,horizontal);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().add(sp);

        label_1 = new JLabel("Member ID");
        getContentPane().add(label_1);

        mid = new JTextField("");
        getContentPane().add(mid);

        label_2 = new JLabel("Member Name");
        getContentPane().add(label_2);
        name = new JTextField("");
        getContentPane().add(name);

		mid.setEnabled(false);
		name.setEnabled(false);

		try
		{
	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
		con=DriverManager.getConnection("jdbc:odbc:emp2");
		Statement state = con.createStatement();
		state.close();
		con.close();
		}
		catch(Exception le)
      	{
	    System.out.println( le );
		le.printStackTrace();
      	}

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
            }
        });
    }
	 public void createtab(String strSQL)
	{
		 System.out.println("hello");
		 try
        {
			 	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
		con=DriverManager.getConnection("jdbc:odbc:emp2");

 			Vector data = new Vector();
			 Vector col = new Vector(13);
			col.add("Programme Name");
			col.add("Status");
			col.add("Payment Date");
			col.add("Method");
			col.add("Amount Paid");
			col.add("Installment");
			col.add("Next due date");
			col.add("Owing");
			col.add("Price");
			col.add("Bank Name");
			col.add("Cheque Number");
			col.add("Account Number");
			col.add("Paid For");

			Statement st=con.createStatement();
            ResultSet rs1 = st.executeQuery(strSQL);
			ResultSetMetaData md = rs1.getMetaData();
            int columns = md.getColumnCount();
			
            //  Get row data
 
            while (rs1.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs1.getObject(i) );
                }
 
                data.addElement( row );
            }
				model.setDataVector(data,col);	
		 }
		catch(Exception e)
		{
 				System.out.println("Exception: " + e);
				e.printStackTrace();
 		}
			
	}

    public static void main(String args[]) {
        viewtab window = new viewtab();
try {
          
    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
      }
       catch (Exception ex) {
            	ex.printStackTrace();
        	}

        window.setTitle("Payment Details");
        window.pack();
        window.show();
    }

}

class viewtabLayout implements LayoutManager {

    public viewtabLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 562 + insets.left + insets.right;
        dim.height = 420 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+104,488,272);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+40,104,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+40,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+40,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+40,112,24);}
    }
}
