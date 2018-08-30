package game.model;

public class AccountUpgradeEntity {
    Integer id;
    Integer accountId;
    Integer upgradeId;

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

    @Override
    public String toString() {
        return "AccountUpgradeEntity{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", upgradeId=" + upgradeId +
                '}';
    }
}
