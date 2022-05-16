import java.sql.*;
public class prova_db {
    public static void main (String args[]) {
        try {
// Carichiamo un driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
// Creiamo la stringa di connessione
            String url = "jdbc:mysql://localhost:3306/rubrica";
// Creiamo un oggetto Statement per poter interrogare il db
            try (// Otteniamo una connessione con username e password
                 Connection con = DriverManager.getConnection (url, "root", ""); // Creiamo un oggetto Statement per poter interrogare il db
                 Statement cmd = con.createStatement ()) {
                // Eseguiamo una query e immagazziniamone i risultati
                // in un oggetto ResultSet
                String qry = "SELECT anagrafica_clienti.id_anagrafica,anagrafica_clienti.ragione_sociale,anagrafica_clienti.localita,vendite.id_vendita,vendite.descrizione,vendite.metodo_di_pagament \n" +
                        "FROM anagrafica_clienti \n" +
                        "    \t\tINNER JOIN vendite ON anagrafica_clienti.id_vendita = vendite.id_vendita;";
// Stampiamone i risultati riga per riga
                try (ResultSet res = cmd.executeQuery(qry)) {
                    // Stampiamone i risultati riga per riga
                    while (res.next()) {
                        System.out.println(res.getString("anagrafica_clienti.id_anagrafica"));
                        System.out.println(res.getString("anagrafica_clienti.ragione_sociale"));
                        System.out.println(res.getString("anagrafica_clienti.localita"));
                        System.out.println(res.getString("vendite.id_vendita"));
                        System.out.println(res.getString("vendite.descrizione"));
                        System.out.println(res.getString("vendite.metodo_di_pagament"));


                    }   }
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
    }
}



