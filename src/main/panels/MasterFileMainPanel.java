package main.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ProductModel;
import model.file.FileManager;
import model.vo.ProductVO;

public class MasterFileMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable fileToAddTable;
	private JTable masterCreationTable;
	private JRadioButtonMenuItem rdbtnmntmGrocery;
	private JRadioButtonMenuItem rdbtnmntmTobacco;
	private String radioValue;
	
	/**
	 * Create the application.
	 */
	public MasterFileMainPanel() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		this.setLayout(new BorderLayout(0, 0));
		JPanel controlBarPanel = new JPanel();
		this.add(controlBarPanel, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new CreateMasterFileClickListener());
		controlBarPanel.add(btnCreate);
		
		JButton btnCleanAll = new JButton("Clean All");
		btnCleanAll.addActionListener(new CleanButtonClickListener());
		controlBarPanel.add(btnCleanAll);
		
		JPanel findFileToAddPanel = new JPanel();
		this.add(findFileToAddPanel, BorderLayout.WEST);
		findFileToAddPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel findSourcePanel = new JPanel();
		findFileToAddPanel.add(findSourcePanel, BorderLayout.NORTH);
		
		JButton btnAddToMasterFile = new JButton("Find");
		btnAddToMasterFile.addActionListener(new UploadFileToListener());
		findSourcePanel.add(btnAddToMasterFile);
		
		/*RadioButtons to select if we are adding grocery items or tobacco items */
		rdbtnmntmTobacco = new JRadioButtonMenuItem("Tobacco (1)");
		rdbtnmntmTobacco.setSelected(true);
		rdbtnmntmTobacco.addActionListener(new TobaccoClickListener());
		findSourcePanel.add(rdbtnmntmTobacco);
		radioValue="1";
		
		rdbtnmntmGrocery = new JRadioButtonMenuItem("Grocery (2)");
		rdbtnmntmGrocery.setSelected(false); 
		rdbtnmntmGrocery.addActionListener(new GroceryClickListener());
		findSourcePanel.add(rdbtnmntmGrocery);
		
		JPanel addToMasterButtonPanel = new JPanel();
		findFileToAddPanel.add(addToMasterButtonPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add To Master ->");
		btnNewButton.addActionListener(new AddToMasterClickListener());
		addToMasterButtonPanel.add(btnNewButton);
		
		JPanel fileToAddTablePanel = new JPanel();
		findFileToAddPanel.add(fileToAddTablePanel, BorderLayout.CENTER);
		
		fileToAddTablePanel.setLayout(new BorderLayout());
		ProductModel model = new ProductModel(new ArrayList<ProductVO>()); 
		fileToAddTable = new JTable(model);
		fileToAddTable.setFillsViewportHeight(true);
		JScrollPane pane1 = new JScrollPane(fileToAddTable);
		fileToAddTablePanel.add(fileToAddTable.getTableHeader(),BorderLayout.PAGE_START);
		fileToAddTablePanel.add(pane1,BorderLayout.CENTER);
		
		
		JPanel separator = new JPanel();
		findFileToAddPanel.add(separator, BorderLayout.EAST);
		
		JPanel masterCreationTablePanel = new JPanel();
		this.add(masterCreationTablePanel, BorderLayout.CENTER);
		masterCreationTablePanel.setLayout(new BorderLayout(0, 0));
		
		ProductModel finalModel = new ProductModel(new ArrayList<ProductVO>());
		masterCreationTable = new JTable(finalModel);
		JScrollPane pane2 = new JScrollPane(masterCreationTable);
		masterCreationTablePanel.add(masterCreationTable.getTableHeader(),BorderLayout.PAGE_START);
		masterCreationTablePanel.add(pane2,BorderLayout.CENTER);
	}
	
	/**
	 * Defines the listener for the grocery radio button click event
	 * */
	class GroceryClickListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if(rdbtnmntmGrocery.isSelected()){
	    		rdbtnmntmTobacco.setSelected(false);
	    		radioValue="2";
	    	}else{
	    		rdbtnmntmTobacco.setSelected(true);
	    		radioValue="1";
	    	}
	  }
	}
	
	/**
	 * Defines the listener for the tobacco radio button click event
	 * */
	class TobaccoClickListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if(rdbtnmntmTobacco.isSelected()){
	    		rdbtnmntmGrocery.setSelected(false);
	    		radioValue="1";
	    	}else{
	    		rdbtnmntmGrocery.setSelected(true);
	    		radioValue="2";
	    	}
	  }
	}
	
	/**
	 * Defines a file selected event from the file finder box to ad it to the master file
	 * */
	class UploadFileToListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
		      // Demonstrate "Open" dialog:
		      int rVal = c.showOpenDialog(MasterFileMainPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		    	 ArrayList<ProductVO> products = FileManager.readFileAddToMaster(c.getSelectedFile().getPath(), radioValue);
		    	 ProductModel m = (ProductModel)fileToAddTable.getModel();
		    	 m.setProducts(products);
		      }
	    }
	}
	
	/**
	 * Defines a file selected event from the file finder box to ad it to the master file
	 * */
	class AddToMasterClickListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			ProductModel modelFrom = (ProductModel)fileToAddTable.getModel();
			ProductModel modelTo = (ProductModel)masterCreationTable.getModel();
			modelTo.addProducts(modelFrom.getProducts());
			modelFrom.setProducts(new ArrayList<ProductVO>());
	    }
	}
	
	/**
	 * Defines a file selected event from the file finder box to ad it to the master file
	 * */
	class CleanButtonClickListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			ProductModel model = (ProductModel)masterCreationTable.getModel();
			model.setProducts(new ArrayList<ProductVO>());
	    }
	}
	
	/**
	 * Defines a file selected event from the file finder box to ad it to the master file
	 * */
	class CreateMasterFileClickListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    int rVal = c.showSaveDialog(MasterFileMainPanel.this);
		    if (rVal == JFileChooser.APPROVE_OPTION) {
		    	ProductModel model = (ProductModel)masterCreationTable.getModel();
		    	boolean result = FileManager.writeMasterFile(c.getSelectedFile().getPath(), model.getProducts());
		    	if(result){
		    		JOptionPane.showMessageDialog(MasterFileMainPanel.this, "File Saved");
		    	}else{
		    		JOptionPane.showMessageDialog(MasterFileMainPanel.this, 
		    				"The file was not saved due to an error. " +
		    					"Check if the there is a file with the same name in the target directory");
		    	}
		    }
	    }
	}
}