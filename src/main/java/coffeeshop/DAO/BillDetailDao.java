package coffeeshop.DAO;

import coffeeshop.DTO.Bill;
import coffeeshop.DTO.BillDetail;
import coffeeshop.Utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillDetailDao implements GenericDao<BillDetail> {

    @Override
    public List<BillDetail> getAll() {
        return null;
    }

    public List<BillDetail> getAllByBillId(int bill_id) {
        List<BillDetail> obj = new ArrayList<>();
        String sql = "{CALL sp_getBillDetailByBillId(?)}";

        try ( Connection conn = new DbUtil().getInstance().getConnection();  CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, bill_id);

            try ( ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    BillDetail billDetail = new BillDetail(
                            rs.getInt("bill_id"),
                            rs.getInt("product_id"),
                            rs.getInt("amount"),
                            rs.getNString("product_name"),
                            rs.getFloat("product_price")
                    );

                    obj.add(billDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public Map<String, Object> create(BillDetail billDetail) {
        Map<String, Object> output = new HashMap<>();
        String sql = "{CALL sp_insertBillDetail(?, ?, ?, ?, ?)}";

        try ( Connection conn = new DbUtil().getInstance().getConnection();  CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, billDetail.getBill_id());
            cs.setInt(2, billDetail.getProduct_id());
            cs.setInt(3, billDetail.getAmount());
            cs.registerOutParameter(4, Types.BIT);
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.execute();

            output.put("status", cs.getBoolean(4));
            output.put("message", cs.getNString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    @Override
    public BillDetail read(int id) {
        return null;
    }

    @Override
    public Map<String, Object> update(BillDetail billDetail) {
        return null;
    }

    @Override
    public Map<String, Object> delete(int bill_id) {
        return null;
    }
}
