public class SoundProfile {
    private String toneName;
    private int volumeLevel;
    private boolean dynamicWeatherSound;

    public SoundProfile(String toneName, int volumeLevel, boolean dynamicWeatherSound) {
        this.toneName = toneName;
        this.volumeLevel = volumeLevel;
        this.dynamicWeatherSound = dynamicWeatherSound;
    }

    public void play() {
        System.out.println("🔊 Reproduciendo tono: " + toneName + " al " + volumeLevel + "% de volumen.");
        if (dynamicWeatherSound) {
            System.out.println("🌧️ Sonido de fondo adaptado al clima actual activado.");
        }
    }

    public void increaseVolumeGradually() {
        if (volumeLevel < 100) {
            volumeLevel += 10;
            System.out.println("Subiendo volumen... " + volumeLevel + "%");
        }
    }
}