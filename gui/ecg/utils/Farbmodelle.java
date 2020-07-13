package gui.ecg.utils;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMLeaf;

public class Farbmodelle {

	private static float[] CMYK = new float[4]; // Subtraktiv von Weiﬂ wird abgezogen
	private static float[] CMY = new float[3]; // Subtraktiv von Weiﬂ wird abgezogen
	private static float[] RGB = new float[3]; // Additiv auf Schwarz wird Addiert
	static float k = 0.3f;
	
	public static void initFarbmodel(float[] farbmodel, float... werte) {
		if(werte.length == farbmodel.length) {
			for (int i = 0; i < werte.length; i++) {
				farbmodel[i] = werte[i];
			}
		} else {
			System.out.println("falsche anzahl an Werten");
		}
	}
	
	public static float[] convertRGB_to_CMY(float[] RGB) {
		for(int i = 0; i < RGB.length; i++) {
			CMY[i] = (1.0f - RGB[i]);
			System.out.println("RGB: " + RGB[i] + " converted to CMY: " +  CMY[i]);
		}
		return CMY;
	}
	
	
	public static float[] convertCMY_to_CMYK(float[] CMY) {
		for(int i = 0; i < CMY.length; i++) {
			for (int j = 1; j < CMY.length-1; j++) {				
				if (CMY[i] < CMY[j]) {
					k = CMY[i];
				}
				else {
					k = CMY[j];
				}
			}
		}
		for(int i = 0; i < CMY.length; i++) {
			CMYK[i] = (CMY[i]-k);
		}
		CMYK[CMYK.length-1] = k; 
		return CMYK;
	}
	
	public static float[] convertCMYK_to_CMY() {
		for(int i = 0; i <CMYK.length-1; i++) {
			CMY[i] = (CMYK[i]+k);
		}
		return CMY;
	}
	
	
	public static float[] convertCMYK_to_RGB() {
		for(int i = 0; i <CMYK.length-1; i++) {
			RGB[i] = 1.0f-(CMYK[i]+k);
		}
		return RGB;
	}
	
	public static void main(String[] args) {
//		initFarbmodel(RGB, 0.2f, 0.5f, 0.7f);
		initFarbmodel(CMYK, 0.5f, 0.2f, 0.0f, 0.3f);
		convertCMYK_to_RGB();
		convertCMYK_to_CMY();
//		convertRGB_to_CMY(RGB);
//		convertCMY_to_CMYK(CMY);
		for(float f : CMY) {
			System.out.println(f + " CMY");
		}
	}
	
}
