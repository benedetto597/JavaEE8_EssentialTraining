<div align="center">
    <img src="https://avatars.githubusercontent.com/u/23086798?s=200&v=4" width=200px"> </img> 
    
<!-- Encabezado -->
### Java EE 8 | Escencial Training
#### OKR Personal Q4 2022
#### Autor 


| Nombre | Identidad | Correo |
|:-------------:| :-----:|:-----:|
| Edgar Josué Benedetto Godoy | `0801-1997-23600` | [Gmail](mailto:edgar.benedetto@baccredomatic.hn) |

</div>

_____
_____
## 8. Validación de Beans
#### 8.1 Vista previa

La validación de datos se realiza con frecuencia dentro de la aplicación para **garantizar que los datos proporcionados por un usuario u otro sistema cumplan con ciertos requisitos**. Estas restricciones son importantes para **garantizar la integridad de los datos** del sistema y pueden ayudar en la aplicación de la seguridad. 

La API de **validación de beans de Java EE** proporciona un **enfoque simple basado en anotaciones** que permite a los desarrolladores agregar restricciones de validación en beans. Dentro de la API de validación de Bean, **existe varias anotaciones** que brindan restricciones integradas para **validaciones comunes**. Para **validaciones más complejas** o de uso frecuente, la API permite a los desarrolladores **crear sus propias restricciones personalizadas**. Las restricciones se **pueden aplicar a varios elementos de una clase, como campos, métodos, constructores, parámetros de métodos y otras anotaciones**. 

Las implementaciones de Java EE 8 se adherirán a Bean Validation 2.0, que agrega varias características: 
1. Se agregaron **restricciones integradas adicionales** a la API que son bastante útiles.
2. Permite **aplicar la validación en objetos dentro de tipos de contenedores**, como Listas y Mapas, claves de un mapa. 
3. Soporte para los nuevos tipos de Java 8, como los **tipos de datos de fecha/hora opcionales y nuevos**. 
4. Dentro de la API, encontrará soporte para 28 restricciones integradas 

| Anotación o Constraint | Descripción |
|:-------------:| :-----:|
| @AssertFalse | El valor del campo debe ser falso. |
| @AssertTrue | El valor del campo debe ser verdadero. |
| @DecimalMax | El valor del campo debe ser menor o igual al valor especificado. |
| @DecimalMin | El valor del campo debe ser mayor o igual al valor especificado. |
| @Digits | El valor del campo debe ser un número que contiene un número específico de dígitos enteros y fraccionarios. |
| @Email | El valor del campo debe ser una dirección de correo electrónico válida. |
| @Future | El valor del campo debe ser una fecha futura. |
| @FutureOrPresent | El valor del campo debe ser una fecha futura o presente. |
| @Max | El valor del campo debe ser menor o igual al valor especificado. |
| @Min | El valor del campo debe ser mayor o igual al valor especificado. |
| @Negative | El valor del campo debe ser negativo. |
| @NegativeOrZero | El valor del campo debe ser negativo o cero. |
| @NotBlank | El valor del campo no debe ser nulo o vacío. |
| @NotEmpty | El valor del campo no debe ser nulo o vacío. |
| @NotNull | El valor del campo no debe ser nulo. |
| @Null | El valor del campo debe ser nulo. |
| @Past | El valor del campo debe ser una fecha pasada. |
| @PastOrPresent | El valor del campo debe ser una fecha pasada o presente. |
| @Pattern | El valor del campo debe coincidir con el patrón o expresión regular especificado. |
| @Positive | El valor del campo debe ser positivo. |
| @PositiveOrZero | El valor del campo debe ser positivo o cero. |
| @Size | El tamaño del valor del campo debe estar entre los valores especificados. |
| @Valid | El valor del campo debe ser válido. |
| @CreditCardNumber | El valor del campo debe ser un número de tarjeta de crédito válido. |
| @Currency | El valor del campo debe ser una moneda válida. |
| @EAN | El valor del campo debe ser un número EAN válido. |
| @ISBN | El valor del campo debe ser un número ISBN válido. |
| @Length | El tamaño del valor del campo debe estar entre los valores especificados. |
| @LuhnCheck | El valor del campo debe ser un número de tarjeta de crédito válido. |
| @Mod10Check | El valor del campo debe ser un número de tarjeta de crédito válido. |
| @Mod11Check | El valor del campo debe ser un número de tarjeta de crédito válido. |
| @ParameterScriptAssert | El valor del campo debe ser válido. |
| @ScriptAssert | El valor del campo debe ser válido. |
| @URL | El valor del campo debe ser una URL válida. |


Ejemplo de varias restricciones aplicadas a nivel de campo en una clase de estudiante simple. 

