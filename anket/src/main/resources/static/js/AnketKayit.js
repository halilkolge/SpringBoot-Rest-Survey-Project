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
            if(id==null){
                var formData = {
                    "adi": $("#ad").val(),
                    "soyadi": $("#soyadi").val(),
                    "takim": $("#takim").val(),
                    "aciklama": $("#aciklama").val(),
                    "anketorAdi": $("#aadi").val(),
                    "anketorSoyAdi": $("#asoyadi").val(),
                    "cinsiyet" : $('#cinsiyet option:selected').val(),
                    "dogumGunu" : $('#dogum').val()
                }

            }
            console.log(formData);
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/anket/kayit",
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
                            window.location.replace("/anket/liste?secim=1");
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