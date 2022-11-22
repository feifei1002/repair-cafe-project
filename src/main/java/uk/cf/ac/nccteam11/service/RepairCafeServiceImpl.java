package uk.cf.ac.nccteam11.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.domain.RepairCafe;

import java.util.List;

@Service
public class RepairCafeServiceImpl implements RepairCafeService {

    private final JdbcTemplate jdbc;
    private RowMapper<RepairCafe> repairCafeMapper;

    public RepairCafeServiceImpl(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
        setRepairCafeRowMapper();

    }

    private void setRepairCafeRowMapper() {
        repairCafeMapper = (rs, i) -> new RepairCafe(
                rs.getString("name"),
                rs.getString("cafe_id"),
                rs.getString("address")
        );
    }

    @Override
    public List<RepairCafe> getRepairCafes() {
        String allRepairCafesSQL = "select * from repair_cafe";
        return jdbc.query(allRepairCafesSQL, repairCafeMapper);
    }
}
