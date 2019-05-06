package cn.njxzc.estore.entity;

public class Role {
    
    private int id;
    
    private String roleType;

    public Role() {
        super();
    }

    public Role(int id, String roleType) {
        super();
        this.id = id;
        this.roleType = roleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", roleType=" + roleType + "]";
    }

}
