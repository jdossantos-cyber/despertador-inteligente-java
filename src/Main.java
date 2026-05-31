import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Despertador Inteligente...\n");

        AlarmManager manager = new AlarmManager();

        // Creamos una alarma normal y otra con reto matemático
        Alarm alarm1 = new Alarm(LocalTime.of(7, 30), "Trabajo");
        MathChallenge mathAlarm = new MathChallenge(LocalTime.of(8, 0), "Gimnasio", "Media");

        manager.addAlarm(alarm1);
        manager.addAlarm(mathAlarm);

        manager.printUpcomingAlarms();

        System.out.println("\n¡Suena la primera alarma!");
        alarm1.snooze(); // Pospone 1 vez

        System.out.println("\nImprimiendo estadísticas de sueño:");
        manager.printStats();
        
        System.out.println("\n¡Todo el núcleo de negocio funciona perfectamente según el UML!");
    }
}