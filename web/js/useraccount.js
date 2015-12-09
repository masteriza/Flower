function findNearestProvider() {
    var userLocation = new google.maps.LatLng(usermarker.getPosition().lat(), usermarker.getPosition().lng());
    var minDistanceBetweenUserProvider = 20000000;
    for (var indexProviderMarker = 0; indexProviderMarker < arrayProviderLocation.length; indexProviderMarker++) {
        var providerLocation = arrayProviderLocation[indexProviderMarker].providerMarkers.getPosition();
        var distanceBetweenUserProvider = google.maps.geometry.spherical.computeDistanceBetween(userLocation, providerLocation);
        if (minDistanceBetweenUserProvider >= distanceBetweenUserProvider) {
            minDistanceBetweenUserProvider = distanceBetweenUserProvider;
            //indexMinDistanceBetweenUserProvider = indexProviderMarker;
            idNearestProvider = arrayProviderLocation[indexProviderMarker].id;
        }
    }
}

function changeMarkerNearestProvider() {
    for (var indexProviderLocation = 0; indexProviderLocation < arrayProviderLocation.length; indexProviderLocation++) {
        if (idNearestProvider == arrayProviderLocation[indexProviderLocation].id) {
            arrayProviderLocation[indexProviderLocation].providerMarkers.setIcon('../img/marker_green.png');
        } else {
            arrayProviderLocation[indexProviderLocation].providerMarkers.setIcon('../img/marker_blue.png');
        }
    }
}

function fillProviderSelect() {
    $("#providerselect").empty();
    for (indexProvider = 0; indexProvider < arrayProviderLocation.length; indexProvider++) {
        if (arrayProviderLocation[indexProvider].id == idNearestProvider) {
            $('#providerselect').append('<option selected value="' + arrayProviderLocation[indexProvider].id + '">' + arrayProviderLocation[indexProvider].providerName + '</option>');
        } else {
            $('#providerselect').append('<option  value="' + arrayProviderLocation[indexProvider].id + '">' + arrayProviderLocation[indexProvider].providerName + '</option>');
        }
    }
}

function getProviderServices() {
    idNearestProvider = $("#providerselect option:selected").val();
    changeMarkerNearestProvider();
    $.ajax({
        type: "POST",
        url: "../GetServiceByProviderId",
        data: {idProvider: idNearestProvider},
        success: function (responseData) {

            $("#providerservices").empty();
            for (i = 0; i <= responseData.length - 1; i++) {
                ////console.log(responseData[i].providerName);
                $('#providerservices').append('<input type="radio" name="providerservices" value="' + responseData[i].id + '">' + responseData[i].serviceName + ' ' + responseData[i].speed + ' - ' + responseData[i].price + '<br>');
            }
        }
    });
}

function initialize() {   //Определение карты
    var latlng = new google.maps.LatLng(50.4501, 30.5234);
    var options = {
        zoom: 11,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(document.getElementById("map_canvas"), options);

    geocoder = new google.maps.Geocoder();//Определение геокодера
    usermarker = new google.maps.Marker({ //определение маркера
        map: map,
        draggable: true
    });
}

function getMarkersData() {
    $.ajax({
        type: "POST",
        url: "../GetAllProviders",
        success: function (responseData) {
            arrayProviderLocation = new Array(
                {
                    "id": "",
                    "providerName": "",
                    "latitude": "",
                    "longitude": "",
                    "providerMarkers": ""

                }
            );
            for (i = 0; i <= responseData.length - 1; i++) {
                arrayProviderLocation[i] = {
                    "id": responseData[i].id,
                    "providerName": responseData[i].providerName,
                    "latitude": responseData[i].latitude,
                    "longitude": responseData[i].longitude

                };
                //console.log(responseData[i].providerName);
            }
            var indexProvider;
            for (indexProvider = 0; indexProvider < arrayProviderLocation.length; indexProvider++) {
                var userMarkerLatLng = new google.maps.LatLng(arrayProviderLocation[indexProvider].latitude, arrayProviderLocation[indexProvider].longitude);
                providerMarker = new google.maps.Marker({
                    map: map,
                    title: arrayProviderLocation[indexProvider].providerName,
                    icon: 'img/marker_blue.png',
                    position: userMarkerLatLng
                });
                arrayProviderLocation[indexProvider].providerMarkers = providerMarker;

            }
            fillProviderSelect();
            getProviderServices();
        }
    });
}

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
        }
    });
}

$(document).ready(function () {
    idNearestProvider = 0;
    initialize();
    getMarkersData();

    google.maps.event.addListener(usermarker, 'dragend', function () {
        geocoder.geocode({'latLng': usermarker.getPosition()}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    $('#address').val(results[0].formatted_address);
                }
            }
        });
        findNearestProvider();
        changeMarkerNearestProvider();
        fillProviderSelect();
        getProviderServices();
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
        findNearestProvider();
        changeMarkerNearestProvider();
        fillProviderSelect();
        getProviderServices();
    });


    $("#address").autocomplete({
        //Определяем значение для адреса при геокодировании
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
        //Выполняется при выборе конкретного адреса
        select: function (event, ui) {
            //$("#latitude").val(ui.item.latitude);
            //$("#longitude").val(ui.item.longitude);
            var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
            usermarker.setPosition(location);
            map.setCenter(location);
        }
    }); //Добавляем слушателя события обратного геокодирования для маркера при его перемещении

    $('#providerselect').change(function () {
        $(this).attr('selected', 'selected');

        getProviderServices();

    });


});

