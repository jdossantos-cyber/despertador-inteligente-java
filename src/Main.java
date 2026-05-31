import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Despertador Inteligente...\n");

        AlarmManager manager = new AlarmManager();

        // Creamos una alarma con reto matemático
        MathChallenge mathAlarm = new MathChallenge(LocalTime.of(6, 0), "Despertar extremo", "Fácil");
        manager.addAlarm(mathAlarm);

        manager.printUpcomingAlarms();

        System.out.println("¡RIIIING! Intentando apagar la alarma de forma normal...");
        mathAlarm.toggleActive(); // Esto debería bloquearnos
        
        System.out.println("\nGenerando reto matemático...");
        System.out.println(mathAlarm.generateProblem());

        // Simulamos que el usuario falla la primera vez
        System.out.println("\nUsuario introduce: 99");
        mathAlarm.verifyAnswer(99);

        // Para simular que acierta, tendríamos que meter la respuesta correcta. 
        // Como es aleatoria en esta prueba, puedes ver que el sistema avisa del error.
    }
}