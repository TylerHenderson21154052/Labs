package Task06_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleGUI {
    
    private static JTextField textField;
    private static JLabel label;
    
    private static class Update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(textField.getText());
        }
    }

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Task 6.1");
        JPanel Updater = new JPanel(), p = new BGPanel();
        
        textField = new JTextField("", 25);
        Updater.add(textField);  
        
        label = new JLabel("", JLabel.CENTER);
        p.add(label);
        
        JButton button = new JButton("Update");     
        button.addActionListener(new Update());
        Updater.add(button);
        
        f.setSize(416, 372);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.add(Updater, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}