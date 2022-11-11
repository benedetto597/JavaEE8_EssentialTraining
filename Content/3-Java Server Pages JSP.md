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

## 3. Java Server Pages JSP
#### 3.1 Vista previa
es una tecnología Java EE que permite a los desarrolladores crear fácilmente páginas web con contenido dinámico. La mayoría de las páginas web se construyen con contenido dinámico porque permite experiencias únicas para cada visita o visitante de una página. Aquí está la página de inicio de otro curso mío en LinkedIn Learning. Tenga en cuenta que el diseño y la temática de la página son consistentes con otros cursos. Sin embargo, hay contenido específico para este curso. Como el nombre del curso y la información sobre lo que aprenderá. LinkedIn no crea una página HTML estática para cada curso. En cambio, el contenido estático tiene una plantilla para elementos de página genéricos como "Diseño" y luego el contenido dinámico como "Información del curso" se entremezcla para crear una página única para cada curso. Este concepto se puede aplicar fácilmente dentro de Java EE utilizando JSP. (sonido de clic suave) A continuación, se incluye una descripción general de cómo se modelan las aplicaciones JSP utilizando las mejores prácticas actuales. En este patrón, un navegador pasa solicitudes HTTP a un servlet. Que realiza su lógica y luego almacena datos en un modelo. Luego, el servlet pasa la solicitud al JSP. Que extrae los datos del modelo y los entremezcla dentro de una plantilla para generar una página dinámica para el usuario final. El patrón conocido como Model View Controller, o MVC para abreviar, separa las tres preocupaciones principales de la creación de páginas web dinámicas para evitar que el código se vuelva ilegible y difícil de mantener. Así que hemos hablado de cómo los JSP son documentos que mezclan contenido estático con contenido dinámico utilizando una arquitectura MVC. Profundicemos un poco más. Al construir una página JSP... hay dos opciones de sintaxis: página JSP o documento JSP. La sintaxis del documento JSP... impone una sintaxis XML estricta. Y puede evitar la combinación de la lógica del controlador en la vista. La sintaxis estándar se usa con más frecuencia. Sin embargo, crea la posibilidad de acoplamiento entre capas MVC. Si tiene un equipo bien disciplinado o un proceso co-revisado, no debería ser un problema usar la sintaxis de la página JSP. Dentro de las páginas JSP, podemos importar bibliotecas de etiquetas que definen cuándo se pueden usar las etiquetas JSP que nos ayudan a construir la página. Además, está disponible un lenguaje de expresión simple que proporciona una sintaxis concisa para hacer referencia a objetos de modelo en la página. Esta descripción general de alto nivel le brinda los conceptos generales con los que trabajaremos en JSP.