package game.repository.dao.impl;

import game.model.AccountEntity;
import game.repository.dao.AccountDao;
import game.repository.helper.QueryHelper;
import java.sql.*;




public class AccountDaoImpl implements AccountDao{

    public AccountEntity getAccount(Integer accountId) {

        return new QueryHelper<AccountEntity>() {
            protected void executeQuery (Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT * FROM Account WHERE id = ?");
                pstmt.setInt(1, accountId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    AccountEntity account = new AccountEntity();
                            account.setId(rs.getInt("id"));
                            account.setUser(account.getUser());
                            account.setRoom(account.getRoom());
                            account.setStartGameTime(rs.getDate("start_gate_time"));
                    returnResult(account);
                }
            }
        }.run();
    }

}