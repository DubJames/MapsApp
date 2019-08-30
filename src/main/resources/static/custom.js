var map;
// var coords = {lat: 39.9612, lng: -82.9988};

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        zoom: 12,
        scrollwheel: false
    });
    var image = {url: '/poop.png', 
    	    scaledSize: new google.maps.Size(50, 50)
    };
    var marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        animation: google.maps.Animation.BOUNCE
    });
    //Charlotte NC is default location, otherwise return city,state
        if (city && state) {
        	var contentString = '<h2>' + city + ', ' + state + '</h2>';
        } else {
            var contentString = '<h2>Charlotte, NC</h2>';   //fix this with default
        }
    
    var infowindow = new google.maps.InfoWindow({
      content: contentString
    });

    google.maps.event.addListener(marker, 'click', function() {
       infowindow.open(map,marker);
    });
}