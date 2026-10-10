# Simulador de Tarifas y Liquidación Institucional

Proyecto académico en Java con Spring Boot que demuestra el uso de `@Service`, `@Component`, `@Autowired` y `@Value`.

## ¿Qué hace?

Al iniciar la aplicación, Spring Boot ejecuta automáticamente una liquidación de ejemplo para 12 créditos académicos. El cálculo incluye:

- Subtotal de créditos.
- Descuento porcentual.
- Cuota administrativa.
- Total a pagar.

Los valores son ejemplos didácticos y se pueden modificar en `src/main/resources/application.properties`. No representan tarifas oficiales de una institución.

## Tecnologías

- Java 17
- Spring Boot 3.4.5
- Maven

## Estructura

```text
simulador-tarifas-liquidacion/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/simulador_tarifas/
    │   │   ├── DemoApplication.java
    │   │   ├── runner/LiquidacionRunner.java
    │   │   └── service/LiquidacionService.java
    │   └── resources/application.properties
    └── test/java/simulador_tarifas/service/
        └── LiquidacionServiceTest.java
```

## Cómo abrir y ejecutar en Apache NetBeans

1. Instala un JDK 17 o superior. Puedes comprobarlo en una terminal con `java -version`.
2. Descarga e instala Apache NetBeans si todavía no lo tienes: https://netbeans.apache.org/
3. Descomprime este proyecto en una carpeta.
4. En NetBeans, elige **File > Open Project** y selecciona la carpeta `simulador-tarifas-liquidacion` que contiene `pom.xml`.
5. Espera a que Maven descargue las dependencias.
6. Ejecuta el proyecto desde NetBeans. Si te pide seleccionar la clase principal, elige `simulador_tarifas.DemoApplication`.
7. En la consola de salida aparecerá el resumen de liquidación.

También puedes ejecutar el proyecto desde una terminal abierta en la carpeta del proyecto con:

```bash
mvn spring-boot:run
```

Necesitas conexión a internet la primera vez para descargar dependencias Maven.

## Cómo subirlo a GitHub

1. Crea un repositorio nuevo en https://github.com/new, por ejemplo `simulador-tarifas-liquidacion`.
2. No es necesario añadir README ni otros archivos al crear el repositorio, porque este proyecto ya incluye README.
3. Descomprime el ZIP y sube los archivos y carpetas del proyecto al repositorio. Puedes usar **Add file > Upload files** en GitHub.
4. Asegúrate de que `pom.xml`, `README.md` y la carpeta `src` queden en la raíz del repositorio, no dentro de una segunda carpeta anidada.
5. Comparte con el profesor el enlace del repositorio.

## Anotaciones solicitadas

- `@Service`: declara `LiquidacionService`, que contiene los cálculos.
- `@Component`: declara `LiquidacionRunner`, que Spring administra.
- `@Autowired`: inyecta `LiquidacionService` en `LiquidacionRunner` por constructor.
- `@Value`: lee los importes configurables desde `application.properties`.

## Nota

Los valores y la fórmula son un ejemplo académico porque el enunciado compartido no define tarifas ni fórmulas específicas. Si el profesor entrega una fórmula concreta, actualiza `LiquidacionService` para seguirla.
