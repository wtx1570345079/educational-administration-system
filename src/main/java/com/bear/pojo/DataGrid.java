package com.bear.pojo;

import java.util.List;

/**
 * json返回数据给datagird数据表
 * @author hp
 *
 */
public class DataGrid {
	// 当前页的记录数据
    private List<?> rows;
    // 总记录数
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
