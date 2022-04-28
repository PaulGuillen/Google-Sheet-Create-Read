# GoogleSheetCRUD

_Este proyecto se enfocará en el uso de retrofit2 para consultas de datos, y volley para el registro con propósitos de aprendizaje, ademas del modelado de los datos, los cuales puedes observar en **Modelado de Datos en Postman**_

## Comenzando 🚀

_Para este proyecto tenemos que tener en cuenta que usaremos AppScript es una de las extensiones en GoogleSheet, ádemas de que la hoja de cálculo debe estar compartida para todas la personas, es necesario tener la URL de la página de GoogleSheet, ádemas de la pestaña en la parte inferior, en este caso la llamamos "Items"_

[![hoja-calculo.png](https://i.postimg.cc/xdYRbZzX/hoja-calculo.png)](https://postimg.cc/xXxHwtgQ)

### Pre-requisitos 📋

_Android Studio, conocer sibre kotlin, tener una base sobre retrofit2,  conocimiento básico en volley_

_En esta imagen podemos apreciar que la URL de google sheet esta siendo utilizada, como también la posicion del archivo el cual es llamado "Items"_

<p align="center">
   <img src="https://i.postimg.cc/ZnZ4k4BT/additem.png"/>
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



