import java.util.ArrayList;
import java.util.List;

public class AlarmManager {
    private List<Alarm> alarms;
    private SleepStatistics stats;

    public AlarmManager() {
        this.alarms = new ArrayList<>();
        this.stats = new SleepStatistics();
    }

    public void addAlarm(Alarm a) {
        alarms.add(a);
        System.out.println("Alarma añadida exitosamente: " + a.getLabel());
    }

    public void removeAlarm(String id) {
        alarms.removeIf(alarm -> alarm.getId().equals(id));
        System.out.println("Alarma eliminada.");
    }

    public void toggleAlarm(String id) {
        for (Alarm alarm : alarms) {
            if (alarm.getId().equals(id)) {
                alarm.toggleActive();
                System.out.println("Estado modificado: " + alarm.toString());
                return;
            }
        }
        System.out.println("No se encontró la alarma con ID: " + id);
    }

    public void printUpcomingAlarms() {
        System.out.println("\n--- Próximas Alarmas ---");
        if (alarms.isEmpty()) {
            System.out.println("No hay alarmas configuradas.");
        } else {
            for (Alarm alarm : alarms) {
                System.out.println(alarm.toString());
            }
        }
        System.out.println("------------------------\n");
    }

    public void printStats() {
        System.out.println(stats.generateReport());
    }
}