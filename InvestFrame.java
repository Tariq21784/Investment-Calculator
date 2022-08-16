/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investment.calculator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author arnol
 */
// InvestmentPanel object
// menu items: File has Exit, Tools has Calculate and Clear
// menu bar has File and Tools
class InvestFrame extends JFrame {
    private final JMenuBar menuBar;
    private final JMenu fileMenu;
    private final JMenu toolsMenu;
    private final JMenuItem file_exitMenuItem;
    private final JMenuItem tools_calculateMenuItem;
    private final JMenuItem tools_clearMenuItem;
    private InvestPanel investPanel;

    // constructor
    public InvestFrame() {
        // initialize
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        toolsMenu = new JMenu("Tools");
        file_exitMenuItem = new JMenuItem("Exit");
        tools_calculateMenuItem = new JMenuItem("Calculate");
        tools_clearMenuItem = new JMenuItem("Clear");


        fileMenu.add(file_exitMenuItem);

        toolsMenu.add(tools_calculateMenuItem);
        toolsMenu.add(tools_clearMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

    }

    public void showFrame() {
        investPanel = new InvestPanel();
        MenuButtons act = new MenuButtons(investPanel);
        file_exitMenuItem.addActionListener(act);
        tools_calculateMenuItem.addActionListener(act);
        tools_clearMenuItem.addActionListener(act);

       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
        getContentPane().add(investPanel.createInvestmentPanel());
        setTitle("Investment Calculator");
        setSize(420, 200);
        setLocation(300, 200);
        setVisible(true);
    }
}
