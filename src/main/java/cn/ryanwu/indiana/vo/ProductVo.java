package cn.ryanwu.indiana.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5982080646378514834L;
	
	private Long productId;
	private String model;
	private BigDecimal price;
	private String image;
	private Integer progress;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	
	

}
