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

## 4. Java Server Faces JSF
#### 4.1 Vista previa

Java Server Faces es un **marco de aplicación web o framework** basado en Java que simplifica el desarrollo de aplicaciones basadas en web. A las JSF se les llama también **Faceslet**

JSF proporciona **un modelo más cohesivo que los servlets y JSP** para crear aplicaciones web. 

Su modelo incluye:
1. Un marco de componentes de interfaz de usuario del lado del servidor
2. Soporte de plantillas y la capacidad de vincular componentes de interfaz de usuario a **java pojos conocidos como backing beans**

![JSF Components](../Img/4.1_JSF_Components.png)
**Componentes clave de JSF**:
1. Dentro de **JSF** encontramos un **servlet de face**, este servlet es el **encargado de orquestar los diferentes eventos dentro del ciclo de vida de JSF**. 
2. La página o **vista JSF**, conocida como **facelet** la cual contienen un **árbol de componentes del lado del servidor** y se construyen utilizando una **combinación de XHTML, bibliotecas de etiquetas, expresiones y plantillas**. 
3. Los componentes dentro de una faceta representan representaciones del lado del servidor de los componentes de la interfaz de usuario que se representarán como HTML en el navegador. 
4. Los **componentes** dentro de la **facelet están vinculados a beans de respaldo que son pojos administrados como beans** que contienen campos y métodos para administrar la interfaz de usuario. 

![JSF Overview](../Img/4.1_Overview_JSF.png)
**La arquitectura de JSF**:
1. Cuando un navegador pasa una solicitud HTTP al servlet de la cara, creará un árbol de componentes para la faceta identificada por la URL. 
2. Luego, los componentes en el árbol de componentes tendrán sus valores actualizados con la información correspondiente encontrada en la solicitud y los valores serán validados.
3. Después de la validación, los valores de los componentes actualizarán los campos en el bean de administración al que están vinculados con sus valores. 
4. El servlet de la cara invocará cualquier método de acción en el bean administrado, los métodos de acción finalmente devolverán una cadena que indica la próxima faceta a representar. 
5. El bean facelet devuelto tendrá su árbol de componentes actualizado con valores de cualquier bean de respaldo al que haga referencia y luego su árbol de componentes se escribirá como HTML devuelto al navegador. 

En resumen, JSF es un **marco de aplicación web Java EE** que se basa en los **principios de MVC**, dentro de la tecnología encontramos un **ciclo de vida que organiza el procesamiento de solicitudes** que implica una secuencia de pasos para **vincular los componentes de facelet del servidor a beans de respaldo basados ​​​​en pojo**. 

![JSF Tags](../Img/4.1_JSF_Tags.png)
Al crear una página de facelet, hay varias bibliotecas de etiquetas disponibles listas para usar para usar con aplicaciones JSF. La biblioteca de etiquetas de facelet es principalmente para plantillas que crean la estructura de una página. Por ejemplo, al incorporar algo de XHTML en una plantilla principal, la biblioteca de etiquetas HTML proporciona componentes que se corresponden con elementos HTML típicos; sin embargo, estas etiquetas hacen que se creen contrapartes del lado del servidor.


![JSF Tags](../Img/4.1_JSF_Example.png)
Ejemplo que involucra una facelet y un bean de respaldo que une todo. La facelet aprovecha las bibliotecas de etiquetas JSF para crear un formulario simple que está vinculado a campos y métodos en el bean de respaldo utilizando lenguaje de expresión. Puede ver esto indicado por el código de colores. Cuando se hace clic en el botón de comando, la cadena de nombre en el bean de respaldo se actualizará y se invocará el método de saludo en el bean de respaldo. El método de saludo devuelve una cadena, saludo, que indica la siguiente facetlet para representar en el navegador.

_____
#### 4.2 JSF configuración en proyecto

1. Crear un nuevo Proyecto Web Dinamico
2. Definir el patrón de URL al que nos gustaría asignar el servlet Faces. Cada solicitud que coincida con el patrón se enrutará a través del servlet de Faces para que pueda realizar el ciclo de vida de JSF. 
3. Cambiar el patrón a este patrón será un asterisco ***.xhtml*** Entonces, cualquier URL que termine con una extensión xhtml se enrutará a través de nuestro servlet Faces.
4. Crear un nuevo archivo .xhtml

_____
#### 4.3 JSF Lo basico

