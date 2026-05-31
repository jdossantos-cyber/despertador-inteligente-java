import java.time.LocalTime;

public class CircadianMode extends Alarm {
    private int fadeUpDurationMinutes;
    private int currentBrightness;

    public CircadianMode(LocalTime time, String label, int fadeUpDurationMinutes) {
        super(time, label);
        this.fadeUpDurationMinutes = fadeUpDurationMinutes;
        this.currentBrightness = 0; // Empieza a oscuras
    }

    public void simulateSunrise() {
        System.out.println("☀️ Iniciando simulación de amanecer para la alarma: " + getLabel());
        
        // Simulamos el incremento de luz en pasos
        int step = 100 / fadeUpDurationMinutes; 
        
        for (int i = 1; i <= fadeUpDurationMinutes; i++) {
            currentBrightness += step;
            if (currentBrightness > 100) currentBrightness = 100;
            System.out.println("Minuto -" + (fadeUpDurationMinutes - i) + " antes de sonar: Brillo de la pantalla al " + currentBrightness + "%");
        }
    }

    public void triggerProgressiveWakeUp() {
        if (isActive()) {
            simulateSunrise();
            System.out.println("⏰ ¡RIIING! Sonido suave activado a la hora exacta: " + getTime());
        }
    }
}