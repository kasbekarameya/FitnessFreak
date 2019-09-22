package gym.com.reports;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class curcust2 extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton close;
    JPanel panel_1;
    JTable table;
    DefaultTableModel model;
    Vector data,columnNames,rowset;

    public curcust2() {
        curcustLayout customLayout = new curcustLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Current Customers");
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

        //panel_1 = new JPanel();
       // getContentPane().add(panel_1);

        int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;


	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:emp2");
			Statement st=conn.createStatement();
			ResultSet set=st.executeQuery("select mid,name,cell_phone,gender from members");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			 model=new DefaultTableModel(new String[]{"Membership Id","Name","Cell Phone No","Gender"},row);
			table=new JTable(model);
			set=st.executeQuery("select mid, name, cell_phone, gender  from members");
			while(set.next())
			{
				model.setValueAt(set.getString(1),i,0);
				model.setValueAt(set.getString(2),i,1);
				model.setValueAt(set.getString(3),i,2);
				model.setValueAt(set.getString(4),i,3);
				i++;
			}
			table=new JTable(model){
					public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell

			};
		}
		catch(Exception ex)
		{
		}
		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		getContentPane().add(sp);			
			
 

		

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
        curcust2 window = new curcust2();
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

        window.setTitle("Customer Report");
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
}*/
