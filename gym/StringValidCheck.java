//package gym;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.util.regex.Pattern;

public class StringValidCheck extends JTextField
{

  
    public Document createDefaultModel()
    {
        return new StringDocument();
    }

    public static class StringDocument extends PlainDocument
    {
        // The regular expression to match input against (zero or more digits)
        private final static Pattern DIGITS = Pattern.compile("[a-zA-Z,\\s]*");


        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            // Only insert the text if it matches the regular expression
           // if (str != null && DIGITS.matcher(str).matches())
 	if (str != null && DIGITS.matcher(str).matches())
                super.insertString(offs, str, a);
	else
		JOptionPane.showMessageDialog(null,"Only alphabets allowed");
        }
    }
}