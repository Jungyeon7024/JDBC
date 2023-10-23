package DTO_Test;

public class ProductDTO {

	private int productId;
	private String productName;
	private String category;
	private int price;
	private int stockquantity;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int productId,String productName,String category,int price,int stockquantity) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stockquantity = stockquantity;
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockquantity() {
		return stockquantity;
	}

	public void setStockquantity(int stockquantity) {
		this.stockquantity = stockquantity;
	}
	
	@Override // 이게 없어도 작동은 하지만 다른 곳에서 가져왔다는 것을 보여줌
	public String toString() {
		return "ProuductDTO";
	}
	
	
	
}
