import java.time.LocalTime;

public class SleepStatistics {
    private int totalHoursSlept;
    private int totalSnoozes;

    public SleepStatistics() {
        this.totalHoursSlept = 0;
        this.totalSnoozes = 0;
    }

    public void recordSnooze() {
        this.totalSnoozes++;
    }

    public void recordWakeUpTime(LocalTime time) {
        System.out.println("📊 Registro guardado: Usuario despertó a las " + time);
        // Aquí en el futuro se calcularían las horas dormidas según la hora a la que se acostó
        this.totalHoursSlept += 8; 
    }

    public String generateReport() {
        return "--- REPORTE DE SUEÑO ---\n" +
               "Horas estimadas de sueño: " + totalHoursSlept + "h\n" +
               "Veces que pospuso la alarma: " + totalSnoozes + "\n" +
               "------------------------";
    }
}