
package com.campusland.utils.conexionpersistencia.conexionbdjson;

import com.campusland.respository.models.Impuesto_ref;

public class ConexionBDJsonImpuesto_ref extends ConexionBDJsonBase<Impuesto_ref>{

    private static ConexionBDJsonClientes conexionRef;

    private ConexionBDJsonImpuesto_ref() {
        super("impuesto_ref.json");
    }

    public static ConexionBDJsonClientes getConexion() {
        if (conexionRef != null) {
            return conexionRef;
        } else {
            conexionRef = new ConexionBDJsonImpuesto_ref();
            return conexionRef;
        }
    }
    
}
    

