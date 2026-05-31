import java.time.LocalTime;
import java.util.UUID;

public class Alarm {
    private String id;
    private LocalTime time;
    private String label;
    private boolean isActive;
    
    // Clases que componen la alarma
    private SnoozeManager snoozeManager;
    private SoundProfile sound;
    
    // Constructor
    public Alarm(LocalTime time, String label) {
        this.id = UUID.randomUUID().toString();
        this.time = time;
        this.label = label;
        this.isActive = true; 
        
        // Inicializamos las piezas (Composición)
        this.snoozeManager = new SnoozeManager(5, 3);
        this.sound = new SoundProfile("Marimba", 50, false);
    }

    public String getId() {
        return id;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getLabel() {
        return label;
    }

    public boolean isActive() {
        return isActive;
    }

    public void toggleActive() {
        this.isActive = !this.isActive;
    }

    public void snooze() {
        if (isActive) {
            System.out.println("Intentando posponer la alarma '" + label + "'...");
            snoozeManager.executeSnooze();
        } else {
            System.out.println("La alarma está desactivada, no se puede posponer.");
        }
    }

    @Override
    public String toString() {
        String status = isActive ? "[ON]" : "[OFF]";
        return status + " " + time.toString() + " - " + label;
    }
}