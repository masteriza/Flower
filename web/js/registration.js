$(document).ready(function () {
    $('#login').click(function () {
        $(this).addClass('active');
        $('#overlay').fadeIn('fast', function () {
            $('.login-form').fadeIn();
        });
    });
    $('#overlay').on('click', function () {
        $('.login-form').fadeOut('fast', function () {
            $('#overlay').fadeOut();
            $('#login').removeClass('active');
        });
    });

    $('#btRegistration').click(function () {
        email = $('#email').val();
        password = $('#password').val();
        verifyPassword = $('#verifyPassword').val();

        firstName = $('#firstName').val();
        lastName = $('#lastName').val();
        phone = $('#phone').val();

        $.ajax({
            type: "POST",
            url: "RegistrationUser",
            data: {
                email: email,
                password: password,
                verifyPassword: verifyPassword,
                firstName: firstName,
                lastName: lastName,
                phone: phone
            },
            success: function (responseData) {

                $(".errorSummary").empty().append(responseData);
                //$(".errorSummary").append(responseData);
                /*for (i = 0; i <= responseData.length - 1; i++) {
                 ////console.log(responseData[i].providerName);
                 $('#providerservices').append('<input type="radio" value="' + responseData[i].id + '">' + responseData[i].serviceName + ' ' + responseData[i].speed + ' - ' + responseData[i].price + '<br>');
                 }*/
            }
        });


        /*$(".message").load("/login/login.php", {loginname: loginname, passwd: passwd}, function () {
         $(".message").show("slow");
         var timetogo = 10;
         var timer = window.setInterval(function () {
         if (timetogo <= 0) {
         $(".message").hide("slow");
         clearInterval(timer);
         }
         timetogo--;
         }, 1000);
         });*/

    });

});
