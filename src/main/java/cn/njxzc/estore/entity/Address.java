package cn.njxzc.estore.entity;

import java.io.Serializable;

public class Address implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3961952459769345602L;

	private int id;
	
	private Long userId;
	
	private String passName;
	
	private String address;
	
	private String tel;
	
	private int isDefault;
	
	private int isDelete;
	
	public Address() {
		super();
	}

	public Address(int id, Long userId, String passName, String address, String tel, int isDefault, int isDelete) {
        super();
        this.id = id;
        this.userId = userId;
        this.passName = passName;
        this.address = address;
        this.tel = tel;
        this.isDefault = isDefault;
        this.isDelete = isDelete;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassName() {
		return passName;
	}

	public void setPassName(String passName) {
		this.passName = passName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", userId=" + userId + ", passName=" + passName + ", address=" + address + ", tel="
            + tel + ", isDefault=" + isDefault + ", isDelete=" + isDelete + "]";
    }
	
}
