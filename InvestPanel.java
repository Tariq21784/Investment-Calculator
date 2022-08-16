/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investment.calculator;

import java.awt.FlowLayout;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author arnol
 */

// textfields for customer name and amount
// type of investment (moderate/aggressive)
// radio button for investment years
// radio button group
// vector types for adding investment types
class InvestPanel extends JPanel {
    private final JTextField customerName;
    private final JTextField amount;
    private final JComboBox type;
    private final JRadioButton term_5years;
    private final JRadioButton term_10years;
    private final JRadioButton term_15years;
    private final ButtonGroup group;
    private final Vector<Object> types = new Vector<>();

    // constructor
    public InvestPanel() {
        customerName = new JTextField(20);
        amount = new JTextField(20);
        types.add("Moderate                         ");
        types.add("Aggressive                         ");
        type = new JComboBox(types);
        term_5years = new JRadioButton("5 Years");
        term_10years = new JRadioButton("10 Years");
        term_15years = new JRadioButton("15 Years");
        group = new ButtonGroup();

    }

    public InvestPanel createInvestmentPanel() {
        term_5years.setSelected(true);
        group.add(term_5years);
        group.add(term_10years);
        group.add(term_15years);

        setLayout(new FlowLayout(10));
        add(new JLabel(" Customer Name: "));
        add(customerName);

        add(new JLabel(" Enter Amount:    "));
        add(amount);

        add(new JLabel(" Select Type:        "));
        add(type);

        add(new JLabel(" Select Term:      "));
        add(term_5years);
        add(term_10years);
        add(term_15years);
        return this;
    }

    // getter methods
    public String getCustomerName() {
        return customerName.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getType() {
        return type.getSelectedItem().toString().trim();
    }

    public int getTerm() {
        if (term_5years.isSelected())
            return 5;
        else if (term_10years.isSelected())
            return 10;
        else
            return 15;
    }

    // setter methods
    public void setCustomerName(String s) {
        customerName.setText(s);
    }

    public void setAmount(String s) {
        amount.setText(s);
    }

    public void setType(int i) {
        type.setSelectedIndex(i);
    }
}