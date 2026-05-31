public class SnoozeManager {
    private int snoozeDurationMinutes;
    private int maxSnoozeCount;
    private int currentSnoozeCount;

    public SnoozeManager(int snoozeDurationMinutes, int maxSnoozeCount) {
        this.snoozeDurationMinutes = snoozeDurationMinutes;
        this.maxSnoozeCount = maxSnoozeCount;
        this.currentSnoozeCount = 0;
    }

    public boolean canSnooze() {
        return currentSnoozeCount < maxSnoozeCount;
    }

    public void executeSnooze() {
        if (canSnooze()) {
            currentSnoozeCount++;
            System.out.println("Alarma pospuesta por " + snoozeDurationMinutes + " minutos. (Posposición " + currentSnoozeCount + "/" + maxSnoozeCount + ")");
        } else {
            System.out.println("No puedes posponer más veces. ¡Es hora de levantarse!");
        }
    }
    
    public void resetSnooze() {
        this.currentSnoozeCount = 0;
    }
}