1. Para enlazar elementos de datos de nuestra facelet, necesitamos crear un bean de respaldo
2. Crear una nueva clase. Esto va a ser un Java POJO.
3. Todo lo que necesita hacer es crear algunos campos a los que le gustaría vincular datos 
4. Crear accesos para admitir esos campos (getters & setters) esos serán utilizados por los enlaces JSF. 
5. Se debe agregar la anotación a esta clase para que JSF cree el bean, ***@RequestScoped*** básicamente va a decir que este bean existe durante la vida de la solicitud. 
6. Dirigirnos a nuestro archivo ***.xhtml***, y podemos comenzar a enlazar con ese bean de respaldo. 
7. Usando la biblioteca de etiquetas html dentro de JSF, en lugar de solo elementos html sin formato. Ahora, cuando enlazamos con JSF, usamos un signo de libra y luego las llaves ***#{}*** Y notará que tenemos IntelliSense dentro de esa expresión, por lo que podemos ver el bean de formulario de catálogo y luego seleccionar el campo de nombre en ese bean. 
8. Y luego, agregaremos un botón de comando al formulario que navegue a una facelet llamada "Lista". 
9. Entonces, esa será la próxima vista que vamos a crear, y le daremos a ese botón el valor "Enviar". Entonces, sigamos adelante y creemos esa página de lista. 
10. Tenemos dos facetas, y están **vinculadas a un bean de respaldo común**, cuyos valores se actualizarán a medida que JSF procese a lo largo de su ciclo de vida. Bueno. 

_____
#### 4.4 JSF Plantillas
Dentro de JSF, se puede usar la **biblioteca de etiquetas facelets, para introducir plantillas** dentro de la aplicación. Es **útil porque podemos evitar repetir el marcado común dentro de cada página**. 

1. Clic con el botón derecho en la carpeta de la aplicación web y luego vaya a nuevo, otro y luego aquí vamos a crear una nueva página XHTML, vamos a nombrar esa plantilla de página y luego Presionaremos siguiente, y en lugar de elegir la página de facelet en blanco, seleccionaremos la página de **facelet común** para construir nuestra plantilla. 
2. Se puede definir un título de página e insertar el contenido dentro de la plantilla desde una página que aprovecha la plantilla. 
3. El facelet de formulario, se puede configurar para aprovechar la nueva plantilla, con la etiqueta **< ui:composition >** para poder usar el template con la etiqueta **< ui:define >**
4. Para definir nuestro cuerpo, solo rodea el contenido que le gustaría colocar dentro de la sección del cuerpo de la plantilla, usando la etiqueta **< ui:define >**. (¿Qué etiqueta se usa para indicar que el contenido de la página debe insertarse en una plantilla? --> <ui:define/>)
5. Especificar un encabezado de página, aquí podemos construir otra pieza de contenido, primero definir un paquete de recursos, que JSF puede usar. Para eso, se crea un nuevo paquete dentro de mi carpeta Java principal fuente, voy a nombrar recursos de ese paquete, y luego dentro de ese paquete de recursos, solo voy a agregar un archivo, y Voy a llamarlo messages.properties, para que pueda ver nuestro archivo de propiedades
6. Definir pares de valores clave que se pueden aprovechar usando el lenguaje de expresión dentro de JSF en el archivo messages.properties 
7. Entonces, voy a agregar una propiedad llamada form.pageTitle, y simplemente estableceremos el valor de las propiedades en el formulario de catálogo, y luego agregaremos otra propiedad list.pageTitle, que estableceremos en catalog
8. Volvemos a nuestro archivo **template.xhtml**, donde esta la etiqueta **loadBundle**, que también es una etiqueta de facelets, y que **debe apuntar a nuestro archivo de propiedades**. 
9. Configuramos el atributo **basename**, y pueden ver que nos estamos beneficiando de IntelliSense y básicamente estamos asignando todas esas propiedades a esta variable msg. 
10. Entonces, volvamos a nuestro formulario, y luego dentro del formulario podemos **aprovechar nuestro paquete de recursos creando una expresión, y luego usamos el nombre de la variable msg** con la que hacemos referencia a messages.properties, por lo que esa fue la propiedad form.PageTitle, y luego simplemente cerramos nuestra expresión

_____
#### 4.5 Beans de respaldo avanzados

¿Cuál es el nombre de las facetas de objetos a las que se vinculan sus datos y operaciones?
Backing Bean

