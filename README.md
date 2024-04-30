# MongoDB
Trabajo MongoDB hecho por Hugo Gil Bailón (Código y este archivo.md) y Jesús Gómez Rodríguez (Documentación)

**Clase Conex**
# Ejemplos de Uso de MongoDB en Java

## Requisitos

Para ejecutar estos ejemplos, necesitarás tener instalado y configurado MongoDB, así como un entorno de desarrollo Java configurado correctamente. Asegúrate de tener acceso a la base de datos MongoDB y las credenciales necesarias para conectarte a ella.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `Conex.java`: Clase principal que contiene la interfaz gráfica y la lógica de interacción con la base de datos MongoDB.
- `Nuevo.java`: Clase secundaria para agregar nuevos ordenadores a la base de datos.
- `Sobremesa.java`: Clase que representa un objeto Sobremesa y su mapeo a la base de datos MongoDB.
- `Portatil.java`: Clase que representa un objeto Portatil y su mapeo a la base de datos MongoDB.

## Configuración

Antes de ejecutar los ejemplos, asegúrate de haber configurado correctamente la conexión a la base de datos MongoDB en la clase `Conex.java`. Debes proporcionar la URL de conexión, el nombre de la base de datos y la colección que se utilizará.

```java
private static String conex = "mongodb+srv://usuario:contraseña@servidor.mongodb.net/";
private static String databaseName = "NombreBaseDeDatos";
private static String collectionName = "NombreColeccion";

ConnectionString connectionString = new ConnectionString(conex);

		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.codecRegistry(codecRegistry).build();

		// Creamos el cliente MongoDB
		MongoClient mongoClient = MongoClients.create(clientSettings);

		// Recuperar base de datos
		db = mongoClient.getDatabase(databaseName);

        // Recuperar coleccion
		collection = db.getCollection(collectionName);
```

## Métodos

`Conex.java`
------------------------------------------------------------------------------------------------------------
`generarConex()`: Creamos un objeto CodecRegistry que es una interfaz en la biblioteca de MongoDB para Java que define un registro de codecs. Un "codec"  traduce los documentos BSON (que es el formato de los documentos de MongoDB) en objetos Java, para obtener en nuestro caso datos de objetos Sobremesa y Portatil.
Creamos unos settings de Mongo y los aplicamos, posteriormente creamos un cliente, recuperamos la base de datos y la colleccion para poder trabajar con ella.

Dentro de el ActionListener llamado manejadorButton tenemos opciones para los botones `carButton` y `deleteButton`.

`carButton`: Recorremos una lista antes creada de tipo Sobremesa o Portatil, dependiendo del radioButton seleccionado, y a través de el mostramos los datos del ordenador (metódo toString en la clase Sobremesa/Portatil) seleccionado en el JComboBox

`deleteButton`: Obtenemos los datos del objeto Sobremesa/Portatil seleccionado en el JComboBox, separamos la marca y el modelo del item y borramos de la colección (db de MongoDB) el objeto con el modelo del item del JComboBox.


`Nuevo.java`
------------------------------------------------------------------------------------------------------------

En la clase privada ManejadorBoton implementada por ActionListener, tenemos la opción de añadir ordenador en la que comprobamos el radioButton seleccionado para el tipo de ordenador, dependiendo de eso creamos una MongoCollection de tipo Sobremesa/Portatil, dandole el valor de la db obteniendo el nombre de la coleccion donde vamos añadir el ordenador y especificando la clase del objeto que vamos a añadir.

Después creamos un objeto Sobremesa/Portatil haciendole setters a sus atributos y así dandoles los valores que introducimos en los JTextField y en el MongoCollection anteriormente creado insertamos el objeto


# Clase Portatil

La clase `Portatil` representa un objeto que encapsula información sobre un ordenador portátil. Esta clase se utiliza en el ejemplo de la interfaz gráfica de usuario (`Conex.java`) para interactuar con la base de datos MongoDB y almacenar información sobre ordenadores portátiles.

## Atributos

La clase `Portatil` tiene los siguientes atributos:

- `id`: Identificador único del ordenador portátil en la base de datos.
- `tipo`: Tipo de ordenador, en este caso, "portátil".
- `marca`: Marca del ordenador portátil.
- `modelo`: Modelo del ordenador portátil.
- `precio`: Precio del ordenador portátil.
- `pantalla`: Especificaciones de la pantalla del ordenador portátil.
- `procesador`: Especificaciones del procesador del ordenador portátil.
- `ram`: Especificaciones de la memoria RAM del ordenador portátil.
- `almacenamiento`: Especificaciones del almacenamiento del ordenador portátil.
- `graficos`: Especificaciones de la tarjeta gráfica del ordenador portátil.
- `so`: Sistema operativo del ordenador portátil.
- `color`: Color del ordenador portátil.

## Métodos

La clase `Portatil` proporciona métodos para acceder y modificar los valores de sus atributos. Algunos de estos métodos son:

- Métodos *getter* y *setter* para cada atributo, que permiten obtener y establecer los valores de los atributos.
- `name()`: Devuelve una representación del nombre del ordenador portátil, que consiste en la combinación de la marca y el modelo.
- `toString()`: Devuelve una representación en formato de cadena de texto de los atributos del ordenador portátil.

## Anotaciones

La clase `Portatil` utiliza anotaciones de la biblioteca de MongoDB para Java (`@BsonProperty`) para especificar cómo se deben mapear los atributos de la clase a los campos en los documentos BSON en la base de datos MongoDB.

## Uso

Creación de objetos de tipo Portatil

# Clase Sobremesa

La clase `Sobremesa` representa un objeto que encapsula información sobre un ordenador de sobremesa. Esta clase se utiliza en el ejemplo de la interfaz gráfica de usuario (`Conex.java`) para interactuar con la base de datos MongoDB y almacenar información sobre ordenadores de sobremesa.

## Atributos

La clase `Sobremesa` tiene los siguientes atributos:

- `id`: Identificador único del ordenador de sobremesa en la base de datos.
- `tipo`: Tipo de ordenador, en este caso, "sobremesa".
- `marca`: Marca del ordenador de sobremesa.
- `modelo`: Modelo del ordenador de sobremesa.
- `precio`: Precio del ordenador de sobremesa.
- `procesador`: Especificaciones del procesador del ordenador de sobremesa.
- `ram`: Especificaciones de la memoria RAM del ordenador de sobremesa.
- `almacenamiento`: Especificaciones del almacenamiento del ordenador de sobremesa.
- `graficos`: Especificaciones de la tarjeta gráfica del ordenador de sobremesa.
- `so`: Sistema operativo del ordenador de sobremesa.
- `color`: Color del ordenador de sobremesa.

## Métodos

La clase `Sobremesa` proporciona métodos para acceder y modificar los valores de sus atributos. Algunos de estos métodos son:

- Métodos *getter* y *setter* para cada atributo, que permiten obtener y establecer los valores de los atributos.
- `name()`: Devuelve una representación del nombre del ordenador de sobremesa, que consiste en la combinación de la marca y el modelo.
- `toString()`: Devuelve una representación en formato de cadena de texto de los atributos del ordenador de sobremesa.

## Anotaciones

La clase `Sobremesa` utiliza anotaciones de la biblioteca de MongoDB para Java (`@BsonProperty`) para especificar cómo se deben mapear los atributos de la clase a los campos en los documentos BSON en la base de datos MongoDB.

## Uso

Creación de objetos de tipo Sobremesa