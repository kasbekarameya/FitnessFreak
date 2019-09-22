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

public class profit extends JFrame implements ActionListener
{
    JLabel current;
    JButton print;
    JButton sumtot;
    JPanel panel_1;
    JLabel label_1;
    //JTextField textfield_1;
	DateField datefield;
    JLabel label_2;
    //JTextField textfield_2;
	DateField datefield2;
    JLabel label_3;
    JTextField textfield_3;
    JLabel label_4;
    JButton button_1;
	JTable table;
    DefaultTableModel model;
	Vector data,columnNames,rowset;

    public profit() {
        profitLayout customLayout = new profitLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Money Collection Report");
        getContentPane().add(current);

		Icon printrep=new ImageIcon("printer_32.gif");

  
        print = new JButton(printrep);
        getContentPane().add(print);
		print.setToolTipText("Print");

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

		Icon total=new ImageIcon("sum.png");
        sumtot = new JButton(total);
        getContentPane().add(sumtot);
		sumtot.setToolTipText("Calculate Sum");

		sumtot.addActionListener(this);

        //panel_1 = new JPanel();
       // getContentPane().add(panel_1);
	   int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

		String col[] = {"Member Id.","Name","Amount Paid"};
			String data[][] = {{"","",""}};

		
 
 model=new DefaultTableModel(data,col);
		table=new JTable(model){
				public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell

		};
 
JScrollPane scrollPane = new JScrollPane( table ,vertical,horizontal);
        getContentPane().add( scrollPane );

        label_1 = new JLabel("Money collected between");
        getContentPane().add(label_1);

        //textfield_1 = new JTextField("textfield_1");
		datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);

        label_2 = new JLabel("and");
        getContentPane().add(label_2);

        //textfield_2 = new JTextField("textfield_2");
		datefield2 = CalendarFactory.createDateField();
        getContentPane().add(datefield2);

        label_3 = new JLabel("Enter your initial target:");
        getContentPane().add(label_3);

        textfield_3 = new JTextField("");
        getContentPane().add(textfield_3);

        label_4 = new JLabel("");
        getContentPane().add(label_4);

		Icon info=new ImageIcon("info.png");
  
        button_1 = new JButton(info);
        getContentPane().add(button_1);
		button_1.addActionListener(this);
		button_1.setToolTipText("Generate");


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
        profit window = new profit();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("profit");
        window.pack();
        window.show();
    }

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==button_1)
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
 
			String sql = "Select members.mid,name,amount_paid from payment,members where members.mid=payment.mid and paydate BETWEEN ? AND ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1,sqlDate);
			stmt.setDate(2,sqlDate2);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

			columnNames.addElement("Member Id");
			columnNames.addElement("Name");
			//columnNames.addElement("Payment Date");
			columnNames.addElement("Amount Paid");
 
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
		if(ae.getSource()==sumtot)
		{
			if(textfield_3.getText().equals(""))
			{
				System.out.println("empty");
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(profit.this,"<html><font size=4 color=green>Enter your target first.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
		
			}
			else
			{
			try
			{
					float sum=0;

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				Statement st=con.createStatement();
				ResultSet set=st.executeQuery("select amount_paid from payment");
			
				while(set.next())
				{
				//System.out.println(set.getString(1));
				float conAmt=Float.parseFloat(set.getString(1));
				System.out.println(conAmt);
				 sum=sum+conAmt;
				}
				System.out.println("sum is"+sum);
				
				float target=Float.parseFloat(textfield_3.getText());
				float profit=sum-target;
				System.out.println(profit);
				label_4.setText("The total amount of money is Rs. "+sum+".    The profit/loss is Rs. "+profit);
			}
		catch(Exception e)
		{
			System.out.println("error---->"+e);
		}
		}
		}
	}//action performed over

}

class profitLayout implements LayoutManager {

    public profitLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 915 + insets.left + insets.right;
        dim.height = 654 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+16,224,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+608,40,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+608,40,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+80,168,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+80,88,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+80,48,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+576,insets.top+80,80,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+568,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+568,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+568,504,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+672,insets.top+72,40,32);}
    }
}
