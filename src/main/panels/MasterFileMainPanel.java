package main.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MasterFileMainPanel extends JPanel {

	private JTextField srcTextField;
	private JTable fileToAddTable;
	private JTable masterCreationTable;
	private String[] columnNames = {"Type",
            "Code"};
	
	private Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	
	/**
	 * Create the application.
	 */
	public MasterFileMainPanel() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setLayout(new BorderLayout(0, 0));
		JPanel controlBarPanel = new JPanel();
		this.add(controlBarPanel, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("Create");
		controlBarPanel.add(btnCreate);
		
		JButton btnCleanAll = new JButton("Clean All");
		controlBarPanel.add(btnCleanAll);
		
		JPanel findFileToAddPanel = new JPanel();
		this.add(findFileToAddPanel, BorderLayout.WEST);
		findFileToAddPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel findSourcePanel = new JPanel();
		findFileToAddPanel.add(findSourcePanel, BorderLayout.NORTH);
		
		JLabel srcLabel = new JLabel("Source:");
		findSourcePanel.add(srcLabel);
		
		srcTextField = new JTextField();
		findSourcePanel.add(srcTextField);
		srcTextField.setColumns(10);
		
		JButton btnAddToMasterFile = new JButton("Find");
		btnAddToMasterFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser c = new JFileChooser();
			      // Demonstrate "Open" dialog:
			      int rVal = c.showOpenDialog(MasterFileMainPanel.this);
			      if (rVal == JFileChooser.APPROVE_OPTION) {
			        /*filename.setText(c.getSelectedFile().getName());
			        dir.setText(c.getCurrentDirectory().toString());*/
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			        /*filename.setText("You pressed cancel");
			        dir.setText("");*/
			      }
			}
		});
		findSourcePanel.add(btnAddToMasterFile);
		
		JRadioButtonMenuItem rdbtnmntmGrocery = new JRadioButtonMenuItem("Grocery");
		findSourcePanel.add(rdbtnmntmGrocery);
		
		JRadioButtonMenuItem rdbtnmntmTobacco = new JRadioButtonMenuItem("Tobacco");
		findSourcePanel.add(rdbtnmntmTobacco);
		
		JPanel addToMasterButtonPanel = new JPanel();
		findFileToAddPanel.add(addToMasterButtonPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add To Master ->");
		addToMasterButtonPanel.add(btnNewButton);
		
		JPanel fileToAddTablePanel = new JPanel();
		findFileToAddPanel.add(fileToAddTablePanel, BorderLayout.CENTER);
		fileToAddTablePanel.setLayout(new BorderLayout());
		
		fileToAddTable = new JTable(data,columnNames);
		fileToAddTablePanel.add(fileToAddTable.getTableHeader(),BorderLayout.PAGE_START);
		fileToAddTablePanel.add(fileToAddTable,BorderLayout.CENTER);
		
		JPanel separator = new JPanel();
		findFileToAddPanel.add(separator, BorderLayout.EAST);
		
		JPanel masterCreationTablePanel = new JPanel();
		this.add(masterCreationTablePanel, BorderLayout.CENTER);
		masterCreationTablePanel.setLayout(new BorderLayout(0, 0));
		
		masterCreationTable = new JTable(data, columnNames);
		masterCreationTablePanel.add(masterCreationTable.getTableHeader(),BorderLayout.PAGE_START);
		masterCreationTablePanel.add(masterCreationTable,BorderLayout.CENTER);
	}
}
