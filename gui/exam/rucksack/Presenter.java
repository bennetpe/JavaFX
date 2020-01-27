package gui.exam.rucksack;

import javafx.scene.control.CheckBox;

public class Presenter {

	private View v;
	private Rucksack m;
	
	
	public void setView(View v) {
		this.v = v;
	}
	
	public void setModel(Rucksack m) {
		this.m = m;
	}
	
	public void fillBackpack() {
		 for (int i=1; i<=20; i++) { // nur adden
	            Rucksack rucksack = new Rucksack(i, "Item "+i, false);

	            // observe item's on property and display message if it changes:
	            rucksack.getIsSelected().addListener((obs, oldValue, newValue) -> {
	                System.out.println(rucksack.getGegenstand().getValue() + " changed on state from "+oldValue+" to "+newValue);
	                System.out.println("Gewicht: "+rucksack.getGewicht().getValue() + "in Rucksack");
	               if( rucksack.getIsSelected().getValue()) {
	            	   m.setAktuellesGewichte(m.getAktuellesGewichte()+rucksack.getGewicht().getValue());
	            	   v.setProgressBar(m.getAktuellesGewichte(),  m.getMaxGewicht());
	               }
	               else if (!rucksack.getIsSelected().getValue()) {
	            	   m.setAktuellesGewichte(m.getAktuellesGewichte()-rucksack.getGewicht().getValue());
	            	   v.setProgressBar(m.getAktuellesGewichte(),  m.getMaxGewicht());
	               }
	               for (Rucksack item : v.getObList()) {
					if(item.getGewicht().getValue() + m.getAktuellesGewichte() > m.getMaxGewicht()) {
//						v.getObList().remove(item);
						System.out.println(item + "zu schwer");
					
					}
				}
	                
	                System.out.println("Summe aktuelles Gewicht: " + m.getAktuellesGewichte() + " Maximales Gewicht: " + m.getMaxGewicht());
	                
	            });
	            v.getObList().add(rucksack);
	        }
	}

}
