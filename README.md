# Prácticas de Programación y Estructuras de Datos
Repositorio de prácticas de laboratorio realizadas en pareja para la asignatura de Programación y Estructuras de Datos en el curso académico 2022-2023.

## Autores de las prácticas:

- Raúl Colindres de Lucas
- Alfredo Sobrados González

## Prácticas

1. **Práctica 1: Gestión de viajes de una empresa de autobuses**
   - Implementación de la gestión de viajes de una empresa de autobuses utilizando una multilista (Una lista doblemente enlazada génerica y una lista enlazada génerica)
   - [Ver código](PED_P1_4L_1/GestionEmpresaAutobuses/src)
   - [Memoria técnica](PED_P1_4L_1/Memoria-Practica1.pdf)
   - [Enunciado de la práctica](PED_P1_4L_1/PED_Practica1_2022-23_multilista-Autobuses.pdf)
     
2. **Práctica 2: TAD Pila y TAD Cola**
   - Implementación de dos estructuras de datos el Tipo Abstracto de Datos Pila y el Tipo Abstracto de Datos Cola
   - [Ver código](PED_P2_4L_1/TADs-Pila-y-Cola/src)
   - [Memoria técnica](PED_P2_4L_1/Memoria-Practica2.pdf)
   - [Enunciado de la práctica](PED_P2_4L_1/Practica_2_PED_2022-23.pdf)
     
3. **Práctica 3: TAD ABB**
   - Implementación de una estructura de datos el Tipo Abstracto de Datos Árbol Binario de Busqueda
   - [Ver código](PED_P3_4L_1/TAD-ABB/src)
   - [Memoria técnica](PED_P3_4L_1/Memoria-Practica3.pdf)
   - [Enunciado de la práctica](PED_P3_4L_1/Practica_3_PED_2022-23.pdf)

## Cómo ejecutar

Todas las prácticas se ejecutan siguiendo estos pasos que se describen a continuación:

## **Usando IntelliJ IDEA**

### **1. Abrir el proyecto en IntelliJ**
1. Abre IntelliJ IDEA.
2. Ve a **File > Open** y selecciona la carpeta del repositorio que clonaste de GitHub.
3. IntelliJ detectará automáticamente si el proyecto es de Java. Si no, te pedirá que configures un **SDK de Java**.

   - Si es la primera vez, selecciona un JDK en tu máquina o descárgalo desde IntelliJ. Asegúrate de usar JDK 8 o superior.

### **2. Verificar la estructura del proyecto**
1. Asegúrate de que tu archivo fuente (`Main.java`) (Clase principal de cada proyecto con el método main) esté dentro de una carpeta llamada `src` o algo similar. La estructura típica sería:

   ```
   repositorio/
   ├── src/
   │   └── com/
   │       └── ejemplo/
   │           └── Main.java
   ```

2. Si no tienes esta estructura, puedes configurar el directorio como "fuente" (`Source Root`):
   - Haz clic derecho en la carpeta `src`.
   - Selecciona **Mark Directory as > Sources Root**.

### **3. Ejecutar el programa**
1. Abre el archivo `Main.java` en IntelliJ.
2. Busca el botón verde con forma de triángulo ▶ junto al método `main`.
3. Haz clic en ese botón y selecciona **Run 'Main'**.
4. IntelliJ compilará automáticamente el programa y lo ejecutará en la consola integrada.

### **4. Configurar parámetros de ejecución (si son necesarios)**
Si tu programa requiere argumentos de entrada, puedes configurarlos fácilmente:
1. Ve a **Run > Edit Configurations**.
2. Selecciona la configuración de tu clase principal (`Main`).
3. En el campo **Program Arguments**, escribe los argumentos separados por espacios (por ejemplo, `arg1 arg2`).
4. Haz clic en **OK** y vuelve a ejecutar el programa.

## **Usando Eclipse**

### **1. Abrir el proyecto en Eclipse**
1. Abre Eclipse.
2. Ve a **File > Import > Existing Projects into Workspace**.
3. Selecciona la carpeta del repositorio clonado de GitHub y haz clic en **Finish**.

### **2. Verificar la estructura del proyecto**
1. Asegúrate de que tu archivo `Main.java` (Clase principal de cada proyecto con el método main) esté dentro de una carpeta marcada como **src**. Por ejemplo:

   ```
   repositorio/
   ├── src/
   │   └── com/
   │       └── ejemplo/
   │           └── Main.java
   ```

2. Si Eclipse no reconoce la carpeta como fuente, haz clic derecho en el proyecto:
   - Ve a **Build Path > Configure Build Path**.
   - En la pestaña **Source**, añade la carpeta `src` como fuente si no está configurada.

### **3. Ejecutar el programa**
1. Haz doble clic en el archivo `Main.java` para abrirlo en el editor.
2. Haz clic derecho en cualquier parte del archivo y selecciona **Run As > Java Application**.
3. Eclipse compilará automáticamente el programa y lo ejecutará en la consola de Eclipse.

### **4. Configurar parámetros de ejecución**
Si necesitas agregar argumentos de entrada:
1. Haz clic derecho sobre el archivo `Main.java`.
2. Ve a **Run As > Run Configurations**.
3. En la pestaña **Arguments**, escribe los argumentos en el campo **Program Arguments**.
4. Haz clic en **Apply** y luego en **Run**.
