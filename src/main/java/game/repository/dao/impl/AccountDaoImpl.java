package game.repository.dao.impl;

import game.dto.UserDto;
import game.model.AccountEntity;
import game.repository.dao.AccountDao;
import game.repository.helper.QueryHelper;

import java.sql.*;

import static org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLLexer.WHERE;
import static org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.JOIN;


public class AccountDaoImpl implements AccountDao {


    @Override
    public AccountEntity getAccount(Integer accountId) {

        return new QueryHelper<AccountEntity>() {
            protected void executeQuery (Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT * FROM Account WHERE user_id = ?");
                pstmt.setInt(1, accountId);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    returnResult(getAccount(accountId));
                }
            }
        }.run();
    }

}