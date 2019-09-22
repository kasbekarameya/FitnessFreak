//package gym.com.reports;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Date;
import java.util.Vector;
import java.awt.print.*;
import java.text.MessageFormat;

public class noofprogs extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton info;
    JPanel panel_1;
    JLabel label_1;
    JComboBox prognames;
	JLabel lblresult;
	JTable table;
	DefaultTableModel model;

    public noofprogs() {
        noofprogsLayout customLayout = new noofprogsLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Programme-wise Memberships");
        getContentPane().add(current);

		Icon warn=new ImageIcon("printer_32.gif");
        print = new JButton(warn);
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



		Icon info2=new ImageIcon("info.png");
        info = new JButton(info2);
        getContentPane().add(info);
		info.setToolTipText("Calculate Sum");

		info.addActionListener(this);

        //panel_1 = new JPanel();
        //getContentPane().add(panel_1);
		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		 int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
   		String col[] = {"Member ID","Name","Period","Cell Phone No."};
		String data[][] = {{"","","",""}};
		model=new DefaultTableModel(data,col);
		table=new JTable(model){
				public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell

		};
		
		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		getContentPane().add(sp);


        label_1 = new JLabel("Number of customers in program ");
        getContentPane().add(label_1);

        prognames = new JComboBox();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select prog_name from prog_config");
			while(rst.next())
			{
					
					prognames.addItem(rst.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}
		
        getContentPane().add(prognames);

		lblresult = new JLabel("");
        getContentPane().add(lblresult);


        setSize(getPreferredSize());
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
			dispose();	            }
        });
    }

    public static void main(String args[]) {
        noofprogs window = new noofprogs();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("noofprogs");
        window.pack();
        window.show();
    }

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==info)
		{
			
			Vector columnNames = new Vector();
			Vector data = new Vector();
 
			try
			{
            //  Connect to the Database
 
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

			String url = "jdbc:odbc:emp2";
           
            Class.forName( driver );
			Connection connection = DriverManager.getConnection( url );
 
            String prog=(String)prognames.getSelectedItem();
			String sql = "Select mem_prog.mid,name,period,cell_phone from members,mem_prog where members.mid=mem_prog.mid and prog_name=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,prog);
			
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
			int count=0;
			
            
 
           /* for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement( md.getColumnName(i) );
            }*/
					columnNames.addElement("Member ID");
					columnNames.addElement("Name");
						columnNames.addElement("Period");
						columnNames.addElement("Cell Phone No.");
 
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
			lblresult.setText("The total no. of customers in this program are:"+count);
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


class noofprogsLayout implements LayoutManager {

    public noofprogsLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+24,248,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+648,insets.top+72,40,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+600,insets.top+72,40,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,832,432);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+80,200,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+456,insets.top+80,128,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+568,400,24);}
    }
}