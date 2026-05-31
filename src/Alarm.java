import java.time.LocalTime;
import java.util.UUID;

public class Alarm {
    // Atributos privados para garantizar la encapsulación
    private String id;
    private LocalTime time;
    private String label;
    private boolean isActive;
    
    // Constructor
    public Alarm(LocalTime time, String label) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único automáticamente
        this.time = time;
        this.label = label;
        this.isActive = true; // Por defecto, al crearla está activa
    }

    // Métodos públicos (Getters y lógica básica)
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

    @Override
    public String toString() {
        String status = isActive ? "[ON]" : "[OFF]";
        return status + " " + time.toString() + " - " + label;
    }
}