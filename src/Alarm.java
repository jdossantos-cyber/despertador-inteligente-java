import java.time.LocalTime;
import java.util.UUID;

public class Alarm {
    private String id;
    private LocalTime time;
    private String label;
    private boolean isActive;
    
    // Aquí aplicamos la composición
    private SnoozeManager snoozeManager;
    
    public Alarm(LocalTime time, String label) {
        this.id = UUID.randomUUID().toString();
        this.time = time;
        this.label = label;
        this.isActive = true; 
        
        // Configuramos por defecto: posponer 5 minutos, máximo 3 veces
        this.snoozeManager = new SnoozeManager(5, 3);
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

    // Nuevo método para posponer
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