* CatalogItem.java contiene: 
  1. El objeto catalogo item es solo un POJO que contiene toda la información de un artículo del catálogo. 
  2. Constructor que podemos usar para crear una instancia de un elemento del catálogo. 

* form.xhtml
  1. Básicamente he creado un formulario que tiene controles que se corresponden con cada uno de los campos en el elemento del catálogo POJO. 

Entonces, lo que podemos hacer para comenzar es navegar a nuestro formulario de elementos del catálogo **Backing Bean**. Y lo que debemos hacer es cambiar ese Bean para que tenga un **alcance de sesión**. Y esto hará que la **información persista en diferentes solicitudes HTTP** para usuarios particulares. 

Ahora, **cada vez que usamos el alcance de la sesión**, debemos asegurarnos de que **nuestro Bean implemente la interfaz Serializable**

Podemos usar la etiqueta **validateRegex** dentro de la biblioteca de etiquetas **Facelets**. Y esto es realmente poderoso porque nos permite **especificar un Regex**. Y ese Regex se usará para validar la entrada proporcionada por el usuario final. Como un Regex alfanumérico que permita espacios. 

```html
<h:inputText id="productName" value="#{catalogItemFormBean.item.name}">
    <f:validateRegex pattern="[A-Za-z0-9 ]+"></f:validateRegex>
</h:inputText>
```

Ahora algo más que tenemos que considerar es que para nuestro control de **fecha disponible**, nuestro usuario simplemente ingresará una cadena. ¿Cómo se convierte esa cadena en una fecha real? Bueno, dentro de JSF hay soporte para esa conversión, así que echamos un vistazo a la biblioteca de etiquetas Facelets y está la etiqueta **ConvertDateTime**. Y esto nos permite especificar el tipo al que nos gustaría convertir, así como un patrón. Entonces, en este caso, vamos a hacer que el usuario ingrese la fecha en un formato de fecha de dos dígitos, mes de dos dígitos y año de cuatro dígitos. 

```html
<h:inputText value="#{catalogItemFormBean.item.availableDate}">
    <f:convertDateTime type="localDate" pattern="dd-MM-yyyy"/>
</h:inputText>
```

El botón de comando del formulario, necesitamos especificar el atributo de acción. En lugar de simplemente vincular este atributo a un Facelet estático, navegará al siguiente, 
 
```html
<h:commandButton value="Submit" action="#{catalogItemFormBean.addItem()}"/>
```

vamos a volver a nuestro Backing Bean y definir un nuevo método. Y este método va a devolver una cadena, **addItem**, será una lista, y ese será el nombre de la Facelet a la que navegaremos una vez que se ejecute la lógica de este método. Y luego vamos a agregar un parámetro aquí. Es face-redirect, y vamos a configurarlo como verdadero. Y eso hará que la navegación se realice a través de una redirección. 

```java
public String addItem() {
	long itemId = this.items.size() + 1;
	this.items.add(new CatalogItem(itemId, this.item.getName(), this.item.getManufacturer(),
			this.item.getDescription(), this.item.getAvailableDate()));
	
	this.items.stream().forEach(item ->{
		System.out.println(item.toString());
	});
	
	return "list?faces-redirect=true";
}
```

_____
#### 4.6 Recursos

La mayoría de las aplicaciones web se crean utilizando CSS, JavaScript o imágenes externas. Vamos a ver cómo podemos hacer referencia a estos recursos dentro de una aplicación JSF. 

Lo primero que se debe hacer es reemplazar las etiqueta HTML con su equivalente JSF. 

| HTML | JSF |
|------|-----|
|```<head> </head>``` | ```<h:head> </h:head>```|


<br>

**Agregar hoja de estilos** con ```<outputStylesheet>``` se puede **apuntar o llamar a la hoja de estilo CSS global**. Se especifica el **atributo de la biblioteca** que será CSS, y luego el **nombre de la hoja de estilo**.

```html
<h:outputStylesheet library="css" name="global.css"></h:outputStylesheet>
```

**Agregar una imagen** de banner se debe hacer referencia a la etiqueta ```<graphicImage>```, permite mostrar una imagen en la página. Se especifica un valor para esa imagen, una ruta al banner.jpeg


```html
<h:graphicImage library="img" value="/resources/img/banner.jpeg"/>
```


**Agregar ese archivo JavaScript** en la página. Se usa la etiqueta ```<outputScript>``` se porporciona una biblioteca, luego se porporciona el nombre del archivo

