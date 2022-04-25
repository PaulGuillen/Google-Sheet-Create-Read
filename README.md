# GoogleSheetCRUD

En este proyecto realizaré un CRUD (create , read , update, delete) en cual se usará como base de datos una hoja de cálculo en google drive.

## Comenzando 🚀

_Esta parte sería el proyecto unido el cual mostrará las diferentes ramas de github_

### Pre-requisitos 📋

_Android Studio, kotlin, retrofit2, volley_

```
. MinSdk =  24
. CompileSdk = 31
. TargetSdk = 31
. Gradle JDFK = corretto - 15 Amanzon Corretto version 15.0.2
. API = 27 Oreo 8.1
```

---

_Aquí podemos apreciar que utilizamos la HOJA 3 llamada "Items", además de tener en cuenta que debemos volver público nuestro documento de hoja de cálculo, también copiar la URL de la página de hoja de calculo de google drive._

<p align="center">
 <img src="https://i.postimg.cc/8PCQKTVw/exceldata.png"/>
</p>

_En este paso nos vamos a "Extensiones" y seleccionamos AppScript deberíamos tener algo así para poder insertar data, noten la URL y el nombre de Hoja de Cálculo._
<p align="center">
 <img src="https://i.postimg.cc/4dGjzg56/app-Script.png"/>
</p>


## Modelo de datos en Postman 📖

_Mostraré un ejemplo del estructura de la información que utilizaremos, en este caso sera la data insertada previamente_

```
{
    "items": [
        {
            "productName": "Televisor ",
            "productDescription": "50 pulgadas , HD , LED ",
            "productSell": 2500,
            "productBuy": 2200,
            "productType": "Tipo 3",
            "productRating": "4.0"
        },
        {
            "productName": "Microondas",
            "productDescription": "Amiray, con horno electrico",
            "productSell": 550,
            "productBuy": 450,
            "productType": "Tipo 2",
            "productRating": "3.0"
        },

```

_En progreso las demás partes del CRUD......._

## Autor ✒️

**Paul Guillen Acuña** - *Mi Repositorio* - [PaulGuillen](https://github.com/PaulGuillen?tab=repositories)