```java	
public class Student {

	@NotBlank //constraint checks if string is not null, empty or whitespace
	@Size(min = 2, max = 30) //constraint checks if string length is between 2 and 30
	private String name;

	@NotNull //constraint checks if value is not null (field constraint 1)
	@Email //constraint checks if value is a valid email address (field constraint 2)
	private String email;

	@Positive //numeric cosntraint checks if value is positive
	private int age;

	@Size(min = 1, max = 5) //constraint checks if list has at least 1 but nor more than 5 items
	private List<@NotEmpty String> aliases;

	@AssertTrue //boolean constraint checks if value is true
	private boolean active;

	@FutureOrPresent //date constraint checks if value is a date in the future or present
	private Date graduationDate;
}
```

La API de validación de Bean también brinda soporte para **grupos de restricciones**, que se pueden usar para aplicar solo ciertas restricciones en un objeto. Aquí vemos un grupo de Restricción que restringe la edad de los estudiantes universitarios a 18 y la de los estudiantes de primaria a cinco. Esto permite que nuestra validación se aplique a un contexto o situación particular dentro de nuestra aplicación.

```java	
public class Student {

	@NotBlank //constraint checks if string is not null, empty or whitespace
	@Size(min = 2, max = 30) //constraint checks if string length is between 2 and 30
	private String name;

	@NotNull //constraint checks if value is not null (field constraint 1)
	@Email //constraint checks if value is a valid email address (field constraint 2)
	private String email;

	@Positive //numeric cosntraint checks if value is positive
	@Min(value = 5, groups = Primary.class) //constraint checks if value is at least 5
	@Min(value = 18, groups = University.class) //constraint checks if value is at least 18
	private int age;
}

public interface Primary {
}

public interface University {
}

```
_____
#### 8.2 Restricciones o constraints añadidos

```java
@Entity
@Table(name = "CATALOG_ITEM")
public class CatalogItem {

	@Id
	@Column(name = "CATALOG_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Size(min = 0, max=3)
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name="CATALOG_ITEM_ID")
		, inverseJoinColumns = @JoinColumn(name="ITEM_MANAGER_ID"))
	private List<ItemManager> itemManagers = new ArrayList<>();

	@NotBlank
	@Column(name = "NAME")
	private String name;

	@Pattern(regexp = "^[A-Za-z]*$", message = "Must be letters")
	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Pattern(regexp = "^[A-Za-z]{5,10}$", message = "Must be letters")
	@Column(name = "DESCRIPTION")
	private String description;

	@Future
	@Column(name = "AVAILABLE_DATE")
	private LocalDate availableDate;
	
	...
}
```

_____
#### 8.3 Anotaciones de validación personalizadas

Dentro de la API de validación de Bean, podemos **aplicar anotaciones de restricción en otras anotaciones. Es una forma de crear un validador personalizada** dentro de la API de validación de Bean. Esto es muy **útil si tenemos alguna validación que se va a aplicar una y otra vez a lo largo de nuestra aplicación**. 

Ejemplo: 
Aquí tenemos una expresión regular que básicamente verifica si una cadena es alfabética o no. Esa podría ser una validación muy común. Hay que crear otra anotación que aplicará esa validación y la hará reutilizable en toda nuestra aplicación. Con CNTRL+N buscamos ***Annotation*** crearemos una anotación simple y nombraremos esta anotación como ***Alfabético***. Querrá establecer la retención en tiempo de ejecución. Puede seleccionar los objetos de tipo Tipo, Campo, Método, Parámetro, Constructor y Anotación para el destino de esta anotación que especifica dónde se puede aplicar. 

Se deben **agregar algunas anotaciones adicionales** como ```@Documented``` y ```@Constraint(validateBy = {})``` se deja como una matriz vacía dado que no aplica aquí, pero es obligatoria la anotación y finalmente se usa la anotación de ```@Pattern.List()``` **permite enumerar diferentes patrones** que nos gustaría aplicar cuando usamos nuestro nuevo validador personalizado.Así que ya hemos visto ese patrón. 

```java
@Pattern.List(@Pattern(regexp = "^[A-Za-z]*$", message = "Must be letters"))
```

Agregar un par de elementos dentro de esta anotación. Primero, necesitamos agregar una Cadena que se llame mensaje, y luego vamos a hacer que esto sea una expresión predeterminada. Y hablaremos de eso aquí en un minuto. Simplemente lo llamaremos alfabético inválido. Luego necesitamos crear una matriz de clases. Y estos serán los grupos a los que podemos proporcionar para que se aplique esta anotación. Los vimos en la descripción general. K, y lo pondremos por defecto en una matriz vacía. Y finalmente necesitamos agregar la carga útil. Y estas son solo cosas predeterminadas que normalmente se colocan en cada anotación que va a ser una restricción. 

