package com.bear.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeaMenu {
	  private int id;
	    // 返回json格式数据的时候会将这个属性面变为text
	    @JsonProperty(value="text")
	    private String name;
	    private int pid;
	    private List<TeaMenu> children;
//	    单个属性可以使用  把filename改为attributes 在json返回数据中    
//	    attributes:被添加到节点的自定义属性。
	    /* @JsonProperty("attributes")
	    private String filename;*/
	    private String filename;
	    
	    //多个属性时   新建一个Attributs的类，用来包含新添加的属性
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
