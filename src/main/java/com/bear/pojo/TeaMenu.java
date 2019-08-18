package com.bear.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeaMenu {
	  private int id;
	    // ����json��ʽ���ݵ�ʱ��Ὣ����������Ϊtext
	    @JsonProperty(value="text")
	    private String name;
	    private int pid;
	    private List<TeaMenu> children;
//	    �������Կ���ʹ��  ��filename��Ϊattributes ��json����������    
//	    attributes:����ӵ��ڵ���Զ������ԡ�
	    /* @JsonProperty("attributes")
	    private String filename;*/
	    private String filename;
	    
	    //�������ʱ   �½�һ��Attributs���࣬������������ӵ�����
	    private Attributes attributes;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public List<TeaMenu> getChildren() {
			return children;
		}

		public void setChildren(List<TeaMenu> children) {
			this.children = children;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public Attributes getAttributes() {
			return attributes;
		}

		public void setAttributes(Attributes attributes) {
			this.attributes = attributes;
		}

		@Override
		public String toString() {
			return "Teamenu [id=" + id + ", name=" + name + ", pid=" + pid + ", children=" + children + ", filename="
					+ filename + ", attributes=" + attributes + "]";
		}
	    
	    
}
