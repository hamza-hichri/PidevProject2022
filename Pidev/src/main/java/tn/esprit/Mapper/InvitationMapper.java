package tn.esprit.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tn.esprit.Entities.Invitation;

public class InvitationMapper implements RowMapper<Invitation>{

	@Override
	public Invitation mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return Invitation
				.builder()
				.orderId(rs.getLong("order_id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .email(rs.getString("email"))
                .cost(rs.getString("cost"))
                .itemId(rs.getString("item_id"))
                .itemName(rs.getString("item_name"))
                .shipDate(rs.getDate("ship_date"))
                .status(rs.getBoolean("status"))
                .emailSent(rs.getBoolean("email_sent"))
               .build();
			
	}

}
