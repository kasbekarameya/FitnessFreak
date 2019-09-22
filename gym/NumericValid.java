//package gym;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class NumericValid extends JTextField
{

  
    protected Document createDefaultModel()
    {
        return new NumericDocument();
    }

    private static class NumericDocument extends PlainDocument
    {
     // The regular expression to match input against (zero or more digits)
        private final static Pattern DIGITS = Pattern.compile("[0-9]*");
     //  private final static Pattern DIGITS = Pattern.compile("\\d*");
   //   private final static Pattern POINT = Pattern.compile(".+\\.[0-9]+");
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            // Only insert the text if it matches the regular expression
           // if (str != null && DIGITS.matcher(str).matches())
 	if (str != null && DIGITS.matcher(str).matches())
	{
                super.insertString(offs, str, a);
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Enter only numbers");
	}
	}


        
    }
}

/*package freak;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.util.regex.Pattern;

class NumericTextField1 extends JTextField
{

  
    protected Document createDefaultModel()
    {
        return new NumericDocument();
    }

    private static class NumericDocument extends PlainDocument
    {
        // The regular expression to match input against (zero or more digits)
        private final static Pattern DIGITS = Pattern.compile("[0-9]*");


        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            // Only insert the text if it matches the regular expression
           // if (str != null && DIGITS.matcher(str).matches())
 	if (str != null && DIGITS.matcher(str).matches()==false)
                super.insertString(offs, str, a);
	else
		JOptionPane.showMessageDialog(null,"No digits allowed");
        }
    }
}*/