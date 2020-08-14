package kr.co.dinner41.vo;

public class OfferTypeVO {
	
	private int id;
	private String name;
	
	public OfferTypeVO() {}

	public OfferTypeVO(int id, String name) {
		super();
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
