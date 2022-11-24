package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCafeRepository;

import java.util.List;

@Service
public class RepairCafeServiceImpl implements RepairCafeService {

    private final JdbcTemplate jdbc;
    private RowMapper<RepairCafeDTO> repairCafeMapper;

    public RepairCafeServiceImpl(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
        setRepairCafeRowMapper();

    }

    private void setRepairCafeRowMapper() {
        repairCafeMapper = (rs, i) -> new RepairCafeDTO(
                rs.getString("name"),
                rs.getString("cafe_id"),
                rs.getString("address")
        );
    }

    @Override
    public List<RepairCafeDTO> getRepairCafes() {
        String allRepairCafesSQL = "select * from repair_cafe";
        return jdbc.query(allRepairCafesSQL, repairCafeMapper);
    }
}
