package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.CouponTicket;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CouponTicketJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void insertCouponTicket(List<CouponTicket> couponTicketList) {
        jdbcTemplate.batchUpdate("insert into coupon_ticket (user_id, coupon_id, created_at, updated_at) values (?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        CouponTicket couponTicket = couponTicketList.get(i);
                        ps.setLong(1, couponTicket.getUser().getId());
                        ps.setLong(2, couponTicket.getCoupon().getId());
                        ps.setObject(3, LocalDateTime.now());
                        ps.setObject(4, LocalDateTime.now());
                    }

                    @Override
                    public int getBatchSize() {
                        return couponTicketList.size();
                    }
                });
    }

}
