function initialize() {   //Определение карты

}

$(document).ready(function () {
    $('#providerselect').change(function () {
        $(this).attr('selected', 'selected');
        getProviderServices();
    });
});

