package game.model;

public class AccountUpgradeEntity {
    Integer id;
    Integer accountId;
    Integer upgradeId;
    Integer number;

    public AccountUpgradeEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountUpgradeEntity{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", upgradeId=" + upgradeId +
                ", number=" + number +
                '}';
    }
}