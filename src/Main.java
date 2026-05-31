import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Despertador Inteligente...\n");

        AlarmManager manager = new AlarmManager();

        // Creamos una alarma circadiana configurada para hacer el "amanecer" 5 minutos antes
        CircadianMode relaxAlarm = new CircadianMode(LocalTime.of(8, 0), "Despertar Zen", 5);
        manager.addAlarm(relaxAlarm);

        manager.printUpcomingAlarms();

        // Simulamos que llega la hora
        System.out.println("\n--- Simulando paso del tiempo ---");
        relaxAlarm.triggerProgressiveWakeUp();
    }
}