package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.vo.ProductVO;

public class ProductModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private ArrayList<ProductVO> products;
	private String[] columnNames = {"Type","Code"};
	private Object[][] data = {};
	
	public ProductModel(ArrayList<ProductVO> products) {
		this.products = products;
	}	

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	public ArrayList<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductVO> products) {
		this.products = products;
		refreshData();
	}
	
	public void addProducts(ArrayList<ProductVO> products) {
		this.products.addAll(products);
		refreshData();
	}
	
	private void refreshData(){
		data = new Object[this.products.size()][getColumnCount()];
		for(int i=0;i<this.products.size();i++){
			data[i][0]=this.products.get(i).getType();
			data[i][1]=this.products.get(i).getCode();
		}
		fireTableDataChanged();
	}
}