package gui.curriculum;

/**
 * Sample Skeleton for 'curriculumView.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class Controller {

	private int etcs = 0;

	public int getEtcs() {
		return etcs;
	}

	public void setEtcs(int etcs) {
		this.etcs = etcs;
	}

	@FXML // fx:id="javaTG"
	private ToggleButton javaTG; // Value injected by FXMLLoader

	@FXML // fx:id="gdmTG"
	private ToggleButton gdmTG; // Value injected by FXMLLoader

	@FXML // fx:id="sysadTG"
	private ToggleButton sysadTG; // Value injected by FXMLLoader

	@FXML // fx:id="dsTG"
	private ToggleButton dsTG; // Value injected by FXMLLoader

	@FXML // fx:id="dmTG"
	private ToggleButton dmTG; // Value injected by FXMLLoader

	@FXML // fx:id="rnTG"
	private ToggleButton rnTG; // Value injected by FXMLLoader

	@FXML // fx:id="laTG"
	private ToggleButton laTG; // Value injected by FXMLLoader

	@FXML // fx:id="setTG"
	private ToggleButton setTG; // Value injected by FXMLLoader

	@FXML // fx:id="daTG"
	private ToggleButton daTG; // Value injected by FXMLLoader

	@FXML // fx:id="wtTG"
	private ToggleButton wtTG; // Value injected by FXMLLoader

	@FXML // fx:id="thiTG"
	private ToggleButton thiTG; // Value injected by FXMLLoader

	@FXML // fx:id="smTG"
	private ToggleButton smTG; // Value injected by FXMLLoader

	@FXML // fx:id="gboTG"
	private ToggleButton gboTG; // Value injected by FXMLLoader

	@FXML // fx:id="omTG"
	private ToggleButton omTG; // Value injected by FXMLLoader

	@FXML // fx:id="gdgTG"
	private ToggleButton gdgTG; // Value injected by FXMLLoader

	@FXML // fx:id="weTG"
	private ToggleButton weTG; // Value injected by FXMLLoader

	@FXML // fx:id="bidTG"
	private ToggleButton bidTG; // Value injected by FXMLLoader

	@FXML // fx:id="bvgTG"
	private ToggleButton bvgTG; // Value injected by FXMLLoader

	@FXML // fx:id="wp2TG"
	private ToggleButton wp2TG; // Value injected by FXMLLoader

	@FXML // fx:id="wp1TG"
	private ToggleButton wp1TG; // Value injected by FXMLLoader

	@FXML // fx:id="waTG"
	private ToggleButton waTG; // Value injected by FXMLLoader

	@FXML // fx:id="mpTG"
	private ToggleButton mpTG; // Value injected by FXMLLoader

	@FXML // fx:id="fsTG"
	private ToggleButton fsTG; // Value injected by FXMLLoader

	@FXML // fx:id="eicTG"
	private ToggleButton eicTG; // Value injected by FXMLLoader

	@FXML // fx:id="wp3TG"
	private ToggleButton wp3TG; // Value injected by FXMLLoader

	@FXML // fx:id="englischTG"
	private ToggleButton englischTG; // Value injected by FXMLLoader

	@FXML // fx:id="wp5TG"
	private ToggleButton wp5TG; // Value injected by FXMLLoader

	@FXML // fx:id="wp4TG"
	private ToggleButton wp4TG; // Value injected by FXMLLoader

	@FXML // fx:id="wp6TG"
	private ToggleButton wp6TG; // Value injected by FXMLLoader

	@FXML // fx:id="iteamTG"
	private ToggleButton iteamTG; // Value injected by FXMLLoader

	@FXML // fx:id="abschlussTG"
	private ToggleButton abschlussTG; // Value injected by FXMLLoader

	@FXML // fx:id="erreichtLabel"
	private Label erreichtLabel; // Value injected by FXMLLoader

	@FXML // fx:id="fehlendLabel"
	private Label fehlendLabel; // Value injected by FXMLLoader

	@FXML
    public void handleJava() {
    	if (javaTG.isSelected()) {
    		this.etcs = getEtcs() + 10;
        	erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
        	fehlendLabel.setText("Fehlende ECTS Punkte: " + (180-getEtcs()) + " ");
    	}
    	if (!javaTG.isSelected()) {
    		this.etcs = getEtcs() - 10;
    		erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
    		fehlendLabel.setText("Fehlende ECTS Punkte: " + (180-getEtcs()) + " ");
    	}
    }

	@FXML
	public void handleMedienProjekt() {
		if (mpTG.isSelected()) {
			this.etcs = getEtcs() + 10;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!mpTG.isSelected()) {
			this.etcs = getEtcs() - 10;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}

	@FXML
	public void handleTeamprojekt() {
		if (iteamTG.isSelected()) {
			this.etcs = getEtcs() + 10;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!iteamTG.isSelected()) {
			this.etcs = getEtcs() - 10;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}

	@FXML
	public void handleAbschluss() {
		if (abschlussTG.isSelected()) {
			this.etcs = getEtcs() + 15;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!abschlussTG.isSelected()) {
			this.etcs = getEtcs() - 15;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}

	@FXML
	public void handleWP1(){
		if (wp1TG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wp1TG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWP2() {
		if (wp2TG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wp2TG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWP3(){
		if (wp3TG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wp3TG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWP4(){
		if (wp4TG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wp4TG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWP5(){
		if (wp5TG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wp5TG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWP6(){
		if (wp6TG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wp6TG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleEnglisch(){
		if (englischTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!englischTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWiArbeit(){
		if (waTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!waTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleFachseminar(){
		if (fsTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!fsTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWebEntwicklung(){
		if (weTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!weTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleGBO(){
		if (gboTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!gboTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleSoftwareManagement(){
		if (smTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!smTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleTheoretischeInformatik(){
		if (thiTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!thiTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleEinführungInComputergrafik(){
		if (eicTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!eicTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleDatenstrukturenUndAlgorithmen(){
		if (daTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!daTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleSoftwarEntwurfTest(){
		if (setTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!setTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleLinAlg(){
		if (laTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!laTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleRechnernetze(){
		if (rnTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!rnTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleGrundlageGestaltung(){
		if (gdgTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!gdgTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleOnlineMedienrecht(){
		if (omTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!omTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleWebTechnologien(){
		if (wtTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!wtTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleBenutzungGestaltung(){
		if (bvgTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!bvgTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleBenutzerInterfaceDesign(){
		if (bidTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!bidTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleSysadmin(){
		if (sysadTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!sysadTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	
	@FXML
	public void handleGrundLMathe(){
		if (gdmTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!gdmTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleDS(){
		if (dsTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!dsTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
	@FXML
	public void handleDM(){
		if (dmTG.isSelected()) {
			this.etcs = getEtcs() + 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
		if (!dmTG.isSelected()) {
			this.etcs = getEtcs() - 5;
			erreichtLabel.setText("Erreichte ECTS Punkte: " + getEtcs() + " ");
			fehlendLabel.setText("Fehlende ECTS Punkte: " + (180 - getEtcs()) + " ");
		}
	}
}
