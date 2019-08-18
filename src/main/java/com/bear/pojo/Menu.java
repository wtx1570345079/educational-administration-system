package com.bear.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import aj.org.objectweb.asm.Attribute;

public class Menu {
    private int id;
    // ����json��ʽ���ݵ�ʱ��Ὣ����������Ϊtext
    @JsonProperty(value="text")
    private String name;
    private int pid;
    private List<Menu> children;
//    �������Կ���ʹ��  ��filename��Ϊattributes ��json����������    
//    attributes:����ӵ��ڵ���Զ������ԡ�
    /* @JsonProperty("attributes")
    private String filename;*/
    private String filename;
    
    //�������ʱ   �½�һ��Attributs���࣬������������ӵ�����
    private Attributes attributes;
    
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

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

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

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", pid=" + pid + ", children=" + children + ", filename="
				+ filename + ", attributes=" + attributes + "]";
	}

}
