package telefon.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import telefon.dao.*;
import telefon.helper.*;
import telefon.pojo.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		ArrayList<Telefon> telefon = TelefonDAO.getAll();
		for (Telefon t : telefon) {
			System.out.println(t.getId() + "   " + t.getMarca());
		}

		Telefon t1 = TelefonDAO.getById(1);
		if (t1 != null) {
			System.out.println("Telefonul cu id=1 are marca " + t1.getMarca());
		} else {
			System.out.println("Nu exista telefon cu id 1 ");
		}

		t1.setId(8);
		t1.setMarca("Samsung");
		boolean actualizat = TelefonDAO.update(t1);
		if (actualizat == true) {
			System.out.println("Telefonul a fost actualizat");
		} else {
			System.out.println("Telefonul nu a fot gasit in db");
		}
		
		String deleted = TelefonDAO.delete("iPhone");
		System.out.println(deleted);
		
		Date aparitie = new Date(System.currentTimeMillis());

		Telefon mario = new Telefon("Nokia", 7, aparitie);
		TelefonDAO.create(mario);
		 
		
		 
		TelHelper.closeConnection();
	}
}
