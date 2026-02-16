## 🗼 Torres de Hanoi – JavaFX

Aplicación visual e interactiva del problema clásico **Torres de Hanoi**, desarrollada con **JavaFX** siguiendo una arquitectura basada en **MVC**, separación de escenas mediante `SceneManager` y un modelo de juego independiente de la vista.

El proyecto permite:

* Configurar número de **torres** y **discos**
* Visualizar la solución automática con **animaciones**
* Calcular los **movimientos mínimos**
* Resolver el problema con **3, 4 o 5 torres** usando el algoritmo óptimo

---

## Características

* 🎮 Interfaz gráfica con JavaFX
* 🎚️ Selección dinámica de:

  * Número de discos
  * Número de torres
* 🧠 Implementación del algoritmo:

  * Clásico (3 torres)
  * **Frame–Stewart** (≥4 torres)
* 🎨 Discos con colores aleatorios
* 🔢 Contador de movimientos en tiempo real
* 🧩 Separación clara entre lógica y UI:

  * `HanoiGame` → lógica del juego
  * `GameController` → render y animación

---

## ⚙️ Tecnologías usadas

* Java 17+
* JavaFX
* FXML
* CSS para estilos

---

## Cómo ejecutar

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/TU-USUARIO/torres-de-hanoi-javafx.git
```

### 2️⃣ Abrir en tu IDE

Configurar:

* SDK de Java
* Librerías de JavaFX

### 3️⃣ Ejecutar

Correr la clase:

```
Main.java
```

---

## 🎮 Cómo usar

1. Selecciona:

   * Número de torres
   * Número de discos
2. Observa el cálculo automático de movimientos mínimos
3. Presiona **Iniciar**
4. Mira la animación de la solución

---

## 🧠 Algoritmo

Se implementa el algoritmo **Frame–Stewart**, que:

1. Divide el problema en subproblemas
2. Reduce la cantidad de movimientos
3. Genera la solución óptima conocida

Ejemplo:

| Discos | 3 torres | 4 torres |
| ------ | -------- | -------- |
| 4      | 15       | 9        |

---

## 🎨 Animación

Cada movimiento:

* Se obtiene desde el modelo (`HanoiGame`)
* Se coloca en una cola de movimientos
* Se ejecuta con `Timeline` de JavaFX

---

## 👨‍💻 Autor

**Diego Ricardo Andrino Jiménez**

---

## 📄 Licencia

Este proyecto es de uso educativo y libre para modificación.

---

## ⭐ Demo visual

<img width="563" height="436" alt="image" src="https://github.com/user-attachments/assets/c51715c7-bf9e-4e89-b60e-2fefe1238b5e" />
<img width="697" height="445" alt="image" src="https://github.com/user-attachments/assets/bc2549aa-8208-441f-953a-ca11c79ab424" />
<img width="700" height="446" alt="image" src="https://github.com/user-attachments/assets/82562685-4954-420f-97a1-eeaeda0a9373" />



---

Si quieres, en el siguiente mensaje te lo preparo en versión:

* con badges
* con gifs
* con capturas organizadas
* optimizado para reclutadores (portfolio)
