package com.bear.pojo;

import java.util.List;

/**
 * json�������ݸ�datagird���ݱ�
 * @author hp
 *
 */
public class DataGrid {
	// ��ǰҳ�ļ�¼����
    private List<?> rows;
    // �ܼ�¼��
    private int total;
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "DataGrid [rows=" + rows + ", total=" + total + "]";
	}
	
    
}
