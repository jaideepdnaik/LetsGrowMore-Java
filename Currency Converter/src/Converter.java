import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Converter extends JFrame implements ActionListener {

    JComboBox fromcountry, tocountry;
    JButton convert, reset, exit;
    JLabel fromunit, tounit;
    JTextField fromtext, answer;

    String[] currencyUnits = {
            "units",
            "Indian Rupee",
            "US Dollar",
            "Canadian Dollar",
            "UAE Dhiram",
            "Bahraini Dinar"
    };

    double Indian_Rupee = 82.68;
    double US_Dollar = 1.00;
    double Canadian_Dollar = 1.34;
    double UAE_Dhiram = 3.67;
    double Bahraini_Dinar = 0.38;

    Converter() {
        setBounds(300, 60, 790, 700);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel maintitle = new JLabel("Currency Converter");
        maintitle.setBounds(150, 30, 650, 60);
        maintitle.setFont(new Font("Cabin Bold", Font.ITALIC, 50));
        maintitle.setForeground(Color.BLUE);
        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(10, 160, 50, 50);
        from.setFont(new Font("Cabin", Font.ITALIC, 20));
        from.setForeground(Color.white);
        add(from);

        fromcountry = new JComboBox<>(new String[] {
                "Select One!", "India", "USA", "Canada", "UAE", "Bahrain"
        });
        fromcountry.setBounds(100, 165, 200, 40);
        fromcountry.setFont(new Font("Cabin", Font.ITALIC, 20));
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                itemStateChanged(e);
            }
        });
        add(fromcountry);

        fromtext = new JTextField();
        fromtext.setBounds(350, 165, 250, 40);
        fromtext.setFont(new Font("Cabin", Font.ITALIC, 20));
        fromtext.setBackground(Color.white);
        add(fromtext);

        fromunit = new JLabel();
        fromunit.setBounds(655, 185, 200, 40);
        fromunit.setFont(new Font("Cabin", Font.ITALIC, 20));
        fromunit.setBackground(Color.BLACK);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(10, 310, 50, 50);
        to.setFont(new Font("Cabin", Font.ITALIC, 20));
        to.setForeground(Color.white);
        add(to);

        tocountry = new JComboBox<>(new String[] {
                "Select One!", "India", "USA", "Canada", "UAE", "Bahrain"
        });
        tocountry.setBounds(100, 310, 200, 40);
        tocountry.setFont(new Font("Cabin", Font.ITALIC, 20));
        tocountry.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                itemStateChanged(e);
            }
        });
        add(tocountry);

        answer = new JTextField(" ");
        answer.setBounds(350, 310, 250, 40);
        answer.setFont(new Font("Cabin", Font.ITALIC, 20));
        answer.setForeground(Color.BLACK);
        add(answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(655, 290, 250, 90);
        tounit.setFont(new Font("Cabin", Font.ITALIC, 20));
        tounit.setForeground(Color.BLACK);
        add(tounit);

        convert = new JButton("Convert Currency");
        convert.setBounds(100, 450, 200, 40);
        convert.setFont(new Font("Cabin", Font.ITALIC, 20));
        convert.addActionListener((ActionListener) this);
        add(convert);

        reset = new JButton("Reset");
        reset.setBounds(450, 450, 200, 40);
        reset.setFont(new Font("Cabin", Font.ITALIC, 20));
        reset.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                fromcountry.setSelectedIndex(0);
                tocountry.setSelectedIndex(0);
                fromtext.setText("");
                answer.setText("");
            }
        });
        add(reset);

        exit = new JButton("Exit");
        exit.setBounds(300, 550, 100, 40);
        exit.setFont(new Font("Cabin", Font.ITALIC, 20));
        exit.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }

        });
        add(exit);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Converter();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;
                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "India":
                        amountInPounds = amountToChange / Indian_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "UAE":
                        amountInPounds = amountToChange / UAE_Dhiram;
                        break;
                    case "Bahrain": 
                        amountInPounds = amountToChange / Bahraini_Dinar;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "India":
                        newamount = amountInPounds * Indian_Rupee;
                        break;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newamount = amountInPounds * Canadian_Dollar;
                        break;
                    case "UAE":
                        newamount = amountInPounds * UAE_Dhiram;
                        break;
                    case "Bahrain":
                        newamount = amountInPounds * Bahraini_Dinar;
                        break;
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                answer.setText(amount);
            }
        }
    }
}
