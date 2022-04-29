# GoogleSheetCRUD

_Este proyecto se enfocará en el uso de retrofit2 para consultar los datos, y volley para el registro con propósitos de aprendizaje, además del modelado de los datos, los cuales puedes observar en **Modelado de Datos en Postman**_

## Comenzando 🚀

_Para este proyecto tenemos que tener en cuenta que usaremos AppScript es una de las extensiones en GoogleSheet, ádemas de que la hoja de cálculo debe estar compartida para todas la personas, es necesario tener la URL de la página de GoogleSheet, también de la pestaña en la parte inferior, en este caso la llamamos "Items"_

[![hoja-calculo.png](https://i.postimg.cc/xdYRbZzX/hoja-calculo.png)](https://postimg.cc/xXxHwtgQ)

### Pre-requisitos 📋

_Android Studio, conocer sibre kotlin, tener una base sobre retrofit2,  conocimiento básico en volley, también debemos tener en cuenta que el APPSCRIPT debe estar implementado como Web para así crear un ENDPOINT._

```
. MinSdk =  24
. CompileSdk = 31
. TargetSdk = 31
. Gradle JDFK = corretto - 15 Amanzon Corretto version 15.0.2 

- Librerías :
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'com.android.volley:volley:1.2.1'
```

_En esta imagen podemos apreciar que la URL de google sheet esta siendo utilizada, como también la posicion del archivo el cual es llamado "Items"_

<p align="center">
   <img src="https://i.postimg.cc/ZnZ4k4BT/additem.png"/>
</p>


_Acá se aprecia como es el appscrit para generar un ENDPOINT y asi poder consultar los datos en postman, el cual procederemos a modelar los datos en kotlin_

<p align="center">
   <img src="https://i.postimg.cc/T3ywJ2nS/listitems.png"/>
</p>

## Modelo de datos en Postman 📖

_Mostraré un ejemplo del estructura de la información que utilizaremos, en este caso sera la data insertada previamente_
_Como podemos ver en la imagen el modelo de datos empieza con llaves lo que significa que es un objeto, dentro de ese objeto hay un Array llamado Items, dentro de ese array existe una lista de objetos, este sería nuestro principal enfoque a consultar._

<p align="center">
     <img src="https://i.postimg.cc/m2Pcrrzk/ListData.png"/>
</p>

## [CRUD Proyecto]
1. Insertando datos con volley
	- CreateDataIntoGoogleSheet
		- https://github.com/PaulGuillen/GoogleSheetCRUD/tree/CreateDataintoGoogleSheetView
2. Consultado datos con retrofit2
   - GettingdataFromGoogleSheet
	   - https://github.com/PaulGuillen/GoogleSheetCRUD/tree/GettingDataFromGoogleSheet
	
   
## Autor ✒️

* **Paul Guillen Acuña** - *Mi Repositorio* - [PaulGuillen](https://github.com/PaulGuillen?tab=repositories)
