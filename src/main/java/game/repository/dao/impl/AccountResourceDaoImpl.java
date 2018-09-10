package game.repository.dao.impl;
import game.model.AccountResourceEntity;
import game.repository.dao.AccountResourceDao;
import game.repository.helper.QueryHelper;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Evgen.Kaliba
 */

public class AccountResourceDaoImpl implements AccountResourceDao {

    private String calculateResourceOnAccountQuery(Integer accountId) {
        StringBuilder accountResourseQuery = new StringBuilder();
        accountResourseQuery.append("SELECT ar.resource_id, ar.number, ab.number * br.number_per_sec * 60 + ab.number * ub.percent AS num_per_min ");
        accountResourseQuery.append("FROM Account_Resource ar");
        accountResourseQuery.append("LEFT JOIN Account_Building ab ON ar.account_id = ab.account_id ");
        accountResourseQuery.append("LEFT JOIN Account_Upgrade au ON ar.account_id = au.account_id ");
        accountResourseQuery.append("LEFT JOIN Building_Resource br ON br.building_id = ab.building_id ");
        accountResourseQuery.append("LEFT JOIN Upgrade_Building ub ON ub.upgrade_id = au.upgrade_id ");
        accountResourseQuery.append("WHERE ar.account_id = " + accountId + " AND ab.account_id = " + accountId + " ");
        accountResourseQuery.append("AND br.resource_id = ar.resource_id AND ab.building_id = br.building_id ");
        accountResourseQuery.append("GROUP BY br.resource_id ");
        return accountResourseQuery.toString();
    }

    @Override
    public void clearAccountResourceList(Integer accountId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement prepStatement = connection.prepareStatement(
                        "UPDATE Account_Resource SET number=0 WHERE account_id=?;");
                prepStatement.setInt(1, accountId);
                int status = prepStatement.executeUpdate();
                connection.commit();
            }
        }.run();
    }

    @Override
    public List<AccountResourceEntity> getAccountResourceList(Integer accountId) {
        return new QueryHelper<List<AccountResourceEntity>>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountResourceEntity> accountResourceDtoList = new LinkedList<>();
                ResultSet rs = statement.executeQuery(calculateResourceOnAccountQuery(accountId));
                while(rs.next()) {
                    AccountResourceEntity accountResource = new AccountResourceEntity();
                    accountResource.setResourceId(rs.getInt("id"));
                    accountResource.setAmount(rs.getInt("number"));
                    accountResource.setNumPerMin(rs.getInt("num_per_min"));
                    accountResourceDtoList.add(accountResource);
                }
                returnResult(accountResourceDtoList);
            }
        }.run();
    }


}



