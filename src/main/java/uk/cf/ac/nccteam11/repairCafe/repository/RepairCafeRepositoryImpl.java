package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.List;

@Repository
public class RepairCafeRepositoryImpl implements RepairCafeRepository {
    private final JdbcTemplate jdbc;
    private RowMapper<RepairCafe> repairCafeMapper;

    public RepairCafeRepositoryImpl(JdbcTemplate jdbcTemplate) {
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
