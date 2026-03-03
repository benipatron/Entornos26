# Informe Técnico - Incidencia Formulario de Contacto

## 1. Descripción del problema
[cite_start]El cliente reporta que el formulario se procesa con éxito incluso cuando los campos obligatorios (Nombre y Email) están vacíos[cite: 23, 24].

## 2. Cómo se reproduce
1. [cite_start]Ejecutar la aplicación mediante la clase `MainApp`[cite: 76].
2. [cite_start]Sin introducir datos en los campos de texto, pulsar el botón de envío[cite: 77].
3. [cite_start]Observar que el sistema muestra un mensaje de éxito sin realizar validaciones[cite: 78, 80].

## 3. Análisis técnico (Uso del Debugger)
[cite_start]Tras colocar un punto de interrupción (breakpoint) en la línea 15 de `UserController.java`, se ha observado lo siguiente durante la ejecución en modo Debug[cite: 83, 86, 91]:
* [cite_start]Los parámetros `name` y `email` llegan al método `createUser` como cadenas vacías (`""`)[cite: 92].
* [cite_start]El flujo de ejecución es lineal; el programa salta directamente a la invocación de `userService.addUser()` sin evaluar el contenido de las variables[cite: 93, 94].

## 4. Causa raíz
La incidencia se debe a la **ausencia de una estructura de control condicional** en la capa del controlador. [cite_start]El sistema no tiene implementadas restricciones que intercepten datos nulos o vacíos antes de enviarlos a la capa de servicio[cite: 107].

## 5. Propuesta de solución
Incorporar una validación mediante una sentencia `if` que verifique si las variables están vacías (ej: `name.isEmpty()`). [cite_start]En caso afirmativo, se deberá interrumpir el proceso y notificar al usuario, evitando que se ejecute la línea de creación del objeto[cite: 108, 115, 116].