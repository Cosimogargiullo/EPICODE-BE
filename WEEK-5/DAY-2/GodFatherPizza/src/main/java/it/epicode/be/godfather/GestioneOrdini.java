package it.epicode.be.godfather;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.godfather.config.MenuConfig;
import it.epicode.be.godfather.config.OrdineConfig;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.MenuItem;
import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.Tavolo;

public class GestioneOrdini {

	private Ordine ordine;
	private AnnotationConfigApplicationContext ctx;

	public GestioneOrdini() {
		ctx = new AnnotationConfigApplicationContext(OrdineConfig.class);
		ordine = (Ordine) ctx.getBean("ordine");
		createdOrdini(ordine);
	}
	
	public void stampaOrdini() {
		System.out.println("******* Ordine id: " + ordine.getIdOrdine() + " *******");
		System.out.println("PRODOTTI");
		ordine.getMenuItems().forEach(
            (key, value)
                -> System.out.println("Prodotto: " + key.getName() + " | Nota: " + value + " ......................... $ " + key.getPrice()));
		System.out.println("Coperti: " + ordine.getNumeroCoperti() + " ......................... $ " + ordine.getPrezzoCoperto());
		System.out.println("Il Totale dell'ordine e di: $ " + ordine.getCostoTot());
		

//		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
//		System.out.println();
//
//		System.out.println("DRINK");
//		menu.getMenuDrink().forEach(p -> System.out.println(p.getMenuItemLine()));
//
//		System.out.println();
//
//		System.out.println("FRANCHISE");
//		menu.getMenuFranchise().forEach(p -> System.out.println(p.getMenuItemLine()));

	}
	public void createdOrdini(Ordine o) {
		GestioneMenu menu = new GestioneMenu();
		o.setNumeroCoperti(2);
		o.setTavolo(new Tavolo());
		o.setMenuItems(menu.getMenu().getMenuPizza().get(0),"Mozzarella di bufala");
		o.setMenuItems(menu.getMenu().getMenuPizza().get(2),"");
		o.setMenuItems(menu.getMenu().getMenuDrink().get(0),"Con Ghiaccio");
		o.setMenuItems(menu.getMenu().getMenuDrink().get(0),"Senza Ghiaccio");
		o.getTotale();
	}
}
