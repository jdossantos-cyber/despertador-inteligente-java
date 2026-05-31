import java.time.LocalTime;
import java.util.Random;

public class MathChallenge extends Alarm {
    private String difficulty;
    private int expectedAnswer;
    private boolean isChallengeSolved;

    // Constructor
    public MathChallenge(LocalTime time, String label, String difficulty) {
        super(time, label); // Hereda los atributos básicos de Alarm
        this.difficulty = difficulty;
        this.isChallengeSolved = false;
    }

    // Genera una suma aleatoria simple
    public String generateProblem() {
        Random rand = new Random();
        int a = rand.nextInt(10) + 1; // Número del 1 al 10
        int b = rand.nextInt(10) + 1;
        this.expectedAnswer = a + b;
        return "¿Para apagar la alarma, cuánto es " + a + " + " + b + "?";
    }

    // Verifica si el usuario ha acertado
    public boolean verifyAnswer(int answer) {
        if (answer == expectedAnswer) {
            this.isChallengeSolved = true;
            System.out.println("✅ ¡Correcto! Alarma detenida.");
            // Si acierta, apagamos la alarma llamando al método del padre
            if (isActive()) {
                super.toggleActive(); 
            }
            return true;
        } else {
            System.out.println("❌ Respuesta incorrecta. ¡La alarma sigue sonando!");
            return false;
        }
    }

    // Sobrescribimos el método original para BLOQUEAR que se apague normal
    @Override
    public void toggleActive() {
        if (isActive() && !isChallengeSolved) {
            System.out.println("⚠️ BLOQUEADO: No puedes apagar '" + getLabel() + "' sin resolver el reto matemático primero.");
        } else {
            super.toggleActive();
        }
    }
}