```html
<h:outputScript library="js" name="shake.js"></h:outputScript>
```


_____
#### 4.7 Visualización de datos

**JSF también proporciona componentes** que se pueden aprovechar para **mostrar datos**. Utilizando la etiqueta **Tabla de datos** 

```html
<h:dataTable value="#{catalogItemFormBean.items}" var="item">
```

También se puede **especificar columnas que se mostrarán como parte de la tabla**. usando la etiqueta de **facet** se puede definir la **faceta como un encabezado** y luego proporcionamos el nombre para ese encabezado de columna.

```html
<f:facet name="header">Name</f:facet>
```

**Vincular una colección a la tabla de datos** usando el lenguaje de expresión, dentro del elemento de la tabla, podemos **especificar el nombre de una variable** usando **var="variableName"** que contendrá cada elemento individual dentro de la colección. Y ahora podemos usar ese nombre de variable **para vincularnos** a ese elemento dentro de nuestra tabla. 

```html
<h:dataTable value="#{catalogItemFormBean.items}" var="item">
	<h:column>
		<f:facet name="header">Name</f:facet>
		<h:outputText value="#{item.name}" />
	</h:column>
	<h:column>
		<f:facet name="header">Manufacturer</f:facet>
		<h:outputText value="#{item.manufacturer}" />
	</h:column>
	<h:column>
		<f:facet name="header">Description</f:facet>
		<h:outputText value="#{item.description}" />
	</h:column>
</h:dataTable>
```

_____
#### 4.8 Navegación

Navegación dentro de una aplicación JSF. Dentro de la biblioteca de etiquetas HTML, está **link** básicamente creará una etiqueta de anclaje en el HTML para navegar entre las páginas.

```html
<ui:define name="pageHeader">
	<h:link value="#{msg['form.pageTitle']}" outcome="form"/> |
	<h:link value="#{msg['list.pageTitle']}" outcome="list"/>
</ui:define>
```


¿Qué pasa si necesitamos **encaminar algunos datos cuando navegamos**? Dentro del **cuerpo del enlace**, podemos **pasar un parámetro** usando la biblioteca de etiquetas facelets. Encontrará una etiqueta de parámetro y simplemente establecemos el nombre de ese parámetro y luego podemos vincularlo a nuestro bean de respaldo y, en este caso, será el ID del elemento que nos gustaría eliminar. 

```html
<h:link value="Remove" outcome="confirm">
	<f:param name="itemId" value="#{item.itemId}"/>
</h:link>
```

Entonces, tenemos nuestro enlace configurado y ahora, una vez que se pasa ese parámetro, debemos hacer algo en la página de confirmación para tomar ese parámetro y seleccionar el elemento apropiado. Dentro de la página de confirmación vamos a usar otra **etiqueta, la de metadatos** y esto nos **permite extraer información** de la solicitud. 

```html
<f:metadata>
	<f:viewParam name="itemId" value="#{catalogItemDeleteBean.itemId}"></f:viewParam>
</f:metadata>
```

Para **llamar al metodo de un bean de respaldo** usamos otra etiqueta, y esa es la etiqueta del **evento clave**. 

```html
<f:metadata>
	<f:viewParam name="itemId" value="#{catalogItemDeleteBean.itemId}"></f:viewParam>
	<f:event type="preRenderView" listener="#{catalogItemDeleteBean.fetchItem()}"/>
</f:metadata>
```

```java
public void fetchItem() {
	List<CatalogItem> items = this.catalogItemFormBean.getItems().stream().filter(i -> {
		return i.getItemId() == itemId;
	}).collect(Collectors.toList());
	if (items.isEmpty()) {
		this.item = null;
	} else {
		this.item = items.get(0);
	}
}
```

Y luego, lo que hacemos es asignar un oyente y podemos vincularnos a un método en nuestro bean de respaldo que se invocará cuando ocurra este evento. Entonces, existe el método de obtención de elementos que acabamos de ver y ahora lo tenemos en su lugar. Simplemente eliminará el elemento de la colección y luego nos llevará de regreso a la lista.


```html
<h:commandButton action="#{catalogItemDeleteBean.removeItem()}" value="Submit" />
<h:commandButton action="list" value="Cancel" />
```

```java
public String removeItem() {
	this.catalogItemFormBean.getItems().removeIf(item ->{
		return item.getItemId().equals(this.itemId);
	});
	return "list?faces-redirect=true";
}
```