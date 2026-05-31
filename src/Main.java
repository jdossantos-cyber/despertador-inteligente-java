import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Despertador Inteligente...\n");

        AlarmManager manager = new AlarmManager();

        Alarm alarm1 = new Alarm(LocalTime.of(7, 30), "Despertar para clase");
        manager.addAlarm(alarm1);

        manager.printUpcomingAlarms();

        // Simulamos que suena la alarma y el usuario la pospone
        System.out.println("¡RIIIING! Suena la alarma.");
        alarm1.snooze(); // Posposición 1
        alarm1.snooze(); // Posposición 2
        alarm1.snooze(); // Posposición 3 (Última permitida)
        
        // Esta vez debería bloquearlo porque superó el límite
        alarm1.snooze(); 
    }
}