# GettingDataFromGoogleSheet

_En esta parte se le añadio, el uso de retrofit2 con convertergson para asi poder obtener los datos del json mostrado en **Modelado de datos en Postman**_

## Comenzando 🚀

_Como podemos ver en la imagen el modelo de datos empieza con llaves lo que significa que es un objecto, dentro de ese objeto hay un Array llamado Items, dentro de ese array existe una lista de objetos, este sería nuestro principal enfoque a consultar._

<p align="center">
     <img src="https://i.postimg.cc/m2Pcrrzk/ListData.png"/>
</p>


## Modelo de datos en Postman 📖

_A tener en cuenta los datos y la estructura_

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
## Ejecutando los diseños ⚙️

_Vistas principales del listado de datos_

<p align="center">
     <img src="https://i.postimg.cc/4xBNbkhq/Screenshot-1651164348.png"/>
     <img src="https://i.postimg.cc/QMCNf4Qt/Screenshot-1651164353.png"/>
</p>

## Video 📄

_Mostraremos como funciona el listado de datos_

https://user-images.githubusercontent.com/43099030/165808247-c26744fe-1730-4c24-8087-070b5494a5b3.mp4


