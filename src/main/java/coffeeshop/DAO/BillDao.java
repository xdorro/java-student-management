package coffeeshop.DAO;

import coffeeshop.DTO.Bill;
import coffeeshop.Utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillDao implements GenericDao<Bill> {

    @Override
    public List<Bill> getAll() {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM Products";

        try (Connection conn = new DbUtil().getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bill obj = new Bill(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("table_id"),
                        rs.getFloat("total_price"),
                        rs.getFloat("discount"),
                        rs.getNString("note"),
                        rs.getBoolean("status"),
                        rs.getString("created_at")
                );
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Map<String, Object> create(Bill bill) {
        Map<String, Object> output = new HashMap<>();
        String sql = "{CALL sp_insertBill(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = new DbUtil().getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, bill.getUser_id());
            cs.setInt(2, bill.getTable_id());
            cs.setFloat(3, bill.getTotal_price());
            cs.setFloat(4, bill.getDiscount());
            cs.setNString(5, bill.getNote());
            cs.setBoolean(6, bill.isStatus());
            cs.registerOutParameter(7, Types.BIT);
            cs.registerOutParameter(8, Types.NVARCHAR);
            cs.execute();

            output.put("status", cs.getBoolean(7));
            output.put("message", cs.getNString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    @Override
    public Bill read(int id) {
        Bill obj = null;
        String sql = "SELECT * FROM Orders WHERE id = ?";

        try (Connection conn = new DbUtil().getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    obj = new Bill(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("table_id"),
                            rs.getFloat("total_price"),
                            rs.getFloat("discount"),
                            rs.getNString("note"),
                            rs.getBoolean("status"),
                            rs.getString("created_at")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public Map<String, Object> update(Bill bill) {
        Map<String, Object> output = new HashMap<>();
        String sql = "{CALL sp_updateBill(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = new DbUtil().getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, bill.getId()); 
            cs.setInt(2, bill.getUser_id());
            cs.setInt(3, bill.getTable_id());
            cs.setFloat(4, bill.getTotal_price());
            cs.setFloat(5, bill.getDiscount());
            cs.setNString(6, bill.getNote());
            cs.setBoolean(7, bill.isStatus());
            cs.registerOutParameter(8, Types.BIT);
            cs.registerOutParameter(9, Types.NVARCHAR);
            cs.execute();

            output.put("status", cs.getBoolean(8));
            output.put("message", cs.getNString(9));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    @Override
    public Map<String, Object> delete(int id) {
        return null;
    }

    public Bill getBillByTableId(int table_id, Boolean status) {
        Bill obj = null;
        String sql = "{CALL sp_getBillByTableId(?, ?)}";

        try (Connection conn = new DbUtil().getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, table_id);

            if (status == null) {
                cs.setNull(2, Types.BOOLEAN);
            } else {
                cs.setBoolean(2, status);
            }

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    obj = new Bill(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("table_id"),
                            rs.getFloat("total_price"),
                            rs.getFloat("discount"),
                            rs.getNString("note"),
                            rs.getBoolean("status"),
                            rs.getString("created_at")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
