package it.epicode.playerMultimediale;

public interface Riproducibile {
	public static int durata = 0;
    public static int volume = 0;
    
    void play();
    void abbassaVolume();
    void alzaVolume();
}
