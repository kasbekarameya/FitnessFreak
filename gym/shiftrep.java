//package gym.com.reports;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class shiftrep extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton ok;
    JPanel panel_1;
    JLabel label_1;
    JLabel label_2;
    JComboBox desg;
    JComboBox shift;
    JTable table;
    DefaultTableModel model;

    public shiftrep() {
        shiftrepLayout customLayout = new shiftrepLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Employee Shift Details");
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

		desg = new JComboBox();
		desg.addItem("Gym Instructor");
		desg.addItem("Receptionist");
		desg.addItem("Management");
		desg.addItem("Nutritionist");
		desg.addItem("Cleaner");

		shift = new JComboBox();
		shift.addItem("Morning");
        shift.addItem("Evening");

		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		String col[] = {"Employee ID","Name"};
		String data[][] = {{"",""}};
		model=new DefaultTableModel(data,col);
		table=new JTable(model){
					public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell

		};
 
		JScrollPane scrollPane = new JScrollPane( table ,vertical,horizontal);
		getContentPane().add( scrollPane );

		label_1 = new JLabel("Employees belonging to shift");
		getContentPane().add(label_1);

		label_2 = new JLabel("and with deignation");
		getContentPane().add(label_2);

		getContentPane().add(desg);
		getContentPane().add(shift);
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
        shiftrep window = new shiftrep();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("shiftrep");
        window.pack();
        window.show();
    }

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			
		Vector columnNames = new Vector();
        Vector data = new Vector();
 
        try
        {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			String url = "jdbc:odbc:emp2";
			Class.forName( driver );
			Connection connection = DriverManager.getConnection( url );
			String sql = null;
			String profselected=(String)desg.getSelectedItem();
			String shiftselected=(String)shift.getSelectedItem();

			if(profselected=="All of them" && shiftselected=="Morning")
			{
				sql="select empno,name from emp where status='Morning'";
				
			}
			else if(profselected=="Gym Instructor" && shiftselected=="Morning")
			{
				sql="select empno,name from emp where shift='Morning' and profile='Gym Instructor'";
			}
			else if (profselected=="Receptionist" && shiftselected=="Morning")
			{
				sql="select empno,name from emp where shift='Morning' and profile='Receptionist'";
			}
			else if (profselected=="Cleaner" && shiftselected=="Morning")
			{
				sql="select empno,name from emp where shift='Morning' and profile='Cleaner'";
			}
			else if (profselected=="Nutritionist" && shiftselected=="Morning")
			{
				sql="select empno,name from emp where shift='Morning' and profile='Nutritionist'";
			}
			else if (profselected=="Management" && shiftselected=="Morning")
			{
				sql="select empno,name from emp where shift='Morning' and profile='Management'";
			}
			else if(profselected=="All of them" && shiftselected=="Evening")
			{
				sql="select empno,name from emp where shift='Evening'";
			}
			else if(profselected=="Gym Instructor" && shiftselected=="Evening")
			{
				sql="select empno,name from emp where shift='Evening' and profile='Gym Instructor'";
			}
			else if (profselected=="Receptionist" && shiftselected=="Evening")
			{
				sql="select empno,name from emp where shift='Evening' and profile='Receptionist'";
			}
			else if (profselected=="Cleaner" && shiftselected=="Evening")
			{
				sql="select empno,name from emp where shift='Evening' and profile='Cleaner'";
			}
			else if (profselected=="Nutritionist" && shiftselected=="Evening")
			{
				sql="select empno,name from emp where shift='Evening' and profile='Nutritionist'";
			}
			else //if (profselected=="Management" && shiftselected=="Evening")
			{
				sql="select empno,name from emp where shift='Evening' and profile='Management'";
			}
			
			Statement stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
            /*for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement( md.getColumnName(i) );
            }*/
			columnNames.addElement("Employee ID");
			columnNames.addElement("Name");
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
 
        }
	}
}

class shiftrepLayout implements LayoutManager {

    public shiftrepLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+24,184,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+568,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+496,insets.top+568,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+80,168,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+488,insets.top+80,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+608,insets.top+80,88,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+80,80,24);}
    }
}
