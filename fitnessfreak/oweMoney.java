//package gym.com.reports;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;
import java.text.MessageFormat;

public class oweMoney extends JFrame implements ActionListener{
    JButton print;
    JButton totAmt;
    JPanel panel_1;
    JLabel label_1;
    JLabel label_3;
	JTable table;
	float sum=0;
    DefaultTableModel model;
	Vector data,columnNames,rowset;

    public oweMoney() {
        oewmonLayout customLayout = new oewmonLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

		Icon printrep=new ImageIcon("printer_32.gif");
        print = new JButton(printrep);
        getContentPane().add(print);
		//print.addActionListener(this);
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
		print.setToolTipText("Click here to print the report");

		Icon total=new ImageIcon("sum.png");
        totAmt = new JButton(total);
        getContentPane().add(totAmt);
		totAmt.addActionListener(this);
		totAmt.setToolTipText("Click here to calculate the total amount of pending money");

        //panel_1 = new JPanel();
        //getContentPane().add(panel_1);
		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			columnNames=new Vector();
 			data=new Vector();
 			Statement stmt=con.createStatement();
			
 			ResultSet rs=stmt.executeQuery("select members.mid,name,cell_phone,owing from members,payment where members.mid=payment.mid and owing>0");
 			ResultSetMetaData md=rs.getMetaData();
 			int columns=md.getColumnCount();
 			/*for (int i=1;i<=columns;i++)
			{
 						
				columnNames.addElement(md.getColumnName(i));
 			}*/
 					columnNames.addElement("Membership Id");
					columnNames.addElement("Name");
					columnNames.addElement("Cell Phone No.");
						columnNames.addElement("Owing Amount");
 			while(rs.next())
			{
 				System.out.println("records: ");
	 			rowset=new Vector(columns);
 				for(int i=1;i<=columns;i++)
				{
 					rowset.addElement(rs.getObject(i));
							
 				}
					data.addElement(rowset);	
 			}
					//model.setDataVector(data,columnNames);
					 
 			model = new DefaultTableModel(data,columnNames);
  			table = new JTable(model){
     		public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;   //Disallow the editing of any cell
     		}
   		 };
  			JScrollPane sp=new JScrollPane(table,vertical,horizontal);
			getContentPane().add(sp);
				
		    }    //try end
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
 			}
			try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				Statement st=con.createStatement();
			ResultSet set=st.executeQuery("select owing from payment");
			
			while(set.next())
			{
				//System.out.println(set.getString(1));
				float conAmt=Float.parseFloat(set.getString(1));
				System.out.println(conAmt);
				 sum=sum+conAmt;
			}
			System.out.println(sum);
			//label_3.setText("The total amount of money pending is "+sum);
		}
		catch(Exception e)
		{
			System.out.println("error---->"+e);
		}

        label_1 = new JLabel("                 Customers Owing Money");
        getContentPane().add(label_1);

        label_3 = new JLabel("");
        getContentPane().add(label_3);

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
        oweMoney window = new oweMoney();
		try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);
			}
        catch (Exception ex) {
           // ex.printStackTrace();
        }
        window.setTitle("oweMoney");
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
			if(ae.getSource()==totAmt)
			{
				label_3.setText("The total sum of amount pending is Rs. "+sum);
			}
		}
}


/*class oewmonLayout implements LayoutManager {

    public oewmonLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 915 + insets.left + insets.right;
        dim.height = 650 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+600,40,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+600,40,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+72,328,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+560,704,24);}
    }
}
*/
