package bean;
// 管理员
public class Administrator {
    private Integer administratorId;
    private String administratorName;
    private String password;

    public Administrator(Integer administratorId, String administratorName, String password) {
        this.administratorId = administratorId;
        this.administratorName = administratorName;
        this.password = password;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
