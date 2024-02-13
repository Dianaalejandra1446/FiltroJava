
package com.campusland.respository.impl.implDIAN;

import com.campusland.respository.RepositoryImpuestoRef;
import com.campusland.respository.models.Impuesto_ref;
import com.campusland.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryImpuesto_ref implements RepositoryImpuestoRef<Impuesto_ref>{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }
    
    private Impuesto_ref crearImpuesto_ref (ResultSet rs) throws SQLException{
        Impuesto_ref iref =new Impuesto_ref();
        iref.setId(rs.getInt("id_ref"));
        iref.setPeriodo_fiscal(rs.getDate("periodo_fiscal").toLocalDate());
        iref.setAnnio(rs.getDouble("año"));
        iref.setPorcentaje(rs.getDouble("porcentaje"));
        
        return iref;
    }

    @Override
    public Impuesto_ref porCodigo(int id) {
        Impuesto_ref iref = null;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM impuesto_ref WHERE  id_impuesto = ?;")) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    iref = crearImpuesto_ref(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del cliente: " + id);
            e.printStackTrace();
        }
        return iref;        
    }

    @Override
    public void guardar(Impuesto_ref entidad) {
        
    }
    
     
}
