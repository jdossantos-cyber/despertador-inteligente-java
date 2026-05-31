# ⏰ Sistema de Despertador Inteligente (Lógica en Java)

## 1. Descripción del proyecto
Implementación de la lógica interna (Core de Negocio) de una aplicación de despertador inteligente, inspirada en los sistemas de los smartphones modernos. El proyecto se centra en el diseño de software orientado a objetos puro, sin interfaz gráfica, gestionando desde alarmas recurrentes hasta funcionalidades avanzadas como el modo circadiano o la resolución de retos matemáticos.

## 2. Objetivos
*   **Técnicos:** Analizar requisitos funcionales y abstraer las funcionalidades en un modelo de clases robusto.
*   **Arquitectura:** Implementar la lógica de negocio totalmente desacoplada de la interfaz visual.
*   **Metodología:** Aplicar buenas prácticas de programación (SOLID, encapsulación), control de versiones profesional con Git/GitHub y documentación técnica.
*   **Productividad:** Utilizar herramientas de IA generativa de forma responsable y validada para asistir el desarrollo.

## 3. Tecnologías utilizadas
*   **Lenguaje:** Java
*   **Control de Versiones:** Git y GitHub (Flujo de trabajo mediante ramas y Pull Requests)
*   **Diseño UML:** PlantUML / Mermaid
*   **Documentación:** Markdown

## 4. Instalación y ejecución
*(Esta sección se completará cuando tengamos la clase Main configurada)*
1. Clonar el repositorio: `git clone [url-del-repositorio]`
2. Abrir el proyecto en un IDE compatible con Java (VS Code, IntelliJ, Eclipse).
3. Ejecutar el archivo `Main.java` ubicado en la ruta `src/main/...`

## 5. Estructura del proyecto
*   `/src`: Código fuente en Java.
*   `/docs`: Especificaciones de casos de uso y diagramas detallados.
*   `/tests`: Pruebas de funcionamiento (si procede).
*   `README.md`: Documentación principal.

---

## 6. Diseño orientado a objetos
*(Aquí explicaremos las decisiones arquitectónicas: por qué existen las clases, cuáles son sus responsabilidades, relaciones y cómo se maneja la visibilidad de los atributos).*


## 7. Diagrama de clases UML

```mermaid
classDiagram
    class AlarmManager {
        -List~Alarm~ alarms
        -SleepStatistics stats
        +addAlarm(Alarm a)
        +removeAlarm(String id)
        +toggleAlarm(String id)
        +getUpcomingAlarms() List~Alarm~
        +checkConflicts(Alarm a) boolean
    }

    class Alarm {
        -String id
        -LocalTime time
        -String label
        -boolean isActive
        -boolean[] repeatDays
        -SoundProfile sound
        -SnoozeManager snoozeManager
        +trigger()
        +stop()
        +snooze()
    }

    class SoundProfile {
        -String toneName
        -int volumeLevel
        -boolean dynamicWeatherSound
        +play()
        +increaseVolumeGradually()
    }

    class SnoozeManager {
        -int snoozeDurationMinutes
        -int maxSnoozeCount
        -int currentSnoozeCount
        +canSnooze() boolean
        +executeSnooze()
    }

    class SleepStatistics {
        -int totalHoursSlept
        -int totalSnoozes
        +recordSnooze()
        +recordWakeUpTime(LocalTime time)
        +generateReport() String
    }

    class MathChallenge {
        -String difficulty
        +generateProblem() String
        +verifyAnswer(int answer) boolean
    }

    class CircadianMode {
        -int fadeUpDurationMinutes
        -int currentBrightness
        +simulateSunrise()
        +triggerProgressiveWakeUp()
    }

    AlarmManager "1" *-- "*" Alarm : gestiona
    AlarmManager "1" --> "1" SleepStatistics : registra
    Alarm "1" *-- "1" SoundProfile : contiene
    Alarm "1" *-- "1" SnoozeManager : maneja
    Alarm <|-- MathChallenge : extiende (reto para apagar)
    Alarm <|-- CircadianMode : extiende (despertar gradual)

## 8. Casos de Uso
flowchart LR
    Actor((Usuario))

    %% Casos de Uso Principales
    Crear[Crear Alarma]
    Gestionar[Activar/Desactivar/Eliminar Alarma]
    Configurar[Configurar Sonido y Repetición]
    Posponer[Posponer Alarma snooze]
    Detener[Detener Alarma]
    Consultar[Consultar Próximas Alarmas]
    Stats[Consultar Estadísticas de Sueño]

    %% Funcionalidades Avanzadas
    Reto[Resolver Reto Matemático]
    Circadiano[Configurar Modo Circadiano]

    %% Relaciones del Actor
    Actor --> Crear
    Actor --> Gestionar
    Actor --> Posponer
    Actor --> Detener
    Actor --> Consultar
    Actor --> Stats

    %% Relaciones Include y Extend
    Crear -. "<< include >>" .-> Configurar
    Detener -. "<< extend >>" .-> Reto
    Crear -. "<< extend >>" .-> Circadiano
    
## 9. Reflexión técnica
### Especificación Detallada de Casos de Uso

| Caso de Uso | CU-01: Crear Alarma |
| :--- | :--- |
| **Objetivo** | Configurar una nueva alarma en el sistema especificando hora, repetición y sonido. |
| **Actor principal** | Usuario |
| **Precondiciones** | El sistema (`AlarmManager`) está inicializado. |
| **Flujo principal** | 1. El usuario solicita crear una nueva alarma.<br>2. Introduce la hora y los minutos.<br>3. Selecciona los días de repetición.<br>4. Elige un perfil de sonido y volumen.<br>5. El sistema guarda la alarma y la marca como activa. |
| **Flujos alternativos** | 3a. El usuario no selecciona días de repetición: La alarma se configura para sonar una única vez (próximas 24h).<br>5a. Conflicto de horario: El sistema detecta otra alarma a la misma hora y lanza una advertencia. |
| **Postcondiciones** | La alarma queda registrada en la lista de alarmas y programada para sonar. |
| **Reglas de negocio** | No se permite crear dos alarmas con la misma configuración exacta (hora y días de repetición). |

<br>

| Caso de Uso | CU-02: Resolver Reto Matemático (Funcionalidad Avanzada) |
| :--- | :--- |
| **Objetivo** | Obligar al usuario a resolver un problema matemático para poder detener la alarma, asegurando que está despierto. |
| **Actor principal** | Usuario |
| **Precondiciones** | Una alarma con la funcionalidad de "Reto Matemático" activada está sonando. |
| **Flujo principal** | 1. El usuario intenta detener la alarma.<br>2. El sistema genera y muestra una operación matemática aleatoria.<br>3. El usuario introduce el resultado correcto.<br>4. La alarma se detiene completamente. |
| **Flujos alternativos** | 3a. El usuario introduce un resultado incorrecto: El sistema indica error, la alarma sigue sonando y genera un nuevo reto matemático. |
| **Postcondiciones** | La alarma pasa a estado inactivo y se registra el evento en las estadísticas de sueño. |
| **Reglas de negocio** | El volumen del sonido no se puede reducir ni silenciar mientras el reto matemático no haya sido resuelto. |

## 10. Reflexión sobre IA
*(Sección reservada para documentar las herramientas de IA utilizadas, prompts exactos, partes de código generadas, errores detectados y cómo se validó manualmente el resultado).*