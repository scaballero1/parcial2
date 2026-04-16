package co.edu.poli.examen2_caballero.servicios;

import java.sql.*;
import java.util.*;

import co.edu.poli.examen2_caballero.modelo.*;

public class DAOInmueble {

    // 🔹 CREATE
    public boolean create(Inmueble i) {

        String sql = "INSERT INTO inmueble VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, i.getNumero());
            ps.setString(2, i.getFechaCompra());
            ps.setString(3, i.getEstado());

            if (i instanceof Casa) {
                ps.setString(4, "casa");
                ps.setInt(5, ((Casa) i).getCantidadPisos());
            } else if (i instanceof Apartamento) {
                ps.setString(4, "apartamento");
                ps.setInt(5, ((Apartamento) i).getNumeroPiso());
            }

            ps.setInt(6, i.getPropietario().getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 READ ALL
    public List<Inmueble> readAll() {

        List<Inmueble> lista = new ArrayList<>();

        String sql = "SELECT * FROM inmueble";

        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                String numero = rs.getString("numero");
                String fecha = rs.getString("fecha_compra");
                String estado = rs.getString("estado");
                String tipo = rs.getString("tipo");
                int valor = rs.getInt("valor");
                int propietarioId = rs.getInt("propietario_id");

                Propietario p = new Propietario(propietarioId, "Desconocido");

                if (tipo.equalsIgnoreCase("casa")) {
                    lista.add(new Casa(numero, fecha, estado, p, valor));
                } else {
                    lista.add(new Apartamento(numero, fecha, estado, p, valor));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}