package cn.ryanwu.indiana.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ra_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 7235159705154463441L;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "model")
	private String model;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "image")
	private String image;
	
	@Column(name = "status")
	private Integer status;

	@Id
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
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
