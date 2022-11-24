package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

import java.util.List;

@Repository
public class RepairBookingRepositoryImpl implements RepairBookingRepository{
    private final JdbcTemplate jdbc;
    private RowMapper<RepairBooking> repairBookingMapper;

    public RepairBookingRepositoryImpl(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
        setRepairBookingRowMapper();

    }

    private void setRepairBookingRowMapper() {
        repairBookingMapper = (rs, i) -> new RepairBooking(
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getDate("repairDate"),
                rs.getString("location")
        );
    }

    @Override
    public List<RepairBooking> getRepairBookings() {
        String allRepairBookingsSQL = "select * from repair_booking";
        return jdbc.query(allRepairBookingsSQL, repairBookingMapper);
    }

    @Override
    public void save(RepairBooking repairBooking) {
        String repairBookingInsertSQL = "insert into repair_booking (firstName, lastName, email, repairDate, location) values (?,?,?,?,?)";
        jdbc.update(repairBookingInsertSQL, repairBooking.getFirstName(), repairBooking.getLastName(), repairBooking.getEmail(), repairBooking.getRepairDate(), repairBooking.getLocation());
    }
}
