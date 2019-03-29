var lat = parseFloat(document.getElementById("map").getAttribute("data-lat"));
var long = parseFloat(document.getElementById("map").getAttribute("data-long"));

var locations = JSON.parse(document.getElementById("map").getAttribute("data-locations"));


var mymap = L.map('mapid').setView([51.505, -0.09], 12);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibHJmbHJmIiwiYSI6ImNqdG94bWQwdTQ4Mng0Ym11YW52MWZ5bnEifQ.lZEH9-1FD4H2KYhVZDIe4Q', {
maxZoom: 18,
attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
  '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
  'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
id: 'mapbox.streets'
}).addTo(mymap);


var i;
for (i = 0; i < 10; i++)
{
   L.marker([lat, long]).addTo(mymap).on('click', onClick);
   lat = lat + 0.01;
}

for (i = 0; i < locations.length; i++)
{
   var mapLocation = locations[i];
   L.marker([mapLocation.latitude, mapLocation.longitude]).addTo(mymap).on('click', onClick);
}

L.circle([51.508, -0.11], {
color: 'red',
fillColor: '#f03',
fillOpacity: 0.5,
radius: 2000
}).addTo(mymap);

/*L.polygon([
[51.508, -0.08],
[51.500, -0.06],
[51.511, -0.048]
]).addTo(mymap);*/

function onClick(e) {
    //alert(this.getLatLng());
    window.location.href = "/testdb";
}
