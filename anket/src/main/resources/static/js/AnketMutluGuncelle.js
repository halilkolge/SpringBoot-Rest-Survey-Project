var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

$(document).ready(function () {


    $("#FormSave").validate({

        submitHandler: function (form) {
            $('#loading-screen').fadeIn();
            var id = getUrlParameter('id');

                var formData = {
                    "adi": $("#ad").val(),
                    "id": $("#id").val(),
                    "soyadi": $("#soyadi").val(),
                    "aciklama": $("#aciklama").val(),
                    "anketorAdi": $("#aadi").val(),
                    "anketorSoyAdi": $("#asoyadi").val(),
                    "cinsiyet" : $('#cinsiyet option:selected').val(),
                    "mutlulukOrani" : $('#mOran').val(),
                    "mutluEden" : $('#mutluE').val(),
                    "mutsuzEden" : $('#mutsuzE').val(),
                    "dogumGunu" : $('#autoclose-datepicker').val()
                }

            console.log(formData);
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/anket/update",
                data: JSON.stringify(formData),
                dataType: 'json',
                cache: false,
                timeout: 60000,

                success: function (data) {
                    $('#loading-screen').fadeOut('slow');
                    if(data.result){
                        console.log(data);
                        success_noti_custom(data.message);
                        setTimeout(function() {
                            window.location.replace("/anket/liste?secim=2");
                        }, 2000);
                    }
                    else{
                        error_noti_yuk(data.message);
                        console.log(data.message+" sdfasdf")
                    }
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                    $("#btn-login").prop("disabled", false);
                }
            });
            return false;
        }
    });
});