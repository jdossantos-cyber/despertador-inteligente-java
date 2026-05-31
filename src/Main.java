import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Despertador Inteligente...\n");

        AlarmManager manager = new AlarmManager();

        // 1. Crear alarmas de prueba
        Alarm alarm1 = new Alarm(LocalTime.of(7, 30), "Despertar para clase");
        Alarm alarm2 = new Alarm(LocalTime.of(8, 45), "Revisión de correos");

        // 2. Añadirlas al gestor
        manager.addAlarm(alarm1);
        manager.addAlarm(alarm2);

        // 3. Consultar las alarmas
        manager.printUpcomingAlarms();

        // 4. Probar a desactivar una alarma
        System.out.println("Desactivando alarma de revisión de correos...");
        manager.toggleAlarm(alarm2.getId());

        // 5. Volver a consultar para ver el cambio a [OFF]
        manager.printUpcomingAlarms();
    }
}