//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;


public class recptnew extends JFrame implements ActionListener {
    JLabel label_1;
    JLabel mid;
    JLabel label_3;
    JLabel mname;
    JLabel label_5;
    JLabel pname;
    JLabel label_7;
    JLabel pprice;
    JLabel label_9;
    JLabel amount;
    JLabel label_11;
    JLabel owing;
    JLabel label_13;
    JLabel meth;
    JLabel label_15;
    JLabel pdate;
    JLabel statu;
    JLabel label_18;
    JButton print;
    JLabel paytyp1;
    JLabel paytyp;
    JLabel paidfor1;
    JLabel paidfor;
    JLabel nxtdue1;
    JLabel nxtdue;
    JLabel bnk1;
    JLabel bnk;
    JLabel chq1;
    JLabel chq;
    JLabel acc1;
    JLabel acc;

    public recptnew() {
        recptnewLayout customLayout = new recptnewLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Member ID");
        getContentPane().add(label_1);

        mid = new JLabel("");
        getContentPane().add(mid);

        label_3 = new JLabel("Member Name");
        getContentPane().add(label_3);

        mname = new JLabel("");
        getContentPane().add(mname);

        label_5 = new JLabel("Programme Name");
        getContentPane().add(label_5);

        pname = new JLabel("");
        getContentPane().add(pname);

        label_7 = new JLabel("Programme Price");
        getContentPane().add(label_7);

        pprice = new JLabel("");
        getContentPane().add(pprice);

        label_9 = new JLabel("Amount Paid");
        getContentPane().add(label_9);

        amount = new JLabel("");
        getContentPane().add(amount);

        label_11 = new JLabel("Owing Amount");
        getContentPane().add(label_11);

        owing = new JLabel("");
        getContentPane().add(owing);

        label_13 = new JLabel("Payment Method");
        getContentPane().add(label_13);

        meth = new JLabel("");
        getContentPane().add(meth);

        label_15 = new JLabel("Payment Date");
        getContentPane().add(label_15);

        pdate = new JLabel("");
        getContentPane().add(pdate);

        statu = new JLabel("");
        getContentPane().add(statu);

        label_18 = new JLabel("Status");
        getContentPane().add(label_18);

        print = new JButton("Print");
        getContentPane().add(print);
		  print.setToolTipText("Prints Payment Receipt");

		
print.addActionListener(this);


        paytyp1 = new JLabel("");
        getContentPane().add(paytyp1);

        paytyp = new JLabel("");
        getContentPane().add(paytyp);

        paidfor1 = new JLabel("");
        getContentPane().add(paidfor1);

        paidfor = new JLabel("");
        getContentPane().add(paidfor);

        nxtdue1 = new JLabel("");
        getContentPane().add(nxtdue1);

        nxtdue = new JLabel("");
        getContentPane().add(nxtdue);

        bnk1 = new JLabel("");
        getContentPane().add(bnk1);

        bnk = new JLabel("");
        getContentPane().add(bnk);

        chq1 = new JLabel("");
        getContentPane().add(chq1);

        chq = new JLabel("");
        getContentPane().add(chq);

        acc1 = new JLabel("");
        getContentPane().add(acc1);

        acc = new JLabel("");
        getContentPane().add(acc);

        setSize(getPreferredSize());
			setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
		public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==print)
		{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
		}
	}
	public void cash(String memid,String memnam,String prg,String pr,String paid,String ow,String met,String pdat,String stau)
	{
		mid.setText(memid);
		mname.setText(memnam);
		pname.setText(prg);
		pprice.setText(pr);
		amount.setText(paid);
		owing.setText(ow);
		meth.setText(met);
		pdate.setText(pdat);
		statu.setText(stau);
	}
	public void instalcash(String memid,String memnam,String prg,String pr,String paid,String ow,String met,String pdat,String stau,String patyp,String pf,String nxt)
	{
		mid.setText(memid);
		mname.setText(memnam);
		pname.setText(prg);
		pprice.setText(pr);
		amount.setText(paid);
		owing.setText(ow);
		meth.setText(met);
		pdate.setText(pdat);
		statu.setText(stau);
		paytyp.setText(patyp);
		paidfor.setText(pf);
		nxtdue.setText(nxt);
		paytyp1.setText("Payment Type");
		paidfor1.setText("Paid For");
		nxtdue1.setText("Next Due Date");

	}
	public void instalcheque(String memid,String memnam,String prg,String pr,String paid,String ow,String met,String pdat,String stau,String patyp,String pf,String nxt,String bk,String ac,String ch)
	{
		mid.setText(memid);
		mname.setText(memnam);
		pname.setText(prg);
		pprice.setText(pr);
		amount.setText(paid);
		owing.setText(ow);
		meth.setText(met);
		pdate.setText(pdat);
		statu.setText(stau);
		paytyp.setText(patyp);
		paidfor.setText(pf);
		nxtdue.setText(nxt);
		paytyp1.setText("Payment Type");
		paidfor1.setText("Paid For");
		nxtdue1.setText("Next Due Date");
		bnk.setText(bk);
		acc.setText(ac);
		chq.setText(ch);
		bnk1.setText("Bank Name");
		acc1.setText("Account Number");
		chq1.setText("Cheque Number");

	}
	public void cheque(String memid,String memnam,String prg,String pr,String paid,String ow,String met,String pdat,String stau,String bak,String aac,String cah)
	{
		mid.setText(memid);
		mname.setText(memnam);
		pname.setText(prg);
		pprice.setText(pr);
		amount.setText(paid);
		owing.setText(ow);
		meth.setText(met);
		pdate.setText(pdat);
		statu.setText(stau);
		bnk.setText(bak);
		acc.setText(aac);
		chq.setText(cah);
		bnk1.setText("Bank Name");
		acc1.setText("Account Number");
		chq1.setText("Cheque Number");

	}

   public void empty()
   {
    mname.setText("");
    pname.setText("");
    pprice.setText("");
    amount.setText("");
      owing.setText("");
      meth.setText("");
      pdate.setText("");
      statu.setText("");
      paytyp1.setText("");
      paytyp.setText("");
      paidfor1.setText("");
      paidfor.setText("");
      nxtdue1.setText("");
      nxtdue.setText("");
      bnk1.setText("");
      bnk.setText("");
      chq1.setText("");
      chq.setText("");
      acc1.setText("");
      acc.setText("");
    }
    public static void main(String args[]) {
        recptnew window = new recptnew();
	try {
          
    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
		 }
       catch (Exception ex) {
            	ex.printStackTrace();
        	}

        window.setTitle("Receipt Generation");
        window.pack();
        window.show();
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
	
}

class recptnewLayout implements LayoutManager {

    public recptnewLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 711 + insets.left + insets.right;
        dim.height = 599 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+80,120,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+80,136,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+120,120,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+120,136,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+160,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+160,184,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+200,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+200,144,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+240,120,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+240,144,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+280,120,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+280,144,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+320,120,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+320,144,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+360,120,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+360,144,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+400,144,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+400,120,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+456,112,32);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+80,112,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+80,144,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+120,112,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+120,144,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+160,112,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+160,144,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+200,112,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+200,144,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+240,112,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+240,144,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+280,112,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+280,144,24);}
    }
}
