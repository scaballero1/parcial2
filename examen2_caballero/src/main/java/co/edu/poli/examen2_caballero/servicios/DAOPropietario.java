package co.edu.poli.examen2_caballero.servicios;

import java.sql.*;
import java.util.*;

import co.edu.poli.examen2_caballero.modelo.Propietario;

public class DAOPropietario {

    public List<Propietario> readAll() {

        List<Propietario> lista = new ArrayList<>();

        String sql = "SELECT * FROM propietario";

        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Propietario(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}