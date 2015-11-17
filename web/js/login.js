function initialize() {   //Определение карты

}



$(document).ready(function () {
    /*$('#providerselect').change(function () {
        $(this).attr('selected', 'selected');
        getProviderServices();
    });*/

    $('#login').click(function () {
        $(this).addClass('active');
        $('#overlay').fadeIn('fast', function () {
            $('.login-form').fadeIn();
        });
    });
    $('#overlay').on('click',function(){
        $('.login-form').fadeOut('fast', function () {
            $('#overlay').fadeOut();
            $('#login').removeClass('active');
        });
    });



});

