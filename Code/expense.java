//package gym.com.reports;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;
import java.math.*;
import java.text.MessageFormat;

public class expense extends JFrame implements ActionListener{
    JButton print;
    JButton totAmt;
    JPanel panel_1;
    JLabel label_1;
    JLabel label_3;
	JTable table;
	float sum=0;
	float finsum=0;
    DefaultTableModel model;
	Vector data,columnNames,rowset;

    public expense() {
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
		totAmt.setToolTipText("Click here to calculate the total expense");

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
			
 			ResultSet rs=stmt.executeQuery("select empno,name,sal from emp");
 			ResultSetMetaData md=rs.getMetaData();
 			int columns=md.getColumnCount();
 			/*for (int i=1;i<=columns;i++)
			{
 						
				columnNames.addElement(md.getColumnName(i));
 			}*/
 					columnNames.addElement("Employee Id");
					columnNames.addElement("Name");
					columnNames.addElement("Salary");
					
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
			

        			label_1 = new JLabel("                                      Expense report");
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
        expense window = new expense();
		try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);
			}
        catch (Exception ex) {
           // ex.printStackTrace();
        }
        window.setTitle("expense");
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
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
					Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
					Statement st=con.createStatement();
					ResultSet set=st.executeQuery("select sal from emp");
			
					while(set.next())
					{
						//System.out.println(set.getString(1));
						float conAmt=Float.parseFloat(set.getString(1));
						//System.out.println(conAmt);
						float tot=Math.round(conAmt);
						sum=sum+conAmt;
						//float finsum=Math.round(sum);
				}
			System.out.println(sum);
			
			}
			catch(Exception e)
			{
				System.out.println("error---->"+e);
			}
				label_3.setText("The total expenditure is Rs. "+sum);
			}
		}
}
