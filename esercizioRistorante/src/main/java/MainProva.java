import it.alfasoft.andrea.bean.Prodotto;
import it.alfasoft.andrea.bean.Ristorante;
import it.alfasoft.andrea.dao.RistoranteDao;

public class MainProva {

	public static void main(String[] args) {
	
	Ristorante r= new Ristorante("RistoranteAndrea");
	Prodotto p=new Prodotto("Pasta",3.50);
	
	r.addPrimo(p);
	
	
	RistoranteDao rDao= new RistoranteDao();
	rDao.aggiungiRistorante(r);
//	rDao.aggiornaRistorante(r);
	
	}
}