```java
@Documented
@Constraint(validatedBy = {})
@Retention(RUNTIME)
@Pattern.List(@Pattern(regexp = "^[A-Za-z]*$", message = "{invalid.alphabetic}"))
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE})
public @interface Alphabetic {

	String message() default "{invalid.alphabetic}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
```

¿De dónde viene ese valor del mensaje? Bueno, dentro de la API de validación podemos **usar un archivo de propiedades**. Y ese archivo de propiedades debe estar ubicado dentro de la raíz de su ruta de clase. Dentro de este archivo podemos colocar diferentes propiedades que nos permitan sacar los mensajes de validación. Así que aquí está nuestra propiedad invalid.alphabetic.

```properties
invalid.alphabetic=Alphabetic invalid
```

Y con ese mensaje en su lugar que completa la configuración de nuestro validador personalizado. Ahí podemos ver la anotación, y ahora solo necesitamos reemplazar nuestro patrón con nuestro nuevo validador personalizado.

```java
@Alphabetic
@Column(name = "MANUFACTURER")
private String manufacturer;
```

_____
#### 8.4 Validadores de restricciones personalizadas

Al crear una aplicación, es posible que se encuentre con un escenario en el que la lógica de validación sea demasiado compleja para las restricciones integradas en la API de validación. 
Se puede **crear un validador de restricciones personalizado** que puede manejar una lógica más avanzada. 

**Ejemplo:** Construir un validador que pueda **restringir a los fabricantes a una lista específica que podamos tener**. 
1. Se necesita **una anotación** que aplicaremos a nuestro campo de fabricante 
2. Crear un nuevo mensaje de validación que se devuelva, ir al archivo de propiedades e ingresarlo 
3. El validador de restricciones, la anotación de restricción espera que proporcionemos una clase que implemente la interfaz del validador de restricciones. Crear una nueva clase, esta clase para implementará la interfaz del validador de restricciones
	
	```java
	@Documented
	@Constraint(validatedBy = {PermittedManufacturerConstraintValidator.class})
	@Retention(RUNTIME)
	@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
	public @interface PermittedManufacturer {

		String message() default "{invalid.manufacturer}";

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};

	}
	```

4. Hay dos tipos de anotaciones en esa interfaz que debemos proporcionar. La primera es la anotación que va a indicar que nos gustaría usar este validador de restricciones y esa será la anotación permitida por el fabricante. Y luego, el segundo argumento de tipo genérico es solo el tipo del valor que vamos a validar. 
5. Agregar los métodos no implementados, solamente un método que necesitaremos implementar ***IsValid*** simplemente devuelve un booleano verdadero o falso y luego estos argumentos de tipo no están muy bien nombrados.

	```java
	public class PermittedManufacturerConstraintValidator implements ConstraintValidator<PermittedManufacturer, String> {

		private static String[] permittedManufacturers = {"CompanyA", "CompanyB"};

		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			return Arrays.asList(permittedManufacturers).contains(value); 
		}
	}
	```

6. Agregar nuestra anotación al campo del fabricante. Entonces podemos especificar que debe ser un fabricante autorizado. 

	```java
	@PermittedManufacturer
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	```

_____
#### Preguntas y respuestas

1. ¿Qué es la API de validación?
	- Es una API que nos permite validar los datos de entrada de una aplicación.

2. ¿Qué es una restricción?
	- Es una anotación que se puede aplicar a un campo de una clase de entidad para indicar que ese campo debe cumplir con ciertas reglas de validación.

3. ¿Qué es un validador de restricciones?
	- Es una clase que implementa la interfaz ConstraintValidator. Esta clase se encarga de validar los datos de entrada de una aplicación.

4. ¿Qué interfaz se utiliza para crear un validador personalizado en la API de bean?
	- ConstraintValidator.

5. ¿Cuál es el nombre predeterminado del archivo que contiene los mensajes de propiedad de validación?
	- ValidationMessages.properties.

6. La anotación @NotBlank fallaría en la validación de esta cadena: "". ¿Es verdadero o falso? ¿Por qué?
	- Verdadero. La cadena vacía no es un valor válido para una cadena.

7. Los desarrolladores pueden crear sus propias restricciones de validación personalizadas mediante la API de validación de beans. ¿Es verdadero o falso? ¿Por qué?
	- Verdadero. La API de validación de beans proporciona una interfaz para crear validadores personalizados.

8. ¿Qué es una anotación de restricción?
	- Es una anotación que se puede aplicar a un campo de una clase de entidad para indicar que ese campo debe cumplir con ciertas reglas de validación.
