/**
 * Created by user on 14.08.2015.
 */
function initialize() {   //ќпределение карты

    $.get("getProviderLocation", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
    /*$.ajax({
        url: "some.php",
        success: function(data){
            alert( "ѕрибыли данные: " + data );
        }
    });*/

    array_provider_location = new Array(
        {
            "providerlocationlat": "50.45095993",
            providerlocationlng: "30.52259982",
            "providertitle": "Main office"
        },
        {
            "providerlocationlat": "50.4282552",
            providerlocationlng: "30.4529175",
            "providertitle": "Solomenka office"
        },
        {
            "providerlocationlat": "50.4535873",
            providerlocationlng: "30.601521",
            "providertitle": "Darnitsa office"
        },
        {
            "providerlocationlat": "50.397944",
            providerlocationlng: "30.634579",
            "providertitle": "Pozniaki office"
        },
        {
            "providerlocationlat": "50.526944",
            providerlocationlng: "30.492778",
            "providertitle": "Obolon office"
        }
    );

    //alert(<%=e.getProviderId()%>);

    var latlng = new google.maps.LatLng(50.4501, 30.5234);
    var options = {
        zoom: 11,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(document.getElementById("map_canvas"), options);
    geocoder = new google.maps.Geocoder();//ќпределение геокодера
    usermarker = new google.maps.Marker({ //определение маркера
        map: map,
        draggable: true
    });

    var indexprovider;
    for (indexprovider = 0; indexprovider < array_provider_location.length; indexprovider++) {
        var providermarker = new google.maps.Marker({
            map: map,

            title: array_provider_location[indexprovider].providertitle
        });
        providermarker.setIcon('img/marker_blue.png');
        var usermarkerLatLng = new google.maps.LatLng(array_provider_location[indexprovider].providerlocationlat, array_provider_location[indexprovider].providerlocationlng);
        providermarker.setPosition(usermarkerLatLng);
    }
}


$(document).ready(function () {

    initialize();
    initlocation();


    $(function () {
        google.maps.event.addListener(usermarker, 'drag', function () {
            geocoder.geocode({'latLng': usermarker.getPosition()}, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    if (results[0]) {
                        /*$('#address').val(results[0].formatted_address);
                         $('#latitude').val(marker.getPosition().lat());
                         $('#longitude').val(marker.getPosition().lng());*/
                        $('#address').val(results[0].formatted_address);
                    }
                }
            });

            var userlocation = new google.maps.LatLng(usermarker.getPosition().lat(), usermarker.getPosition().lng());
            var mindistancebetweenprovideruser = 20000000;
            for (indexprovider = 0; indexprovider < array_provider_location.length; indexprovider++) {
                var providerlocation = new google.maps.LatLng(array_provider_location[indexprovider].providerlocationlat, array_provider_location[indexprovider].providerlocationlng);
                var distancebetweenprovideruser = google.maps.geometry.spherical.computeDistanceBetween(userlocation, providerlocation);
                //alert(array_provider_location[indexprovider].providertitle + "   " + distancebetweenprovideruser);
                if (mindistancebetweenprovideruser >= distancebetweenprovideruser) {
                    mindistancebetweenprovideruser = distancebetweenprovideruser;
                    var indexprovidermindistancebetweenprovideruser = indexprovider;
                }
            }

        });

        google.maps.event.addListener(map, 'click', function (event) {
            usermarker.setPosition(event.latLng);
            geocoder.geocode({'latLng': usermarker.getPosition()}, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    if (results[0]) {
                        $('#address').val(results[0].formatted_address);
                    }
                }
            });
        });

        $("#address").autocomplete({
            //ќпредел€ем значение дл€ адреса при геокодировании
            source: function (request, response) {
                geocoder.geocode({'address': request.term}, function (results, status) {
                    response($.map(results, function (item) {
                        return {
                            label: item.formatted_address,
                            value: item.formatted_address,
                            latitude: item.geometry.location.lat(),
                            longitude: item.geometry.location.lng()
                        }
                    }));
                })
            },
            //¬ыполн€етс€ при выборе конкретного адреса
            select: function (event, ui) {
                //$("#latitude").val(ui.item.latitude);
                //$("#longitude").val(ui.item.longitude);
                var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
                usermarker.setPosition(location);
                map.setCenter(location);
            }
        });


        //End FuncReady
    });

    //ƒобавл€ем слушател€ событи€ обратного геокодировани€ дл€ маркера при его перемещении


});

function codeAddress() {
    var address = document.getElementById('address').value;
    geocoder.geocode({'address': address}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            usermarker.setPosition(results[0].geometry.location);
            //map.setZoom(11);
            usermarker.setMap(map);
        } else {
            alert('Your address is not found');
            //alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}