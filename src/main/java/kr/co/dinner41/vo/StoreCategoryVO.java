package kr.co.dinner41.vo;

public class StoreCategoryVO {
	private int id;
	private String name;
	
	public StoreCategoryVO() {}

	public StoreCategoryVO(int id, String name) {
		this.id = id;
		this.name = name;
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
	
	
	
}
