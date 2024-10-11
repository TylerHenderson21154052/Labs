package Task06_2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleGUI {
    
    private static JTextField textField;
    private static JLabel label;
    private static JComboBox<String> font;
    private static JComboBox<Integer> size;
    
    private static class Update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String fontString = font.getItemAt(font.getSelectedIndex());
            int fontSize = size.getItemAt(size.getSelectedIndex());
            label.setFont(new Font(fontString, Font.PLAIN, fontSize));
            label.setText(textField.getText());
        }
    }

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Task 6.1");
        JPanel Updater = new JPanel(), p = new BGPanel(), combo = new JPanel();
        
        textField = new JTextField("", 25);
        Updater.add(textField);  
        
        label = new JLabel("", JLabel.CENTER);
        p.add(label);
        
        JButton button = new JButton("Update");     
        button.addActionListener(new Update());
        Updater.add(button);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        
        font = new JComboBox<>(fonts);
        combo.add(new JLabel("Font:"));
        combo.add(font);
        
        size = new JComboBox<>(new Integer[] {12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 48, 56, 64});
        combo.add(new JLabel("Font Size:"));
        combo.add(size);
        
        f.setSize(416, 415);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.add(Updater, BorderLayout.SOUTH);
        f.add(combo, BorderLayout.NORTH);
        f.setVisible(true);
    }
}