
$(document).ready(function () {


    $("#Secim1").validate({

        submitHandler: function (form) {
            window.location.replace("/anket/kaydet?secim=1");
        }
    });

    $("#Secim2").validate({

        submitHandler: function (form) {
            window.location.replace("/anket/kaydet?secim=2");
        }
    });
});