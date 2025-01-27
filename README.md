```mermaid
---
title: Diagrama de secuencia 
---
sequenceDiagram
    participant C as CLIENTE
    participant S as SERVIDOR

    C->>S: Registrar Cliente
    S->>C: OK
    C->>S: Esperar Mensajes
    Note right of S: Esperar 2 segundos

    loop Hasta cliente ganador
    S->>C: Valor aleatorio (1-10)
    end

    alt CLIENTE gana
        S->>C: Enhorabuena
    else CLIENTE pierde
        S->>C: Game Over
    end
```
<br><br><br><br><br>

```mermaid
---
title: Diagrama de clase
---

classDiagram
    class Cliente {
        +String nombre
        +int posicion
        +registrar()
        +recibirMensaje()
        +actualizarposicion()
    }
    
    class Servidor {
        -int tiempoEspera
        -List~Cliente~ clientesRegistrados
        +registrarCliente(nombre: String)
        +eviarPosicionAleatoria()
        +verificarGanador()
        +enviarMensajeFinJuego()
    }

    Cliente --> Servidor : registra
    Servidor --> Cliente : OK
    Servidor ..> Cliente : eviarPosicionAleatoria
    Servidor ..> Cliente : enviarMensajeFinJuego
```