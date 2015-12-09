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

    $('#btlogin').click(function () {
        email = $('#email').val();
        password = $('#password').val();
        $.ajax({
            type: "POST",
            url: "UserAuthentication",
            data: {
                email: email,
                password: password
            },
            success: function (responseData) {
                if (responseData != "") {
                    location.href = 'login.jsp';
                } else {
                    location.href = 'sec/useraccount.jsp';
                }
            }
        });
    });

    $('.btlogin_form').click(function () {
        email = $('#form_email').val();
        password = $('#form_password').val();
        $.ajax({
            type: "POST",
            url: "UserAuthentication",
            data: {
                email: email,
                password: password
            },
            success: function (responseData) {
                if (responseData != "") {
                    location.href = 'login.jsp';
                } else {
                    location.href = 'sec/useraccount.jsp';
                }
            }
        });
    });

    $('#pgRegistration').click(function () {
        location.href = 'registration.jsp';
    });

    $('#btRegistration').click(function () {
        email = $('#reg_email').val();
        password = $('#reg_password').val();
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
                if (responseData != "") {
                    $(".errorSummary").empty().append(responseData);
                } else {
                    location.href = 'message.jsp';
                }
            }
        });
    });

    $('.btRecovery').click(function () {
        email = $('#recovery_email').val();
        $.ajax({
            type: "POST",
            url: "RecoveryUserPassword",
            data: {
                recovery_email: email
            },
            success: function (responseData) {
                if (responseData != "") {
                    $(".errorSummary").empty().append(responseData);
                } else {
                    location.href = 'message.jsp';
                }
            }
        });
    });

    $('#btLogout').click(function () {
        $.ajax({
            type: "POST",
            url: "../UserLogout",
            success: function () {
                //NOOP
            }
        });
    });

});

