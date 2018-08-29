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
                        "SELECT user_id FROM Account JOIN User WHERE user.id=account.user_id;"
                );
                ResultSet rs = pstmt.executeQuery();
//                if(rs.next()) {
//                    returnResult(new AccountEntity(rs.getInt("id"),,rs.getInt("room_id"),rs.getDate("start_game_time")));
//                }
            }
        }.run();
    }

    @Override
    public AccountEntity setUserId(Integer user_id) { return null;
//        return new QueryHelper<AccountEntity>(){
//            protected void executeQuery (Statement statement, Connection connection) throws SQLException {
//                PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO Account(user_id) VALUES(?);");
//                preparedStatement.setInt(1, user_id);
//
//                }}.run();
    }
}