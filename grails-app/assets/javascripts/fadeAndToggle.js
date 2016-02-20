/**
 * Created by Alexander on 27.11.2015.
 * Blendet Nachrichten im View nach 5 Sekunden automatisch aus
 */


function toggleErrorDetails() {
    $('.error-content').slideToggle('fast');
}
$('#topAlerts').delay(5000).fadeOut('slow');
$('.error-expand').click(function () {
    $('.error-content').slideToggle('fast');
})
$('.content-expand').click(function () {
    $('.expand-content').slideToggle('slow');
})
$(document).ready(function () {
    window.setTimeout("toggleErrorDetails();", 5000);
})

