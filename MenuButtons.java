/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investment.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author arnol
 */
// Menu Button Functionality
class MenuButtons implements ActionListener {
    private InvestPanel investPanel;

    public MenuButtons(InvestPanel panel) {
        investPanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() instanceof JMenuItem) {
            String item = evt.getActionCommand().trim();
            switch (item) {  
                case "Exit":
                    System.exit(0);
                    break;
                case "Calculate":
                    calculate();
                    break;
                case "Clear":
                    clear();
                    break;
            }
        }
    }

    // calculate investment amount
    private void calculate() {
        // get amount from customer name text field
        double amount = Double.parseDouble(investPanel.getAmount());
        // get intereset rate from type
        double interest = 10.0;
        String type = investPanel.getType();
        if (type.equals("Moderate"))
            interest = 10.0;
        else if (type.equals("Aggressive"))
            interest = 15.0;

        // investment in years input
        int years = investPanel.getTerm();
        // Math.pow is used for exponents
        double investment = amount * (Math.pow((1.00 + (interest / 100.00)), years));
        double compound_interest = investment - amount;

        String str = "INVESTMENT REPORT\n"
                + "\nCUSTOMER NAME: " + investPanel.getCustomerName()
                + "\nORIGINAL AMOUNT: R " + investPanel.getAmount()
                + "\nYEARS Invested: " + years
                + "\nFINAL AMOUNT: R " + Math.round(investment * 100.0) / 100.0;

        // Message box details
        JOptionPane.showMessageDialog(null, str);
    }

    // This should clear all the text fields
    private void clear() {
        investPanel.setCustomerName("");
        investPanel.setAmount("");
        investPanel.setType(0);
    }
}