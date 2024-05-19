package clinicmanagement.model.service;

import clinicmanagement.constant.EntityName;
import clinicmanagement.controller.database.DatabaseContext;
import clinicmanagement.model.entity.PrescriptionDetail;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Singleton
public class PrescriptionDetailService {
    @Inject @Named(EntityName.PRESCRIPTION_DETAIL)
    private ArrayList<PrescriptionDetail> listPrescriptionDetails;
    @Inject
    private DatabaseContext databaseContext;

    public void getDatabase() throws SQLException {
        Connection con = databaseContext.getConnection();
        String sqlQuery = "{CALL LayTatCaCTTT()}";
        CallableStatement stm = con.prepareCall(sqlQuery);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            PrescriptionDetail prescriptionDetail = new PrescriptionDetail(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3)
            );
            listPrescriptionDetails.add(prescriptionDetail);
        }
        con.close();
    }

    public void removeAllObject() {this.listPrescriptionDetails.removeAll(listPrescriptionDetails);}

    public ArrayList<Integer> getListMedicineIdByPrescriptionId(int id) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (PrescriptionDetail prescriptionDetail : listPrescriptionDetails) {
            if (prescriptionDetail.getPrescriptionId() == id) {
                list.add(prescriptionDetail.getMedicineId());
            }
        }
        return list;
    }

    public ArrayList<Integer> getListAmountByPrescriptionId(int id) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (PrescriptionDetail prescriptionDetail : listPrescriptionDetails) {
            if (prescriptionDetail.getPrescriptionId() == id) {
                list.add(prescriptionDetail.getAmount());
            }
        }
        return list;
    }
}